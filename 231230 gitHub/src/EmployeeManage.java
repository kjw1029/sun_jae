public interface EmployeeManage {
    // 로그인
    boolean login(Employee employee);
    // 로그아웃
    void logout(Employee employee);
    // 출퇴근
    void commute(int input);
    // 직원 접근
    Employee[] getEmployee();
}
