
public class Cleaner extends Employee {

	public Cleaner(String name, String number) {
		super(name, number);
	}

	@Override
	public void LoginStart() {
		System.out.println("1.청소관리  2. 출퇴근 인증 3.로그아웃 ");
	}

}
