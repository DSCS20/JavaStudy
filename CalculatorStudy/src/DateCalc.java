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

//java.util.Date > java.util.Calendar > java.time


public class DateCalc extends Calculator{
	
	static int getyear=0;
	static int getmonth=0;
	static int getdays=0;
	static int week=0;
	static long getalldays=0;
	static String getd ; //얻어올 요일
	
	
	DateCalc(){};

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
	
	
	// FromToDate(String,String) 
	public static void FromToDate(String todate,String fromdate) {
		try {
			
	        LocalDate toDateTime = LocalDate.parse(todate, formatter);
	        LocalDate fromDateTime = LocalDate.parse(fromdate, formatter);
	       
			Period period = Period.between(toDateTime, fromDateTime);
			
			
			getyear=period.getYears();	getyear=getyear<0?-getyear:getyear;
			getmonth=period.getMonths();	getmonth=getmonth<0?-getmonth:getmonth;
			getdays=period.getDays();	getdays=getdays<0?-getdays:getdays;
			 getalldays=ChronoUnit.DAYS.between(toDateTime, fromDateTime);
		
			 //실제 계산기에서 0이면 안나와서
			
			System.out.print(toDateTime+"와 "+fromDateTime+"의 차이 : ");
			if(getyear!=0)
				System.out.print(getyear+"년, ");
			if(getmonth!=0)
				System.out.print(getmonth+"월, ");
			if(getdays!=0) {
				if(getdays>=7) {
					week=getdays/7;
					getdays-=week*7;
					System.out.print(week+"주, ");
				}
				System.out.print(getdays+"일 ");
			}
			 System.out.println("(총 "+ getalldays+"일)");
			
		}catch (Exception e) {
			System.out.println("올바른 값을 입력해주세요 ex)2001년01월01일" );
		}
	}

	
	

	public static void AddDate(String date,long year,long month,long day) {
		try {
		
			LocalDate DateTime = LocalDate.parse(date, formatter);

			System.out.print(date+"에 "+year+"년 "+month+"월 "+day+"일 ");
			
			//if 추가하면
			DateTime=DateTime.plusYears(year); 
			DateTime=DateTime.plusMonths(month);
			DateTime=DateTime.plusDays(day);  
			
			System.out.print("추가 : "+DateTime); 
			
			// DayOfWeek 객체 생성
			DayOfWeek dayOfWeek =DateTime.getDayOfWeek();
			//TextStyle.Full 전체 길이 가져오기 토요일 O 토 x
			getd=dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN);

			System.out.println(" "+getd);
			
			
			//if 빼기버튼 누르면
           /*
              DateTime=DateTime.minusYears(year);
			  DateTime=DateTime.minusMonths(month);
			  DateTime=DateTime.minusDays(day);
			
			  System.out.println("빼기 : "+DateTime);
            */
			
		
		}catch(Exception e) {
			System.out.println("올바른 값을 입력하시오");
		}
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("비교할 날짜 2개를 입력하시오 날짜 ex) 2021년01월01일" );
		
		Scanner sc1 = new Scanner(System.in);
		String todate=sc1.next();	
		 String fromdate=sc1.next();			
		 DateCalc.FromToDate(todate,fromdate);
		 
		 System.out.println("----------------------------");
		 
		 System.out.println("날짜와 추가할 연,월,일을 입력하시오" );
		 
	     String date=sc1.next();
		 long year=sc1.nextLong();	
		 long month=sc1.nextLong();
		 long day=sc1.nextLong();
		 DateCalc.AddDate(date, year, month,day);
		 sc1.close();
		}
		
	}

