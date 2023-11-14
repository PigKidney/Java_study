package database.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JdbcConnection;

public class PrizeDb {
	Integer prize_id;
	String prize_name;
	Integer prize_quantity;
	Double prize_pct;
	
	public PrizeDb(
			Integer prize_id, 
			String prize_name, 
			Integer prize_quantity, 
			Double prize_pct) {
		this.prize_id = prize_id;
		this.prize_name = prize_name;
		this.prize_pct = prize_pct;
		this.prize_quantity =prize_quantity;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %d %f",prize_id,prize_name,prize_quantity,prize_pct);
	}
	
	
	
}
