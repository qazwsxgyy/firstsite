package info.anchora.mobilemonitor.service.impl;

import info.anchora.mobilemonitor.dao.MonitorStatisticsDao;
import info.anchora.mobilemonitor.entiry.AndroidVersionEntiry;
import info.anchora.mobilemonitor.entiry.AppAndDeveloperEntiry;
import info.anchora.mobilemonitor.entiry.DevelopInfoEntiry;
import info.anchora.mobilemonitor.entiry.InstallAndActivityAmount;
import info.anchora.mobilemonitor.entiry.ModelInfoEntiry;
import info.anchora.mobilemonitor.entiry.MonitorStatisticsEntiry;
import info.anchora.mobilemonitor.entiry.OSInfoEntiry;
import info.anchora.mobilemonitor.entiry.SDKVersionEntiry;
import info.anchora.mobilemonitor.entiry.iOSVersionEntiry;
import info.anchora.mobilemonitor.httpclient.BaseHttpClient;
import info.anchora.mobilemonitor.service.MonitorStatisticsService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

public class MonitorStatisticsServiceImpl implements MonitorStatisticsService {
	@Autowired
	MonitorStatisticsDao MonitorStatisticsDao;

	public JSONArray getInstallInfo(String mode) throws Exception {
		// TODO Auto-generated method stub
		java.sql.Date startday;
		java.sql.Date stopday;
		JSONArray json = new JSONArray();
		List<InstallAndActivityAmount> installamount = new ArrayList<InstallAndActivityAmount>();

		if (mode.equals("week")) {
			/* 按周统计 */
			for(int i=0;i<4;i++){
				InstallAndActivityAmount install = new InstallAndActivityAmount();
				Date weekstart = dateAdd(-6-7*i);
				startday = new java.sql.Date(weekstart.getTime());
				Date weekstop = dateAdd(-7*i);
				stopday = new java.sql.Date(weekstop.getTime());
				MonitorStatisticsEntiry monitorentiry = new MonitorStatisticsEntiry(startday, stopday);
				/*获取安装量*/				
				int installresult = MonitorStatisticsDao.getInstallAmount(monitorentiry);
				install.setAmount(installresult);
				install.setDate(stopday.toString());
				installamount.add(install);
			}
			json.addAll(installamount);
		} else if (mode.equals("month")) {
			/* 按月统计 */
			for(int j=0;j<6;j++){
				InstallAndActivityAmount install = new InstallAndActivityAmount();
				Date weekstart = dateAdd(-29-30*j);
				startday = new java.sql.Date(weekstart.getTime());
				Date weekstop = dateAdd(-30*j);
				stopday = new java.sql.Date(weekstop.getTime());
				MonitorStatisticsEntiry monitorentiry = new MonitorStatisticsEntiry(startday, stopday);
				/*获取安装量*/				
				int installresult = MonitorStatisticsDao.getInstallAmount(monitorentiry);
				install.setAmount(installresult);
				install.setDate(stopday.toString());
				installamount.add(install);
			}
			json.addAll(installamount);			
		} else {
			/* 报错 */
			return new JSONArray();
		}
		return json;
	}
	
	public JSONArray getActivityInfo(String mode) throws Exception {
		// TODO Auto-generated method stub
		java.sql.Date startday;
		java.sql.Date stopday;
		JSONArray json = new JSONArray();
		List<InstallAndActivityAmount> activityamount = new ArrayList<InstallAndActivityAmount>();
		if (mode.equals("week")) {
			/* 按周统计 */
			for(int i=0;i<4;i++){
				InstallAndActivityAmount activity = new InstallAndActivityAmount();
				Date weekstart = dateAdd(-6-7*i);
				startday = new java.sql.Date(weekstart.getTime());
				Date weekstop = dateAdd(-7*i);
				stopday = new java.sql.Date(weekstop.getTime());
				MonitorStatisticsEntiry monitorentiry = new MonitorStatisticsEntiry(startday, stopday);
				/*获取活跃量*/
				int activityresult = MonitorStatisticsDao.getActivityAmount(monitorentiry);
				activity.setAmount(activityresult);
				activity.setDate(stopday.toString());
				activityamount.add(activity);
			}
			json.addAll(activityamount);
		} else if (mode.equals("month")) {
			/* 按月统计 */
			for(int j=0;j<6;j++){
				InstallAndActivityAmount activity = new InstallAndActivityAmount();
				Date weekstart = dateAdd(-29-30*j);
				startday = new java.sql.Date(weekstart.getTime());
				Date weekstop = dateAdd(-30*j);
				stopday = new java.sql.Date(weekstop.getTime());
				MonitorStatisticsEntiry monitorentiry = new MonitorStatisticsEntiry(startday, stopday);
				/*获取活跃量*/
				int activityresult = MonitorStatisticsDao.getActivityAmount(monitorentiry);
				activity.setAmount(activityresult);
				activity.setDate(stopday.toString());
				activityamount.add(activity);
			}
			json.addAll(activityamount);
		} else {
			/* 报错 */
			return new JSONArray();
		}
		return json;
	}

