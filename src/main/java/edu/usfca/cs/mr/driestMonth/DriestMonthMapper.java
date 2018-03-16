package edu.usfca.cs.mr.driestMonth;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DriestMonthMapper
extends Mapper<LongWritable, Text, LongWritable, DoubleWritable> {

    @Override
    protected void map(LongWritable key, Text text, Context context)
        throws IOException, InterruptedException {


        String line = text.toString();
        String[] tokens = line.split("\t");
        if(tokens[1].startsWith("9q")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(Long.parseLong(String.valueOf(tokens[0])));

            context.write(new LongWritable(Long.parseLong(simpleDateFormat.format(calendar.getTime()))), new DoubleWritable(Double.parseDouble(tokens[12])));
        }
    }
}
