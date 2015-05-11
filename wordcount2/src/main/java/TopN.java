import java.io.IOException;
import java.util.PriorityQueue;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


public class TopN {
	
	public static class ItemFreq implements Comparable<ItemFreq> {
		
		private String word;
		private Long freq;
		
		public ItemFreq() {
			this("", 0L);
		}
		
		public ItemFreq(String word, Long freq) {
			this.word = word;
			this.freq = freq;
		}
		
		public int compareTo(ItemFreq o) {
			return (int)(freq - o.freq);
		}
		
	}
	
	public static void insert(PriorityQueue<ItemFreq> queue,
			String word, Long longVal, int topN) {
		ItemFreq head = queue.peek();	// 가장 적은 빈도 수의 아이템
		if (queue.size() < topN || head.freq < longVal) {
			// 일단 큐에 담기
			queue.add(new ItemFreq(word, longVal));
			// 큐의 사이즈가 topN 보다 크다면
			if (queue.size() > topN) {
				queue.remove();	// 큐의 맨 앞(가장 적은 빈도 수 아이템) 삭제
			}
		}
	}
	
	public static class Map extends Mapper<Text, Text, Text, LongWritable> {
		
		PriorityQueue<ItemFreq> queue = null;
		private int topN;
		
		@Override
		public void setup(
				Mapper<Text, Text, Text, LongWritable>.Context context)
				throws IOException, InterruptedException {
			topN = context.getConfiguration().getInt("topN", 10);
			queue = new PriorityQueue<TopN.ItemFreq>(topN);
		}
		
		@Override
		public void map(Text key, Text value,
				Mapper<Text, Text, Text, LongWritable>.Context context)
				throws IOException, InterruptedException {
			// queue에 이미 담겨 있는 애들이랑 비교해서 담을지, 버릴지?
			Long longVal = Long.parseLong(value.toString());
			
			insert(queue, key.toString(), longVal, topN);
		}
		
		@Override
		public void cleanup(
				Mapper<Text, Text, Text, LongWritable>.Context context)
				throws IOException, InterruptedException {
			// queue에 담겨 있는 데이터 들을 context.write()로 내보내기
			while (queue.size() != 0) {
				ItemFreq item = queue.remove();
				context.write(new Text(item.word),
						new LongWritable(item.freq));
			}
		}
		
	}
	
	public static class Reduce
			extends Reducer<Text, LongWritable, Text, LongWritable> {
		
		private PriorityQueue<ItemFreq> queue;
		private int topN;
		
		@Override
		public void setup(
				Reducer<Text, LongWritable, Text, LongWritable>.Context context)
				throws IOException, InterruptedException {
			topN = context.getConfiguration().getInt("topN", 10);
			queue = new PriorityQueue<ItemFreq>(topN);
		}
		
		@Override
		public void reduce(Text key, Iterable<LongWritable> values,
				Reducer<Text, LongWritable, Text, LongWritable>.Context context)
				throws IOException, InterruptedException {
			long sum = 0;
			for (LongWritable val : values) {
				sum += val.get();
			}
			
			insert(queue, key.toString(), sum, topN);
		}
		
		@Override
		public void cleanup(
				Reducer<Text, LongWritable, Text, LongWritable>.Context context)
				throws IOException, InterruptedException {
			while (queue.size() != 0) {
				ItemFreq item = queue.remove();
				context.write(new Text(item.word),
						new LongWritable(item.freq));
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = new Job(conf, "TopN");
		
		job.setJarByClass(TopN.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		
		job.setInputFormatClass(KeyValueTextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		job.setMapperClass(TopN.Map.class);	// Mapper
		job.setReducerClass(TopN.Reduce.class);	// Reducer
		job.setNumReduceTasks(1);	// 리듀스 태스크 개수를 1개로 제한
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.getConfiguration().setInt("topN", Integer.parseInt(args[2]));
		
		job.waitForCompletion(true);
	}
	
}
























