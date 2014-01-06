package info.anchora.mobilemonitor.controller;

import info.anchora.mobilemonitor.enums.MonitorEnums;
import info.anchora.mobilemonitor.service.MonitorStatisticsService;
import info.anchora.mobilemonitor.util.MonitorResult;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MonitorStatisticsController {
	private static final Logger log = Logger
			.getLogger(MonitorController.class);

	@Autowired
	MonitorStatisticsService monitorstatisticsservice;
	
	/**
	 * 获取安装量相关统计信息
	 * @param mode（week表示按周，month表示按月）
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "api/getmonitorinfo/installcapacity")
	public void installinfo(
			@RequestParam(value = "mode", required = true) String mode,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		JSONObject json = null;
		try {
			/*获取总的安装量*/
			int allinstall = monitorstatisticsservice.getAllInstallInfo();
			/*按周或者按月获取安装信息
			 * 按周表示每七天统计一次
			 * 按月表示每30天统计一次*/
			JSONArray installjson = monitorstatisticsservice.getInstallInfo(mode);
			/*按周或者按月获取活跃信息
			 * 按周表示每七天统计一次
			 * 按月表示每30天统计一次
			 * 统计过程中有进行去重处理*/
			JSONArray activityjson = monitorstatisticsservice.getActivityInfo(mode);
			json=new JSONObject();			
			json.put("allinstall", allinstall);
			if(installjson!=null)
				json.put("install_info", installjson);
			if(activityjson!=null)
				json.put("activity_info", activityjson);
		} catch (Exception e) {
			log.info("Unexpect Exception", e);
			json=new JSONObject();
			json.put("status", MonitorEnums.DATABASE_QUERY_ERROR.code());
			json.put("message", MonitorEnums.DATABASE_QUERY_ERROR.message());
		}
		new MonitorResult().asynchronousPrintResult(response, json);
	}
	
	/**
	 * 按周或者按月获取不同的手机操作系统平台上，SDK的活跃统计信息
	 * @param mode（此处按周表示统计近7天，按月表示统计近30天）
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "api/getmonitorinfo/os")
	public void osinfo(
			@RequestParam(value = "mode", required = true) String mode,
			HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		JSONObject json = null;
		JSONArray jsonarray = new JSONArray();
		try {
			jsonarray = monitorstatisticsservice.getOSInfo(mode);
			json=new JSONObject();
			if(jsonarray!=null)
				json.put("OS_info", jsonarray);
		} catch (Exception e) {
			log.info("Unexpect Exception", e);
			json=new JSONObject();
			json.put("status", MonitorEnums.DATABASE_QUERY_ERROR.code());
			json.put("message", MonitorEnums.DATABASE_QUERY_ERROR.message());
		}
		new MonitorResult().asynchronousPrintResult(response, json);
	}
	
	/**
	 * 按周或者按月统计ios的SDK不同版本的活跃信息
	 * @param mode（此处按周表示统计近7天，按月表示统计近30天）
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "api/getmonitorinfo/iosdk")
	public void iosdk(
			@RequestParam(value = "mode", required = true) String mode,
			HttpServletRequest request, HttpServletResponse response)
	throws IOException{
		JSONObject json = null;
		JSONArray jsonarray = new JSONArray();
		try {
			jsonarray = monitorstatisticsservice.getiOSDKVersion(mode);
			json = new JSONObject();
			json.put("iOSDK_version", jsonarray);
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Unexpect Exception", e);
			json=new JSONObject();
			json.put("status", MonitorEnums.DATABASE_QUERY_ERROR.code());
			json.put("message", MonitorEnums.DATABASE_QUERY_ERROR.message());
		}
		new MonitorResult().asynchronousPrintResult(response, json);
	}
	
	/**
	 * 按周或者按月统计Android的SDK不同版本的活跃统计信息
	 * @param mode（此处按周表示统计近7天，按月表示统计近30天）
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "api/getmonitorinfo/androidsdk")
	public void androidsdk(
			@RequestParam(value = "mode", required = true) String mode,
			HttpServletRequest request, HttpServletResponse response)
	throws IOException{
		JSONObject json = null;
		JSONArray jsonarray = new JSONArray();
		try {
			jsonarray = monitorstatisticsservice.getAndroidSDKVersion(mode);
			json = new JSONObject();
			json.put("androidSDK_version", jsonarray);
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Unexpect Exception", e);
			json=new JSONObject();
			json.put("status", MonitorEnums.DATABASE_QUERY_ERROR.code());
			json.put("message", MonitorEnums.DATABASE_QUERY_ERROR.message());
		}
		new MonitorResult().asynchronousPrintResult(response, json);
	}
	
	/**
	 * 按周或者按月获取使用SDK的系统中，ios各个系统版本的统计信息
	 * @param mode（此处按周表示统计近7天，按月表示统计近30天）
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "api/getmonitorinfo/iosversion")
	public void iosversion(
			@RequestParam(value = "mode", required = true) String mode,
			HttpServletRequest request, HttpServletResponse response)
	throws IOException{
		JSONObject json = null;
		JSONArray jsonarray = new JSONArray();
		try {
			jsonarray = monitorstatisticsservice.getiOSVersion(mode);
			json = new JSONObject();
			json.put("iOS_version", jsonarray);
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Unexpect Exception", e);
			json=new JSONObject();
			json.put("status", MonitorEnums.DATABASE_QUERY_ERROR.code());
			json.put("message", MonitorEnums.DATABASE_QUERY_ERROR.message());
		}
		new MonitorResult().asynchronousPrintResult(response, json);
	}
	
	/**
	 * 按周或者按月获取使用SDK的系统中，android各个系统版本的统计信息
	 * @param mode（此处按周表示统计近7天，按月表示统计近30天）
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "api/getmonitorinfo/androidversion")
	public void androidversion(
			@RequestParam(value = "mode", required = true) String mode,
			HttpServletRequest request, HttpServletResponse response)
	throws IOException{
		JSONObject json = null;
		JSONArray jsonarray = new JSONArray();
		try {
			jsonarray = monitorstatisticsservice.getAndroidVersion(mode);
			json = new JSONObject();
			json.put("android_version", jsonarray);
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Unexpect Exception", e);
			json=new JSONObject();
			json.put("status", MonitorEnums.DATABASE_QUERY_ERROR.code());
			json.put("message", MonitorEnums.DATABASE_QUERY_ERROR.message());
		}
		new MonitorResult().asynchronousPrintResult(response, json);
	}
	
	/**
	 * 按周或者按月获取使用SDK的系统中，ios系统的设备型号的统计信息
	 * @param mode（此处按周表示统计近7天，按月表示统计近30天）
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "api/getmonitorinfo/iosmodel")
	public void iosmodel(
			@RequestParam(value = "mode", required = true) String mode,
			HttpServletRequest request, HttpServletResponse response)
	throws IOException{
		JSONObject json = null;
		JSONArray jsonarray = new JSONArray();
		try {
			jsonarray = monitorstatisticsservice.getiOSModelInfo(mode);
			json = new JSONObject();
			json.put("iOS_Model", jsonarray);
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Unexpect Exception", e);
			json=new JSONObject();
			json.put("status", MonitorEnums.DATABASE_QUERY_ERROR.code());
			json.put("message", MonitorEnums.DATABASE_QUERY_ERROR.message());
		}
		new MonitorResult().asynchronousPrintResult(response, json);
	}
	
	/**
	 * 按周或者按月获取使用SDK的系统中，android系统的设备型号的统计信息
	 * 由于android的设备型号过多，此处统计前十
	 * @param mode（此处按周表示统计近7天，按月表示统计近30天）
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "api/getmonitorinfo/androidmodel")
	public void androidmodel(
			@RequestParam(value = "mode", required = true) String mode,
			HttpServletRequest request, HttpServletResponse response)
	throws IOException{
		JSONObject json = null;
		JSONArray jsonarray = new JSONArray();
		try {
			jsonarray = monitorstatisticsservice.getAndroidModelInfo(mode);
			json = new JSONObject();
			json.put("android_Model", jsonarray);
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Unexpect Exception", e);
			json=new JSONObject();
			json.put("status", MonitorEnums.DATABASE_QUERY_ERROR.code());
			json.put("message", MonitorEnums.DATABASE_QUERY_ERROR.message());
		}
		new MonitorResult().asynchronousPrintResult(response, json);
	}
	
	/**
	 * 按周或者按月获取使用SDK的开发者的应用的活跃情况（由于开发者众多，此处最多统计前十名）
	 * @param mode（此处按周表示统计近7天，按月表示统计近30天）
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "api/getmonitorinfo/developer")
	public void developer(
			@RequestParam(value = "mode", required = true) String mode,
			HttpServletRequest request, HttpServletResponse response)
	throws IOException{
		JSONObject json = null;
		try {
			json = monitorstatisticsservice.getDeveloper(mode);
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Unexpect Exception", e);
			json=new JSONObject();
			json.put("status", MonitorEnums.DATABASE_QUERY_ERROR.code());
			json.put("message", MonitorEnums.DATABASE_QUERY_ERROR.message());
		}
		new MonitorResult().asynchronousPrintResult(response, json);
	}
	
}
