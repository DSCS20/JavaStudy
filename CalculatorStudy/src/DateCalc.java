import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale; 
import java.time.temporal.ChronoUnit;



//java.util.Date > java.util.Calendar > java.time


public class DateCalc extends Calculator implements Dnum{
	
	DateCalc(){};
	
	//날짜 더하거나 뺄 때
	
		//더하거나 뺄 연 월 일
	static int ay=1; //addyear
	static int am=1;
	static int ad=1;
	
	static int getyear=0;//추가or빼서 얻어올 연도
	static int getmonth=0;//추가or빼서 얻어올 월			
	static int getdays=0;//추가or빼서 얻어올 일
			
	static int week=0;//getdays가 7이상이면 1주로 바꾸기
	static long getalldays=0;//총 며칠인지 계산하기			
	static String getd=" " ; //얻어올 요일s
			
		
		//날짜 차이 구할 때
			
			//날짜 차이 구할때 시작과 끝의 연 월 일 알아와야 계산 가능
	static int syear=1;
	static int smonth=1;	
	static int sday=1;

	static int eyear=1;
	static int emonth=1;
	static int eday=1;
		
	static int year=0;
	static int month=0;
	static int day=0;
	
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
	static LocalDate toDateTime=LocalDate.now();
	static LocalDate fromDateTime=LocalDate.now();

	public static void FromToDate(LocalDate toDateTime, LocalDate fromDateTime) {
		
			Period period = Period.between(toDateTime, fromDateTime);
			
			//-1년이면 1년이라고 떠야하니까 음수면 양수로 바꾸기
			getyear=period.getYears();	getyear=getyear<0?-getyear:getyear;
			getmonth=period.getMonths();	getmonth=getmonth<0?-getmonth:getmonth;
			getdays=period.getDays();	getdays=getdays<0?-getdays:getdays;
			getalldays=ChronoUnit.DAYS.between(toDateTime, fromDateTime);
		
			 //실제 계산기에서 0이면 안나와서 //gui 이벤트쪽으로 옮기기해야할듯..?
			System.out.print(toDateTime+"와 "+fromDateTime+"의 차이 : ");
			if(getyear!=0)
				System.out.print(getyear+"년, "); //print가 아니라 라벨로 바꿔서 해야함 나중에 이벤트 처리..?
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
	}

	
	
//public static void AddDate(String date,long year,long month,long day)
	public static void AddDate(LocalDate date,int year,int month,int day) {
		
			date=date.plusYears(year); 
			date=date.plusMonths(month);
			date=date.plusDays(day); 
	}
	
	public static void MinusDate(LocalDate date,int year,int month,int day) {
		  date=date.minusYears(year);
		  date=date.minusMonths(month);
		  date=date.minusDays(day);
	}
	
	//요일 구하기
	public static void GetDayOfWeek(LocalDate date) {
		DayOfWeek dayOfWeek =date.getDayOfWeek();
		getd=dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN); //TextStyle.Full 전체 길이 가져오기 토요일 O 토 x
	}
	
	
	public static void main(String[] args) {
	
			
		}	
	}

