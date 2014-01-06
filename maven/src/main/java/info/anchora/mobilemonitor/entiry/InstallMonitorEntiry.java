package info.anchora.mobilemonitor.entiry;

import java.sql.Date;

public class InstallMonitorEntiry {

	private String uid = null;
	private String os = null;
	private String deviceid = null;
	private String sdk_version = null;
	private String ios_version = null;
	private String android_version = null;
	private String brands = null;
	private String model = null;
	private String socialkey = null;
	private String androidpushkey = null;
	private String iospushkey = null;
	private String locationkey = null;	
	private Date installdate;
	
	public InstallMonitorEntiry(){
		super();
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	public String getSdk_version() {
		return sdk_version;
	}
	public void setSdk_version(String sdk_version) {
		this.sdk_version = sdk_version;
	}
	public String getIos_version() {
		return ios_version;
	}
	public void setIos_version(String ios_version) {
		this.ios_version = ios_version;
	}
	public String getAndroid_version() {
		return android_version;
	}
	public void setAndroid_version(String android_version) {
		this.android_version = android_version;
	}
	public String getBrands() {
		return brands;
	}
	public void setBrands(String brands) {
		this.brands = brands;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
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
	public Date getInstalldate() {
		return installdate;
	}
	public void setInstalldate(Date installdate) {
		this.installdate = installdate;
	}
	
	

}
