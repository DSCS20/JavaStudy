import java.math.*;
public class EnginCalcu extends Calc{
	
	double result=0;
	
	//펙토리얼, 실수 어떻게??
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
		
		//x^2
		void xexpo2(double inputx) {
			result=Math.pow(inputx, 2);
		}
		//x^3
		void xexpo3(double inputx) {
			result=Math.pow(inputx, 3);
		}
		
		//2제곱근
		void tworoot(double inputx) {
			result=Math.sqrt(inputx);
		}
		//3제곱근
		void threeroot(double inputx) {
			result=Math.cbrt(inputx);
		}
		
		//x^y 
		double xexpoy(double inputx,double inputy) {
			double result=Math.pow(inputx, inputy);
			return result;
		}
		//x 루트 y
		double xrooty(double inputx, double inputy) {
			result=Math.pow(inputx,1.0/inputy);
			return result;
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
		//2^x
		void twoexpox(double inputx) {
			result=Math.pow(2, inputx);
		}
		
		//log(밑이 10인 log)
		void log10(double input) {
			if(input<=0) {
				System.out.print("입력이 잘못되었습니다.");
			}
			System.out.print(Math.log10(input));
		}
		//logxy(밑이 x)
		double logxy(double inputx, double inputy) {
			result=Math.log(inputx) / Math.log(inputy);
			return result;
		}
		
				
		//ln(log밑이 e)
		void ln(double input) {
			if(input<=0) {
				System.out.print("입력이 잘못되었습니다.");
			}
			System.out.print(Math.log(input));
		}
		//e^x
		void eexpox(double inputx) {
			result=Math.pow(Math.E, inputx);
		}
		
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
