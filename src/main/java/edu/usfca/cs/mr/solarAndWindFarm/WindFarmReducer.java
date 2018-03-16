package edu.usfca.cs.mr.solarAndWindFarm;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


public class WindFarmReducer
        extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {

    @Override
    protected void reduce(
            Text geohash, Iterable<DoubleWritable> values, Context context)
            throws IOException, InterruptedException {
        ArrayList<Double> windSpeedAL = new ArrayList<>();
        for (DoubleWritable val:
                values) {
            windSpeedAL.add(val.get());
        }
        context.write(geohash,new DoubleWritable(Collections.max(windSpeedAL)));

    }

}
