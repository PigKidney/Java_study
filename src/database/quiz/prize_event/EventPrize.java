package database.quiz.prize_event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.JdbcConnection;

public class EventPrize {
	Integer prize_id;
	String prize_name;
	Integer prize_quantity;
	Double prize_pct;
	Integer prize_max_qty;
	
	public EventPrize(String name) {
		this.prize_name = name;
	}
	
	public EventPrize(
			Integer prize_id, 
			String prize_name, 
			Integer prize_quantity, 
			Double prize_pct) {
		this.prize_id = prize_id;
		this.prize_name = prize_name;
		this.prize_pct = prize_pct;
		this.prize_quantity =prize_quantity;
	}
	
	public EventPrize(String name, int qty, double chance) {
		this.prize_name = name;
		this.prize_quantity =qty;
		this.prize_pct = chance;
		this.prize_max_qty = qty;
		try (Connection conn = JdbcConnection.getConnection();) {
			conn.setAutoCommit(false);
			String sql1 = "INSERT INTO prizes VALUES(prize_id_seq.nextval,?,?,?,?)";
			try (PreparedStatement pstmt = conn.prepareStatement(sql1)) {
				pstmt.setString(1, name);
				pstmt.setInt(2, qty);
				pstmt.setDouble(3, chance);
				pstmt.setInt(4, qty);
				pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void minusQty(String name) {
		try (Connection conn = JdbcConnection.getConnection();) {
			String sql = "UPDATE prizes SET prize_quantity = prize_quantity - 1 WHERE prize_name = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				conn.setAutoCommit(false);
				pstmt.setString(1, name);
				pstmt.executeUpdate();
				System.out.println(name + "의 상품이 줄어들었습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Double getPrize_pct() {
		
		return prize_pct;
	}
	
	public String getPrize_name() {
		return prize_name;
	}
	
	public Integer getPrize_quantity() {
		String sql = "SELECT * FROM prizes WHERE prize_name = ?";
		try(Connection conn = JdbcConnection.getConnection();
		) {
			conn.setAutoCommit(false);
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, prize_name);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					this.prize_quantity = rs.getInt("prize_quantity");
				}
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prize_quantity;
	}
	
	public Integer rollback_qty() {
		String sql = "UPDATE prizes SET prize_quantity = prize_max_qty";
		try(
			Connection conn = JdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prize_quantity;
	}
	
	@Override
	public String toString() {
		return String.format("%s %d %.2f\n",prize_name,prize_quantity,prize_pct);
	}
}
