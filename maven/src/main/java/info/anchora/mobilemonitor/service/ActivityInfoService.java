package info.anchora.mobilemonitor.service;

import net.sf.json.JSONObject;

public interface ActivityInfoService {

	/**
	 * 插入活跃信息
	 * @param activityinfo
	 * @return
	 * @throws Exception
	 */
	public JSONObject addActivityInfo(String activityinfo) throws Exception;

}
