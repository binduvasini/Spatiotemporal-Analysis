package edu.usfca.cs.mr.climateChart;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class ClimateChartReducer
        extends Reducer<LongWritable, Text, LongWritable, Text> {

    @Override
    protected void reduce(
            LongWritable time, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

        ArrayList<Double> tempAL = new ArrayList<>();
        ArrayList<Double> precipAL = new ArrayList<>();
        for (Text val:
                values) {
            String[] tempAndPrecip = String.valueOf(val).split(";");
            tempAL.add(Double.parseDouble(tempAndPrecip[0]));
            precipAL.add(Double.parseDouble(tempAndPrecip[1]));
        }

        double highTemp = Collections.max(tempAL);
        double lowTemp = Collections.min(tempAL);
        double sumTemp = 0.0;
        for (Double temp:
             tempAL) {
            sumTemp+=temp;
        }
        double avgTemp = sumTemp/tempAL.size();
        double sumPrecip = 0.0;
        for (Double precip:
             precipAL) {
            sumPrecip+=precip;
        }
        double avgPrecip = sumPrecip/precipAL.size();
        context.write(time,new Text(highTemp+"\t"+lowTemp+"\t"+avgPrecip+"\t"+avgTemp));

    }

}
