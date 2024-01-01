
public class Desk extends Employee {

	public Desk(String name, String number) {
		super(name, number);
	}

	@Override
	public void LoginStart() {
		System.out.println("1.예약관리  2. 출퇴근 인증 3.로그아웃 ");
	}

}
