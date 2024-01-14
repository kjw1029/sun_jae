public interface EmployeeManage {
    // 로그인
    void login(String id, String password);
//    // 로그아웃
//    void logout();
    // 출퇴근
    void commute(int input);
    // 직원 접근
    Employee[] getEmployee();
}
