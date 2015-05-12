import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class JoinIDTitle {
	
	/* 2M.TITLE.ID 용 매퍼 */
	public static class Map1 extends Mapper<Text, Text, Text, Text> {
		@Override
		public void map(Text key, Text value,
				Mapper<Text, Text, Text, Text>.Context context)
				throws IOException, InterruptedException {
			context.write(value, new Text(key.toString() + "\t1"));
			context.getCounter("State", "Number of Title + DocID").increment(1);
		}
	}
	
	/* CountCitation/TopN 용 매퍼 */
	public static class Map2 extends Mapper<Text, Text, Text, Text> {
		@Override
		public void map(Text key, Text value,
				Mapper<Text, Text, Text, Text>.Context context)
				throws IOException, InterruptedException {
			context.write(key, new Text(value.toString() + "\t2"));
			context.getCounter("State", "Number of Freq").increment(1);
		}
	}
	
	/* Reducer */
	public static class Reduce extends Reducer<Text, Text, Text, Text> {
		@Override
		public void reduce(Text key, Iterable<Text> values,
				Reducer<Text, Text, Text, Text>.Context context)
				throws IOException, InterruptedException {
			String title = null;
			String freq = null;
			for (Text val : values) {
				String[] temp = val.toString().split("\\t", 2);
				if (temp.length < 2) {
					continue;
				}
				if ("1".equals(temp[1]))
					title = temp[0];
				else if ("2".equals(temp[1]))
					freq = temp[0];
			}
			if (title != null && freq != null) {
				context.write(key, new Text(freq + "\t" + title));
				context.getCounter("State", "Number of freq & title").increment(1);
			} else if (title == null) {
				context.getCounter("State", "Number of title NULL").increment(1);
			} else if (freq == null) {
				context.getCounter("State", "Number of freq NULL").increment(1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		String docTitleFile = args[0];	// 2M.TITLE.ID
		String docFreqFile = args[1];	// CountCitation/TopN의 결과
		String outputDir = args[2];		// 결과 출력 디렉토리
		
		if (docTitleFile == null || docFreqFile == null || outputDir == null) {
			System.err.println("사용법: hadoop jar <JAR_FILE> "
					+ "JoinIDTitle {문서 제목 파일} {문서 빈도수 파일} "
					+ "{출력 디렉토리}");
			System.exit(1);
		}
		
		Configuration conf = new Configuration();
		Job job = new Job(conf, "JoinIDTitle");
		
		job.setJarByClass(JoinIDTitle.class);
		
		// 입력 파일 지정 & inputFormat 설정 & Mapper 설정
		MultipleInputs.addInputPath(job, new Path(docTitleFile),
				KeyValueTextInputFormat.class, JoinIDTitle.Map1.class);
		MultipleInputs.addInputPath(job, new Path(docFreqFile),
				KeyValueTextInputFormat.class, JoinIDTitle.Map2.class);
		
		// 출력 디렉토리 지정
		FileOutputFormat.setOutputPath(job, new Path(outputDir));
		
		// 출력 데이터 포맷 지정
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		// 리듀서 지정
		job.setReducerClass(JoinIDTitle.Reduce.class);
		
		// 잡 실행
		job.waitForCompletion(true);
	}
	
}




























