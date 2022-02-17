import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class GUI_engin extends JFrame{
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	
	public GUI_engin() {
		
		super("계산기_공학용");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton[] bt = new JButton[33];
		setLayout(new GridLayout(7,5,3,3));
		
		bt[0]=new JButton("DEG");
		bt[1]=new JButton("삼각법");
		JPanel degtri=new JPanel();
		degtri.add(bt[0]);
		degtri.add(bt[1]);
		
		bt[2]=new JButton("2nd");
		bt[3]=new JButton("ㅠ");
		bt[4]=new JButton("e");
		bt[5]=new JButton("C");
		//CE버튼 추가하기
		bt[6]=new JButton("<-");
		
		bt[7]=new JButton("x^2");
		bt[8]=new JButton("(");
		bt[9]=new JButton(")");
		bt[10]=new JButton("n!");
		bt[11]=new JButton("/");
		
		bt[12]=new JButton("x root 2");
		bt[13]=new JButton("7");
		bt[14]=new JButton("8");
		bt[15]=new JButton("9");
		bt[16]=new JButton("*");
		
		bt[17]=new JButton("x^y");
		bt[18]=new JButton("4");
		bt[19]=new JButton("5");
		bt[20]=new JButton("6");
		bt[21]=new JButton("-");
		
		bt[22]=new JButton("x root 2");
		bt[23]=new JButton("1");
		bt[24]=new JButton("2");
		bt[25]=new JButton("3");
		bt[26]=new JButton("+");
		
		bt[27]=new JButton("log");
		bt[28]=new JButton("+/-");
		bt[29]=new JButton("0");
		bt[30]=new JButton(".");
		bt[31]=new JButton("=");
		
		bt[32]=new JButton("ln");
	
		for (int i=2; i<33; i++) {
			add(bt[i]);
		}
		
		Container c = getContentPane();
		c.setLayout(new GridBagLayout());
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		mainPanel_engin mpen = new mainPanel_engin();  //for logs, cur NUM 라벨 배치
		addPanel(mpen, 0, 0, 4, 2);
		
		
		
		pack();
		setLocation(400,500);
		setVisible(true);
		
		
	}
	
	public void addPanel(Component com, int x, int y, int width, int height) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = 1;
		gbc.weighty = 1;
		
		add(com, gbc);
	}
	

	public static void main(String[] args) {
		GUI_engin ex=new GUI_engin();
	}
}
	
	class mainPanel_engin extends JPanel{
		
		JLabel log;
		JLabel cur;
		
		public mainPanel_engin() {
			setBackground(Color.gray);
			
			setLayout(new GridLayout(2,1));
			
			log = new JLabel("for logs");
			cur = new JLabel("0");
			
			Font font1 = new Font("고딕", Font.PLAIN, 20);
			Font font2 = new Font("고딕", Font.PLAIN, 40);
			
			log.setFont(font1);
			log.setHorizontalAlignment(SwingConstants.RIGHT);
			log.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
			
			cur.setFont(font2);
			cur.setHorizontalAlignment(SwingConstants.RIGHT);
			cur.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
			
			add(log);
			add(cur);
			
		}
	}
	
		//2nd누르면 바뀌게, 근데 버튼을 어떻게 가져오지..? bt[7]=new JButton("x^3"); 이런식이 되어야 하는데
		/*public void actionPerformed(ActionEvent e) {
			ButtonPanel_engin buttonen=
			
			
			JButton b=(JButton)e.getSource();
			if(b.getText().equals("2nd")) {
				
			}
		}*/
		
