package com.samodeika.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.samodeika.dao.TransactionDAO;
import com.samodeika.entities.Transaction;

public class TransactionService {

	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String username = "alex";
	private String password = "alex";
	private Connection connection;
	private TransactionDAO tr;

	public TransactionService() throws SQLException {
		this.connection = DriverManager.getConnection(this.url, this.username,
				this.password);
		this.tr = new TransactionDAO();
	}

	public void closeConnection() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Transaction getTransaction(int id) throws SQLException {
		return tr.get(connection, id);
	}

	public int createTransaction(Transaction t) throws SQLException {
		return tr.create(connection, t);
	}

}
