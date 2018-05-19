package mapred;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Assgn5Mapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	@Override
	public void map(LongWritable key, Text value, Context context) 
		throws IOException, InterruptedException {
		
		String[] strArr = value.toString().split("\\|");
		Text outputkey = new Text(strArr[3]);	
		IntWritable outputvalue = new IntWritable(1);
		
		if (!(strArr[0].contains("NA"))) {
			if (!(strArr[1].contains("NA"))) {
				if (strArr[0].contains("Onida")) {
					context.write(outputkey, outputvalue);
				}				
			}
		}
		
	}

}
