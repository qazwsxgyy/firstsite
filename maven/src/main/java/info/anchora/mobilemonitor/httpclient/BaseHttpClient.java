package info.anchora.mobilemonitor.httpclient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BaseHttpClient {

	private static String Urlpath="http://mgr.sturgeon.mopaas.com/service/getBindingApps.json";
	/**
	 * 通用的服务器交互GET方法
	 * 
	 * @param Urlpath
	 * @param params
	 * @return String
	 * @throws IOException
	 */
	public static String HttpGetMethod(String paramname,
			String paramvalue) throws IOException {
		String result = null;
		String content = "";
		content += "&" + URLEncoder.encode(paramname, "UTF-8") + "="
				+ URLEncoder.encode(paramvalue, "UTF-8");
		URL loginUrl = new URL(Urlpath + "?" + content.substring(1));
		HttpURLConnection connection = (HttpURLConnection) loginUrl
				.openConnection();
		connection.setDoInput(true);
		connection.setRequestMethod("GET");
		connection.setUseCaches(false);
		connection.connect();
		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,
				"UTF-8"));
		int ch;
		StringBuffer b = new StringBuffer();
		while ((ch = br.read()) != -1) {
			b.append((char) ch);
		}
		result = b.toString().trim();
		connection.disconnect();
		return result;
	}

	/**
	 * 公用的与服务器交互的post方法 param paramlist参数列表 返回值 String
	 * 
	 * @throws IOException
	 */
	public static String HttpPostMethod(String paramname,
			String paramvalue) throws IOException {
		String result = null;
		URL loginUrl = new URL(Urlpath);
		HttpURLConnection connection = (HttpURLConnection) loginUrl
				.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod("POST");
		connection.setUseCaches(false);
		connection.setInstanceFollowRedirects(false);
		connection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		connection.setConnectTimeout(30 * 1000);
		connection.setReadTimeout(30 * 1000);
		connection.connect();

		DataOutputStream out = new DataOutputStream(
				connection.getOutputStream());

		String content = "";
		content += "&" + URLEncoder.encode(paramname, "UTF-8") + "="
				+ URLEncoder.encode(paramvalue, "UTF-8");
		out.writeBytes(content.substring(1));

		out.flush();
		out.close();
		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,
				"UTF-8"));
		int ch;
		StringBuffer b = new StringBuffer();
		while ((ch = br.read()) != -1) {
			b.append((char) ch);
		}
		result = b.toString().trim();
		connection.disconnect();
		return result;
	}

}
