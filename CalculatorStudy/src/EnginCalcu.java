import java.math.*;
public class EnginCalcu extends Calc{
	
	//실수 어떻게??
		double factorial(double input) {
			int output;
			if(input==1) {
				return 1;
			}
			else {
				return input*factorial(input-1);
			}
		}
		
		//괄호???
		
		//파이(3.14)
		void pi() {
			System.out.print(Math.PI);
		}
		
		//e
		void e() {
			System.out.print(Math.E);
		}
		
		//ln(log밑이 e)
		double ln(double input) {
			if(input<=0) {
				System.out.print("입력이 잘못되었습니다.");
			}
			return Math.log(input);
		}
		
		//log(밑이 10인 log)
		double log10(double input) {
			if(input<=0) {
				System.out.print("입력이 잘못되었습니다.");
			}
			return Math.log10(input);
		}
		
		//10^x
		void tenexpo(double input){  
			if(input<0) {
				System.out.print("입력이 잘못되었습니다.");
			}
			else {
				double result=Math.pow(10, input);
				System.out.print(result);
			}
		}
		
		//x^y
		void xexpoy(double inputx,double inputy) {
			double result=Math.pow(inputx, inputy);
			System.out.print(result);
		}
		
		//
		/*toRadians() : 각도 -> 라디안 : double b = Math.toRadians(a);
		toDegrees() : 라디안 -> 각도 : double a = Math.toDegrees(b);*/
		void trifunc(int selec,double inputx) {
			double result;
			switch(selec) {
				case 0:
					result=Math.sin(inputx);
					System.out.print(result);
				case 1:
					result=Math.cos(inputx);
					System.out.print(result);
				case 2:
					result=Math.tan(inputx);
					System.out.print(result);
				case 3:
					result=Math.sin(inputx);
					result=Math.pow(result, -1);
					System.out.print(result);
				case 4:
					result=Math.cos(inputx);
					result=Math.pow(result, -1);
					System.out.print(result);
				case 5:
					result=Math.tan(inputx);
					result=Math.pow(result, -1);
					System.out.print(result);
				}
			}
	
		//2nd
		
	

}
