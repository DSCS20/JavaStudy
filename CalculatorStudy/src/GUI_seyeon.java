import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;

public class GUI_seyeon extends JFrame implements ActionListener{
	
	int MAX_LENGTH=20;
	
	int displayMode;
	
	boolean clear;
	
	private JLabel output; //숫자표시
	private JLabel str; //숫자위에
	private JButton btn[];
	private JPanel mainPanel,bitPanel,buttonPanel,calcPanel;

	String result="";  //null로 넣으면 오류
	String result1=""; //중간
	String result2=""; //현재화면
	String bun[]= {"","","",""};//0은 결과, 1은 중간, 2는 현재, 3은 진수변환값
	String tr="";//진수변환용
	int cnt=0;
	
	public GUI_seyeon() {
		setBackground(Color.gray);
		
		setTitle("프로그래머 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(400,600);
		setVisible(true);
		
		mainPanel=new JPanel();  //계산과정,결과
		bitPanel=new JPanel(); //16,10,8,2진수, AND OR NOT XOR
		buttonPanel=new JPanel(); //버튼
		calcPanel=new JPanel();
		
		mainPanel.setLayout(new GridLayout(2,1));
		
		str=new JLabel("",JLabel.RIGHT);
		output=new JLabel("0",JLabel.RIGHT);
		str.setBackground(Color.WHITE);
		output.setBackground(Color.WHITE);
		mainPanel.add(str);
		mainPanel.add(output);
		
		Font font1 = new Font("고딕", Font.PLAIN, 20);
		Font font2 = new Font("고딕", Font.PLAIN, 60);
		
		str.setFont(font1);
		str.setHorizontalAlignment(SwingConstants.RIGHT);
		str.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		
		output.setFont(font2);
		output.setHorizontalAlignment(SwingConstants.RIGHT);
		output.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		
		btn=new JButton[38];
		
		for(int i=0;i<10;i++) {
			btn[i]=new JButton(String.valueOf(i));
		}
		
		btn[10]=new JButton("A");
		btn[11]=new JButton("B");
		btn[12]=new JButton("C");
		btn[13]=new JButton("D");
		btn[14]=new JButton("E");
		btn[15]=new JButton("F");
		
		btn[16]=new JButton("+");
		btn[17]=new JButton("-");
		btn[18]=new JButton("*");
		btn[19]=new JButton("/");
		btn[20]=new JButton("%");
		btn[21]=new JButton("(");
		btn[22]=new JButton(")");
		
		btn[23]=new JButton("<<");
		btn[24]=new JButton(">>");
		btn[25]=new JButton("AND");
		btn[26]=new JButton("OR");
		btn[27]=new JButton("NOT");
		btn[28]=new JButton("XOR");
		btn[29]=new JButton("+/-");
		btn[30]=new JButton(".");
		
		btn[31]=new JButton("CE");
		btn[32]=new JButton("←");
		btn[33]=new JButton("=");
		
		btn[34]=new JButton("HEX");
		btn[35]=new JButton("DEC");
		btn[36]=new JButton("OCT");
		btn[37]=new JButton("BIN");
		
		bitPanel.setLayout(new GridLayout(2,4,2,2));
		
		for(int i=34;i<=37;i++) { //진수
			bitPanel.add(btn[i]);
		}
		
		for(int i=25;i<=28;i++) { //논리
			bitPanel.add(btn[i]);
		}
		
		buttonPanel.setLayout(new GridLayout(6,4,2,2));
		
		buttonPanel.add(btn[10]); //A
		buttonPanel.add(btn[23]); //<<
		buttonPanel.add(btn[24]); //>>
		buttonPanel.add(btn[31]); //C
		buttonPanel.add(btn[32]); //=
		
		buttonPanel.add(btn[11]); //B
		buttonPanel.add(btn[21]); //<<
		buttonPanel.add(btn[22]); //>>
		buttonPanel.add(btn[20]); //%
		buttonPanel.add(btn[19]); // /
		
		buttonPanel.add(btn[12]); //C
		for(int i=7;i<=9;i++) {  
			buttonPanel.add(btn[i]);  //7,8,9
		}
		buttonPanel.add(btn[18]); //*
		
		buttonPanel.add(btn[13]); //D
		for(int i=4;i<=6;i++) {
			buttonPanel.add(btn[i]); //4,5,6
		}
		buttonPanel.add(btn[17]); //-
		
		buttonPanel.add(btn[14]); //E
		for(int i=1;i<=3;i++) {
			buttonPanel.add(btn[i]); //1,2,3
		}
		buttonPanel.add(btn[16]);
		
		buttonPanel.add(btn[15]); //F
		buttonPanel.add(btn[29]); //+/-
		buttonPanel.add(btn[0]); //0
		buttonPanel.add(btn[30]); //.
		buttonPanel.add(btn[33]); //=
		
		for(int i=0;i<38;i++) {
			if((25<=i||i<=28)&&(34<=i||i<=37)) {
				btn[i].setFont(new Font("맑은 고딕", 0, 15));
			}else {
				btn[i].setFont(new Font("맑은 고딕", 0, 20));
			}
			btn[i].setBackground(Color.DARK_GRAY);
			btn[i].setForeground(Color.WHITE);
			
			btn[i].addActionListener(this);
		}

		calcPanel.setLayout(new BorderLayout());
		calcPanel.add(bitPanel,BorderLayout.NORTH);
		calcPanel.add(buttonPanel,BorderLayout.CENTER);
		
		getContentPane().add(mainPanel,BorderLayout.NORTH);
		getContentPane().add(calcPanel,BorderLayout.CENTER);
		
	}



	public static void main(String[] args) {
		new GUI_seyeon();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String data=e.getActionCommand();
		
		if(data.equals("1")||data.equals("2")||data.equals("3")||data.equals("4")||
				data.equals("5")||data.equals("6")||data.equals("7")||data.equals("8")||
				data.equals("9")) {
			result2+=data;
			output.setText(result2);
		}
		else if(data.equals("←")) {
			int len=output.getText().length();
			if(len==1)
			{
				result2="";
				output.setText("0");
			}
			else
			{
				if(!result2.equals(""))
				{
					result2=result2.substring(0,len-1);
					output.setText(result2);
				}
				
			}
		}
		else if(data.equals("CE"))
		{
			result="";
			result1="";
			result2="";
			str.setText("");
			output.setText("0");
			bun[0]="";
			bun[1]="";
			bun[2]="";
		}
		else if(data.equals("."))
		{
			if(result2.equals(""))
			{
				if(result2.indexOf(".")==-1)
				{
					result="0"+data;
				}
			}
			else 
			{
				if(result2.indexOf(".")==-1)
				{
					result+=data;
				}
			}
			output.setText(result2);
		}
		else if(data.equals("0"))
		{
			if(result2.equals("0"))
			{
				result="0";
			}
			else
			{
				result2+=data;
			}
			output.setText(result2);
		}
		else if(data.equals("*")||data.equals("/")||data.equals("+")||data.equals("-")||
				data.equals("AND")||data.equals("OR")||data.equals("NOT")||data.equals("XOR")||
				data.equals("%"))
		{
			if(result1.equals(""))
			{
				if(result2.equals(""))
				{
					if(result.equals(""))
					{
						result1="0"+data;
						bun[0]="0";
					}
					else
					{
						result1=result+data;
					}
				}
				else
				{
					if(!result.equals(""))
					{
						result1=result+data;
					}
					result1=result2+data;
					bun[0]=result2;
				}
				bun[1]=data;
			}
			else
			{
				if(result2.equals(""))
				{
					result1=result1.substring(0,result1.length()-1)+data;
					bun[1]=data;
				}
				else
				{
					if(cnt>=1)
					{
						if(data.equals("*")||data.equals("/")||data.equals("%"))
						{
							result2="1";
						}
						else
							result2="0";
					}
					result1+=result2+data;
					bun[2]=result2;
					result=Calc();
					bun[1]=data;
					output.setText(result);
					bun[0]=result;
				}
				cnt=0;
			}
			if(result.equals("0으로 나눌 수 없다"))
			{
				result1 = "";
				result2 = "";
				result = "";
				bun[0] = "";
				bun[1] = "";
				bun[2] = "";
			}
			result2="";
			str.setText(result1);
		}

		else if(data.equals("="))
		{
			cnt+=1;
			if(!result2.equals(""))
			{
				bun[2]=result2;
				str.setText("");
			}
			bun[0]=Calc();
			output.setText(bun[0]);
			if(bun[1].equals("/") && result2.equals("0"))
			{
				result1 = "";
				result2 = "";
				result = "";
				bun[0] = "";
				bun[1] = "";
				bun[2] = "";
				output.setText("0으로 나눌 수 없다");
			}
		}
		//else if
		
	}
	
	public String Calc() {
		String sum ="";
		BigDecimal big1 = new BigDecimal(bun[0]);
		BigDecimal big2 = new BigDecimal(bun[2]);
		Double dou=new Double(0);
		if(bun[1].equals("*"))
		{
			if(bun[0].indexOf(".") != -1 || bun[2].indexOf(".") != -1)
			{
				dou = big1.multiply(big2,MathContext.DECIMAL32).doubleValue();//바로 toString에 넣으면 뒤에 .0000이 잘리지 않는다.
				sum += dou.toString();
			}
			else
				sum += Integer.parseInt(bun[0]) * Integer.parseInt(bun[2]);
		}
		if(bun[1].equals("-"))
		{
			if(bun[0].indexOf(".") != -1 || bun[2].indexOf(".") != -1)
			{
				dou = big1.subtract(big2,MathContext.DECIMAL32).doubleValue();
				sum += dou.toString();
			}
			else
				sum += Integer.parseInt(bun[0]) - Integer.parseInt(bun[2]);
		}
		if(bun[1].equals("+"))
		{
			if(bun[0].indexOf(".") != -1 || bun[2].indexOf(".") != -1)
			{
				dou = big1.add(big2,MathContext.DECIMAL32).doubleValue();
				sum += dou.toString();
			}
			else
				sum += Integer.parseInt(bun[0]) + Integer.parseInt(bun[2]);
		}
		if(bun[1].equals("/"))
		{
			if(bun[0].indexOf(".") != -1 || bun[2].indexOf(".") != -1)
			{
				try
				{
					dou = big1.divide(big2,MathContext.DECIMAL32).doubleValue();
					sum += dou.toString();
				}
				catch (ArithmeticException e)
				{
					sum += "0으로 나눌 수 없다";
				}
				
			}
			else
			{
				try
				{
					sum += Integer.parseInt(bun[0]) / Integer.parseInt(bun[2]);
				}
				catch (ArithmeticException e)
				{
					sum += "0으로 나눌 수 없다";
				}
				
			}
		}
		if(bun[1].equals("%"))
		{
			if(bun[0].indexOf(".") != -1 || bun[2].indexOf(".") != -1)
			{
				try
				{
					dou = big1.divide(big2,MathContext.DECIMAL32).doubleValue();
					sum += dou.toString();
				}
				catch (ArithmeticException e)
				{
					sum += "0으로 나눌 수 없다";
				}
				
			}
			else
			{
				try
				{
					sum += Integer.parseInt(bun[0]) % Integer.parseInt(bun[2]);
				}
				catch (ArithmeticException e)
				{
					sum += "0으로 나눌 수 없다";
				}
				
			}
			
		}
		if(bun[1].equals("AND"))
		{
			if(bun[0].indexOf(".") != -1 || bun[2].indexOf(".") != -1)
			{
				dou = big1.add(big2,MathContext.DECIMAL32).doubleValue();
				sum += dou.toString();
			}
			else
				sum += Integer.parseInt(bun[0]) & Integer.parseInt(bun[2]);
		}
		if(bun[1].equals("OR"))
		{
			if(bun[0].indexOf(".") != -1 || bun[2].indexOf(".") != -1)
			{
				dou = big1.add(big2,MathContext.DECIMAL32).doubleValue();
				sum += dou.toString();
			}
			else
				sum += Integer.parseInt(bun[0]) | Integer.parseInt(bun[2]);
		}
		if(bun[1].equals("NOT"))//NOT은 다시
		{
			if(bun[0].indexOf(".") != -1)
			{
				dou = big1.add(big2,MathContext.DECIMAL32).doubleValue();
				sum += dou.toString();
			}
			else
				sum += ~Integer.parseInt(bun[0]);
		}
		if(bun[1].equals("AND"))
		{
			if(bun[0].indexOf(".") != -1 || bun[2].indexOf(".") != -1)
			{
				dou = big1.add(big2,MathContext.DECIMAL32).doubleValue();
				sum += dou.toString();
			}
			else
				sum += Integer.parseInt(bun[0]) ^ Integer.parseInt(bun[2]);
		}
		return sum;

	}
	
	public String Trans()
	{
		String result = "";
		return result;
	}
	
}	
