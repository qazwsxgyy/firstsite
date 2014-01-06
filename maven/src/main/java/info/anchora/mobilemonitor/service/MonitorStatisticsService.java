package info.anchora.mobilemonitor.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface MonitorStatisticsService {

	/**
	 * 按周或者按月获取安装信息
	 * @param mode
	 * @return
	 * @throws Exception
	 */
	public JSONArray getInstallInfo(String mode) throws Exception;
	/**
	 * 按周或者按月获取活跃信息（有去重，同一个手机用户有两次以上活跃信息，只取一次）
	 * @param mode
	 * @return
	 * @throws Exception
	 */
	public JSONArray getActivityInfo(String mode) throws Exception;
	/**
	 * 按周或者按月获取不同的手机操作系统平台上，SDK的活跃统计信息
	 * @param mode
	 * @return
	 * @throws Exception
	 */
	public JSONArray getOSInfo(String mode) throws Exception;
	/**
	 * 按周或者按月统计ios的SDK不同版本的活跃信息
	 * @param mode
	 * @return
	 * @throws Exception
	 */
	public JSONArray getiOSDKVersion(String mode) throws Exception;
	/**
	 * 按周或者按月统计Android的SDK不同版本的活跃统计信息
	 * @param mode
	 * @return
	 * @throws Exception
	 */
	public JSONArray getAndroidSDKVersion(String mode) throws Exception;
	/**
	 * 按周或者按月获取使用SDK的系统中，ios各个系统版本的统计信息
	 * @param mode
	 * @return
	 * @throws Exception
	 */
	public JSONArray getiOSVersion(String mode) throws Exception;
	/**
	 * 按周或者按月获取使用SDK的系统中，android各个系统版本的统计信息
	 * @param mode
	 * @return
	 * @throws Exception
	 */
	public JSONArray getAndroidVersion(String mode) throws Exception;
	/**
	 * 按周或者按月获取使用SDK的系统中，ios系统的设备型号的统计信息
	 * @param mode
	 * @return
	 * @throws Exception
	 */
	public JSONArray getiOSModelInfo(String mode) throws Exception;
	/**
	 * 按周或者按月获取使用SDK的系统中，android系统的设备型号的统计信息
	 * 由于android的设备型号过多，此处统计前十
	 * @param mode
	 * @return
	 * @throws Exception
	 */
	public JSONArray getAndroidModelInfo(String mode) throws Exception;
	/**
	 * 获取总的安装量
	 * @return
	 * @throws Exception
	 */
	public int getAllInstallInfo() throws Exception;
	/**
	 * 按周或者按月获取使用SDK的开发者的应用的活跃情况（由于开发者众多，此处最多统计前十名）
	 * @param mode
	 * @return
	 * @throws Exception
	 */
	public JSONObject getDeveloper(String mode) throws Exception;

}
