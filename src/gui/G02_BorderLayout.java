package gui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

public class G02_BorderLayout {
	/*
	  	# 레이아웃 관리자 (Layout Manager)
	  	
	  	- 컨테이너에는 레이아웃 관리자를 설정할 수 있다
	  	- 레이아웃을 설정한 컨테이너에는 컴포넌트를 원하는 위치에 마음대로 부착할 수 없고
	  	  레이아웃에서 정해주는 위치에만 부착할 수 있다
	  	- 컴포넌트를 자유롭게 배치하고 싶다면 해당 컨테이너의 레이아웃 매니저를 null로 설정해야 한다
	  	  (setLocation, setSize를 통해 배치)
	  	  
	  	# BorderLayout
	  	
	  	- JFrame의 기본값
	  	- 동, 서 , 남, 북, 가운데에 컴포넌트를 배치할 수 있다
	 
	*/
	public static void main(String[] args) {
		JFrame f = new JFrame("My GUI Program");
		
		List<JButton> btns = new ArrayList<>();
		for (int i = 0 ; i <=5; i++) {
			btns.add(new JButton("Button"+i));
		}
		
		// 생성자에 gap을 설정할 수 있는 오버로딩이 존재한다
//		f.setLayout(new BorderLayout(10, 30));
		f.setLayout(new BorderLayout());
		
		// 보더 레이아웃이 설정된 컨테이너에 컴포넌트를 붙인다
		f.add(btns.get(0), BorderLayout.EAST);
		f.add(btns.get(1), BorderLayout.SOUTH);
		f.add(btns.get(2), BorderLayout.NORTH);
		f.add(btns.get(3), BorderLayout.WEST);
		f.add(btns.get(4), BorderLayout.CENTER);
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100,100,500,500);
		f.setVisible(true);
	}
}
