import java.util.*;

//한글확인//다시
public class ProgCalc extends Calc{
	String button="";
	String sign="";
	int result=0;
	int input,output=0;
	
	Pnum pm=new Pnum(button, input, button, button);
	
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
