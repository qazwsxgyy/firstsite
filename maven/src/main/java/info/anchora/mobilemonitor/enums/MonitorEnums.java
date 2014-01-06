package info.anchora.mobilemonitor.enums;

public enum MonitorEnums {
	
	/**
	 * 系统问题（0xx）
	 */
	SUCCESS(000,"成功"),	
	SYSTEM_UNKNOW_ERROR(001,"未知错误"),
	REQUEST_PARAMETER_ERROR(002,"参数错误"),
	
	/**
	 * 数据库问题（1xx）
	 */
	DATABASE_UNKNOW_ERROR(101 ,"数据库未知错误"),
	DATABASE_INIT_ERROR(102 ,"数据库初始化错误"),
	DATABASE_ACCESS_ERROR(103 ,"数据库连接错误"),
	DATABASE_INSERT_ERROR(104 ,"数据库插入数据错误"),
	DATABASE_DELETE_ERROR(105 ,"数据库删除数据错误"),
	DATABASE_QUERY_ERROR(106 ,"数据库查询错误"),
	DATABASE_DATA_NOT_GET(107 ,"数据库查询不到相关数据"),
	
	/**
	 * 服务权限问题（2xx）
	 */	
	PERMISSIONS_ERROR(201 ,"操作没有相关权限"),	
	SERVICEKEY_NOT_EXIST_ERROR(202, "servicekey不存在"),
	SERVICE_NOT_BIND_ERROR(203, "服务未绑定"),
	SERVICE_IS_MAX_LIMIT(204,"服务内任务已经到达上限"),
	
	/**
	 * 特定服务问题（3xx）
	 */
	
	
	/**
	 * 服务器连接失败（5xx）
	 */
	SERVER_CONNECT_ERROR(501 ,"服务器连接失败");
	
	
	private final int code;
	private final String message;
	
	public int code() {
		return code;
	}

	public String message() {
		return message;
	}
	
	private MonitorEnums(int code, String msg){
		this.code = code;
		this.message = msg;
	}

}
