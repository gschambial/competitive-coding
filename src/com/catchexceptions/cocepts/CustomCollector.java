package com.catchexceptions.cocepts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public class CustomCollector {

	public static void main(String[] args) {
		/*
		 * T - Type of Stream
		 * A - Type of Container to carry intermediate results
		 * R - Type of final value to be returned
		 */
		Collector<String, StringBuilder, String> whiteSpaceCollector = 
				Collector.of(
							//Supplier: specifies the container to hold intermediate values and must be mutable
							() -> new StringBuilder(""),
							//Accumulator: takes container and Stream element and is used to update
							//container with intermediate value
							(b, s) -> b.append(s).append(" "), 
							//Combiner: is used to specify how 2 intermediate results will
							//be combined when operating parallel on Stream
							(b1, b2) -> {
								  return b1.append(b2);
										  
							},
							//Finisher: returns the final value
							(b1) -> b1.toString());
		List<String> numbers = new ArrayList<>();
		numbers.add("Gourav");
		numbers.add("Singh");
		numbers.add("Chambial");
		System.out.println(numbers.stream().collect(whiteSpaceCollector));
		
		
	}

}
