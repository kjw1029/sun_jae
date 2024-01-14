import java.util.List;

public abstract class CustomerManage {
	private String name;
	private String phone;
	private int unit;
	private String customerReservationStatus;
	
	public CustomerManage(String name, String phone, int unit, String customerReservationStatus) {
		this.name = name;
		this.phone = phone;
		this.unit = unit;
		this.customerReservationStatus = customerReservationStatus;
	}
	
	public void reservation(Room roomunit) {
//		this(); // 왜 생성자가 안되는거죠? 알려주세요..
		if (this.unit == roomunit.getUnit()) {
			if (roomunit.getRoomstatus().equals("예약")) {
				System.out.println("예약되어있는 방입니다.");
			} else if (roomunit.getRoomstatus().equals("빈방")) {
				System.out.println("예약 완료");
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	public void cancelReservation() {
		
		
	}
	public void listAccess(List<Customer> list) {
//		list.get
	}
	public void findCustomer() {
		
	}
	public void customerApproach () {
		
	}
}
