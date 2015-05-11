import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;

public class WordCount2 {
	
	// Mapper
	public static class Map extends Mapper<Text, Text, Text, LongWritable> {
		
		private Text word = new Text();
		private final static LongWritable one = new LongWritable(1);
		
		@Override
		public void map(Text key, Text value,
				Mapper<Text, Text, Text, LongWritable>.Context context)
				throws IOException, InterruptedException {
			
			String line = value.toString();
			
			StringTokenizer tokenizer
					= new StringTokenizer(line, " \t\r\n\f|,.()<>[]");
			
			while (tokenizer.hasMoreTokens()) {
				word.set(tokenizer.nextToken().toLowerCase());
				context.write(word, one);
			}
			
		}
		
	}
	
	// Reducer
	public static class Reduce
			extends Reducer<Text, IntWritable, Text, LongWritable> {
		
		private LongWritable sumWritable = new LongWritable();
		
		@Override
		public void reduce(Text key, Iterable<IntWritable> values,
				Reducer<Text, IntWritable, Text, LongWritable>.Context context)
				throws IOException, InterruptedException {
			
			long sum = 0;
			
			for (IntWritable value : values) {
				sum += value.get();
			}
			
			sumWritable.set(sum);
			
			context.write(key, sumWritable);
			
		}
		
	}
	
	// main 메소드
	public static void main(String[] args) throws Exception {
		
		Configuration conf = new Configuration();
		Job job = new Job(conf, "WordCount2");
		
		job.setJarByClass(WordCount2.class);
		
		// InputFormat 설정
		job.setInputFormatClass(KeyValueTextInputFormat.class);
		// OutputFormat 설정
		job.setOutputFormatClass(TextOutputFormat.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		
		// Mapper 설정
		job.setMapperClass(WordCount2.Map.class);
		// Combiner 설정
		job.setCombinerClass(WordCount2.Reduce.class);
		// Reducer 설정
		job.setReducerClass(WordCount2.Reduce.class);
		
		// 입력 파일 지정
		FileInputFormat.addInputPath(job, new Path(args[0]));
		// 출력 파일 경로 지정
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.waitForCompletion(true);
		
	}
	
}
