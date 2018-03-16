package edu.usfca.cs.mr.wordcount;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Mapper: Reads line by line, split them into words. Emit <word, 1> pairs.
 */
public class WordCountMapper
extends Mapper<LongWritable, Text, Text, DoubleWritable> {

    @Override
    protected void map(LongWritable key, Text text, Context context)
        throws IOException, InterruptedException {
        /*StringTokenizer itr = new StringTokenizer(text.toString());
        while (itr.hasMoreTokens()) {
            itr.nextToken();

            //context.write(new Text(), new IntWritable(1));
        }*/


        /*String line = text.toString();
        String[] tokens = line.split("\t");
        context.write(new Text(tokens[1]),new DoubleWritable(Double.parseDouble(tokens[50])));*/

        String line = text.toString();
        String[] tokens = line.split("\t");
        context.write(new Text(tokens[1]),new DoubleWritable(Double.parseDouble(tokens[40])));
    }
}
