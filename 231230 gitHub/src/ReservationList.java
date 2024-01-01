

public class ReservationList {
	private Customer reservationPerson;

	public ReservationList(Customer reservationPerson) {
		super();
		this.reservationPerson = reservationPerson;
	}

	public Customer getReservationPerson() {
		return reservationPerson;
	}

	public void setReservationPerson(Customer reservationPerson) {
		this.reservationPerson = reservationPerson;
	} 
	
}
