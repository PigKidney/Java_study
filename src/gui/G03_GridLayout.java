package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class G03_GridLayout {
	public static void main(String[] args) {
		JFrame f = new JFrame("GridLayout Sample");
		
		//
		GridLayout g1 = new GridLayout(5, 3);
		g1.setVgap(30);
		g1.setHgap(15);
		f.setLayout(g1);
		
		// 그리드 레이아웃에 컴포넌트 붙이기
		for(int i = 0 ; i < 15; ++i) {
			f.add(new JButton("Button"+i));
		}
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100,100,500,500);
		f.setVisible(true);
	}
}
