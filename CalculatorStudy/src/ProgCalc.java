import java.util.Scanner;
//한글확인
public class ProgCalc extends Calc{

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String sign="";
		int num=0;
		num=s.nextInt();
		
		String HEX=Integer.toHexString(num);
		String OCT=Integer.toOctalString(num);
		String BIN=Integer.toBinaryString(num);
		
		if(sign.equals("DEC")) {
			System.out.println("HEX="+HEX);
			System.out.println("DEC="+num);
			System.out.println("OCT="+OCT);
			System.out.println("BIN="+BIN);
		}
		else if(sign.equals("HEX")) {
			
		}
		else if(sign.equals("OCT")) {
			
		}
		else if(sign.equals("BIN")) {
			
		}
		//
		
		String button="";
		
		int one=0;
		int two=0;
		int result=0;
		
		one=s.nextInt();
		button=s.next();
		two=s.nextInt();
		
		//산술
		switch(button) {
		case ">>":
			result=one>>two;
			break;
		case "<<":
			result=one<<two;
			break;
		case ">>>":
			result=one>>>two;
			break;
		}
		//원형
		
		//자리올림 순환

		//비트
		switch(button) {
		case "AND":
			result=one&two;
			break;
		case "OR":
			result=one|two;
			break;
		case "XOR":
			result=one^two;
			break;
		case "NOT":
			result=~one;
		}
		
	}

}
