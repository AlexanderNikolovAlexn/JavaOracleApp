package com.samodeika.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;

import oracle.jdbc.internal.OraclePreparedStatement;
import oracle.jdbc.internal.OracleTypes;

import com.samodeika.entities.Transaction;
import com.samodeika.interfaces.GenericCRUD;

public class TransactionDAO implements GenericCRUD<Transaction> {

	public int create(Connection conn, Transaction t) throws SQLException {
		int id = 0;

		OraclePreparedStatement stm = (OraclePreparedStatement) conn
				.prepareStatement("insert into transactions(transaction_id, transaction_date, transaction_amount)"
						+ "values(seq_transactions.nextval, ?,  ?)"
						+ "returning transaction_id into ?");
		stm.setTimestamp(1, t.getDate());
		stm.setFloat(2, t.getAmount());
		stm.registerReturnParameter(3, OracleTypes.NUMBER);
		stm.executeUpdate();

		ResultSet rs = stm.getReturnResultSet();

		while (rs.next()) {
			id = rs.getInt(1);
		}

		return id;
	}

	public Transaction get(Connection conn, int id) throws SQLException {
		PreparedStatement stm = conn
				.prepareStatement("select * from transactions where transaction_id = ?");
		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();

		Transaction tr = new Transaction();

		if (rs.next()) {
			tr.setId(rs.getInt("transaction_id"));
			tr.setDate(rs.getTimestamp("transaction_date"));
			tr.setAmount(rs.getFloat("transaction_amount"));
		} else {
			throw new SQLDataException("No data found");
		}

		return tr;
	}

	public boolean update(Connection conn, Transaction t) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
