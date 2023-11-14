package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class G08_JTextArea extends JFrame{
	public G08_JTextArea() {
		super("JTextArea Sample");
		setLayout(null);
		
		JTextArea ta = new JTextArea();
		
		ta.setBounds(100,100,300,300);
		
		// 테두리 설정
		ta.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		
		// 키보드 이벤트 설정
		// KeyListener 자리에 KeyAdapter를 사용하면
		// 여러 이벤트 중 원하는 이벤트 메서드만 오버라이드 할 수 있다
		ta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println(e.getKeyChar());
			}
		});
		add(ta);


		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,100,500,500);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new G08_JTextArea();
	}
}
