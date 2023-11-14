package gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class G01_JavaSwing {
	
	/*
	  
	  	# Java Swing
	  	
	  	- 자바로 GUI 프로그램을 만들 수 있는 API
	  	- GUI(Graphic User Interface) : 컴퓨터 화면을 이미지로 제어할 수 있는 환경
	 	- 컨테이너 위에 컴포넌트를 배치하는 방식으로 화면을 구성할 수 있다
	 	
	 	
	 	# Swing Container
	 	
	 	- 컨테이너 위에는 여러가지 컴포넌트들을 배치할 수 있다
	 	- JFrame, JPanel, JDialog .. 등 컨테이너로 분류되는 다양한 클래스들이 존재한다
	 	
	 	
	 	# Swing Component
	 	
	 	- 컨테이너 위에 배치할 수 있는 객체들
	 	- 버튼, 라벨, 표, 체크박스 .. 등 컴포넌트로 분류되는 다양한 클래스들이 존재한다
	 	
	*/
	
	public static void main(String[] args) {
		
		// JFrame : 대표적인 컨테이너 (초기에는 보이지 않는 상태)
		JFrame frame = new JFrame();
		
		// JButton : 여러 컴포넌트들 중 한 종류. 누를 수 있다
		JButton button = new JButton();
		JButton button1 = new JButton();

		button.setSize(150, 80);
		// Swing의 일부 컴포넌트 라벨에서 html문법이 동작한다 (줄바꿈)
		button.setText("<html>button<br>눌러주세요...</html>");
		button.setLocation(300 , 300 );
		
		// setBounds == setLocation + setSize
		button1.setBounds(100, 300, 150, 80);
		button1.setText("button1");
		
		// 만든 컴포넌트를 프레임에 붙인다
		frame.add(button);
		frame.add(button1);

		// 해당 프레임의 레이아웃관리자를 설정 (레이아웃관리자 - 컴포넌트를 부착할 때 위치를 제어해주는 클래스)
		frame.setLayout(null);
		// 프레임의 x버튼을 눌렀을 때 동작을 설정하는 메서드
		// - EXIT_ON_CLOSE : 누르면 프로그램 종료
		// - HIDE_ON_CLOSE : 누르면 창을 숨김
		// - DO_NOTHING ON CLOSE : 눌러도 아무것도 안한다.
		// - DISPOSE_ON_CLOSE : 누르면 해당 창만 종료함. 프로그램은 종료하지 않음 (기본값)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 해당 프레임의 제목을 설정하는 메서드
		frame.setTitle("My GUI Program");
		// 해당 프레임의 초기 위치를 성정하는 메서드
		frame.setLocation(100, 100);
		// 해당 프레임의 초기 크기를 설정하는 메서드
		frame.setSize(768,1024);
		// 해당 프레임을 보이는 상태로 설정
		frame.setVisible(true); // 프레임을 보이는 상태로 설정
	
	}
	
	
}
