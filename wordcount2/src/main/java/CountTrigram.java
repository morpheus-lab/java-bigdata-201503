import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;

public class CountTrigram {
	
	// Mapper
	public static class Map extends Mapper<Text, Text, Text, LongWritable> {
		
		private final static LongWritable one = new LongWritable(1);
		
		@Override
		public void map(Text key, Text value,
				Mapper<Text, Text, Text, LongWritable>.Context context)
				throws IOException, InterruptedException {
			
			String line = value.toString();
			
			StringTokenizer tokenizer
					= new StringTokenizer(line, " \t\r\n\f|,.()<>{}[]\"\'=~!@#$%^&*_+/");
			
			if (tokenizer.countTokens() >= 3) {
				String firstWord = tokenizer.nextToken();
				String secondWord = tokenizer.nextToken();
				
				while (tokenizer.hasMoreTokens()) {
					String thirdWord = tokenizer.nextToken();
					
					Text trigram = new Text(firstWord + " " + secondWord + " " + thirdWord);
					context.write(trigram, one);
					
					firstWord = secondWord;
					secondWord = thirdWord;
				}
			}
			
		}
		
	}
	
	// Reducer
	public static class Reduce
			extends Reducer<Text, IntWritable, Text, LongWritable> {
		
		@Override
		public void reduce(Text key, Iterable<IntWritable> values,
				Reducer<Text, IntWritable, Text, LongWritable>.Context context)
				throws IOException, InterruptedException {
			
			long sum = 0;
			
			for (IntWritable value : values) {
				sum += value.get();
			}
			
			context.write(key, new LongWritable(sum));
			
		}
		
	}
	
	// main 메소드
	public static void main(String[] args) throws Exception {
		
		Configuration conf = new Configuration();
		Job job = new Job(conf, "CountTrigram");
		
		job.setJarByClass(CountTrigram.class);
		
		// InputFormat 설정
		job.setInputFormatClass(KeyValueTextInputFormat.class);
		// OutputFormat 설정
		job.setOutputFormatClass(TextOutputFormat.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		
		// Mapper 설정
		job.setMapperClass(CountTrigram.Map.class);
		// Combiner 설정
		job.setCombinerClass(CountTrigram.Reduce.class);
		// Reducer 설정
		job.setReducerClass(CountTrigram.Reduce.class);
		
		// 입력 파일 지정
		FileInputFormat.addInputPath(job, new Path(args[0]));
		// 출력 파일 경로 지정
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		if (!job.waitForCompletion(true)) {
			return;
		}
		
		Configuration conf2 = new Configuration();
		Job job2 = new Job(conf2, "TopN");
		
		job2.setJarByClass(TopN.class);
		job2.setOutputKeyClass(Text.class);
		job2.setOutputValueClass(LongWritable.class);
		
		job2.setMapperClass(TopN.Map.class);
		job2.setReducerClass(TopN.Reduce.class);
		job2.setNumReduceTasks(1);
		
		job2.setInputFormatClass(KeyValueTextInputFormat.class);
		job2.setOutputFormatClass(TextOutputFormat.class);
		
		FileInputFormat.addInputPath(job2, new Path(args[1] + "/part-r-00000"));
		FileOutputFormat.setOutputPath(job2, new Path(args[1] + "/topN"));
		job2.getConfiguration().setInt("topN", Integer.parseInt(args[2]));
		
		job2.waitForCompletion(true);
	}
	
}
