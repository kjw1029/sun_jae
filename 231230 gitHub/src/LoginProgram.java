import java.util.Scanner;

public class LoginProgram {
    public void managerLogin() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("1.예약관리  2.출퇴근 관리 3.매출 관리 4.로그아웃");
            int input = scan.nextInt();
            switch (input) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    start();
                    break;
                default:
                    System.out.println("로그인 실패. 사용자 정보를 확인하세요.");
            }
        }
    }
    public void start() {
        Scanner scan = new Scanner(System.in);

        System.out.println("사용자 이름을 입력하세요: ");
        String id = scan.next();
        System.out.println("비밀번호를 입력하세요: ");
        String password = scan.next();
        Employee loginInput = new Employee(id, password);
        loginInput.login(id, password);
    }
}
