package info.anchora.mobilemonitor.controller;

import info.anchora.mobilemonitor.dao.MySQLDao;
import info.anchora.mobilemonitor.enums.MonitorEnums;
import info.anchora.mobilemonitor.util.MonitorResult;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DataBaseInitController {
	private static Log log = LogFactory.getLog(DataBaseInitController.class);

	@Autowired
	public MySQLDao mysqlDao;

	@RequestMapping(value = "/database/init", method = { RequestMethod.POST,
            RequestMethod.GET })
	public void helloworld (HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		JSONObject json;
		try{
			if (mysqlDao.init())
			{
				response.getWriter().append("<h1>Create Tables Successful !</h1>");
			}
			else
			{
				response.getWriter().append("<h1>ERROR</h1>");
			}
			response.getWriter().flush();
			response.getWriter().close();
		}catch (Exception e) {
			log.info("DataBaseInitController Unexpect Exception",e);
			json=new JSONObject();
			json.put("status", MonitorEnums.DATABASE_INIT_ERROR.code());
			json.put("message", MonitorEnums.DATABASE_INIT_ERROR.message());
			new MonitorResult().asynchronousPrintResult(response, json);
		}
	}

}
