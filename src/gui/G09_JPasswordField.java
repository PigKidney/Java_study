package gui;

import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class G09_JPasswordField extends JFrame{
	
	// 비밀번호를 입력할 때 사용하는 필드
	
	public G09_JPasswordField() {
		super("JTextArea Sample");
		setLayout(new GridLayout(2,2));
		
		JLabel idLabel = new JLabel("ID : ");
		JTextField idField = new JTextField();
		
		// 비밀번호를 텍스트 필드로 하게되면 옆사람에게 다 보인다
		JLabel pwLabel = new JLabel("pw : ");
		JTextField pwField = new JPasswordField();
		// JTextField pwField = new JTextField();
		
		add(idLabel);
		add(idField);
		
		add(pwLabel);
		add(pwField);
		
		this.addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentMoved(ComponentEvent e) {
				System.out.println("x: "+e.getComponent().getX()+"  y: "+e.getComponent().getY());
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				System.out.println("width: "+e.getComponent().getWidth()+"  height: "+e.getComponent().getHeight());
			}
			
		}); 
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 80);
		setVisible(true);
	}
	public static void main(String[] args) {
		new G09_JPasswordField();
	}
}
