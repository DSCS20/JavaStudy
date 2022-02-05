
public class NUM {
	//실수나 정수를 저장하는 클래스
	int i_num;
	double d_num;
	boolean IorD; //정수면 true, 실수면 false
	
	NUM() { //기본값. 정수 0
		this.i_num = 0;
		this.d_num = 0;
		this.IorD = true;
	}
	
	NUM(int num) { //정수 생성자.
		this.i_num = num;
		this.d_num = (double)num;
		this.IorD = true;
	}
	
	NUM(double num) { //정수 생성자.
		this.i_num = (int)num;
		this.d_num = num;
		this.IorD = false;
	}
	
	public boolean isInt() {
		return this.IorD; 
	}
	
	public boolean canInt() {
		double tmp = this.d_num;
		double a = (int)tmp;
		if(tmp-a == 0) {
			this.i_num = (int)tmp;
			return this.IorD = true;
		} else {
			return this.IorD = false;
		}
	}
	
	public String toString() {
		if (isInt()) {
			return String.format("%d", i_num);
		} else {
			return String.format("%lf", d_num);
		}
	}
}
