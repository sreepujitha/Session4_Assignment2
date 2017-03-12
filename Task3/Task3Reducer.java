package com.acadgild.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Task3Reducer extends Reducer<Text,Text,Text,IntWritable>{

	public void reduce(Text key,Iterable<Text> values,Context context)
			throws InterruptedException,IOException{
		int totalUnits=0;
		for(Text value:values){
			totalUnits++;			
		}
		context.write(key,new IntWritable(totalUnits));

	}
}
