import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static Scanner scanner = new Scanner(System.in);

	private static Person manager = new Manager("매니저", "매니저1234");
	private static Person desk = new Desk("데스크", "데스1234");
	private static Person cleaner = new Cleaner("청소", "청소1234");
	private static Person[] customer = new Customer[80];
	static	Person[] employee = new Person[] {(Employee) manager, (Employee) desk, (Employee) cleaner};
	public static void main(String[] args) {

//		employee[0] = (Employee) manager;
//		employee[1] = (Employee) desk;
//		employee[2] = (Employee) cleaner;
		System.out.println(employee[0].getName());

		boolean go = true;

		Employee loggedInUser = new Employee("", "");
//		Person loggedInUser = new Person("", "");
//		
		System.out.print("사용자 이름을 입력하세요: ");
		String username = scanner.next();
		loggedInUser.setName(username);

		System.out.print("비밀번호를 입력하세요: ");
		String password = scanner.next();
		loggedInUser.setNumber(password);
		System.out.println(loggedInUser.getName());
		if (loggedInUser.getName().equals(manager.getName()) && loggedInUser.getNumber().equals(manager.getNumber())) {

			if (loggedInUser instanceof Manager) {
//								Manager down = (Manager) loggedInUser;
				System.out.println("dd");
//				((Manager) loggedInUser).LoginStart();
			}
		}
//					} catch {
//					}

	}

}

/*
 * //User loggedInUser = loginManager.login(username, password);
 * 
 * if (loggedInUser != null) { while(go) { System.out.println("");
 * 
 * try { // 어드민 계정일 경우 if (loggedInUser.isAdmin()) {
 * System.out.println("1.예약관리  2.출퇴근 관리 3.매출 관리 4.로그아웃"); int Asellect =
 * scanner.nextInt();
 * 
 * if (Asellect == 1) { chkoutInfo = hotel.hotel(false); } else if (Asellect ==
 * 2) { // AttendanceSystem.AdminWork(); workInAndOutSet(loggedInUser.isAdmin(),
 * loggedInUser.getUsername()); } else if (Asellect == 3) { //매출관리
 * manager.retvMoney(chkoutInfo[0], chkoutInfo[1], chkoutInfo[2],
 * chkoutInfo[3]); } else if (Asellect == 4) { loginEnd(); go = false; }
 * 
 * // 일반 계정일 경우 } else if (loggedInUser.getUsername().equals("데스크")) {
 * System.out.println("1.예약관리  2. 출퇴근 인증 3.로그아웃 "); //DeskSellct();
 * 
 * int Dsellect = scanner.nextInt(); if (Dsellect == 1) { chkoutInfo =
 * hotel.hotel(false); } else if (Dsellect == 2) {
 * workInAndOutSet(loggedInUser.isAdmin(), loggedInUser.getUsername()); // 데스크
 * 청소용 출퇴근
 * 
 * 
 * go = false; }
 * 
 * // 청소부일 경우 } else if (loggedInUser.getUsername().equals("청소")) {
 * System.out.println("1.청소관리  2. 출퇴근 인증 3.로그아웃 "); //
 * CleanerProgram.cleanerProgram(); int csellect = scanner.nextInt(); if
 * (csellect == 1) { hotel.hotel(true); } else if (csellect == 2) {
 * workInAndOutSet(loggedInUser.isAdmin(), loggedInUser.getUsername()); //데스크
 * 청소용 출퇴근
 * 
 * } else if (csellect == 3) { loginEnd(); go = false; } }
 * 
 * } catch (Exception e) {
 * System.out.println("올바르지 못한 값을 입력하여 로그아웃 처리됩니다.\n재로그인해 주십시오.");
 * scanner.nextLine(); loginStart(); } }
 * 
 * } else { System.out.println("로그인 실패. 사용자 정보를 확인하세요."); loginStart(); } }
 */
