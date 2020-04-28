package catchexceptions.java.cocepts;

public class MethodReferences {

	public static void main(String[] args) {
		Person p = new Person("Gourav", 26);

		System.out.println("Testing Static Method..................................");
		System.out.println();

		System.out.println("With lambda********************************************");
		PersonOperationsCheckStatic staticMethodCheckWithLambda = (person) -> PersonUtils.isAdult(person);
		System.out.println(staticMethodCheckWithLambda.isPersonAdult(p));

		System.out.println("With Method Reference**********************************");
		PersonOperationsCheckStatic staticMethodCheckWithMethodReference = PersonUtils::isAdult;
		System.out.println(staticMethodCheckWithMethodReference.isPersonAdult(p));

		System.out.println();

		System.out.println("Testing Instance Method................................");
		System.out.println();

		System.out.println("With lambda********************************************");
		PersonOperationsCheckInstance instanceMethodCheckWithLambda = (person) -> new PersonUtils()
				.isLegalToMarry(person);
		System.out.println(instanceMethodCheckWithLambda.isPersonLegalToMarry(p));

		System.out.println("With Method Reference**********************************");
		PersonOperationsCheckInstance instanceMethodCheckWithMethodReference = new PersonUtils()::isLegalToMarry;
		System.out.println(instanceMethodCheckWithMethodReference.isPersonLegalToMarry(p));

		System.out.println("With Method Reference using static syntax**************");
		PersonOperationsCheckArbitrary instanceMethodInStaticStyle = Person::isFirstLarger;
		System.out.println(instanceMethodInStaticStyle.isFirstPersonLarger(p, new Person("Varun", 18)));
		
		System.out.println("With Method Reference using static syntax**************");
		PersonOperationsCheckArbitraryDiffTypes instanceMethodInStaticStyleDiffParams = Person::isFirstLargerInteger;
		System.out.println(instanceMethodInStaticStyleDiffParams.isFirstPersonLarger(p, 18));
		
		System.out.println();

		System.out.println("Testing Constructor................................");
		System.out.println();

		System.out.println("With lambda********************************************");
		PersonOperations constructorCheckWithLambda = (name, age) -> new Person(name, age);
		System.out.println(constructorCheckWithLambda.get("Sourav", 20));

		System.out.println("With Method Reference**********************************");
		PersonOperations constructorCheckWithMethodReference = Person::new;
		System.out.println(constructorCheckWithMethodReference.get("Tarun", 28));

	}

}

/*
 * Functional Interface where body is a reference to static method of some other
 * class
 */
interface PersonOperationsCheckStatic {

	boolean isPersonAdult(Person person);
}

/*
 * Functional Interface where body is a reference to instance method of some
 * other class
 */
interface PersonOperationsCheckInstance {

	boolean isPersonLegalToMarry(Person person);
}

/*
 * 
 */
interface PersonOperationsCheckArbitrary {

	boolean isFirstPersonLarger(Person p1, Person p2);
}

/*
 * 
 */
interface PersonOperationsCheckArbitraryDiffTypes {

	boolean isFirstPersonLarger(Person p1, Integer i);
}

class PersonUtils {

	public static boolean isAdult(Person person) {
		return person.getAge() >= 18 ? true : false;
	}

	public boolean isLegalToMarry(Person person) {
		return person.getAge() >= 21 ? true : false;
	}

}

/*
 * Functional Interface where body is reference to constructor of some class
 */
interface PersonOperations {

	Person get(String name, Integer age);
}

class Person {

	private String name;
	private Integer age;

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public boolean isFirstLarger(Person p) {
		return this.getAge() >= p.getAge();
	}
	
	public boolean isFirstLargerInteger(Integer i) {
		return this.getAge() >= i;
	}

}
