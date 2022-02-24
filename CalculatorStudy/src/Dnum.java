import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//삭제????????????
interface Dnum {
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
		static String getd="" ; //얻어올 요일s
		
	
	//날짜 차이 구할 때
		
		//날짜 차이 구할때 시작과 끝의 연 월 일 알아와야 계산 가능
		static int syear=1;
		static int smonth=1;
		static int sday=1;
		
		static int eyear=1;
		static int emonth=1;
		static int eday=1;
		
		//계산해서 알려줄 날짜의 연 월 일
		static int year=0;
		static int month=0;
		static int day=0;
		
	    static LocalDate d =null;
		
		static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
		
	
		public static void FromToDate(String todate,String fromdate) {}; //날짜 차이 구하기 
		public static void AddDate(LocalDate date,int year,int month,int day) {}; //날짜 더하기
		public static void MinusDate(LocalDate date,int year,int month,int day) {}; //날짜 빼기
		public static void makelocaldate(int year,int month,int date) {};//연 월 일 정수를 입력받아서 LocalDate로 만듦
		public static void GetDayOfWeek(LocalDate date) {};//요일 구하기
}
