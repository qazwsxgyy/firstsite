package info.anchora.mobilemonitor.service.impl;

import info.anchora.mobilemonitor.dao.InstallInfoDao;
import info.anchora.mobilemonitor.entiry.InstallMonitorEntiry;
import info.anchora.mobilemonitor.enums.MonitorEnums;
import info.anchora.mobilemonitor.service.InstallInfoService;
import info.anchora.mobilemonitor.util.MonitorInfoParse;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

public class InstallInfoServiceImpl implements InstallInfoService {

	@Autowired
	InstallInfoDao InstallInfoDao;

	public JSONObject addInstallInfo(String installinfo) throws Exception {
		// TODO Auto-generated method stub
		JSONObject json = null;
		/**
		 * 插入一条新的安装信息
		 */
		if (installinfo != null && !"".equals(installinfo)) {
			InstallMonitorEntiry installentiry = new MonitorInfoParse()
					.installinfoparse(installinfo);
			if (installentiry != null){
				InstallInfoDao.addInstallInfo(installentiry);
				json=new JSONObject();
				json.put("status", MonitorEnums.SUCCESS.code());
				json.put("message", MonitorEnums.SUCCESS.message());
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
