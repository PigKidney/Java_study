package myobj.prizedraw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JdbcConnection;
import database.model.PrizeDb;

public class Prize {

	String name;
	int qty;
	double chance;

	
	public Prize(String name, int qty, double chance) {
		this.chance = chance;
		this.name = name;
		this.qty = qty;
		
		try (Connection conn = JdbcConnection.getConnection();) {
			conn.setAutoCommit(false);
			String sql1 = "INSERT INTO prizes VALUES(prize_id_seq.nextval,?,?,?)";
			try (PreparedStatement pstmt = conn.prepareStatement(sql1)) {
				pstmt.setString(1, name);
				pstmt.setInt(2, qty);
				pstmt.setDouble(3, chance);
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return name;
	}
	
	public double getChance() {
		return chance;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void minusQty(String name) {
		try (Connection conn = JdbcConnection.getConnection();) {
			String sql = "UPDATE prizes SET fprize_quantity = prize_quantity - 1 WHERE prize_name = '?';";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, name);
				int row = pstmt.executeUpdate();
				System.out.println(name + "의 상품이 줄어들었습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		--qty;
	}
	
	@Override
	public String toString() {
		return String.format("[%s/남은수량:%d/확률%.2f]",name,qty,chance);
	}
	
	
	
	
	
	
}