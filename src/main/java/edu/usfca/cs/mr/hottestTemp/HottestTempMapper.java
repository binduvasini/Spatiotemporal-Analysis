package edu.usfca.cs.mr.hottestTemp;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class HottestTempMapper
extends Mapper<LongWritable, Text, Text, DoubleWritable> {

    @Override
    protected void map(LongWritable key, Text text, Context context)
        throws IOException, InterruptedException {

        String line = text.toString();
        String[] tokens = line.split("\t");
        context.write(new Text(tokens[1]+";"+tokens[0]),new DoubleWritable(Double.parseDouble(tokens[40])));
    }
}
