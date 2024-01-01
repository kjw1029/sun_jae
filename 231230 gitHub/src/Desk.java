
public class Desk extends Employee {

	public Desk(String name, String number) {
		super(name, number);
	}

	@Override
	public void LoginStart() {
		System.out.println("desk method");
	}

}
