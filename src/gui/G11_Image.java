package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class G11_Image {
	static ImageIcon no1 ;
	static ImageIcon no2 ;
	
	// 해당 컴포넌트의 이미지를 setIcon 메서드로 교체할 수 있다
	public static void main(String[] args) {
		JFrame f = new JFrame("Image Samples");
		
		CardLayout card = new CardLayout();
		f.setLayout(new BorderLayout());
		
		JLabel image1Label = new JLabel();

		// 라벨에 이미지 설정하기
//		image1Label.setIcon(new ImageIcon("myfiles/myimages/lostArk/download.png"));
		// 이미지 크기 수정해서 사용하기
		try {
			// 1. 이미지의 크기를 수정하기위해 불러온다
			BufferedImage bufferedImage =
					ImageIO.read(new File("myfiles/myimages/lostArk/download.png"));
			BufferedImage bufferedImage1 =
					ImageIO.read(new File("myfiles/myimages/lostArk/download1.png"));
			
			// 2. 불러온 이미지로부터 사이즈 조절된 새로운 인스턴스를 받을 수 있다
			Image scaledImage =
					bufferedImage.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
			Image scaledImage1 =
					bufferedImage1.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
			Image subImage =
					bufferedImage.getSubimage(50, 50, 150, 150);
			// 3. 크기 조절된 이미지를 라벨에 붙인다
			no1 = new ImageIcon(scaledImage);
			no2 = new ImageIcon(scaledImage1);
			image1Label.setIcon(no1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		image1Label.setIcon(null);
		f.add(image1Label, "Center");
		// 연습 : 다음 버튼을 누르면 이미지가 교체되도록 만들어보세요 (순환되게 만들것)
		
		JButton southBtn = new JButton("다음!");
		southBtn.addActionListener(new ActionListener() {
			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (image1Label.getIcon() == no1) {
//					image1Label.setIcon(no2);
//				} else if (image1Label.getIcon() == no2) {
//					image1Label.setIcon(no1);
//				}
//				
//			}
			
			int ae = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				File images = new File("myfiles/myimages/lostArk/");
				String[] imageList = images.list();
//				System.out.println(imageList.length);
//				System.out.println(imageList[ae].toString());
				try {
					// 1. 이미지의 크기를 수정하기위해 불러온다
					BufferedImage bufferedImage =
							ImageIO.read(new File("myfiles/myimages/lostArk/"+ imageList[ae].toString()));
					// 2. 불러온 이미지로부터 사이즈 조절된 새로운 인스턴스를 받을 수 있다
					Image scaledImage =
							bufferedImage.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
					image1Label.setIcon(new ImageIcon(scaledImage));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				ae++;
				if( ae == imageList.length) {
					ae=0;
				}
			}
			
		});
		
		
		f.add(southBtn, "South");
	
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100,100,500,500);
		f.setVisible(true);
	}
}
