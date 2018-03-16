package edu.usfca.cs.mr.solarAndWindFarm;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class SolarAndWindFarmMapper
extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    protected void map(LongWritable key, Text text, Context context)
        throws IOException, InterruptedException {

        String line = text.toString();
        String[] tokens = line.split("\t");
        double u_comp_wind = Double.parseDouble(tokens[53]);
        double v_comp_wind = Double.parseDouble(tokens[37]);
        double windSpeed = Math.sqrt(Math.pow(u_comp_wind,2)+Math.pow(v_comp_wind,2));
        context.write(new Text(tokens[1]), new Text(tokens[16]+";"+windSpeed));
    }
}
