package info.anchora.mobilemonitor.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;
import info.anchora.mobilemonitor.entiry.ActivityMonitorEntiry;
import info.anchora.mobilemonitor.entiry.InstallMonitorEntiry;

public class MonitorInfoParse {

	/**
	 * 解析安装信息的json
	 * @param source
	 * @return
	 */
	public InstallMonitorEntiry installinfoparse(String source){
		JSONObject jsonRoot = JSONObject.fromObject(source);
		if(jsonRoot.getJSONObject("Installed_info")!=null){
			JSONObject installjson = jsonRoot.getJSONObject("Installed_info");
			InstallMonitorEntiry installentiry = new InstallMonitorEntiry();
			if(installjson.containsKey("uid"))
				installentiry.setUid(installjson.getString("uid"));
			else
				installentiry.setUid(null);
			
			if(installjson.containsKey("os"))
				installentiry.setOs(installjson.getString("os"));
			else
				installentiry.setOs(null);
			
			if(installjson.containsKey("deviceid"))
				installentiry.setDeviceid(installjson.getString("deviceid"));
			else
				installentiry.setDeviceid(null);
			
			if(installjson.containsKey("sdk_version"))
				installentiry.setSdk_version(installjson.getString("sdk_version"));
			else
				installentiry.setSdk_version(null);
			
			if(installjson.containsKey("ios_version"))
				installentiry.setIos_version(installjson.getString("ios_version"));
			else
				installentiry.setIos_version(null);
			
			if(installjson.containsKey("android_version"))
				installentiry.setAndroid_version(installjson.getString("android_version"));
			else
				installentiry.setAndroid_version(null);
			
			if(installjson.containsKey("brands"))
				installentiry.setBrands(installjson.getString("brands"));
			else
				installentiry.setBrands(null);
			
			if(installjson.containsKey("model"))
				installentiry.setModel(installjson.getString("model"));
			else
				installentiry.setModel(null);
			
			if(installjson.containsKey("socialkey"))
				installentiry.setSocialkey(installjson.getString("socialkey"));
			else
				installentiry.setSocialkey(null);
			
			if(installjson.containsKey("androidpushkey"))
				installentiry.setAndroidpushkey(installjson.getString("androidpushkey"));
			else
				installentiry.setAndroidpushkey(null);
			
			if(installjson.containsKey("iospushkey"))
				installentiry.setIospushkey(installjson.getString("iospushkey"));
			else
				installentiry.setIospushkey(null);
			
			if(installjson.containsKey("locationkey"))
				installentiry.setLocationkey(installjson.getString("locationkey"));
			else
				installentiry.setLocationkey(null);
			
			Date indate = new Date();
			java.sql.Date sqldate = new java.sql.Date(indate.getTime());
			
			installentiry.setInstalldate(sqldate);
			return installentiry;
		}else
			return null;		
	}
	
	public ActivityMonitorEntiry activityinfoparse(String activityinfo) throws ParseException{
		JSONObject jsonRoot = JSONObject.fromObject(activityinfo);
		if(jsonRoot.getJSONObject("Active_info")!=null){
			JSONObject activityjson = jsonRoot.getJSONObject("Active_info");
			ActivityMonitorEntiry activityentiry = new ActivityMonitorEntiry();
			if(activityjson.containsKey("uid"))
				activityentiry.setUid(activityjson.getString("uid"));
			else
				return null;
			if(activityjson.containsKey("launch_date")){
				String date = activityjson.getString("launch_date");
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date launch = format.parse(date);
				java.sql.Date launch_date = new java.sql.Date(launch.getTime());
				activityentiry.setLaunch_date(launch_date);
			}else 
				return null;
			if(activityjson.containsKey("socialkey"))
				activityentiry.setSocialkey(activityjson.getString("socialkey"));
			if(activityjson.containsKey("androidpushkey"))
				activityentiry.setAndroidpushkey(activityjson.getString("androidpushkey"));
			if(activityjson.containsKey("iospushkey"))
				activityentiry.setIospushkey(activityjson.getString("iospushkey"));
			if(activityjson.containsKey("locationkey"))
				activityentiry.setLocationkey(activityjson.getString("locationkey"));
			return activityentiry;
		}else
			return null;
	}

}
