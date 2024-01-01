import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Employee extends Person {
	private String inWorkTime;
	private String outWorkTime;

	public Employee(String name, String number) {
		super(name, number);
	}

	public Employee(String name, String number, String inWorkTime, String outWorkTime) {
		super(name, number);
		this.inWorkTime = inWorkTime;
		this.outWorkTime = outWorkTime;
	}
	
	public void printMenu() {
		
	}

	public void LoginStart() {
	}

	class LoginManager {
		private User[] users;
		private int userCount;

		public LoginManager(int capacity) {
			users = new User[capacity];
			userCount = 0;

			users[userCount++] = new User("매니저", "매니저1234", true, "", "");
			users[userCount++] = new User("데스크", "데스크1234", false, "", "");
			users[userCount++] = new User("청소", "청소1234", false, "", "");
		}

		public String setUserWorkInInfo(String userName) {
			String timeInfo = "";
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			timeInfo = sdf.format(cal.getTime());
			String returnVal = "";

			for (int i = 0; i < users.length; i++) {
				if (userName.equals(users[i].getUsername())) {
					if (!"".equals(users[i].getInWorkTime()) || !users[i].getInWorkTime().isEmpty()) {
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

			for (int i = 0; i < users.length; i++) {
				if (userName.equals(users[i].getUsername())) {
					if (!"".equals(users[i].getOutWorkTime()) || !users[i].getOutWorkTime().isEmpty()) {
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

			for (int i = 0; i < users.length; i++) {
				if (userName.equals(users[i].getUsername())) {
					if ("".equals(users[i].getInWorkTime()) || users[i].getInWorkTime().isEmpty()) {
						userInfo = users[i].getUsername() + "는/은 출근 기록이 존재하지 않습니다.";
						break;
					}
					userInfo = users[i].getUsername() + "는/은" + users[i].getInWorkTime() + "시각에 출근했습니다.";
					break;
				}
			}

			if ("".equals(userInfo) || userInfo.isEmpty()) {
				userInfo = "올바른 사원 이름을 입력하세요.";
			}
			return userInfo;
		}

		public String getUserWorkOutInfo(String userName) {
			String userInfo = "";
			for (int i = 0; i < users.length; i++) {
				if (userName.equals(users[i].getUsername())) {
					if ("".equals(users[i].getOutWorkTime()) || users[i].getOutWorkTime().isEmpty()) {
						userInfo = users[i].getUsername() + "는/은 퇴근 기록이 존재하지 않습니다.";
						break;
					}
					userInfo = users[i].getUsername() + "는/은" + users[i].getOutWorkTime() + "시각에 퇴근했습니다.";
					break;
				}
			}

			if ("".equals(userInfo) || userInfo.isEmpty()) {
				userInfo = "올바른 사원 이름을 입력하세요.";
			}
			return userInfo;
		}
	}
}