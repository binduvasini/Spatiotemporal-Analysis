package edu.usfca.cs.mr.driestMonth;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;

public class DriestMonthReducer
extends Reducer<LongWritable, DoubleWritable, LongWritable, DoubleWritable> {

    @Override
    protected void reduce(
            LongWritable time, Iterable<DoubleWritable> values, Context context)
    throws IOException, InterruptedException {


        ArrayList<Double> humidityAL = new ArrayList<>();
        double humidity=0.0;
        for (DoubleWritable val:
             values) {
            humidityAL.add(val.get());
            humidity+=val.get();
        }
        double avgHumidity=humidity/humidityAL.size();
        context.write(time,new DoubleWritable(avgHumidity));
    }

}
