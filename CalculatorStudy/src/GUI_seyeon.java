import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI_seyeon extends JFrame implements ActionListener{
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	
	public GUI_seyeon() {
		setTitle("프로그래머 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new GridBagLayout());
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		 
		mainPanel MP=new mainPanel();  //계산과정,결과
		addPanel(MP, 0, 0, 4, 1, 1, 0.1);
		
		bitPanel BP=new bitPanel(); //진수
		addPanel(BP, 0, 1, 4, 2, 1, 0.5);
		
		CenterPanel CP=new CenterPanel();  //버튼
		addPanel(CP, 0, 3, 4, 4, 1, 2);
		
		setSize(400,600);
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
		new GUI_seyeon();
		
	}
	
	class MyActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) { //DEC클릭시 DEC,HEX,OCT,BIN순서로 바뀜
		JButton b=(JButton)e.getSource();
		
		if(b.getText().equals("DEC"))
			b.setText("HEX");
		else if(b.getText().equals("HEX"))
			b.setText("OCT");
		else if(b.getText().equals("OCT"))
			b.setText("BIN");
		else if(b.getText().equals("BIN"))
			b.setText("DEC");
		
		}
	}
}

	class mainPanel extends JPanel{
		
		JLabel log;
		JLabel cur;
		
		public mainPanel() {
		setBackground(Color.gray);
		
		setLayout(new GridLayout(2,1));
		
		log = new JLabel("for logs");
		cur = new JLabel("0");
		
		Font font1 = new Font("고딕", Font.PLAIN, 20);
		Font font2 = new Font("고딕", Font.PLAIN, 60);
		
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
	
	class bitPanel extends JPanel{
		JLabel hex,dec,oct,bin;
		
		public bitPanel() {
			
			setLayout(new GridLayout(4,1));
			
			hex=new JLabel("HEX=");
			dec=new JLabel("DEC=");
			oct=new JLabel("OCT=");
			bin=new JLabel("BIN=");
			
			Font font3=new Font("고딕",Font.PLAIN,10);
			
			hex.setFont(font3);
			hex.setHorizontalAlignment(SwingConstants.LEFT);
			hex.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
			
			dec.setFont(font3);
			dec.setHorizontalAlignment(SwingConstants.LEFT);
			dec.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
			
			oct.setFont(font3);
			oct.setHorizontalAlignment(SwingConstants.LEFT);
			oct.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
			
			bin.setFont(font3);
			bin.setHorizontalAlignment(SwingConstants.LEFT);
			bin.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
			
			add(hex);
			add(dec);
			add(oct);
			add(bin);
			
		}
	}
	class CenterPanel extends JPanel{
		public CenterPanel() {
			JButton[] btn=new JButton[35];
			setLayout(new GridLayout(7,4,3,3));  //동일크기
			btn[0]=new JButton("AND");
			btn[1]=new JButton("OR");
			btn[2]=new JButton("NOT");
			btn[3]=new JButton("XOR");
			btn[4]=new JButton("DEC");
			
			btn[5]=new JButton("A");
			btn[6]=new JButton("<<");
			btn[7]=new JButton(">>");
			btn[8]=new JButton("CE");
			btn[9]=new JButton("ex");
			
			btn[10]=new JButton("B");
			btn[11]=new JButton("(");
			btn[12]=new JButton(")");
			btn[13]=new JButton("%");
			btn[14]=new JButton("/");
			
			btn[15]=new JButton("C");
			btn[16]=new JButton("7");
			btn[17]=new JButton("8");
			btn[18]=new JButton("9");
			btn[19]=new JButton("*");
			
			btn[20]=new JButton("D");
			btn[21]=new JButton("4");
			btn[22]=new JButton("5");
			btn[23]=new JButton("6");
			btn[24]=new JButton("-");
		
			btn[25]=new JButton("E");
			btn[26]=new JButton("1");
			btn[27]=new JButton("2");
			btn[28]=new JButton("3");
			btn[29]=new JButton("+");
			
			btn[30]=new JButton("F");
			btn[31]=new JButton("+/-");
			btn[32]=new JButton("0");
			btn[33]=new JButton(".");
			btn[34]=new JButton("=");
			
			for(int i=0;i<35;i++) {
				add(btn[i]);
			
		}
	}

}