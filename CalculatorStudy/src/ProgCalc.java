import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//한글확인//다시
public class ProgCalc extends Calc{
	String button="";
	String sign="";
	int result=0;
	int input,output=0;
	
	Pnum pm=new Pnum(button, input, button, button);
	
	public ProgCalc() {
		setTitle("프로그래머 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new BorderLayout(5,5));
		c.setBackground(Color.BLACK);
		 
		NorthPanel NP=new NorthPanel();  //계산과정,결과
		c.add(NP,BorderLayout.EAST);
		
		CenterPanel CP=new CenterPanel();  //버튼
		c.add(CP,BorderLayout.SOUTH);
		
		setSize(500,600);
		setVisible(true);
	}
	
	class NorthPanel extends JPanel{
		public NorthPanel() {
			
		}
	}
	
	class CenterPanel extends JPanel{
		public CenterPanel() {
			JButton[] btn=new JButton[29];
			setBackground(Color.BLACK);
			setLayout(new GridLayout(4,4,5,5));  //동일크기
			
			btn[0]=new JButton("A");
			btn[1]=new JButton("<<");
			btn[2]=new JButton(">>");
			btn[3]=new JButton("CE");
			btn[4]=new JButton("ex");
			
			btn[5]=new JButton("B");
			btn[6]=new JButton("(");
			btn[7]=new JButton(")");
			btn[8]=new JButton("%");
			btn[9]=new JButton("/");
			
			btn[10]=new JButton("C");
			btn[11]=new JButton("7");
			btn[12]=new JButton("8");
			btn[13]=new JButton("9");
			btn[14]=new JButton("*");
			
			btn[15]=new JButton("D");
			btn[16]=new JButton("4");
			btn[17]=new JButton("5");
			btn[18]=new JButton("6");
			btn[19]=new JButton("-");
			
			btn[20]=new JButton("E");
			btn[21]=new JButton("1");
			btn[22]=new JButton("2");
			btn[23]=new JButton("3");
			btn[24]=new JButton("+");
			
			btn[25]=new JButton("F");
			btn[26]=new JButton("+/-");
			btn[27]=new JButton("0");
			btn[28]=new JButton("=");
			
		}
	}
	
	public void bit() { 
		if(sign.equals("DEC")) {
			String HEX=Integer.toHexString(input);
			String OCT=Integer.toOctalString(input);
			String BIN=Integer.toBinaryString(input);
			System.out.println("HEX="+HEX);
			System.out.println("DEC="+input);
			System.out.println("OCT="+OCT);
			System.out.println("BIN="+BIN);
		}
		else if(sign.equals("HEX")) {
			int DEC=Integer.parseInt("input",16);
			String OCT=Integer.toOctalString(DEC);
			String BIN=Integer.toBinaryString(DEC);
			System.out.println("HEX="+input);
			System.out.println("DEC="+DEC);
			System.out.println("OCT="+OCT);
			System.out.println("BIN="+BIN);
		}
		else if(sign.equals("OCT")) {
			int DEC=Integer.parseInt("input",8);
			String HEX=Integer.toOctalString(DEC);
			String BIN=Integer.toBinaryString(DEC);
			System.out.println("HEX="+HEX);
			System.out.println("DEC="+DEC);
			System.out.println("OCT="+input);
			System.out.println("BIN="+BIN);
		}
		else if(sign.equals("BIN")) {
			int DEC=Integer.parseInt("input",2);
			String HEX=Integer.toOctalString(DEC);
			String OCT=Integer.toBinaryString(DEC);
			System.out.println("HEX="+HEX);
			System.out.println("DEC="+DEC);
			System.out.println("OCT="+OCT);
			System.out.println("BIN="+input);
			
		}
	}
	
	
	public void shift() {
		switch(button) {
		case ">>":
			result=input>>output;
			System.out.println(result);
			break;
		case "<<":
			result=input<<output;
			System.out.println(result);
			break;
		case ">>>":
			result=input>>>output;
			System.out.println(result);
			break;
		}
	}
		//산술
		//원형
		
		//자리올림 순환

	public void bitshift() {
		switch(button) {
		case "AND":
			result=input&output;
			System.out.println(result);
			break;
		case "OR":
			result=input|output;
			System.out.println(result);
			break;
		case "XOR":
			result=input^output;
			System.out.println(result);
			break;
		case "NOT":
			result=~input;
			System.out.println(result);
		}
	}
		
}
