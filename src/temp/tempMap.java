package temp;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.record.compiler.generated.Token;

public class tempMap extends Mapper<LongWritable,Text,Text,FloatWritable> {
	@Override
	protected void map(LongWritable key, Text value,
			Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//if(key.toString()!=null)
		//{
			String string = value.toString();
			StringTokenizer tokens = new StringTokenizer(string);
			while(tokens.hasMoreElements())
			{
				String opKey = tokens.nextToken();
				Float opVal = Float.parseFloat(tokens.nextToken());
				context.write(new Text(opKey), new FloatWritable(opVal));
			}
		//}
	}
}
