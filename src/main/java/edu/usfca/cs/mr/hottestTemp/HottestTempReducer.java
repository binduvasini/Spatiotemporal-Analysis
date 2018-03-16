package edu.usfca.cs.mr.hottestTemp;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class HottestTempReducer
extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {

    @Override
    protected void reduce(
            Text key, Iterable<DoubleWritable> values, Context context)
    throws IOException, InterruptedException {

        ArrayList<Double> valAL = new ArrayList<>();
        for (DoubleWritable val:
             values) {
            valAL.add(val.get());
        }

        context.write(key,new DoubleWritable(Collections.max(valAL)));
    }

}
