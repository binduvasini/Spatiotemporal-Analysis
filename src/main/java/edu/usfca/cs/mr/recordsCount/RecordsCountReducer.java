package edu.usfca.cs.mr.recordsCount;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class RecordsCountReducer
extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    protected void reduce(
            Text key, Iterable<IntWritable> values, Context context)
    throws IOException, InterruptedException {

        int count = 0;
        for (IntWritable val:
             values) {
            count += val.get();
            context.write(key, new IntWritable(count));
        }
    }
}
