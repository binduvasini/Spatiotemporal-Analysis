package edu.usfca.cs.mr.lightning;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class LightningMapper
        extends Mapper<LongWritable, Text, Text, DoubleWritable> {

    @Override
    protected void map(LongWritable key, Text text, Context context)
            throws IOException, InterruptedException {

        String line = text.toString();
        String[] tokens = line.split("\t");

        context.write(new Text(tokens[1].substring(0,4)), new DoubleWritable(Double.parseDouble(tokens[22])));

    }
}
