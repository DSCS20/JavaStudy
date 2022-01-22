import java.util.Scanner;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale; // 요일을 한국어로 구할꺼
import java.time.temporal.ChronoUnit;

//https://sunghs.tistory.com/128 참고
//https://joswlv.github.io/2019/07/21/java8_date_function/ 참고
//https://hianna.tistory.com/610 참고

//Java 시간 API 시대 흐름순 : java.util.Date > java.util.Calendar > java.time
// 새로운 API 장점 : Calendar,Date를 혼용해서 사용X => 잘못 지정하거나 혼동 X

public class DateCalc extends Calculator{
	
	static int getyear=0;
	static int getmonth=0;
	static int getdays=0;
	static int week=0;
	static long getalldays=0;
	static String getd; //얻어올 요일
	
	
	DateCalc(){};

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
	
	
	//날짜 차이 구하는 함수 FromToDate(String,String) 생성
	public static void FromToDate(String todate,String fromdate) {
		try {
			
	        LocalDate toDateTime = LocalDate.parse(todate, formatter);
	        LocalDate fromDateTime = LocalDate.parse(fromdate, formatter);
	       
			Period period = Period.between(toDateTime, fromDateTime);
			
			/*Java8 date관련 함수 
			** 기간 (TemporalAmount)**
			Period : 두 날짜 사이의 [년,월,일]로 표현되는 기간 
			(시간을 다루지 않다 보니 LocalDate를 사용한다)

			Duration : 두 시간 사이의 [일,시,분,초]로 표현되는 기간 
			(Instant 클래스를 사용하고, seconds와 nanoseconds로 측정 되지만 
			[일,시,분,초]로 변환해 주는 메서드를 제공)
			 */			
			
			getyear=period.getYears();	getyear=getyear<0?-getyear:getyear;
			getmonth=period.getMonths();	getmonth=getmonth<0?-getmonth:getmonth;
			getdays=period.getDays();	getdays=getdays<0?-getdays:getdays;
			 getalldays=ChronoUnit.DAYS.between(toDateTime, fromDateTime);
			//실제 계산기에서 0이면 안 나옴
			
			System.out.print(toDateTime+"과 "+fromDateTime+"의 차이 : ");
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
			System.out.println("올바른 값을 입력해주세요 예시) 2021년01월01일" );
		}
	}

	
	
	//00년 00월 00일 (추가/빼기)
	public static void AddDate(String date,long year,long month,long day) {
		try {
		
			LocalDate DateTime = LocalDate.parse(date, formatter);

			System.out.print(date+"에 "+year+"년 "+month+"월 "+day+"일 ");
			
			//if 추가 버튼을 누르면
			DateTime=DateTime.plusYears(year); 
			DateTime=DateTime.plusMonths(month);
			DateTime=DateTime.plusDays(day);  
			
			System.out.print("추가 : "+DateTime); //고칠것-요일도 나오게 해야함
			
			// DayOfWeek 객체 구하기
			DayOfWeek dayOfWeek =DateTime.getDayOfWeek();
			//TextStyle.Full은 요일의 전체 텍스트 ex) 토요일 o 토 x
			getd=dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN);

			System.out.println(" "+getd);
			
			
			//if 빼기 버튼을 누르면
           /*
              DateTime=DateTime.minusYears(year);
			  DateTime=DateTime.minusMonths(month);
			  DateTime=DateTime.minusDays(day);
			
			  System.out.println("빼기 : "+DateTime);
            */
			
		
		}catch(Exception e) {
			System.out.println("올바른 값을 입력해주세요");
		}
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("비교할 날짜 2개를 입력하시오 예시) 2021년01월01일" );
		
		Scanner sc1 = new Scanner(System.in);
		String todate=sc1.next();	
		 String fromdate=sc1.next();			
		 DateCalc.FromToDate(todate,fromdate);
		 
		 System.out.println("----------------------------");
		 
		 System.out.println("날짜 1개와 추가할 연,월,일을 입력하시오" );
		 
	     String date=sc1.next();
		 long year=sc1.nextLong();	
		 long month=sc1.nextLong();
		 long day=sc1.nextLong();
		 DateCalc.AddDate(date, year, month,day);
		 sc1.close();
		}
		
	}

