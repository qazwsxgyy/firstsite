package info.anchora.mobilemonitor.dao;

import info.anchora.mobilemonitor.entiry.ActivityMonitorEntiry;

public interface ActivityInfoDao {

	/**
	 * 添加活跃信息
	 * @param activityinfo
	 * @throws Exception
	 */
	public void addActivityInfo(ActivityMonitorEntiry activityinfo) throws Exception;
}
