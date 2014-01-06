package info.anchora.mobilemonitor.aop;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogAOPInterceptor extends HandlerInterceptorAdapter{
	
	private static Log logger = LogFactory.getLog(LogAOPInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("requestUrl:" + request.getRequestURL() + "?" + getParameters(request)
				+ " ip:" + request.getRemoteAddr() + " port:" + request.getRemotePort());
		return super.preHandle(request, response, handler);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static String getParameters(HttpServletRequest request)
	{
		Map map = request.getParameterMap();
		if (map != null)
		{
			StringBuffer sb = new StringBuffer();
			Iterator<Map.Entry> iter = map.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = iter.next();
				sb.append("&" + entry.getKey() + "=" + ((String []) entry.getValue())[0]);
			}
			return sb.toString();
		}
		
		return null;
	}

}
