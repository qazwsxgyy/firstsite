package info.anchora.mobilemonitor.entiry;

import java.sql.Date;

public class ActivityMonitorEntiry {

	private String uid = null;
	private Date launch_date;
	private String socialkey = null;
	private String androidpushkey=null;
	private String iospushkey=null;
	private String locationkey=null;
	
	public ActivityMonitorEntiry(){
		super();
	}
	
	public ActivityMonitorEntiry(String uid, Date launch_date){
		super();
		this.uid = uid;
		this.launch_date = launch_date;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Date getLaunch_date() {
		return launch_date;
	}
	public void setLaunch_date(Date launch_date2) {
		this.launch_date = launch_date2;
	}
	public String getSocialkey() {
		return socialkey;
	}
	public void setSocialkey(String socialkey) {
		this.socialkey = socialkey;
	}
	public String getAndroidpushkey() {
		return androidpushkey;
	}
	public void setAndroidpushkey(String androidpushkey) {
		this.androidpushkey = androidpushkey;
	}
	public String getIospushkey() {
		return iospushkey;
	}
	public void setIospushkey(String iospushkey) {
		this.iospushkey = iospushkey;
	}
	public String getLocationkey() {
		return locationkey;
	}
	public void setLocationkey(String locationkey) {
		this.locationkey = locationkey;
	}	
}
