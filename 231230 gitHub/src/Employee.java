public class Employee extends Person implements EmployeeManage {
    private String inWorkTime;
    private String outWorkTime;
    private LoginProgram loginProgram = new LoginProgram();

    public Employee(String name, String number) {
        super(name, number);
    }

    public Employee() {

    }


    @Override
    public void login(String id, String password) {
        Employee temp = new Employee(id, password);
        if (temp.equals(new Employee("매니저", "매니저1234"))) {
            System.out.println("매니저 로그인");
            LoginProgram manager = new LoginProgram();
            manager.managerLogin();
        } else if (temp.equals(new Employee("데스크", "데스크1234"))) {
            System.out.println("데스크 로그인");
        } else if (temp.equals(new Employee("청소", "청소1234"))) {
            System.out.println("청소 로그인");
        } else {
            System.out.println("로그인 실패");
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
