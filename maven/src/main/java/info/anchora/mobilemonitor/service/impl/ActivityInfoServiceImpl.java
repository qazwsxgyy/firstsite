package info.anchora.mobilemonitor.service.impl;

import info.anchora.mobilemonitor.dao.ActivityInfoDao;
import info.anchora.mobilemonitor.entiry.ActivityMonitorEntiry;
import info.anchora.mobilemonitor.enums.MonitorEnums;
import info.anchora.mobilemonitor.service.ActivityInfoService;
import info.anchora.mobilemonitor.util.MonitorInfoParse;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

public class ActivityInfoServiceImpl implements ActivityInfoService{
	
	@Autowired
	ActivityInfoDao ActivityInfoDao;

	public JSONObject addActivityInfo(String activityinfo) throws Exception {
		// TODO Auto-generated method stub
		JSONObject json = null;
		/**
		 * 插入一条新的安装信息
		 */
		if (activityinfo != null && !"".equals(activityinfo)) {
			ActivityMonitorEntiry activityentiry = new MonitorInfoParse()
					.activityinfoparse(activityinfo);
			if (activityentiry != null){
				ActivityMonitorEntiry addactivityentiry = new ActivityMonitorEntiry(activityentiry.getUid(), activityentiry.getLaunch_date());
				ActivityInfoDao.addActivityInfo(addactivityentiry);
				json=new JSONObject();
				json.put("status", MonitorEnums.SUCCESS.code());
				json.put("message", MonitorEnums.SUCCESS.message());
				
				/**
				 * 以下代码暂未使用
				 */
				if(activityentiry.getSocialkey()!=null){
					
				}
				if(activityentiry.getAndroidpushkey()!=null){
					
				}if(activityentiry.getIospushkey()!=null){
					
				}if(activityentiry.getLocationkey()!=null){
					
				}
			}else{
				json=new JSONObject();
				json.put("status", MonitorEnums.REQUEST_PARAMETER_ERROR.code());
				json.put("message", MonitorEnums.REQUEST_PARAMETER_ERROR.message());
			}
		}else{
			json=new JSONObject();
			json.put("status", MonitorEnums.REQUEST_PARAMETER_ERROR.code());
			json.put("message", MonitorEnums.REQUEST_PARAMETER_ERROR.message());
		}
		return json;
	}



}
