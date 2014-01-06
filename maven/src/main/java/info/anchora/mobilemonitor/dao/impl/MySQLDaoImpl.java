package info.anchora.mobilemonitor.dao.impl;

import info.anchora.mobilemonitor.dao.MySQLDao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class MySQLDaoImpl extends SqlMapClientDaoSupport implements MySQLDao{

	public boolean init() {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("mysqlEdm.CT_install_monitor");
		getSqlMapClientTemplate().update("mysqlEdm.CT_activity_monitor");
		return true;
	}
}
