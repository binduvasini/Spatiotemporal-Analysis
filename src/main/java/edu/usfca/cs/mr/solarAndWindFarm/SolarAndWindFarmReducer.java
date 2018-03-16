package edu.usfca.cs.mr.solarAndWindFarm;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


public class SolarAndWindFarmReducer
        extends Reducer<Text, Text, Text, DoubleWritable> {

    @Override
    protected void reduce(
            Text geohash, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        ArrayList<Double> cloudCoverAL = new ArrayList<>();
        ArrayList<Double> windSpeedAL = new ArrayList<>();
        for (Text val:
                values) {
            String[] cloudAndWind = String.valueOf(val).split(";");
            cloudCoverAL.add(Double.parseDouble(cloudAndWind[0]));
            windSpeedAL.add(Double.parseDouble(cloudAndWind[1]));
        }
        double avg = (Collections.min(cloudCoverAL)+Collections.max(windSpeedAL))/2;
        context.write(geohash,new DoubleWritable(avg));
    }

}
