package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// Swing 컴포넌트들은 상속을 통한 구현이 가능하다
public class G05_JButton extends JFrame{
	
	
	public G05_JButton() {
		setLayout(null);
		// ContentPane : 프레임 내에서 실제로 내용이 그려지는 곳
		getContentPane().setBackground(Color.GRAY);
		
		JButton btn1 = new JButton("Button1");
		
		// 여러가지 버튼 설정들a
		btn1.setText("Changed Text...");
		btn1.setBounds(100, 100, 300, 70);
		// 글씨색 설정
//		btn1.setForeground(Color.red);
		btn1.setForeground(new Color(255,189,196));
		// 배경색 설정
		btn1.setBackground(Color.white);
//		btn1.setEnabled(false);
		
		
		// 버튼을 눌렀을 때의 동작을 설정
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼을 누르셨네요");
				getContentPane().setBackground(Color.DARK_GRAY);
			}
		});
		
		add(btn1);
		add(new MyButton2(100,200,this));
		add(new MyButton(100,300,this));
		
		setTitle("JButton Examples...");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(100,100);
		setSize(500,500);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new G05_JButton();
		
	}
}

class MyActionListener implements ActionListener {
	JFrame parent;
	
	public MyActionListener(JFrame parent) {
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		parent.getContentPane().setBackground(Color.lightGray);
	}
}

class MyButton extends JButton{

	public MyButton(int h, int v, JFrame parent) {
		super("MyBytton");
		
		setBounds(h, v, 300, 70);
		setForeground(Color.BLACK);
		setBackground(new Color(255,189,196));
		addActionListener(new MyActionListener(parent));
	}
}

class MyButton2 extends JButton implements ActionListener{
	JFrame parent;
	
	public MyButton2(int h, int v, JFrame parent) {
		super("MyBytton");
		this.parent = parent;
		setBounds(h, v, 300, 70);
		setForeground(new Color(255,189,196));
		setBackground(Color.BLACK);
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		parent.getContentPane().setBackground(Color.gray);

	}
}