package com.samodeika.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface GenericCRUD<T> {

	public int create(Connection conn, T t) throws SQLException;

	public T get(Connection conn, int id) throws SQLException;

	public boolean update(Connection conn, T t) throws SQLException;

	public boolean delete(Connection conn, int id) throws SQLException;

}
