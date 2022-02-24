import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

//https://chaengstory.tistory.com/46
public class GUI_engin extends JFrame implements ActionListener{
	JLabel resultlabel;  //연산 결과창
	JLabel loglabel;
	boolean state=false;  //화면에 표시된 number 핸들러
	double num1, num2;
	double result;
	String func="";  //기능 연산자
	String lastput="";
	JButton[] button;
	int ndcnt=1;
	
	String btn[]= {"DEG","삼각법","CE","2nd","ㅠ","e","C","<-","x^2","(",")","n!","/","x root 2","7","8","9","*",
			"x^y","4","5","6","-","x root 2","1","2","3","+","log","+/-","0",".","=","ln"};
	
	public GUI_engin() {
		
		super("계산기_공학용");
		super.setResizable(true);  //프레임 크시를 사용자가 조절
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//연산결과창
		resultlabel=new JLabel("0",JLabel.RIGHT);  //처음 출력될 값, 위치
		JPanel mainView=new JPanel();
		resultlabel.setFont(new Font("Serif",Font.BOLD,40));  //폰트 지정
		resultlabel.setBackground(Color.WHITE);
		resultlabel.setOpaque(true);  //배경색 적용을 위해 불투명 설정
		
		//로그창
		loglabel=new JLabel("logs..",JLabel.RIGHT);  //처음 출력될 값, 위치
		loglabel.setFont(new Font("Serif",Font.BOLD,15));  //폰트 지정
		loglabel.setBackground(Color.WHITE);
		loglabel.setOpaque(true);  //배경색 적용을 위해 불투명 설정
		
		//버튼 창 gui
		JPanel btnView=new JPanel();
		btnView.setLayout(new GridLayout(7,5,2,2));   //row, col, 간격, 간격
		button = new JButton[btn.length]; 
		btnView.setBackground(Color.WHITE);
		btnView.setOpaque(true);
		
		 //DEG, 삼각법, CE 외 나머지 
		for(int i=3; i<btn.length; i++) {
			button[i]=new JButton(btn[i]);
			button[i].setFont(new Font("Serif",Font.BOLD,30));
			button[i].addActionListener(this);
			btnView.add(button[i]);
		}
		
		 //DEG, 삼각법, CE
		for(int i=0; i<3; i++) {   
			button[i]=new JButton(btn[i]);
			button[i].setFont(new Font("Serif",Font.BOLD,30));
			button[i].addActionListener(this);
		}
		JPanel degtri=new JPanel(); 
		degtri.add(button[0]);
		degtri.add(button[1]);
		degtri.add(button[2]);

		mainView.setLayout(new BorderLayout());  //동서남북 레이아웃 배치
		add(loglabel, BorderLayout.NORTH);  //로그창 배치
		add(resultlabel, BorderLayout.CENTER);  //연산결과창 배치
		//add(degtri);
		add(btnView, BorderLayout.SOUTH);
		
		setSize(400,600);
		setLocation(400,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		GUI_engin ex=new GUI_engin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String input=e.getActionCommand();
		
		if(input.equals("2nd")) {
			//2nd아래 버튼들 바뀌게 
			ndcnt++;
			if(ndcnt%2==0) {
				button[8].setText("x^2");
				button[13].setText("xroot2");
				button[18].setText("x^y");
				button[23].setText("10^x");
				button[28].setText("log");
				button[33].setText("ln");
			}else {
				button[8].setText("x^3");
				button[13].setText("xroot3");
				button[18].setText("xrooty");
				button[23].setText("2^x");
				button[28].setText("logyx");
				button[33].setText("e^x");
			}
		}else if(input.equals("<-")) {
			 setBackSpace(getBackSpace().substring(0, getBackSpace().length() - 1));
			 
			 if (getBackSpace().length() < 1) {  // 더 이상 지울 숫자가 없으면, 0으로 clear
		            lastput = "";
		            num2 = 0;
		            num1 = 0;
		            resultlabel.setText("0");
		        }
			 
		}else if(input.equals("=")) {
			
		}else { //?????
			if(state) {
				resultlabel.setText("0");
				state=false;
				num1=0;
				num2=0;
				lastput="";
			}
			
			lastput += e.getActionCommand();
			resultlabel.setText(lastput);
			num2=Double.parseDouble(lastput);
		}
		
		
		
	}

	private void setBackSpace(String bs) {
		resultlabel.setText(bs);
	}

	private String getBackSpace() {
		return resultlabel.getText();
	}
}
	
	
		//2nd누르면 바뀌게, 근데 버튼을 어떻게 가져오지..? bt[7]=new JButton("x^3"); 이런식이 되어야 하는데
		/*public void actionPerformed(ActionEvent e) {
			ButtonPanel_engin buttonen=
			
			
			JButton b=(JButton)e.getSource();
			if(b.getText().equals("2nd")) {
				
			}
		}*/
		
