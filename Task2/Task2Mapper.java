package com.acadgild.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class Task2Mapper extends Mapper<LongWritable,Text,Text ,Text>{
	
	public void map(LongWritable key,Text value,Context context)throws InterruptedException,IOException{
	String[] lineArray=value.toString().split("\\|");
	if(!(lineArray[0].equals("NA") ||lineArray[1].equals("NA")) ){
		Text companyName=new Text(lineArray[0]);
		Text product=new Text(lineArray[1]);
		
		context.write(companyName, product);
	}
}

	
}