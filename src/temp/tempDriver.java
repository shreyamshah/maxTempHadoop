package temp;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.lib.output.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.*;

public class tempDriver {
public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
	Configuration conf = new Configuration();
	Job jb = Job.getInstance(conf);
	jb.setJarByClass(tempDriver.class);
	jb.setJobName("Max Temperature Program");
	jb.setOutputKeyClass(Text.class);
	jb.setOutputValueClass(FloatWritable.class);
	jb.setMapperClass(tempMap.class);
	jb.setReducerClass(tempReduce.class);
	FileInputFormat.addInputPath(jb,new Path(args[0]));
	FileOutputFormat.setOutputPath(jb, new Path(args[1]));
	jb.waitForCompletion(true);
}
}
