
public class StanCalc extends Calc{
	
	NUM cur = new NUM();
	
	public Double pers(Double num) { // %
		return num/100;
	}
	
	public void square() { //x^2
		if (cur.isInt()) { //정수이면
			int tmp = cur.i_num;
			cur.i_num = tmp*tmp;
			cur.d_num = (double)cur.i_num;
		} else { //실수이면
			double tmp = cur.d_num;
			cur.d_num = tmp*tmp;
			cur.i_num = (int)cur.d_num;
		}
	}
	
	public void inverse() { //x/1
		if (cur.isInt()) { //정수이면 
			if (cur.i_num != 1) { //1이 아닐 경우 (1이면 그대로)
				int tmp = cur.i_num;
				cur.d_num = 1/tmp;
				cur.i_num = (int)cur.i_num;
				cur.IorD = false; //실수가 되므로 실수처리해줌
			}
		} else {
			double tmp = cur.d_num;
			cur.d_num = 1/tmp;
			cur.i_num = (int)cur.d_num;
		}
	}
	
	public void sqrt() { //2루트x
		cur.d_num = Math.sqrt(cur.d_num); //실수를 통해 제곱근을 double로 반환
		cur.canInt();
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
		double result = 0;
		
		return result;
	}
	public double calculation(int op, double x, double y) { //두개 받는 경우
		double result = 0;
		
		return result;
	}
}