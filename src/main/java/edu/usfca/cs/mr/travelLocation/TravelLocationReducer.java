package edu.usfca.cs.mr.travelLocation;

import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.util.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


public class TravelLocationReducer
        extends Reducer<Text, Text, Text, Text> {

    @Override
    protected void reduce(
            Text geohash, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        HashSet<String> timeToVisit = new HashSet<>();

        for (Text val:
                values) {
            String[] timeAndHumid = String.valueOf(val).split(";");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(Long.parseLong(timeAndHumid[0]));
            String month = simpleDateFormat.format(calendar.getTime());
            double humidity = Double.parseDouble(timeAndHumid[1]);

            if(humidity>0 && humidity<60){
                timeToVisit.add(month);
            }
        }
        context.write(geohash,new Text(String.valueOf(timeToVisit)));

    }

}
