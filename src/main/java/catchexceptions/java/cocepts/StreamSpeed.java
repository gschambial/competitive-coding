package catchexceptions.java.cocepts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StreamSpeed {

	public static void main(String[] args) {
		
		List<Long> numbers = new ArrayList<Long>();
		IntStream.range(0, 10000000).forEach( (i) ->
				numbers.add((long)Math.floor(Math.random() * 10))
		);
		
		long started = System.currentTimeMillis();
		long sum = 0;
		for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i);
		}
		long ended = System.currentTimeMillis();
		System.out.println("Sum: " + sum);
		System.out.println("loop time: " + (ended - started));
		started = System.currentTimeMillis();
		sum = numbers.parallelStream().mapToLong(Long::longValue).sum();
		ended = System.currentTimeMillis();
		System.out.println("Sum: " + sum);
		System.out.println("Stream time: " + (ended - started));
	}

}