	public JSONArray getOSInfo(String mode) throws Exception {
		// TODO Auto-generated method stub
		Date indate = new Date();
		java.sql.Date today = new java.sql.Date(indate.getTime());
		java.sql.Date startday;
		JSONArray json = new JSONArray();
		if (mode.equals("week")) {
			/* 按周统计 */
			Date weekdate = dateAdd(-6);
			startday = new java.sql.Date(weekdate.getTime());			
		} else if (mode.equals("month")) {
			/* 按月统计 */
			Date monthdate = dateAdd(-29);
			startday = new java.sql.Date(monthdate.getTime());						
		} else {
			/* 报错 */
			return new JSONArray();
		}
		MonitorStatisticsEntiry monitorentiry = new MonitorStatisticsEntiry(startday, today);
		List<OSInfoEntiry> result = MonitorStatisticsDao.getOSInfo(monitorentiry);
		
		json.addAll(result);
		return json;
	}

	public JSONArray getiOSDKVersion(String mode) throws Exception {
		// TODO Auto-generated method stub
		Date indate = new Date();
		java.sql.Date today = new java.sql.Date(indate.getTime());
		java.sql.Date startday;
		JSONArray json = new JSONArray();
		if (mode.equals("week")) {
			/* 按周统计 */
			Date weekdate = dateAdd(-6);
			startday = new java.sql.Date(weekdate.getTime());
		}else if (mode.equals("month")) {
			/* 按月统计 */
			Date monthdate = dateAdd(-29);
			startday = new java.sql.Date(monthdate.getTime());						
		} else {
			/* 报错 */
			return new JSONArray();
		}
		MonitorStatisticsEntiry monitorentiry = new MonitorStatisticsEntiry(startday, today);
		List<SDKVersionEntiry> result = MonitorStatisticsDao.getioSDKVersion(monitorentiry);
		json.addAll(result);		
		return json;
	}

	public JSONArray getAndroidSDKVersion(String mode) throws Exception {
		// TODO Auto-generated method stub
		Date indate = new Date();
		java.sql.Date today = new java.sql.Date(indate.getTime());
		java.sql.Date startday;
		JSONArray json = new JSONArray();
		if (mode.equals("week")) {
			/* 按周统计 */
			Date weekdate = dateAdd(-6);
			startday = new java.sql.Date(weekdate.getTime());
		}else if (mode.equals("month")) {
			/* 按月统计 */
			Date monthdate = dateAdd(-29);
			startday = new java.sql.Date(monthdate.getTime());						
		} else {
			/* 报错 */
			return new JSONArray();
		}
		MonitorStatisticsEntiry monitorentiry = new MonitorStatisticsEntiry(startday, today);
		List<SDKVersionEntiry> result = MonitorStatisticsDao.getAndroidDKVersion(monitorentiry);
		json.addAll(result);
		return json;
	}

	public JSONArray getiOSVersion(String mode) throws Exception {
		// TODO Auto-generated method stub
		Date indate = new Date();
		java.sql.Date today = new java.sql.Date(indate.getTime());
		java.sql.Date startday;
		JSONArray json = new JSONArray();
		if (mode.equals("week")) {
			/* 按周统计 */
			Date weekdate = dateAdd(-6);
			startday = new java.sql.Date(weekdate.getTime());
		}else if (mode.equals("month")) {
			/* 按月统计 */
			Date monthdate = dateAdd(-29);
			startday = new java.sql.Date(monthdate.getTime());						
		} else {
			/* 报错 */
			return new JSONArray();
		}
		MonitorStatisticsEntiry monitorentiry = new MonitorStatisticsEntiry(startday, today);
		List<iOSVersionEntiry> result = MonitorStatisticsDao.getiOSVersion(monitorentiry);
		json.addAll(result);
		return json;
	}

	public JSONArray getAndroidVersion(String mode) throws Exception {
		// TODO Auto-generated method stub
		Date indate = new Date();
		java.sql.Date today = new java.sql.Date(indate.getTime());
		java.sql.Date startday;
		JSONArray json = new JSONArray();
		if (mode.equals("week")) {
			/* 按周统计 */
			Date weekdate = dateAdd(-6);
			startday = new java.sql.Date(weekdate.getTime());
		}else if (mode.equals("month")) {
			/* 按月统计 */
			Date monthdate = dateAdd(-29);
			startday = new java.sql.Date(monthdate.getTime());						
		} else {
			/* 报错 */
			return new JSONArray();
		}
		MonitorStatisticsEntiry monitorentiry = new MonitorStatisticsEntiry(startday, today);
		List<AndroidVersionEntiry> result = MonitorStatisticsDao.getAndroidVersion(monitorentiry);
		json.addAll(result);
		return json;
	}

