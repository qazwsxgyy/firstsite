package info.anchora.mobilemonitor.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import info.anchora.mobilemonitor.dao.InstallInfoDao;
import info.anchora.mobilemonitor.entiry.InstallMonitorEntiry;

public class InstallInfoDaoImpl extends SqlMapClientDaoSupport implements InstallInfoDao{

	public void addInstallInfo(InstallMonitorEntiry installinfo)
			throws Exception {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("InstallMonitorEdm.addInstallMonitor", installinfo);
	}


}
