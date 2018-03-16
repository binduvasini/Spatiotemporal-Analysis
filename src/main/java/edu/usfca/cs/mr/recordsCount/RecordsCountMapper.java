package edu.usfca.cs.mr.recordsCount;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;


public class RecordsCountMapper
extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    protected void map(LongWritable key, Text text, Context context)
        throws IOException, InterruptedException {
        StringTokenizer itr = new StringTokenizer(text.toString());
        while (itr.hasMoreTokens()) {
            itr.nextToken();

            context.write(new Text("record"), new IntWritable(1));
        }

    }
}
