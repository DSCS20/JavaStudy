import java.math.*;
//내가 하다가 뭔갈 건드렸나봐 이 클래스 이상해져서 engincalcu로 새로 옮겼어!
public class EnginCalc extends Calc{
	
	//펙토리얼이 소수도 가능한데 이걸 어떻게..?
	double factorial(double input) {
		int output;
		if(input==1) {
			return 1;
		}
		else {
			return input*factorial(input-1);
		}
	}
	
	//괄호 ???
	
	//파이(ㅠ)
	void pi() {
		System.out.print(Math.PI);
	}
	
	//자연로그 e
	void e() {
		System.out.print(Math.E);
	}
	
	//ln(밑이 e인 log)
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
	
	//삼각함수들 switch문으로..?, deg or rad는 삼각함수 버튼 누르기 전에 누를 수 있으니 따로 구현
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
					result=Math.
			}
		}
		
	
	
	
}