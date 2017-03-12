package com.acadgild.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Task3Mapper extends Mapper<LongWritable,Text,Text ,Text>{
	
	public void map(LongWritable key,Text value,Context context)throws InterruptedException,IOException{
	String[] lineArray=value.toString().split("\\|");
	if(!(lineArray[0].equals("NA") ||lineArray[1].equals("NA")) ){
		if(lineArray[0].equals("Onida")){
			Text state=new Text(lineArray[3]);
			Text product=new Text(lineArray[1]);			
			context.write(state, product);
		}
	}
}

	
}