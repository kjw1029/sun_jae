import java.util.Scanner;

public class LoginProgram {
    private Scanner scan = new Scanner(System.in);
    public void managerLogin() {
        while (true) {

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
                    end();
                    break;
                default:
                    System.out.println("로그인 실패. 사용자 정보를 확인하세요.");
            }
        }
    }

    // 로그인
    public void start() {
        System.out.println("사용자 이름을 입력하세요: ");
        String id = scan.next();
        System.out.println("비밀번호를 입력하세요: ");
        String password = scan.next();
        Employee loginInput = new Employee(id, password);
        loginInput.login(id, password);
    }
    public void end() {
        System.out.println("1.사용자변경 2.프로그램 종료");
        int input = scan.nextInt();
        switch (input) {
            case 1:
                start();
                break;
            case 2:
                System.out.println("프로그램 종료");
                System.exit(0);
                break;
            default:
                System.out.println("다시 선택하세요.");
        }
    }
}
