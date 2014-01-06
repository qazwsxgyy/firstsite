package info.anchora.mobilemonitor.service;

import net.sf.json.JSONObject;

public interface InstallInfoService {
	
	/**
	 * 向数据库添加安装信息或者活跃信息
	 * @param installinfo
	 * @return
	 * @throws Exception
	 */
	public JSONObject addInstallInfo(String installinfo) throws Exception;

}
