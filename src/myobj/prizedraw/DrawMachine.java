package myobj.prizedraw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JdbcConnection;
import database.model.PrizeDb;

public class DrawMachine {

	private Prize[] prizes;
	private Prize[] pickBox = new Prize[100]; // 확률을 만들기 위한 배열
	private List<PrizeDb> pl = new ArrayList<>();

	
	// 상품 목록을 전달받으면 상품을 배치하는 생성자
	public DrawMachine(Prize[] prizes) {
		this.prizes = prizes;
		initPickBox();
	}
	

	private void initPickBox() {
		// Prizes에 들어있는 상품 정보들로 확률을 만들어낸다
		int index = 0;
		for (int i = 0; i < prizes.length; ++i) {
			double per = prizes[i].getChance() * 100;
			for (int j = 0; j < per; ++j) {
				pickBox[index++] = prizes[i];
			}
		}
	}

	public Prize draw() {
		Prize present = pickBox[(int) (Math.random() * 100)];
		if (present == null) {
			return new Prize("꽝", 0, 0);
		} else {
			if (present.getQty() == 0) {
				return new Prize("상품 소진", 0, 0);
			}
			present.minusQty(present.getName());
			return present;
		}

	}
	
	public void rollback() {
		try (Connection conn = JdbcConnection.getConnection();) {
			conn.setAutoCommit(false);
			conn.rollback();
			System.out.println("롤백완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertPrizeList() {
		String sql = "SELECT * FROM prizes";
		try(
			Connection conn = JdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		) {
			while(rs.next()) {
				PrizeDb pr = new PrizeDb(
						rs.getInt("prize_id"),
						rs.getString("prize_name"),
						rs.getInt("prize_quantity"),
						rs.getDouble("prize_pct")
						);
				pl.add(pr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void commit() {
		try (Connection conn = JdbcConnection.getConnection();) {
			conn.setAutoCommit(false);
			conn.commit();
			System.out.println("커밋완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
