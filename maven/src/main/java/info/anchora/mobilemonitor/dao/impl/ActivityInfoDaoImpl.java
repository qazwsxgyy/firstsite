package info.anchora.mobilemonitor.dao.impl;

import info.anchora.mobilemonitor.dao.ActivityInfoDao;
import info.anchora.mobilemonitor.entiry.ActivityMonitorEntiry;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class ActivityInfoDaoImpl extends SqlMapClientDaoSupport implements ActivityInfoDao{

	public void addActivityInfo(ActivityMonitorEntiry activityinfo)
			throws Exception {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("ActivityEdm.addActivityMonitor", activityinfo);
	}



}
