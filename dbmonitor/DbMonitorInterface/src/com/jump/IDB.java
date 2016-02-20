package com.jump;

import java.sql.SQLException;

public interface IDB {

	public void init(String param) throws SQLException,ClassNotFoundException;
	
	public void destroy() throws SQLException;
}
