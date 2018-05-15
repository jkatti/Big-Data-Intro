package mapred;

import java.io.IOException;

//import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Assgn6Mapper extends Mapper<LongWritable, Text, LongWritable, Text> {
	
	@Override
	public void map(LongWritable key, Text value, Context context) 
		throws IOException, InterruptedException {
		
		String[] strArr = value.toString().split("\\|");
		System.out.println("StrArr :" + strArr[0]);
		/*
		if (!(strArr[0].contains("NA"))) {
			//System.out.println("STRING 1:" + strArr[0] + " | " + strArr[1]);
			if (!(strArr[1].contains("NA"))) {
				//System.out.println("STRING 2:" + strArr[0] + " | " + strArr[1]);
				context.write(key, value);
			}
		}
		*/
		if (!(strArr[0].contains("NA")) && !(strArr[1].contains("NA"))) {
			context.write(key, value);
		}
		
		
		
	}

}
