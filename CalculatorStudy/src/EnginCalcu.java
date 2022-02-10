import java.math.*;
import java.util.*;
import java.util.Stack;

public class EnginCalcu extends Calc{
	
	NUM cur = new NUM();
	
	//펙토리얼, 재귀함수 안에 다른 클래스 생성자를 넣은??
		public double factorial() {
			if(!cur.isInt()) {
				System.out.println("정수값을 입력하세요.");
			}
			else {
				if(cur.i_num==0) {
					return 1;
				}
				else {
					return (cur.i_num)*factorial((cur.i_num)-1);
				}
			}
		}
		
		//괄호: stack사용. https://devheat.tistory.com/3 참고
		public void bracket(String str) {
			
		}
		
		//파이(3.14)
		public void pi() {
			System.out.print(Math.PI);
		}
		
		//e
		public void e() {
			System.out.print(Math.E);
		}
		
		//x^2
		public void xexpo2() {
			if(cur.isInt()) {
				int tmp=cur.i_num;
				cur.i_num=(int)Math.pow(cur.i_num, 2);
				cur.d_num=Math.pow(cur.i_num, 2);
			}else {
				double tmp=cur.d_num;
				cur.i_num=(int)Math.pow(cur.d_num, 2);
				cur.d_num=Math.pow(cur.d_num, 2);
			}
		}
		//x^3
		public void xexpo3() {
			if(cur.isInt()) {
				int tmp=cur.i_num;
				cur.i_num=(int)Math.pow(cur.i_num, 3);
				cur.d_num=Math.pow(cur.i_num, 3);
			}else {
				double tmp=cur.d_num;
				cur.i_num=(int)Math.pow(cur.d_num, 3);
				cur.d_num=Math.pow(cur.d_num, 3);
			}
		}
		
		//2제곱근
		public void tworoot(double inputx) {
			if(cur.isInt()) {
				int tmp=cur.i_num;
				cur.i_num=(int)Math.sqrt(tmp);
				cur.d_num=Math.sqrt(tmp);
			}else {
				double tmp=cur.d_num;
				cur.i_num=(int)Math.sqrt(tmp);
				cur.d_num=Math.sqrt(tmp);
			}
		}
		//3제곱근
		public void threeroot(double inputx) {
			if(cur.isInt()) {
				int tmp=cur.i_num;
				cur.i_num=(int)Math.cbrt(tmp);
				cur.d_num=Math.cbrt(tmp);
			}else {
				double tmp=cur.d_num;
				cur.i_num=(int)Math.cbrt(tmp);
				cur.d_num=Math.cbrt(tmp);
			}
		}
		
		//x^y 
		public double xexpoy(NUM y) {
			double tmp=cur.d_num;
			cur.d_num=Math.pow(tmp, y.d_num);
			return cur.d_num;
		}
		//x 루트 y
		public double xrooty(NUM y) {
			double tmp=cur.d_num;
			cur.d_num=Math.pow(y.i_num,tmp);
			return cur.d_num;
		}
		
		//10^x
		public void tenexpo(){  
			if(cur.isInt()) {
				int tmp=cur.i_num;
				cur.i_num=(int)Math.pow(10, tmp);
				cur.d_num=Math.pow(10, tmp);
			}
			else {
				double tmp=cur.d_num;
				cur.i_num=(int)Math.pow(10, tmp);
				cur.d_num=Math.pow(10, tmp);
			}
		}
		//2^x
		public void twoexpox() {
			if(cur.isInt()) {
				int tmp=cur.i_num;
				cur.i_num=(int)Math.pow(2, tmp);
				cur.d_num=Math.pow(2, tmp);
			}
			else {
				double tmp=cur.d_num;
				cur.i_num=(int)Math.pow(2, tmp);
				cur.d_num=Math.pow(2, tmp);
			}
		}
		
		//log(밑이 10인 log)
		public void log10() {
			double tmp=cur.d_num;
			if(tmp<=0) {
				System.out.println("입력이 잘못되었습니다.");
			}
			else {
				cur.d_num=Math.log10(tmp);
				cur.i_num=(int)Math.log10(tmp);
			}
		}
		//logxy(밑이 x)
		public double logxy(NUM y) {
			if(y.d_num<=0) {
				System.out.println("입력이 잘못되었습니다.");
			}else {
				double tmp=cur.d_num;
				cur.d_num=Math.log(tmp) / Math.log(y.d_num);
				cur.i_num=(int)cur.d_num;
				return cur.d_num;
			}
			return cur.d_num;
		}
		
				
		//ln(log밑이 e)
		public void ln() {
			if(cur.d_num<=0) {
				System.out.print("입력이 잘못되었습니다.");
			}else {
				double tmp=cur.d_num;
				cur.d_num=Math.log(tmp);
				cur.i_num=(int)Math.log(tmp);
			}
		}
		//e^x
		public void eexpox() {
			double tmp=cur.d_num;
			cur.d_num=Math.pow(Math.E, cur.d_num);
			cur.i_num=(int)Math.pow(Math.E, cur.d_num);
		}
		
		/*toRadians() : 각도 -> 라디안 : double b = Math.toRadians(a);
		toDegrees() : 라디안 -> 각도 : double a = Math.toDegrees(b);*/
		public void trifunc(int selec) {
			double tmp=cur.d_num;
			switch(selec) {
				case 0:
					cur.d_num=Math.sin(tmp);
				case 1:
					cur.d_num=Math.cos(tmp);
				case 2:
					cur.d_num=Math.tan(tmp);
				case 3:
					cur.d_num=Math.sin(tmp);
					cur.d_num=Math.pow(cur.d_num, -1);
				case 4:
					cur.d_num=Math.cos(tmp);
					cur.d_num=Math.pow(cur.d_num, -1);
				case 5:
					cur.d_num=Math.tan(tmp);
					cur.d_num=Math.pow(cur.d_num, -1);
				}
			}
	
		//2nd
		
	

}
