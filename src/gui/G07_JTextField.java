package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class G07_JTextField extends JFrame {
	public G07_JTextField() {
		super("JTextField Sample");
	
		setLayout(null);
	
		JLabel label = new JLabel("취미 : ");
		label.setBounds(50, 100, 50, 30);
		
		JTextField tf = new JTextField();
		
		tf.setLocation(100,100);
		tf.setSize(200,30);
		
		
		// JTextField의 액션 리스너는
		// 텍스트 필드가 선택된 채로 엔터키를 눌렀을때 발동한다
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 이벤트 발생시 ActionEvent에 필요한 정보들이 함께 넘어온다
				// (이벤트 발생 당시의 여러 정보들)
				System.out.println("이벤트를 발생시킨 컴포넌트"+e.getSource());
				System.out.println("이벤트를 발생시간 : "+ new Date(e.getWhen()));
				System.out.println("이벤트 발생 당시 텍스트필드 값 : "+ 
						e.getActionCommand());

			}
		});
		
		// 키보드가 눌렸을 때 발생하는 이벤트에 대한 처리
		tf.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// 입력이 있을 때 (글자가 아닌 다른 것이 눌렸을때 제외, crtl, alt, shifft 발동 안함)
//				System.out.println("Typed");
				
				// 한글은 2번 누를때 1글자 입력될때도 있고 3번 누를때 입력될때도 있기때문에 
				// 여기에서만 걸린다
				System.out.println(e.getKeyChar());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// 키보드에서 손을 뗐을 때
//				System.out.println("손을 뗌!");
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// 키보드를 눌렸을 때 (전부 다 발동함)
				//System.out.println("누름");
				System.out.println("keyChar : " +e.getKeyChar());
				System.out.println("keyCode : " +e.getKeyCode());
				
				switch(e.getKeyCode()) {
				case KeyEvent.VK_SPACE : 
					System.out.println("스페이스바가 눌렸습니다");
					break;
				case KeyEvent.VK_SHIFT:
					System.out.println("쉬프트키가 눌렸습니다");
				}
			}
		});
		
		add(label);
		add(tf);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,100,500,500);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new G07_JTextField();
	}
}
