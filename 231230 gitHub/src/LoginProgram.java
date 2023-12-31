
import java.util.Scanner;

public class LoginProgram {

	public static Scanner scanner = new Scanner(System.in);
	public static LoginManager loginManager = new LoginManager(3); // 최대 10명의 사용자를 저장할 수 있는 배열
	public static Hotel hotel = new Hotel();
	public static int[] chkoutInfo = new int[4];
	public static boolean isDebug = true;
	private static Manager manager = new Manager("매니저", "매니저1234");
	
	// 로그인 프로그램 시작
	public static void loginStart() {
		System.out.print("사용자 이름을 입력하세요: ");
		String username = scanner.next();

		System.out.print("비밀번호를 입력하세요: ");
		String password = scanner.next();
		
		boolean go = true;
		
		User loggedInUser = loginManager.login(username, password);
		
		if (loggedInUser != null) {
			while(go) {
			System.out.println("");
			
				try {
					// 어드민 계정일 경우
					if (loggedInUser.isAdmin()) {
						System.out.println("1.예약관리  2.출퇴근 관리 3.매출 관리 4.로그아웃");
						int Asellect = scanner.nextInt();
						
						if (Asellect == 1) {
							chkoutInfo = hotel.hotel(false);
						} else if (Asellect == 2) {
						//	AttendanceSystem.AdminWork();
							workInAndOutSet(loggedInUser.isAdmin(), loggedInUser.getUsername());
						} else if (Asellect == 3) {
							//매출관리
						manager.retvMoney(chkoutInfo[0], chkoutInfo[1], chkoutInfo[2], chkoutInfo[3]);
						} else if (Asellect == 4) {
							loginEnd();
							go = false;
						}
						
					// 일반 계정일 경우 
					} else if (loggedInUser.getUsername().equals("데스크")) {
						System.out.println("1.예약관리  2. 출퇴근 인증 3.로그아웃 ");
						//DeskSellct();
						
						int Dsellect = scanner.nextInt();
						if (Dsellect == 1) {
							chkoutInfo = hotel.hotel(false);
						} else if (Dsellect == 2) {
							workInAndOutSet(loggedInUser.isAdmin(), loggedInUser.getUsername()); // 데스크 청소용 출퇴근
							
						} else if (Dsellect == 3) {
							loginEnd();
							go = false;
						}
						
					// 청소부일 경우
					} else if (loggedInUser.getUsername().equals("청소")) {
						System.out.println("1.청소관리  2. 출퇴근 인증 3.로그아웃 ");
						// CleanerProgram.cleanerProgram();
						int csellect = scanner.nextInt();
						if (csellect == 1) {
							hotel.hotel(true);
						} else if (csellect == 2) {
							workInAndOutSet(loggedInUser.isAdmin(), loggedInUser.getUsername()); //데스크 청소용 출퇴근
		
						} else if (csellect == 3) {
							loginEnd();
							go = false;
						}
					}
					
				} catch (Exception e) {
					System.out.println("올바르지 못한 값을 입력하여 로그아웃 처리됩니다.\n재로그인해 주십시오.");
					scanner.nextLine();
					loginStart();
				}
			}
			
		} else {
			System.out.println("로그인 실패. 사용자 정보를 확인하세요.");
			loginStart();
		}
	}
	
	public static void workTypeSelect(User loggedInUser, boolean go) {
		
	}
	
	// 로그인 종료시키는 메서드
	public static void loginEnd() {
		Scanner endScrChk = new Scanner(System.in);
		System.out.println("1.사용자변경 2.프로그램 종료");
		String endProgram = endScrChk.nextLine();
		if ("1".equals(endProgram)) {
			loginStart();
		} else if ("2".equals(endProgram)) {
			System.out.println("프로그램 종료");
			System.exit(0);
		} else {
			System.out.println("다시 선택하세요.");
			loginEnd();
		}
	}
	
	// 출퇴근관리 메서드
	public static void workInAndOutSet(boolean isAdmin, String userName) { 
		System.out.println("출퇴근 관리 시스템 정상 접속되었습니다.");
		String retvUsers = "";
		
		if(isAdmin) {
			retvUsers = "\n4.출근기록 조회\n5.퇴근기록 조회";
		}
		
		Scanner scanner = new Scanner(System.in);
		
		boolean go = true;
		while (go) {
			System.out.println("이용하실 기능을 선택해주세요. \n1.출근\n2.퇴근\n3.출퇴근 관리 기능종료" +retvUsers);
			String choice = scanner.nextLine();
			String resultMsg = "";

			switch (choice) {
			case "1":
				resultMsg = loginManager.setUserWorkInInfo(userName);
				System.out.println(resultMsg);
				break;
				
			case "2":
				resultMsg = loginManager.setUserWorkOutInfo(userName);
				System.out.println(resultMsg);
				break;
				
			case "3":
				go = false;
				break;
				
			case "4":
				if(!isAdmin) {
					System.out.println("올바른 메뉴를 선택해 주세요");
					go = false;
					break;
				}
				System.out.println("조회하고 싶은 사원ID를 입력하세요.");
				String retvIn = scanner.nextLine();
				resultMsg = loginManager.getUserWorkInInfo(retvIn);
				
				System.out.println(resultMsg);
				break;
				
			case "5":
				if(!isAdmin) {
					System.out.println("올바른 메뉴를 선택해 주세요");
					go = false;
					break;
				}
				System.out.println("조회하고 싶은 사원ID를 입력하세요.");
				String retvOut = scanner.nextLine();
				resultMsg = loginManager.getUserWorkOutInfo(retvOut);
				
				System.out.println(resultMsg);
				break;
				
			default:
				System.out.println("올바른 메뉴를 선택하세요.");
			}
		}
	}
	
//	
//	public static void retvMoney(int singleM, int doubleM, int singleCount, int doubleCount) {
//		System.out.println("조회할 서비스를 입력해 주세요.(\n1.전체\n2.싱글\n3.더블");
//		Scanner scr = new Scanner(System.in);
//		try {
//			int retvInfo = scr.nextInt();
//			if(retvInfo == 1) {
//				System.out.println("전체 체크아웃 수익 합계 : " + (singleM + doubleM));
//				System.out.println("전체 체크아웃된 전체룸 수 : " + (singleCount + doubleCount));
//			} else if(retvInfo == 2) {
//				System.out.println("싱글룸 체크아웃 수익 합계 : " + singleM);
//				System.out.println("싱글룸 체크아웃된 수 : " + singleCount);
//			} else if(retvInfo == 3) {
//				System.out.println("더블룸 체크아웃 수익 합계 : " + doubleM);
//				System.out.println("더블룸 체크아웃된 수 : " + doubleCount);
//			}
//			
//		} catch(Exception e) {
//			System.out.println("올바른 값을 입력해 주세요. 이전 상태로 돌아갑니다.");
//			return;
//		}
//		return;
//	}

}
