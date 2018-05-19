package mapred.ex;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Assgn5Mapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	@Override
	public void map(LongWritable key, Text value, Context context) 
		throws IOException, InterruptedException {
		
		// Split the input record based on the delimeter "|". Because "|" is a special char, 
		// We have to use it along with the 2 escape characters - "\\|"
		String[] strArr = value.toString().split("\\|");
		// Make the company name (index 0 in the input file) as the key so as to consolidate the number of units based on company.
		Text outputkey = new Text(strArr[0]);	
		// For every record matching the key, assign the value of "1". 
		//This will be used in the Reduce to sum to get to the total units for each company.
		IntWritable outputvalue = new IntWritable(1);
		
		// The below logic is to ignore the records that have "NA" for company name and brand name.
		if (!(strArr[0].contains("NA"))) {
			if (!(strArr[1].contains("NA"))) {
				// write to context the valid records, after ignoring the "NA".
				context.write(outputkey, outputvalue);
			}
		}
		;
	}

}
