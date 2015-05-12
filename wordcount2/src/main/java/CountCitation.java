import java.io.IOException;

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


public class CountCitation {
	
	public static class Map extends Mapper<Text, Text, Text, LongWritable> {
		
		private static final LongWritable one = new LongWritable(1L);
		
		@Override
		public void map(Text key, Text value,
				Mapper<Text, Text, Text, LongWritable>.Context context)
				throws IOException, InterruptedException {
			
			context.write(value, one);
			
		}
		
	}
	
	public static class Reduce extends Reducer<Text, LongWritable, Text, LongWritable> {
		@Override
		public void reduce(Text key, Iterable<LongWritable> values,
				Reducer<Text, LongWritable, Text, LongWritable>.Context context)
				throws IOException, InterruptedException {
			
			long sum = 0;
			
			for (LongWritable val : values) {
				sum += val.get();
			}
			
			context.write(key, new LongWritable(sum));
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		Configuration conf = new Configuration();
		Job job = new Job(conf, "CountCitation");
		
		job.setJarByClass(CountCitation.class);
		
		// 어떤 문서?
		FileInputFormat.addInputPath(job, new Path(args[0]));
		
		// 문서에 데이터를 한 줄씩 읽어서 Mapper에게 전달
		job.setInputFormatClass(KeyValueTextInputFormat.class);
		
		// Mapper
		job.setMapperClass(CountCitation.Map.class);
		// Combiner
		job.setCombinerClass(CountCitation.Reduce.class);
		// Reducer
		job.setReducerClass(CountCitation.Reduce.class);
		job.setNumReduceTasks(1);
		
		// Reducer가 만든 최종 결과를 파일에 기록
		job.setOutputFormatClass(TextOutputFormat.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		
		// 출력 문서 경로
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		// 하나의 Job에 대한 설정 끝
		
		// Job 실행
		job.waitForCompletion(true);
	}
	
}














