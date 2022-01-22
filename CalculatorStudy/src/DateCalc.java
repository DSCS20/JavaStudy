import java.util.Scanner;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale; // ������ �ѱ���� ���Ҳ�
import java.time.temporal.ChronoUnit;

//https://sunghs.tistory.com/128 ����
//https://joswlv.github.io/2019/07/21/java8_date_function/ ����
//https://hianna.tistory.com/610 ����

//Java �ð� API �ô� �帧�� : java.util.Date > java.util.Calendar > java.time
// ���ο� API ���� : Calendar,Date�� ȥ���ؼ� ���X => �߸� �����ϰų� ȥ�� X

public class DateCalc extends Calculator{
	
	static int getyear=0;
	static int getmonth=0;
	static int getdays=0;
	static int week=0;
	static long getalldays=0;
	static String getd; //���� ����
	
	
	DateCalc(){};

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy��MM��dd��");
	
	
	//��¥ ���� ���ϴ� �Լ� FromToDate(String,String) ����
	public static void FromToDate(String todate,String fromdate) {
		try {
			
	        LocalDate toDateTime = LocalDate.parse(todate, formatter);
	        LocalDate fromDateTime = LocalDate.parse(fromdate, formatter);
	       
			Period period = Period.between(toDateTime, fromDateTime);
			
			/*Java8 date���� �Լ� 
			** �Ⱓ (TemporalAmount)**
			Period : �� ��¥ ������ [��,��,��]�� ǥ���Ǵ� �Ⱓ 
			(�ð��� �ٷ��� �ʴ� ���� LocalDate�� ����Ѵ�)

			Duration : �� �ð� ������ [��,��,��,��]�� ǥ���Ǵ� �Ⱓ 
			(Instant Ŭ������ ����ϰ�, seconds�� nanoseconds�� ���� ������ 
			[��,��,��,��]�� ��ȯ�� �ִ� �޼��带 ����)
			 */			
			
			getyear=period.getYears();	getyear=getyear<0?-getyear:getyear;
			getmonth=period.getMonths();	getmonth=getmonth<0?-getmonth:getmonth;
			getdays=period.getDays();	getdays=getdays<0?-getdays:getdays;
			 getalldays=ChronoUnit.DAYS.between(toDateTime, fromDateTime);
			//���� ���⿡�� 0�̸� �� ����
			
			System.out.print(toDateTime+"�� "+fromDateTime+"�� ���� : ");
			if(getyear!=0)
				System.out.print(getyear+"��, ");
			if(getmonth!=0)
				System.out.print(getmonth+"��, ");
			if(getdays!=0) {
				if(getdays>=7) {
					week=getdays/7;
					getdays-=week*7;
					System.out.print(week+"��, ");
				}
				System.out.print(getdays+"�� ");
			}
			 System.out.println("(�� "+ getalldays+"��)");
			
		}catch (Exception e) {
			System.out.println("�ùٸ� ���� �Է����ּ��� ����) 2021��01��01��" );
		}
	}

	
	
	//00�� 00�� 00�� (�߰�/����)
	public static void AddDate(String date,long year,long month,long day) {
		try {
		
			LocalDate DateTime = LocalDate.parse(date, formatter);

			System.out.print(date+"�� "+year+"�� "+month+"�� "+day+"�� ");
			
			//if �߰� ��ư�� ������
			DateTime=DateTime.plusYears(year); 
			DateTime=DateTime.plusMonths(month);
			DateTime=DateTime.plusDays(day);  
			
			System.out.print("�߰� : "+DateTime); //��ĥ��-���ϵ� ������ �ؾ���
			
			// DayOfWeek ��ü ���ϱ�
			DayOfWeek dayOfWeek =DateTime.getDayOfWeek();
			//TextStyle.Full�� ������ ��ü �ؽ�Ʈ ex) ����� o �� x
			getd=dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN);

			System.out.println(" "+getd);
			
			
			//if ���� ��ư�� ������
           /*
              DateTime=DateTime.minusYears(year);
			  DateTime=DateTime.minusMonths(month);
			  DateTime=DateTime.minusDays(day);
			
			  System.out.println("���� : "+DateTime);
            */
			
		
		}catch(Exception e) {
			System.out.println("�ùٸ� ���� �Է����ּ���");
		}
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("���� ��¥ 2���� �Է��Ͻÿ� ����) 2021��01��01��" );
		
		Scanner sc1 = new Scanner(System.in);
		String todate=sc1.next();	
		 String fromdate=sc1.next();			
		 DateCalc.FromToDate(todate,fromdate);
		 
		 System.out.println("----------------------------");
		 
		 System.out.println("��¥ 1���� �߰��� ��,��,���� �Է��Ͻÿ�" );
		 
	     String date=sc1.next();
		 long year=sc1.nextLong();	
		 long month=sc1.nextLong();
		 long day=sc1.nextLong();
		 DateCalc.AddDate(date, year, month,day);
		 sc1.close();
		}
		
	}

