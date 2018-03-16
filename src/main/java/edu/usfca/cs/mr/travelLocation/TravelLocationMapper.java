package edu.usfca.cs.mr.travelLocation;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class TravelLocationMapper
extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    protected void map(LongWritable key, Text text, Context context)
        throws IOException, InterruptedException {

        String line = text.toString();
        String[] tokens = line.split("\t");
        if(tokens[1].startsWith("dpxt") || tokens[1].startsWith("f244") || tokens[1].startsWith("dpz8") || tokens[1].startsWith("9qqj") || tokens[1].startsWith("dqcj"))
            context.write(new Text(tokens[1]), new Text(tokens[0]+";"+tokens[12]));
    }
}
