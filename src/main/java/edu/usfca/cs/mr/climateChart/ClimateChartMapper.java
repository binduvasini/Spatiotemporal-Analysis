package edu.usfca.cs.mr.climateChart;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class ClimateChartMapper
        extends Mapper<LongWritable, Text, LongWritable, Text> {

    @Override
    protected void map(LongWritable key, Text text, Context context)
            throws IOException, InterruptedException {
        String line = text.toString();
        String[] tokens = line.split("\t");
        if(tokens[1].startsWith("9q8yny6gc2pb")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(Long.parseLong(String.valueOf(tokens[0])));

            context.write(new LongWritable(Long.parseLong(simpleDateFormat.format(calendar.getTime()))), new Text(tokens[40] + ";" + tokens[55]));
        }
    }
}
