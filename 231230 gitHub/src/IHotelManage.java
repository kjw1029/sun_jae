
public interface IHotelManage {
	// 명단접근
	Customer[] getCustomerList(Customer cus);
	// 예약
	void reservation(Room room, Customer cus);
	// 예약취소?
	void cancelReservation(Customer cus);
	// 예약 확인 
	void checkReservation(Customer cus);
	// 방 고객(체크인)
	void checkIn (Customer cus);
	// 체크아웃
	void checkOut(Customer cus);
	// 청소
	
	// 워크인? 예약?
	
}
