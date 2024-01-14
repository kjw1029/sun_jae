import java.util.Objects;

public class Person {
	private String name;
	private String number;
	public Person(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}

	public Person() {

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return Objects.equals(name, person.name) && Objects.equals(number, person.number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, number);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

}


