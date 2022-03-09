package Proj;

public class LoginVO {
	private String id;
	private String pwd;
	private static String ppid;
	private static String pppwd;
	private static String ppname;
	private static int age;
	private static String address;
	private static String food;

	public LoginVO() {

	}

	public LoginVO(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}

	public LoginVO(String ppid, String pppwd, String ppname, int age, String address, String food) {
		LoginVO.ppid = ppid;
		LoginVO.pppwd = pppwd;
		LoginVO.ppname = ppname;
		LoginVO.age = age;
		LoginVO.address = address;
		LoginVO.food = food;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public static String getPpid() {
		return ppid;
	}

	public void setPpid(String ppid) {
		LoginVO.ppid = ppid;
	}

	public static String getPppwd() {
		return pppwd;
	}

	public void setPppwd(String pppwd) {
		LoginVO.pppwd = pppwd;
	}

	public static String getPpname() {
		return ppname;
	}

	public void setPpname(String ppname) {
		LoginVO.ppname = ppname;
	}

	public static int getAge() {
		return age;
	}

	public void setAge(int age) {
		LoginVO.age = age;
	}

	public static String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		LoginVO.address = address;
	}

	public static String getFood() {
		return food;
	}

	public void setFood(String food) {
		LoginVO.food = food;
	}

}
