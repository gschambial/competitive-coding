package catchexceptions.java.cocepts;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import catchexceptions.java.beans.Person;

public class FunctionalInterfaces {

	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>();

		Person p26 = new Person("Gourav", 26);
		Person p20 = new Person("Sourav", 15);

		persons.add(p26);
		persons.add(p20);

		System.out.println("Testing Predicate..................................");
		Predicate<Person> personPredicate = (person) -> person.getAge() > 18;
		System.out.println(personPredicate.test(p26));

		System.out.println("Testing Function...................................");
		Function<Person, String> personFunction = (person) -> personPredicate.test(person) ? "Adult" : "Kid";
		System.out.println(personFunction.apply(p26));
		System.out.println(personFunction.apply(p20));

		System.out.println("Testing Supplier...................................");
		Supplier<Double> randomIntSupplier = () -> Math.floor(Math.random() * 10);
		System.out.println(randomIntSupplier.get());

		System.out.println("Testing Consumer...................................");
		Consumer<List<Person>> ageConsumer = (personsList) -> {
			personsList.forEach((person) -> {
				if (person.getAge() >= 18) {
					System.out.println("Adult");
				} else {
					throw new RuntimeException("Not an adult");
				}
			});
		};
		try {
		ageConsumer.accept(persons);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("Testing BiFunction...................................");
		BiFunction<Person, Person, Integer> greaterAgeBifunction = (p1, p2) -> p1.getAge() >= p2.getAge() ? p1.getAge() :p2.getAge();
		System.out.println(greaterAgeBifunction.apply(p26, p20));
	}

}
