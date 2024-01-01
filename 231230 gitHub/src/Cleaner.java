
public class Cleaner extends Employee {

	public Cleaner(String name, String number) {
		super(name, number);
	}

	@Override
	public void LoginStart() {
		System.out.println("cleaner method");
	}

}
