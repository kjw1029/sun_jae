import java.util.Scanner;

public class Manager extends Employee {
	

	public Manager(String name, String number) {
		super(name, number);
	}

	@Override
	public void LoginStart() {
		System.out.println("1.예약관리  2.출퇴근 관리 3.매출 관리 4.로그아웃");
	}
	

	public static void retvMoney(int singleM, int doubleM, int singleCount, int doubleCount) {
		System.out.println("조회할 서비스를 입력해 주세요.(\n1.전체\n2.싱글\n3.더블");
		Scanner scr = new Scanner(System.in);
		try {
			int retvInfo = scr.nextInt();
			if(retvInfo == 1) {
				System.out.println("전체 체크아웃 수익 합계 : " + (singleM + doubleM));
				System.out.println("전체 체크아웃된 전체룸 수 : " + (singleCount + doubleCount));
			} else if(retvInfo == 2) {
				System.out.println("싱글룸 체크아웃 수익 합계 : " + singleM);
				System.out.println("싱글룸 체크아웃된 수 : " + singleCount);
			} else if(retvInfo == 3) {
				System.out.println("더블룸 체크아웃 수익 합계 : " + doubleM);
				System.out.println("더블룸 체크아웃된 수 : " + doubleCount);
			}
			
		} catch(Exception e) {
			System.out.println("올바른 값을 입력해 주세요. 이전 상태로 돌아갑니다.");
			return;
		}
		return;
	}

	
}