	public JSONArray getiOSModelInfo(String mode) throws Exception {
		// TODO Auto-generated method stub
		Date indate = new Date();
		java.sql.Date today = new java.sql.Date(indate.getTime());
		java.sql.Date startday;
		JSONArray json = new JSONArray();
		if (mode.equals("week")) {
			/* 按周统计 */
			Date weekdate = dateAdd(-6);
			startday = new java.sql.Date(weekdate.getTime());
		}else if (mode.equals("month")) {
			/* 按月统计 */
			Date monthdate = dateAdd(-29);
			startday = new java.sql.Date(monthdate.getTime());						
		} else {
			/* 报错 */
			return new JSONArray();
		}
		MonitorStatisticsEntiry monitorentiry = new MonitorStatisticsEntiry(startday, today);
		List<ModelInfoEntiry> result = MonitorStatisticsDao.getiOSModelInfo(monitorentiry);
		json.addAll(result);
		return json;
	}

	public JSONArray getAndroidModelInfo(String mode) throws Exception {
		// TODO Auto-generated method stub
		Date indate = new Date();
		java.sql.Date today = new java.sql.Date(indate.getTime());
		java.sql.Date startday;
		JSONArray json = new JSONArray();
		if (mode.equals("week")) {
			/* 按周统计 */
			Date weekdate = dateAdd(-6);
			startday = new java.sql.Date(weekdate.getTime());
		}else if (mode.equals("month")) {
			/* 按月统计 */
			Date monthdate = dateAdd(-29);
			startday = new java.sql.Date(monthdate.getTime());						
		} else {
			/* 报错 */
			return new JSONArray();
		}
		MonitorStatisticsEntiry monitorentiry = new MonitorStatisticsEntiry(startday, today);
		List<ModelInfoEntiry> result = MonitorStatisticsDao.getAndroidModelInfo(monitorentiry);
		json.addAll(result);
		return json;
	}

	public int getAllInstallInfo() throws Exception {
		// TODO Auto-generated method stub
		int allinstall = MonitorStatisticsDao.getAllInstall();
		return allinstall;
	}

	public JSONObject getDeveloper(String mode) throws Exception {
		// TODO Auto-generated method stub
		Date indate = new Date();
		java.sql.Date today = new java.sql.Date(indate.getTime());
		java.sql.Date startday;
		JSONArray jsonarray = new JSONArray();
		JSONObject json = new JSONObject();
		if (mode.equals("week")) {
			/* 按周统计 */
			Date weekdate = dateAdd(-6);
			startday = new java.sql.Date(weekdate.getTime());
		}else if (mode.equals("month")) {
			/* 按月统计 */
			Date monthdate = dateAdd(-29);
			startday = new java.sql.Date(monthdate.getTime());						
		} else {
			/* 报错 */
			json.put("developer_info", new JSONArray());
			return json;
		}
		List<AppAndDeveloperEntiry> returninfo = new ArrayList<AppAndDeveloperEntiry>();
		MonitorStatisticsEntiry monitorentiry = new MonitorStatisticsEntiry(startday, today);
		List<DevelopInfoEntiry> resultlist = MonitorStatisticsDao.getDeveloper(monitorentiry);
		if(resultlist !=null && resultlist .size()>0){
			for(int i=0;i<resultlist .size();i++){
				String key = null;
				AppAndDeveloperEntiry entiry;
				DevelopInfoEntiry developer = resultlist .get(i);
				/*从安装信息的表中获取到一个key*/
				if(developer.getSocialkey()!=null && !"".equals(developer.getSocialkey())){
					key = developer.getSocialkey();
				}else if(developer.getIospushkey()!=null && !"".equals(developer.getIospushkey())){
					key = developer.getIospushkey();
				}else if(developer.getAndroidpushkey()!=null && !"".equals(developer.getAndroidpushkey())){
					key = developer.getAndroidpushkey();
				}else if(developer.getLocationkey()!=null && !"".equals(developer.getLocationkey())){
					key = developer.getLocationkey();
				}
				if(key!=null){
					/*调用接口，根据key获取到开发者的账号，以及该开发者的所有应用*/
					String jsonresult = BaseHttpClient.HttpPostMethod("servicekey", key);
					JSONObject rootjson = JSONObject.fromObject(jsonresult);
					if(rootjson.getJSONArray(key)!=null){
						JSONArray appjsonarray = rootjson.getJSONArray(key);
						JSONObject appjson = appjsonarray.optJSONObject(0);
						String appname = appjson.getString("appname");
						String username = appjson.getString("developer");
						entiry = new AppAndDeveloperEntiry(appname, username, developer.getNum());				
					}else{
						entiry = new AppAndDeveloperEntiry("null", "null", developer.getNum());
					}
				}else{
					entiry = new AppAndDeveloperEntiry("null", "null", developer.getNum());
				}
				returninfo.add(entiry);				
			}						
		}
		jsonarray.addAll(returninfo);
		json.put("developer_info", jsonarray);
		return json;
	}

	/**
	 * 计算日期
	 * @param days
	 * @return
	 */
	public static Date dateAdd(int days) {
		// 日期处理模块 (将日期加上某些天或减去天数)返回字符串
		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, days); // 日期减 如果不够减会将月变动
		return canlendar.getTime();
	}
}
