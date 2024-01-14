import java.util.Scanner;

public class LoginProgram {
    private Employee e;

    private Scanner scan = new Scanner(System.in);

    public void loginMenu() {
        while (true) {
            try {
                Employee e = start();
                e.login(e.getName(), e.getNumber());
            } catch (Exception e) {
                System.out.println("올바르지 못한 값을 입력하여 로그아웃 처리됩니다.\n재로그인해 주십시오.");
//                e.printStackTrace();
//                scan.nextLine();
//                start();
            }
        }
    }

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
                    break;
            }

        }
    }

    public void deskLogin() {
        while (true) {
            System.out.println("1.예약관리  2. 출퇴근 인증 3.로그아웃 ");
            int input = scan.nextInt();
            switch (input) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    end();
                    break;
                default:
            }
        }
    }

    public void cleanerLogin() {
        while (true) {
            System.out.println("1.청소관리  2. 출퇴근 인증 3.로그아웃 ");
            int input = scan.nextInt();
            switch (input) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    end();
                    break;
                default:
            }
        }
    }

    // 로그인 입력
    public Employee start() {
        System.out.print("사용자 이름을 입력하세요: ");
        String id = scan.next();
        System.out.print("비밀번호를 입력하세요: ");
        String password = scan.next();
        Employee loginInput = new Employee(id, password);
//        loginInput.login(id, password);
        return loginInput;
    }


    // 로그아웃 메뉴
    public void end() {
        while (true) {
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
}
