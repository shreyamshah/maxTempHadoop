package temp;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class tempReduce extends Reducer<Text,FloatWritable,Text,FloatWritable> {

	@Override
	protected void reduce(Text keyIn, Iterable<FloatWritable> valueIn,
			Context arg2)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		float maxTemp = 0;
		for (FloatWritable temp : valueIn) {
			maxTemp = Math.max(maxTemp, temp.get());
		}
		arg2.write(keyIn, new FloatWritable(maxTemp));
	}
}
