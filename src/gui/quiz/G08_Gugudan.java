package gui.quiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class G08_Gugudan extends JFrame {
	/*
	 * # 실행하면 구구단이 출력되는 GUI 프로그램을 만들어보세요
	 * 
	 * (1) 프로그램을 처음 시작하면 구구단 2단이 출력된 상태로 시작
	 * 
	 * (2) + 버튼을 누르면 단이 증가하며 구구단 내용이 바뀜 (최대 9단 까지)
	 * 
	 * (3) - 버튼을 누르면 단이 감소하며 구구단 내용이 바귐 (최소 2단 까지)
	 * 
	 */
	int dan = 2;
	public G08_Gugudan() {

		super("구구단");
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setBounds(20, 20, 345, 650);
		add(panel, BorderLayout.CENTER);

		JLabel label = new JLabel("구구단");
		label.setBounds(275, 200, 50, 30);
		label.setFont(new Font("나눔고딕", Font.BOLD, 30));
		panel.add(label);

		JTextArea ta = new JTextArea();
		
		ta.setBounds(40, 70, 305, 585);
		ta.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		add(ta, JFrame.CENTER_ALIGNMENT);
		ta.setFont(new Font("나눔고딕", Font.BOLD, 40));
		ta.setText(new gogodan(dan).toString());
		ta.setEditable(false);
		ta.setFocusable(false);  
		
		JButton min = new JButton("<<");
		min.setBounds(25, 695, 80, 40);
		min.setForeground(new Color(255, 189, 196));
		min.setBackground(Color.DARK_GRAY);
		min.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(dan>2) {
					--dan;
					JTextArea ta = new JTextArea();
					ta.setBounds(40, 70, 305, 585);
					ta.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
					add(ta, JFrame.CENTER_ALIGNMENT);
					ta.setFont(new Font("나눔고딕", Font.BOLD, 40));
					ta.setText(new gogodan(dan).toString());
					
				} 
			}
		});
	
		
		JButton puls = new JButton(">>");
		puls.setBounds(280, 695, 80, 40);
		puls.setForeground(new Color(255, 189, 196));
		puls.setBackground(Color.DARK_GRAY);
		puls.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				++dan;
				JTextArea ta = new JTextArea();
				ta.setBounds(40, 70, 305, 585);
				ta.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
				add(ta, JFrame.CENTER_ALIGNMENT);
				ta.setFont(new Font("나눔고딕", Font.BOLD, 40));
				ta.setText(new gogodan(dan).toString());
			}
		});
		add(min);
		add(puls);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 800);
		setVisible(true);

	}

	public static void main(String[] args) {
		new G08_Gugudan();

	}
}

//class PulsButton extends JButton implements ActionListener {
//	public PulsButton(int h, int v) {
//		super(">>");
//		setBounds(h, v, 80, 40);
//		setForeground(new Color(255, 189, 196));
//		setBackground(Color.DARK_GRAY);
//		addActionListener(this);
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		System.out.println(e.getActionCommand());
//	}
//}

//class MinButton extends JButton implements ActionListener {
//
//	public MinButton(int h, int v) {
//		super("<<");
//		setBounds(h, v, 80, 40);
//		setForeground(new Color(255, 189, 196));
//		setBackground(Color.DARK_GRAY);
//		addActionListener(this);
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		System.out.println(e.getActionCommand());
//
//	}
//}

class gogodan {
	StringBuilder sb = new StringBuilder();

	public gogodan(int dan) {
		for (int i = dan; i < dan + 1; i++) {
			sb.append(dan + "단\n");
			for (int g = 1; g < 10; g++) {
				sb.append(i + " x ");
				sb.append(g + " : ");
				sb.append(i * g + "\n");
			}
		}
	}

	@Override
	public String toString() {
		return sb.toString();
	}
}