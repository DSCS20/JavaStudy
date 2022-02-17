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
	static int ay=0; //addyear
	static int am=0;
	static int ad=0;
	
	static int getyear=0;//추가or빼서 얻어올 연도
	static int getmonth=0;//추가or빼서 얻어올 월			
	static int getdays=0;//추가or빼서 얻어올 일
			
	static int week=0;//getdays가 7이상이면 1주로 바꾸기
	static int getalldays=0;//총 며칠인지 계산하기			
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
	static int lengthOfMon=LocalDate.now().lengthOfMonth();
	
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" yyyy년 MM월 dd일 ");
	static LocalDate toDateTime=LocalDate.now();
	static LocalDate fromDateTime=LocalDate.now();
	static LocalDate startDate=LocalDate.now();

	public static void FromToDate(LocalDate toDateTime, LocalDate fromDateTime) {
		
			Period period = Period.between(toDateTime, fromDateTime);
			
			//-1년이면 1년이라고 떠야하니까 음수면 양수로 바꾸기
			getyear=period.getYears();	getyear=getyear<0?-getyear:getyear;
			getmonth=period.getMonths();	getmonth=getmonth<0?-getmonth:getmonth;
			getdays=period.getDays();	getdays=getdays<0?-getdays:getdays;
			getalldays=(int)ChronoUnit.DAYS.between(toDateTime, fromDateTime); getalldays=getalldays<0?-getalldays:getalldays;
			
			if(getdays>=7) {
				week=getdays/7;
				getdays-=week*7;
			}
	}

	
	
	//날짜에 더하기 연산
	public static LocalDate AddDate(LocalDate date,int year,int month,int day) {
			
			date=date.plusYears(year); 
			date=date.plusMonths(month);
			date=date.plusDays(day); 
			GetDayOfWeek(date);
			
			return date;
	}
	//날짜에 빼기 연산
	public static  LocalDate MinusDate(LocalDate date,int year,int month,int day) {
		  date=date.minusYears(year);
		  date=date.minusMonths(month);
		  date=date.minusDays(day);
		  GetDayOfWeek(date);
		  return date;
	}

	
	//요일 구하기
	public static void GetDayOfWeek(LocalDate date) {
		DayOfWeek dayOfWeek =date.getDayOfWeek();
		getd=dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN); //TextStyle.Full 전체 길이 가져오기 토요일 O 토 x
	}
	//월별 총 일수 구하기
	public static void GetDayOfMonth(LocalDate date) {
		lengthOfMon = date.lengthOfMonth();
	}
	//java.time.DateTimeException 없애기
	public static void GetDayOfMonth(int month,LocalDate date) {
		int l=lengthOfMon; //원래 3월이어서 31일
		int bigwo=(date.withMonth(month)).lengthOfMonth(); //2월 클릭하면 28일이 끝이게 됨
	
		if(l>bigwo) {
			date=date.withDayOfMonth(bigwo);
		}
		lengthOfMon = date.lengthOfMonth();
	}
	public static void main(String[] args) {
	
			
		}	
	}

