package info.anchora.mobilemonitor.dao;

import info.anchora.mobilemonitor.entiry.InstallMonitorEntiry;

public interface InstallInfoDao {

	/**
	 * 插入安装信息
	 * @param installinfo
	 * @throws Exception
	 */
	public void addInstallInfo(InstallMonitorEntiry installinfo) throws Exception;

}
