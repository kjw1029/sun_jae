import java.util.Scanner;

public class LoginProgram {
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
