package edu.usfca.cs.mr.snowDepth;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class SnowDepthReducer
        extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {

    @Override
    protected void reduce(
            Text key, Iterable<DoubleWritable> values, Context context)
            throws IOException, InterruptedException {

        boolean snowDepthZero = false;
        double snowDepth = 0.0;
        for (DoubleWritable val:
                values) {
            if(val.get()==0.0){
                snowDepthZero=true;
                break;
            }
            snowDepth=snowDepth+val.get();
        }
        if(!snowDepthZero){
            context.write(key,new DoubleWritable(snowDepth));
        }

    }

}
