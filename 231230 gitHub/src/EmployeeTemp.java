public class EmployeeTemp extends Person implements EmployeeManage {
    private String inWorkTime;
    private String outWorkTime;

    public EmployeeTemp(String name, String number) {
        super(name, number);
    }

    public EmployeeTemp() {

    }


    @Override
    public void login(String id, String password) {
        EmployeeTemp temp = new EmployeeTemp(id, password);
        if (temp.equals(new EmployeeTemp("매니저", "매니저1234"))) {
            System.out.println("매니저 로그인");
        } else if (temp.equals(new EmployeeTemp("데스크", "데스크1234"))) {
            System.out.println("데스크 로그인");
        } else if (temp.equals(new EmployeeTemp("청소", "청소1234"))) {
            System.out.println("청소 로그인");
        } else {
            System.out.println("로그인 실패");
        }
    }

    @Override
    public void logout(EmployeeTemp employee) {

    }

    @Override
    public void commute(int input) {

    }

    @Override
    public EmployeeTemp[] getEmployee() {
        return new EmployeeTemp[0];
    }

}
