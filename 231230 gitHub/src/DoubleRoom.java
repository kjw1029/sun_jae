
public class DoubleRoom extends RoomInfo{
	private Person person;

	public DoubleRoom(int unit, int price, String roomtype, String roomStatus, boolean isClean) {
		super(unit, price, roomtype, roomStatus, isClean);
	}
	
	public DoubleRoom(int unit, int price, String roomtype, String roomStatus, boolean isClean,Person person) {
		super(unit, price,roomtype, roomStatus, isClean);
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
