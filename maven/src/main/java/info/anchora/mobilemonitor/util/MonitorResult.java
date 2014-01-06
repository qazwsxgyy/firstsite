package info.anchora.mobilemonitor.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

public class MonitorResult {

	private static Logger logger=Logger.getLogger(MonitorResult.class);
	private JSONObject result = new JSONObject();
	/**
     * 设置CODE和MSG
     * @param code
     * @param msg
     */
    public void setCodeAndMsg(String code, Object msg) {
        result.put("returnCode", code);
        result.put("returnMessage", msg);
    }
    
    public void setMsg(Object msg) {
        result.put("returnMessage", msg);
    }

    /**
     * 将数据加入到JSON中
     * @param key
     * @param value
     */
    public void add(String key, Object value) {
        result.put(key, value);
    }
	
	/**
     * 创建一个JSON
     * @param fieldMap
     * @return
     */
    public JSONObject createJson(String fieldMap) {
        JSONObject cJson = new JSONObject();
        if (fieldMap == null) {
            return cJson;
        }
        String[] fields = fieldMap.split(";");
        int lenght = fields.length;
        for (int i = 0; i < lenght; i++) {
            if (lenght <= 0) {
                continue;
            }
            String[] field = fields[i].split("=");
            String fromName = field[0];
            String toName = field.length == 1 ? field[0] : field[1];
            cJson.put(fromName, toName);
        }
        return cJson;
    }

    public JSONObject returnResult() {
        return result;
    }

    /**
     * 输出到界面的数据
     * @param response
     * @param value
     * @throws BusinessException
     */
    public void asynchronousPrintResult(HttpServletResponse response, Object value) {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.print(value.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            logger.error("asynchronousPrintResult error!" + e);
        }
    }

    public String createXml(String returnCode, String returnMessage) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        buffer.append("<result>");
        buffer.append("<returnCode>" + returnCode + "</returnCode>");
        buffer.append("<returnMessage>" + returnMessage + "</returnMessage>");
        buffer.append("</result>");
        return buffer.toString();
    }

}
