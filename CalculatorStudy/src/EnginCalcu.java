import java.math.*;
public class EnginCalcu extends Calc{
	
	//���丮���� �Ҽ��� �����ѵ� �̰� ���..?
		double factorial(double input) {
			int output;
			if(input==1) {
				return 1;
			}
			else {
				return input*factorial(input-1);
			}
		}
		
		//��ȣ ???
		
		//����(��)
		void pi() {
			System.out.print(Math.PI);
		}
		
		//�ڿ��α� e
		void e() {
			System.out.print(Math.E);
		}
		
		//ln(���� e�� log)
		double ln(double input) {
			if(input<=0) {
				System.out.print("�Է��� �߸��Ǿ����ϴ�.");
			}
			return Math.log(input);
		}
		
		//log(���� 10�� log)
		double log10(double input) {
			if(input<=0) {
				System.out.print("�Է��� �߸��Ǿ����ϴ�.");
			}
			return Math.log10(input);
		}
		
		//10^x
		void tenexpo(double input){  
			if(input<0) {
				System.out.print("�Է��� �߸��Ǿ����ϴ�.");
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
		
		//�ﰢ�Լ��� switch������..?, deg or rad�� �ﰢ�Լ� ��ư ������ ���� ���� �� ������ ���� ����
		/*toRadians() : ���� -> ���� : double b = Math.toRadians(a);
		toDegrees() : ���� -> ���� : double a = Math.toDegrees(b);*/
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
