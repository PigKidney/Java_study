package gui.quiz.gugudan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

public class GugudanButtonActionListener implements ActionListener{
	final private int GUGUDAN_SIZE;
	
	List<JLabel> gugudanLabels;
	int dan = 2;
	
	JButton prevBtn;
	JButton nextBtn;
	
	public GugudanButtonActionListener(GugudanFrame mainFrame) {
		GUGUDAN_SIZE = mainFrame.GUGUDAN_SIZE;
		gugudanLabels = mainFrame.gugudanLabels;
		prevBtn = mainFrame.prevBtn;
		nextBtn = mainFrame.nextBtn;
//		dan = mainFrame.dan;
		
		prevBtn.setEnabled(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트를 구현하기 위해 필요한 재료 : JLabels 9개 , 현재 단
		
		if(e.getSource() == prevBtn) {
			--dan;
			if(dan == GUGUDAN_SIZE-1) {
				nextBtn.setEnabled(true);
			} else if (dan == 2) {
				prevBtn.setEnabled(false);
			}
//			System.out.println("prevBtn이 눌렸습니다");
		} else if(e.getSource() == nextBtn){
			++dan;
			if(dan == 3) {
				prevBtn.setEnabled(true);
			} else if (dan == GUGUDAN_SIZE) {
				nextBtn.setEnabled(false);
			}
//			System.out.println("nextBtn이 눌렸습니다");
		}
		
		for (int i = 0; i < gugudanLabels.size(); ++i) {
			JLabel gugudanLabel = gugudanLabels.get(i);
			int gop = i + 1;
			gugudanLabel.setText(String.format("%d x %d = %d", dan, gop, dan * gop));
		}
	}
}
