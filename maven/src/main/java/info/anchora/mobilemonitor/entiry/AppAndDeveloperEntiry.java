package info.anchora.mobilemonitor.entiry;

public class AppAndDeveloperEntiry {

	private String appname;
	private int num;
	private String username;
	
	public AppAndDeveloperEntiry(){
		super();
	}
	
	public AppAndDeveloperEntiry(String appname, String username, int num){
		super();
		this.appname = appname;
		this.username = username;
		this.num = num;
	}
	
	public AppAndDeveloperEntiry(int num){
		super();
		this.num = num;
	}
	
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
