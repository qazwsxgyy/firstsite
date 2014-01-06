package info.anchora.mobilemonitor.dao.impl;

import info.anchora.mobilemonitor.dao.MonitorStatisticsDao;
import info.anchora.mobilemonitor.entiry.AndroidVersionEntiry;
import info.anchora.mobilemonitor.entiry.DevelopInfoEntiry;
import info.anchora.mobilemonitor.entiry.ModelInfoEntiry;
import info.anchora.mobilemonitor.entiry.MonitorStatisticsEntiry;
import info.anchora.mobilemonitor.entiry.OSInfoEntiry;
import info.anchora.mobilemonitor.entiry.SDKVersionEntiry;
import info.anchora.mobilemonitor.entiry.iOSVersionEntiry;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class MonitorStatisticsDaoImpl extends SqlMapClientDaoSupport implements MonitorStatisticsDao{

	@SuppressWarnings("unchecked")
	public List<OSInfoEntiry> getOSInfo(MonitorStatisticsEntiry monitorentiry)
			throws Exception {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("MonitorStatisticsEdm.queryforos", monitorentiry);
	}

	@SuppressWarnings("unchecked")
	public List<SDKVersionEntiry> getioSDKVersion(MonitorStatisticsEntiry monitorentiry)
			throws Exception {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("MonitorStatisticsEdm.queryforiosdk", monitorentiry);
	}
	
	@SuppressWarnings("unchecked")
	public List<SDKVersionEntiry> getAndroidDKVersion(MonitorStatisticsEntiry monitorentiry)
			throws Exception {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("MonitorStatisticsEdm.queryforandroidsdk", monitorentiry);
	}

	@SuppressWarnings("unchecked")
	public List<iOSVersionEntiry> getiOSVersion(
			MonitorStatisticsEntiry monitorentiry) throws Exception {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("MonitorStatisticsEdm.queryforiosversion", monitorentiry);
	}

	@SuppressWarnings("unchecked")
	public List<AndroidVersionEntiry> getAndroidVersion(
			MonitorStatisticsEntiry monitorentiry) throws Exception {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("MonitorStatisticsEdm.queryforandroidversion", monitorentiry);
	}

	@SuppressWarnings("unchecked")
	public List<ModelInfoEntiry> getiOSModelInfo(
			MonitorStatisticsEntiry monitorentiry) throws Exception {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("MonitorStatisticsEdm.queryforiosmodel", monitorentiry);
	}

	@SuppressWarnings("unchecked")
	public List<ModelInfoEntiry> getAndroidModelInfo(
			MonitorStatisticsEntiry monitorentiry) throws Exception {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("MonitorStatisticsEdm.queryforandroidmodel", monitorentiry);
	}

	public int getActivityAmount(MonitorStatisticsEntiry monitorentiry)
			throws Exception {
		// TODO Auto-generated method stub
		return (Integer) getSqlMapClientTemplate().queryForObject("MonitorStatisticsEdm.queryforactivity", monitorentiry);
	}

	public int getInstallAmount(MonitorStatisticsEntiry monitorentiry)
			throws Exception {
		// TODO Auto-generated method stub
		return (Integer) getSqlMapClientTemplate().queryForObject("MonitorStatisticsEdm.queryforinstall", monitorentiry);
	}

	public int getAllInstall()
			throws Exception {
		// TODO Auto-generated method stub
		return (Integer) getSqlMapClientTemplate().queryForObject("MonitorStatisticsEdm.queryforallinstall");
	}

	@SuppressWarnings("unchecked")
	public List<DevelopInfoEntiry> getDeveloper(
			MonitorStatisticsEntiry monitorentiry) throws Exception {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("MonitorStatisticsEdm.queryDeveloperInfo", monitorentiry);
	}

}
