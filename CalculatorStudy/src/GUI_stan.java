import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI_stan extends JFrame {
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	static boolean first = true;
	
	Calc C = new StanCalc();
	
	public GUI_stan() {
		super("표준 계산기 GUI 만드는 중");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridBagLayout());
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		mainPanel mp = new mainPanel();
		addPanel(mp, 0, 0, 4, 2, 1, 0.1);
	
		
		ButtonPanel bp = new ButtonPanel();
		addPanel(bp, 0, 2, 4, 6, 1, 2);
		
		setSize(400, 600);
		setVisible(true);
		
	}
	
	public void addPanel(Component com, int x, int y, int width, int height, double weightx, double weighty) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		
		add(com, gbc);
	}
	

	public static void main(String[] args) {
		new GUI_stan();
		
	}

}
class mainPanel extends JPanel {
	
	static JLabel log;
	static JLabel current;
	
	public mainPanel() {
		setBackground(Color.gray);
		
		setLayout(new GridLayout(2,1));
		
		log = new JLabel("for logs");
		current = new JLabel("0");
		
		Font font1 = new Font("고딕", Font.PLAIN, 15);
		Font font2 = new Font("고딕", Font.PLAIN, 40);
		
		log.setFont(font1);
		log.setHorizontalAlignment(SwingConstants.RIGHT);
		log.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		log.setBounds(0, 0, 400, 100);
		
		
		current.setFont(font2);
		current.setHorizontalAlignment(SwingConstants.RIGHT);
		current.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		
		add(log);
		add(current);
		
	}
}
class ButtonPanel extends JPanel {
	public ButtonPanel() {
		JButton[] bt = new JButton[24];
		setLayout(new GridLayout(6,4,3,3));
		
		bt[0] = new JButton("%");
		bt[1] = new JButton("CE");
		bt[2] = new JButton("C");
		bt[3] = new JButton("<-");
		
		bt[4] = new JButton("1/x");
		bt[5] = new JButton("x^2");
		bt[6] = new JButton("2루트x");
		bt[7] = new JButton("/");
	
		bt[8] = new JButton("7");
		bt[9] = new JButton("8");
		bt[10] = new JButton("9");
		bt[11] = new JButton("x");
		
		bt[12] = new JButton("4");
		bt[13] = new JButton("5");
		bt[14] = new JButton("6");
		bt[15] = new JButton("-");
		
		bt[16] = new JButton("1");
		bt[17] = new JButton("2");
		bt[18] = new JButton("3");
		bt[19] = new JButton("+");
		
		bt[20] = new JButton("+/-");
		bt[21] = new JButton("0");
		bt[22] = new JButton(".");
		bt[23] = new JButton("=");
		
		for (int i=0; i<24; i++) {
			bt[i].setFont(new Font("맑은 고딕", 0, 30));
			bt[i].setBackground(Color.DARK_GRAY);
			bt[i].setForeground(Color.WHITE);
			add(bt[i]);
			
			if ((i>7 && i%4!=3 && i<20) || i==21) { //숫자패널이면~
				
				bt[i].addActionListener(new ActionListener() {
					String newtext;
					String oldtext;
					String text;
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					if (GUI_stan.first) {
						newtext = b.getText();
						GUI_stan.first = false;
					} else {
						oldtext = mainPanel.current.getText();
						text = b.getText();
						newtext = oldtext + text;
					}
						
					int n = newtext.length(); //숫자의 길이
					if (n < 16) mainPanel.current.setText(newtext); //15보다 작을때만 갱신해줌
					//나중에 포메터 클래스로 , 추가하기
					
					}
				});
			}
			
			
			
		}
		
	}
}

