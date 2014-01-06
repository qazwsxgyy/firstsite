package info.anchora.mobilemonitor.dao;

import info.anchora.mobilemonitor.entiry.AndroidVersionEntiry;
import info.anchora.mobilemonitor.entiry.DevelopInfoEntiry;
import info.anchora.mobilemonitor.entiry.ModelInfoEntiry;
import info.anchora.mobilemonitor.entiry.MonitorStatisticsEntiry;
import info.anchora.mobilemonitor.entiry.OSInfoEntiry;
import info.anchora.mobilemonitor.entiry.SDKVersionEntiry;
import info.anchora.mobilemonitor.entiry.iOSVersionEntiry;

import java.util.List;

public interface MonitorStatisticsDao {

	public List<OSInfoEntiry> getOSInfo(MonitorStatisticsEntiry monitorentiry) throws Exception;
	public List<SDKVersionEntiry> getioSDKVersion(MonitorStatisticsEntiry monitorentiry) throws Exception;
	public List<SDKVersionEntiry> getAndroidDKVersion(MonitorStatisticsEntiry monitorentiry) throws Exception;
	public List<iOSVersionEntiry> getiOSVersion(MonitorStatisticsEntiry monitorentiry) throws Exception;
	public List<AndroidVersionEntiry> getAndroidVersion(MonitorStatisticsEntiry monitorentiry) throws Exception;
	public List<ModelInfoEntiry> getiOSModelInfo(MonitorStatisticsEntiry monitorentiry) throws Exception;
	public List<ModelInfoEntiry> getAndroidModelInfo(MonitorStatisticsEntiry monitorentiry) throws Exception;
	public int getActivityAmount(MonitorStatisticsEntiry monitorentiry) throws Exception;
	public int getInstallAmount(MonitorStatisticsEntiry monitorentiry) throws Exception;
	public int getAllInstall() throws Exception;
	public List<DevelopInfoEntiry> getDeveloper(MonitorStatisticsEntiry monitorentiry) throws Exception;
}
