public class Employee extends Person implements EmployeeManage {
    private String inWorkTime;
    private String outWorkTime;
    private LoginProgram loginProgram = new LoginProgram();

    public Employee(String name, String number) {
        super(name, number);
    }

    @Override
    public void login(String id, String password) {
        Employee temp = new Employee(id, password);
        if (temp.equals(new Employee("매니저", "매니저1234"))) {
            System.out.println("매니저 로그인");
            loginProgram.managerLogin();
        } else if (temp.equals(new Employee("데스크", "데스크1234"))) {
            System.out.println("데스크 로그인");
            loginProgram.deskLogin();
        } else if (temp.equals(new Employee("청소", "청소1234"))) {
            System.out.println("청소 로그인");
            loginProgram.cleanerLogin();
        } else {
            System.out.println("로그인 실패. 사용자 정보를 확인하세요.");
            loginProgram.start();
        }
    }

    @Override
    public void logout() {
       loginProgram.start();


    }


    @Override
    public void commute(int input) {

    }

    @Override
    public Employee[] getEmployee() {
        return new Employee[0];
    }

}
