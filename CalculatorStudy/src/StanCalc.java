
public class StanCalc extends Calc{
	
	NUM cur = new NUM();
	
	public double pers(double num) { // %
		return num/100;
	}
	
	public double inverse(double num) { //x/1
		return 1/num;
	}
	
	public double square(double num) { //x^2
		return num*num;
	}
	
	public double sqrt(double num) { //2루트x
		return Math.sqrt(num);
	}
	
	
	
	public void add(NUM n) {
		if (cur.isInt()) {
			if(n.isInt()) {
				//둘 다 정수임
				cur.i_num += n.i_num;
				cur.d_num = (double)cur.i_num;
			} else {
				//정수에 실수를 더함 => 실수로
				cur.d_num += n.d_num;
				cur.i_num = (int)cur.d_num;
				cur.IorD = false;
			}
		} else {
			// 실수에 정수 또는 실수를 더함 => 실수 그대로
			cur.d_num += n.d_num;
			cur.i_num = (int)cur.d_num;
		}
	}
	
	public void sub(NUM n) {
		if (cur.isInt()) {
			if(n.isInt()) {
				//둘 다 정수임
				cur.i_num -= n.i_num;
				cur.d_num = (double)cur.i_num;
			} else {
				//정수에 실수를 뺌 => 실수로
				cur.d_num -= n.d_num;
				cur.i_num = (int)cur.d_num;
				cur.IorD = false;
			}
		} else {
			// 실수에 정수 또는 실수를 뺌 => 실수 그대로
			cur.d_num -= n.d_num;
			cur.i_num = (int)cur.d_num;
		}
	}
	
	public void mul(NUM n) {
		if (cur.isInt()) {
			if(n.isInt()) { // 정수 * 정수 인 경우
				cur.i_num *= n.i_num;
				cur.d_num = (double)cur.i_num;
			}
		} else { //그 외 (정수*실수, 실수*정수, 실수*실수)
			cur.d_num *= n.d_num;
			cur.i_num = (int)cur.d_num;
		}
	}
	
	public void div(NUM n) {
		if (cur.isInt()) {
			if(n.isInt()) { // 정수 * 정수 인 경우
				cur.i_num /= n.i_num;
				cur.d_num = (double)cur.i_num;
			}
		} else { //그 외 (정수*실수, 실수*정수, 실수*실수)
			cur.d_num /= n.d_num;
			cur.i_num = (int)cur.d_num;
		}
	}
	
	public double calculation(int op, double x) { //하나만 받는 경우
		double result; //받은 값을 result에 저장
		
		switch(op) {
			case 0: result = pers(x); break;
			case 1: result = inverse(x); break;
			case 2: result = square(x); break;
			case 3: result = sqrt(x); break;
			default: result = x; //오류방지
		}
		
		return result;
	}
	public double calculation(int op, double x, double y) { //두개 받는 경우
		double result = 0;
		
		return result;
	}
}