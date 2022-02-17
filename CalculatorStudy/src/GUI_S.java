import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.text.*;

public class GUI_S extends JFrame implements ActionListener {

	GridBagLayout gb;
	GridBagConstraints gbc;
	DecimalFormat df= new DecimalFormat("#,##0.###############"); //출력 포맷
	StringBuffer sb = new StringBuffer(); //스트링버퍼
	StanCalc C = new StanCalc();
	
	boolean positive = true; //양수,음수 판별. 처음에는 양수가 기본
	boolean flag = false; //깃발. true일 경우 버퍼를 초기화(즉, 새로운 숫자로 받아들임)
	boolean inProcess = false; //계산이 진행중인지 표시. 진행중이면 "pre"값을 가지고 있는다
	boolean zero = false;
	double pre = 0;

	HashMap <String, Integer> op = setHashMap();
	
	JLabel log;
	JLabel current;
	
	public GUI_S() {
		super("표준 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridBagLayout());
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		//숫자와 로그를 보여주는 패널
		JPanel mainP = new JPanel();
		//mainP 배경
		mainP.setBackground(Color.LIGHT_GRAY);
		mainP.setLayout(new GridLayout(2,1));
		//log
		log = new JLabel("for logs");
		log.setFont(new Font("고딕", Font.PLAIN, 15));
		log.setHorizontalAlignment(SwingConstants.RIGHT);
		log.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		log.setBounds(0, 0, 400, 100);
		//current(현재 상태)
		current = new JLabel("0");
		current.setFont(new Font("고딕", Font.PLAIN, 40));
		current.setHorizontalAlignment(SwingConstants.RIGHT);
		current.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		
		//main패널에 추가
		mainP.add(log);
		mainP.add(current);
		
		//main패널을 추가
		addPanel(mainP, 0, 0, 4, 2, 1, 0.1);
		
		//버튼패널
		JPanel buttonP = new JPanel();
		buttonP.setLayout(new GridLayout(6,4,3,3));
		//버튼들
		JButton[] bt = new JButton[24];
		String[] btn = {"%", "CE", "C", "<-", "1/x", "x²", "²√x", "/", "7", "8", "9", "×",
						"4", "5", "6", "-", "1", "2", "3", "+", "±", "0", ".", "="};
		for (int i=0; i<24; i++) {
			bt[i] = new JButton(btn[i]); //이름 차례대로 넣기
			bt[i].setFont(new Font("고딕", 0, 30));
			bt[i].setBackground(Color.DARK_GRAY);
			bt[i].setForeground(Color.WHITE);
			bt[i].addActionListener(this); //액션리스너 추가
			buttonP.add(bt[i]); //버튼패널에 버튼 추가
		}
		//버튼패널을 추가
		addPanel(buttonP, 0, 2, 4, 6, 1, 2);
		
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

	
	public void actionPerformed(ActionEvent e) {
		try {
			//(1)숫자 버튼이 눌렸을 경우
			if(e.getActionCommand()=="1") { sb.append(1); }
			else if(e.getActionCommand()=="2") { sb.append(2); }
			else if(e.getActionCommand()=="3") { sb.append(3); }
			else if(e.getActionCommand()=="4") { sb.append(4); }
			else if(e.getActionCommand()=="5") { sb.append(5); }
			else if(e.getActionCommand()=="6") { sb.append(6); }
			else if(e.getActionCommand()=="7") { sb.append(7); }
			else if(e.getActionCommand()=="8") { sb.append(8); }
			else if(e.getActionCommand()=="9") { sb.append(9); }
			else if(e.getActionCommand()=="0") { //0은 특별하게 처리 ("000"이 저장되지 않도록)
				if (sb.length()<1) { }//첫 숫자가 0으로 눌린거면 넘어감
				else {
					sb.append(0); //그 외에는 추가함
					zero = true;
				}}
			else if(e.getActionCommand()=="±") { positive = !positive; } //양수는 음수로,, 음수는 양수로,,,
			else if(e.getActionCommand()==".") { if (sb.indexOf(".")==-1) sb.append("."); }
			//소수점이 이미 있으면 추가하지 않는다.
			
			/* ------------------------------------------------------------------------------------------*/
			
			//(2) 즉각적용되는 연산자가 눌린 경우
			else if(e.getActionCommand()=="%") { setLogI("%"); }
			else if(e.getActionCommand()=="1/x") { setLogI("1/x"); }
			else if(e.getActionCommand()=="x²") { setLogI("x²"); }
			else if(e.getActionCommand()=="²√x") { setLogI("²√x"); }
			
			/* ------------------------------------------------------------------------------------------*/
			
			//(3) =이 필요한 연산자가 눌린 경우
			else if(e.getActionCommand()=="/") { }
			else if(e.getActionCommand()=="×") { }
			else if(e.getActionCommand()=="-") { }
			else if(e.getActionCommand()=="+") { }
			
			/* ------------------------------------------------------------------------------------------*/
			
			//(4)제어자가 눌린 경우
			else if(e.getActionCommand()=="CE") { }
			else if(e.getActionCommand()=="C") { }
			else if(e.getActionCommand()=="<-") { sb.deleteCharAt(sb.length()-1); } //버퍼의 뒤에서부터 삭제
			else if(e.getActionCommand()=="=") { }
			//label에 적용하기
			setCur(sb);
			
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	public void clearBuffer() {
		sb.delete(0, sb.length());
	}
	
	public void setCur(StringBuffer sb) { //Current 갱신
		String a; String b;
		if(sb.length()>0) {
			//버퍼에 소수점이 있으면~
			if (sb.indexOf(".") != -1 ) {
				//소수점으로 끝나는 경우
				if(sb.indexOf(".") == sb.length()-1) {
					a = sb.substring(0, sb.indexOf("."));
					a = df.format(Integer.parseInt(a));
					a += ".";
					changeCur(a);
					
				}
				else {
					a = sb.substring(0, sb.indexOf("."));
					a = df.format(Integer.parseInt(a));
					b = sb.substring(sb.indexOf(".")+1, sb.length());
					a += ".";
					a += b;
					changeCur(a);
						
				}
			}
			//버퍼에 소수점이 없으면~
			else {
				a = sb.toString();
				a = df.format(Integer.parseInt(a));
				changeCur(a);
				
			}
		}
		//버퍼가 비어있다면
		else current.setText("0");
		
		if (flag) { //flag가 세워져 있다면 초기화하며 마무리
			clearBuffer();
			flag = !flag;
		}
	}
	
	public void changeCur(String str) { //받은 문자열을 라벨로 반환하는 메서드. 음수,양수확인 추가
		if (positive) {
			current.setText(str);
		} else {
			current.setText("-" + str);
		}
	}
	
	public void setLogI(String oper) throws ParseException { // 즉각적으로 적용되는 경우
		StringBuffer result = new StringBuffer();
		Number pre = df.parse(current.getText());
		System.out.println(pre + "," + oper);
		//1. current의 현재 숫자를 받아옴
		double cur = pre.doubleValue();
		//2. 연산자와 함께 StanCalc의 calculation => 결과받아옴
		cur = C.calculation(op.get(oper), cur);
		System.out.println(cur);
		//3. log에 표시
		changelog(op.get(oper), pre);
		//4. 계산결과를 current로 표시. 및 플래그 세우기
		sb.delete(0, sb.length());
		sb.append(cur);
		flag = true;
	}
	public String changelog(int op, Number pre) {
		String str = "";
		switch (op) {
		case 0: str = "%(" + pre + ")"; break;
		case 1: str = "1/(" + pre + ")"; break;
		case 2: str = "(" + pre + ")²"; break;
		case 3: str = "²√(" + pre + ")"; break;
		}
		log.setText(str);
		return str;
	}
	
	public HashMap setHashMap() {
		HashMap <String, Integer> tmp = new HashMap <String, Integer>();
		String[] oper = {"%", "1/x", "x²", "²√x", "/", "×", "-", "+", "=", "CE", "C", "<-"};
		for (int i=0; i<12; i++) {
			tmp.put(oper[i], i);
		}
		return tmp;
	}
	public static void main(String[] args) {
		new GUI_S();

	}
}
