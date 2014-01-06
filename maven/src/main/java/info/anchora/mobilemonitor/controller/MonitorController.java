package info.anchora.mobilemonitor.controller;

import info.anchora.mobilemonitor.enums.MonitorEnums;
import info.anchora.mobilemonitor.service.ActivityInfoService;
import info.anchora.mobilemonitor.service.InstallInfoService;
import info.anchora.mobilemonitor.util.MonitorResult;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MonitorController {

	private static final Logger log = Logger
			.getLogger(MonitorController.class);

	@Autowired
	InstallInfoService installinfoservice;
	@Autowired
	ActivityInfoService activityinfoservice;

	/**
	 * 调用该接口将安装信息或者活跃信息提交到数据库
	 * @param installinfo 安装信息(json)
	 * @param activityinfo 活跃信息(json)
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "api/mobilemonitor")
	public void create(
			@RequestParam(value = "installinfo", required = false) String installinfo,
			@RequestParam(value = "activityinfo", required = false) String activityinfo,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		JSONObject json = null;
		try {
			if (installinfo != null) {
				json = installinfoservice.addInstallInfo(installinfo);
			}
			if (activityinfo != null) {
				json = activityinfoservice.addActivityInfo(activityinfo);
			}

		} catch (Exception e) {
			log.info("Unexpect Exception", e);
			json=new JSONObject();
			json.put("status", MonitorEnums.DATABASE_INSERT_ERROR.code());
			json.put("message", MonitorEnums.DATABASE_INSERT_ERROR.message());
		}
		new MonitorResult().asynchronousPrintResult(response, json);
	}

}
