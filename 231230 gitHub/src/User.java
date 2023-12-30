

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


class User {
	private String username;
	private String password;
	private boolean isAdmin;
	private String inWorkTime;
	private String outWorkTime;
	//
	
	
	public String getOutWorkTime() {
		return outWorkTime;
	}

	public void setOutWorkTime(String outWorkTime) {
		this.outWorkTime = outWorkTime;
	}

	public User(String username, String password, boolean isAdmin, String inWorkTime, String outWorkTime) {
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.inWorkTime = inWorkTime;
		this.outWorkTime = outWorkTime;
	}

	public String getUsername() {
		return username;
	}
	

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public String getInWorkTime() {
		return inWorkTime;
	}

	public void setInWorkTime(String inWorkTime) {
		this.inWorkTime = inWorkTime;
	}



}

/*
 * 매니저 데스크 청소  아이디 3가지만들고
1개 컴퓨터로 번갈아가면서 로그아웃 로그인하면서 작업한다는 가정하에 만들어야함
공통기능(청소제외)은 호텔룸 예약관련 워크인 워크아웃 체크인관련인데 파일 안에있음
그외 매니저는 직원들 출퇴근시간 열람, 매출현황 볼수있어야됨
데스크직원은 공통기능 외에 넣을거 없을듯?
청소는 룸마다 청소확인유무 조작가능해야하는데 껍데기만 만들어둠 고객이 체크아웃하고 빈방으로 다시 바뀌려면 청소유무에서 청소확인이되야 빈방으로 돌아오도록 만들어야함
 */

class LoginManager {
	private User[] users;
	private int userCount;

	public LoginManager(int capacity) {
		users = new User[capacity];
		userCount = 0;
		
		
		// 기본 사용자 추가
		users[userCount++] = new User("매니저", "매니저1234", true, "", "");
		users[userCount++] = new User("데스크", "데스크1234", false, "", "");
		users[userCount++] = new User("청소", "청소1234", false, "", "");
		
		
	}

	public User login(String username, String password) {
		for (int i = 0; i < userCount; i++) {
			if (users[i].getUsername().equals(username) && users[i].checkPassword(password)) {
				System.out.println(users[i].getUsername());
				return users[i];
			}
		}
		return null; // 사용자가 없거나 비밀번호가 일치하지 않는 경우
	}
	

	public String setUserWorkInInfo(String userName) {
		String timeInfo = "";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		timeInfo = sdf.format(cal.getTime());
		String returnVal = "";

		for(int i = 0; i < users.length;i++) {
			if(userName.equals(users[i].getUsername())) {
				if(!"".equals(users[i].getInWorkTime()) || !users[i].getInWorkTime().isEmpty()) {
					returnVal = users[i].getUsername() + "는/은 이미 출근 처리된 사용자입니다.";
					break;
				}
				users[i].setInWorkTime(timeInfo);
				returnVal = users[i].getUsername() + "는/은 현재 시각 " + users[i].getInWorkTime() + "에 정상 출근 처리되었습니다.";
				break;
			}
		}
		return returnVal;
	}
	
	
	public String setUserWorkOutInfo(String userName) {
		String timeInfo = "";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		timeInfo = sdf.format(cal.getTime());
		String returnVal = "";
		for(int i = 0; i < users.length;i++) {
			if(userName.equals(users[i].getUsername())) {
				if(!"".equals(users[i].getOutWorkTime()) || !users[i].getOutWorkTime().isEmpty()) {
					timeInfo = users[i].getUsername() + "는/은 이미 퇴근 처리된 사용자입니다.";
					break;
				}
				users[i].setOutWorkTime(timeInfo);
				returnVal = users[i].getUsername() + "는/은 현재 시각 " + users[i].getOutWorkTime() + "에 정상 퇴근 처리되었습니다.";
				break;
			}
		}
		return returnVal;
	}
	
	public String getUserWorkInInfo(String userName) {
		String userInfo = "";

		for(int i = 0; i < users.length;i++) {
			if(userName.equals(users[i].getUsername())) {
				if("".equals(users[i].getInWorkTime()) || users[i].getInWorkTime().isEmpty()) {
					userInfo = users[i].getUsername() + "는/은 출근 기록이 존재하지 않습니다.";
					break;
				}
				userInfo = users[i].getUsername() + "는/은" + users[i].getInWorkTime() + "시각에 출근했습니다.";
				break;
			} 
		}
		if("".equals(userInfo) || userInfo.isEmpty()) {
			userInfo = "올바른 사원 이름을 입력하세요.";
		}
		return userInfo;
	}
	
	public String getUserWorkOutInfo(String userName) {
		String userInfo = "";
		for(int i = 0; i < users.length;i++) {
			if(userName.equals(users[i].getUsername())) {
				if("".equals(users[i].getOutWorkTime()) || users[i].getOutWorkTime().isEmpty()) {
					userInfo = users[i].getUsername() + "는/은 퇴근 기록이 존재하지 않습니다.";
					break;
				}
				userInfo = users[i].getUsername() + "는/은" + users[i].getOutWorkTime() + "시각에 퇴근했습니다.";
				break;
			} 
		}
		if("".equals(userInfo) || userInfo.isEmpty()) {
			userInfo = "올바른 사원 이름을 입력하세요.";
		}
		return userInfo;
	}
}


