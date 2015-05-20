package com.samodeika.JavaOracleApp;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;

import com.samodeika.entities.Transaction;
import com.samodeika.services.TransactionService;

public class MultiProcessor implements Runnable {

	private int id;
	
	public MultiProcessor(int id){
		this.id = id;
	}
	
	public void run() {
		// System.out.println("Starting: " + id);
		

		TransactionService tr = null;

		try {

			long offset = Timestamp.valueOf("2014-01-01 00:00:00").getTime();
			long end = Timestamp.valueOf("2016-01-01 00:00:00").getTime();
			long diff = end - offset + 1;
			Timestamp newTime = new Timestamp(offset
					+ (long) (Math.random() * diff));

			Random rand = new Random();
			float amount = rand.nextFloat() * rand.nextInt(1000);

			Transaction newTrans = new Transaction(0, newTime, amount);

			tr = new TransactionService();
			
			int id = tr.createTransaction(newTrans);

			tr.commit();
			
			// System.out.println("Id is " + id);

			// Transaction trans = tr.getTransaction(id);

			// System.out.println(trans);
			
			//Thread.sleep(5000);

		} catch (SQLException e) {
			tr.rollback();
			e.printStackTrace();
		}
		finally {
			if (tr != null) {
				tr.closeConnection();
			}
		}
		
		// System.out.println("Completed: " + id);
	}
	
}
