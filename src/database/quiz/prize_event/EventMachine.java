package database.quiz.prize_event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JdbcConnection;
import database.model.Employee;

public class EventMachine {
	
	private List<EventPrize> ep = new ArrayList<>();
	private List<EventPrize> epBox = new ArrayList<>(100);
	
	public void setEventBox() {
		EventPrize ep = new EventPrize("꽝");
		for (int i = 0; i < 100 ; ++i) {
			epBox.add(i, ep);
		}
	}
	
	
	private void initPickBox() {
		// EventPrize List에 들어있는 상품 정보들로 확률을 만들어낸다
		setEventBox();
		int index = 0;
		for (int i = 0; i < ep.size() ; ++i) {
			double per = ep.get(i).getPrize_pct() * 100;
			for (int j = 0; j < per; ++j) {
				epBox.add(index++, ep.get(i));
			}
		}
	}
	/***
	 * 상품 목록 배치 생성자
	 * @param ep
	 */
	public EventMachine(List<EventPrize> ep) {
		this.ep = ep;
		initPickBox();
	}
	
	
	
	public void draw() {
		EventPrize ep = epBox.get((int)(Math.random() * 100));
		if (ep.getPrize_name().equals("꽝")) {
			System.out.println("꽝 다음기회에...");
		} else {
			if ((int)ep.getPrize_quantity() == 0) {
				System.out.println("상품이 없습니다...");
			} else {
				ep.minusQty(ep.getPrize_name());
				System.out.println(ep.getPrize_name()+"을 뽑으셨습니다.");
			}
			
		}

	}
	
	
	
	public void rollback() {
		
		for(int i = 0 ; i < ep.size() ; i++) {
			ep.get(i).rollback_qty();
		}
		initPickBox();
		System.out.println("롤백완료");
	}
	
	public void crateTable() {
		String sql = "CREATE TABLE prizes(prize_id NUMBER(5) CONSTRAINT prize_id_pk PRIMARY KEY, "
				+ "prize_name VARCHAR2 (30) CONSTRAINT prize_name_nn NOT NULL, "
				+ "prize_quantity NUMBER(3) DEFAULT 0 CHECK (prize_quantity >= 0), "
				+ "prize_pct NUMBER(2,2) DEFAULT 0 CHECK (prize_pct >= 0 AND prize_pct <= 1))";
		try (Connection conn = JdbcConnection.getConnection();) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.executeUpdate();
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
	
	public void delete() {
		try (Connection conn = JdbcConnection.getConnection();) {
			String sql = "DELETE FROM prizes";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void info() {
		String sql = "SELECT * FROM prizes";
		try(
			Connection conn = JdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		) {
//			List<EventPrize> eps = new ArrayList<>();
			conn.setAutoCommit(false);
			while(rs.next()) {
				EventPrize eps = new EventPrize(
						rs.getInt("prize_id"),
						rs.getString("prize_name"),
						rs.getInt("prize_quantity"),
						rs.getDouble("prize_pct")
						);
				System.out.println(eps.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
