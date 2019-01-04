import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ProfileReducer extends Reducer<Text, IntWritable, Text, Text> {
  @Override
  public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
    Integer maxLength = 0;
    for (IntWritable value : values) {
      maxLength = Math.max(maxLength, value.get());
    }
    context.write(key, new Text(maxLength.toString()));
  }
}
