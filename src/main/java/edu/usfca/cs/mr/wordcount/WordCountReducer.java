package edu.usfca.cs.mr.wordcount;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

/**
 * Reducer: Input to the reducer is the output from the mapper. It receives
 * word, list<count> pairs.  Sums up individual counts per given word. Emits
 * <word, total count> pairs.
 */
public class WordCountReducer
extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {

    @Override
    protected void reduce(
            Text key, Iterable<DoubleWritable> values, Context context)
    throws IOException, InterruptedException {
        /* 1.
        int count = 0;
        for (IntWritable val:
             values) {
            count += val.get();
            context.write(key, new IntWritable(count));
        }*/

         /*2.
        TreeMap<DoubleWritable, Text> tm = new TreeMap<>();
        boolean snowDepthZero = false;
        double snowDepth = 0.0;
        int topcount=0;
        for(DoubleWritable val : values){
            if(val.get() == 0.0){
                snowDepthZero = true;
                break;
            }
            else
                snowDepth = val.get();
            if(topcount>10)
                break;
            topcount+=1;
        }
        if(!snowDepthZero){
            tm.put(new DoubleWritable(snowDepth),key);
        }
        for (Text geohash :
             tm.descendingMap().values()) {
            context.write(geohash,new DoubleWritable(snowDepth));
        }*/

         /*2.
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
        }*/

        ArrayList<Double> valAL = new ArrayList<>();
        for (DoubleWritable val:
             values) {
            valAL.add(val.get());
        }

        context.write(key,new DoubleWritable(Collections.max(valAL)));
    }

}
