import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;


import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale; // ������ �ѱ���� ���Ҳ�
import java.time.temporal.ChronoUnit;
import java.awt.*;



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
			
			//계산해서 알려줄 날짜의 연 월 일
	static int year=0;
	static int month=0;
	static int day=0;
			
	
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
	static LocalDate d;
	

	public static void FromToDate(LocalDate toDateTime, LocalDate fromDateTime) {
		
			Period period = Period.between(toDateTime, fromDateTime);
			
			//-1년이면 1년이라고 떠야하니까 음수면 양수로 바꾸기
			getyear=period.getYears();	getyear=getyear<0?-getyear:getyear;
			getmonth=period.getMonths();	getmonth=getmonth<0?-getmonth:getmonth;
			getdays=period.getDays();	getdays=getdays<0?-getdays:getdays;
			getalldays=ChronoUnit.DAYS.between(toDateTime, fromDateTime);
		
			 //실제 계산기에서 0이면 안나와서
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
	
	//연 월 일 정수를 입력받아서 LocalDate로 만듦
	 static void makelocaldate(int ye,int mo,int da){
		 d=LocalDate.of( ye,mo,da );
		 }
	
	public static void main(String[] args) {
	
	
			JFrame f=new JFrame("날짜 계산기");
			
			JSpinner s=new JSpinner();
			
			Panel p=new Panel();
			Panel p2=new Panel();
			
			String menu[]= {"날짜 간 차이","일 합산 또는 빼기"};
			
			JComboBox<String> combo;
			combo=new JComboBox<String>(menu);
			p.add(combo).setBounds(20,10,100,30);
			
			JComboBox<String> combo2;
			combo2=new JComboBox<String>(menu);
			p2.add(combo2).setBounds(20,10,100,30);

			
			Label l1=new Label("시작일");
			l1.setBounds(20,82,40,20);
			p.add(l1);
			
			p.setLayout(null);
			p2.setLayout(null);
			
			
			JComboBox<Integer> yearCombo = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>(); 
			JLabel yLbl = new JLabel("년 "); 
			
			JComboBox<Integer> monthCombo = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();
			JLabel mLbl = new JLabel("월"); 
			
			JComboBox<Integer> dayCombo = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> dayModel = new DefaultComboBoxModel<Integer>();
			JLabel dLbl = new JLabel("일"); 
			
			
			
			JComboBox<Integer> EyearCombo = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> EyearModel = new DefaultComboBoxModel<Integer>(); 
			JLabel EyLbl = new JLabel("년 "); 
			
			JComboBox<Integer> EmonthCombo = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> EmonthModel = new DefaultComboBoxModel<Integer>();
			JLabel EmLbl = new JLabel("월"); 
			
			JComboBox<Integer> EdayCombo = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> EdayModel = new DefaultComboBoxModel<Integer>();
			JLabel EdLbl = new JLabel("일"); 
			
			LocalDate now = LocalDate.now();
			
			int syear =now.getYear(); 	int eyear =now.getYear(); int year =now.getYear();
			int smonth=now.getMonthValue(); int emonth=now.getMonthValue();  int month=now.getMonthValue();
			int sday=now.getDayOfMonth(); int eday=now.getDayOfMonth(); int day=now.getDayOfMonth();
			
			for(int i=(int) (syear-150); i<=syear+150; i++)
				{yearModel.addElement(i);
				EyearModel.addElement(i);
				}
			for(int i=1; i<=12; i++) 
				{ monthModel.addElement(i); 
				EmonthModel.addElement(i);}
			for(int i=1; i<=31; i++) 
			{ dayModel.addElement(i);
			EdayModel.addElement(i);}
			
			
			p.add(yearCombo).setBounds(80,78,60,30); yearCombo.setModel(yearModel); 
			yearCombo.setSelectedItem(syear); p.add(yLbl).setBounds(142,78,60,30); 
			
			p.add(monthCombo).setBounds(162,78,60,30); monthCombo.setModel(monthModel); 
			monthCombo.setSelectedItem(smonth); p.add(mLbl).setBounds(224,78,60,30); 
			
			p.add(dayCombo).setBounds(244,78,60,30); dayCombo.setModel(dayModel); 
			dayCombo.setSelectedItem(sday); p.add(dLbl).setBounds(306,78,60,30); 
			
			
			Label l2=new Label("종료일");
			p.add(l2).setBounds(20,124,40,20);
			
			p.add(EyearCombo).setBounds(80,120,60,30); EyearCombo.setModel(EyearModel); 
			EyearCombo.setSelectedItem(eyear); p.add(EyLbl).setBounds(142,120,60,30); 
			
			p.add(EmonthCombo).setBounds(162,120,60,30); EmonthCombo.setModel(EmonthModel); 
			EmonthCombo.setSelectedItem(emonth); p.add(EmLbl).setBounds(224,120,60,30); 
			
			p.add(EdayCombo).setBounds(244,120,60,30); EdayCombo.setModel(EdayModel); 
			EdayCombo.setSelectedItem(eday); p.add(EdLbl).setBounds(306,120,60,30); 
			
			Label l3=new Label("차이");
			p.add(l3).setBounds(20,166,40,20);
			
			//나중에 다시 - 이벤트 처리해야 - 걍 위치만 
			//FromtoDate 함수 사용하면 getyear getmonth getdays 바뀜
			JLabel get1=new JLabel(getyear+"년 "+getmonth+"월 "+getdays+"일");
			p.add(get1).setBounds(80,166,100,20);
			//
			
			f.add(p);
			
			
			//p2 구성
			
			
			Label p2start=new Label("시작일");
			p2start.setBounds(20,82,40,20);
			p2.add(p2start);	
			
			JComboBox<Integer> yearCombo2 = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> yearModel2 = new DefaultComboBoxModel<Integer>(); 
			JLabel yLbl2 = new JLabel("년 ");  
			
			JComboBox<Integer> monthCombo2 = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> monthModel2 = new DefaultComboBoxModel<Integer>();
			JLabel mLbl2 = new JLabel("월"); 
			
			JComboBox<Integer> dayCombo2 = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> dayModel2 = new DefaultComboBoxModel<Integer>();
			JLabel dLbl2 = new JLabel("일"); 
			
			
			for(int i=(int) (year-150); i<=year+150; i++)
				yearModel2.addElement(i);
			
			for(int i=1; i<=12; i++) 
				monthModel2.addElement(i); 

			for(int i=1; i<=31; i++) 
			    dayModel2.addElement(i);
		
			
			
			p2.add(yearCombo2).setBounds(80,78,60,30); yearCombo2.setModel(yearModel2); 
			yearCombo2.setSelectedItem(year); p2.add(yLbl2).setBounds(142,78,60,30); 
			
			p2.add(monthCombo2).setBounds(162,78,60,30); monthCombo2.setModel(monthModel2); 
			monthCombo2.setSelectedItem(month); p2.add(mLbl2).setBounds(224,78,60,30); 
			
			p2.add(dayCombo2).setBounds(244,78,60,30); dayCombo2.setModel(dayModel2); 
			dayCombo2.setSelectedItem(day); p2.add(dLbl2).setBounds(306,78,60,30); 
			
			
			JComboBox<Integer> yearCombo3 = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> yearModel3 = new DefaultComboBoxModel<Integer>(); 
			
			JComboBox<Integer> monthCombo3 = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> monthModel3 = new DefaultComboBoxModel<Integer>();
			
			JComboBox<Integer> dayCombo3 = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> dayModel3 = new DefaultComboBoxModel<Integer>();
			
			for(int i=0;i<1000;i++) {
				yearModel3.addElement(i);
				monthModel3.addElement(i);
				dayModel3.addElement(i);
			}
			
	
			p2.add(yearCombo3).setBounds(20,182,45,20); yearCombo3.setModel(yearModel3); 
			yearCombo3.setSelectedItem(ay);
			ay=(int) yearCombo3.getSelectedItem(); //	addyear Dnum으로?
			
		
			p2.add(monthCombo3).setBounds(80,182,45,20); monthCombo3.setModel(monthModel3); 
			monthCombo3.setSelectedItem(am); 
			am=(int) monthCombo3.getSelectedItem(); 
			
			
			p2.add(dayCombo3).setBounds(140,182,45,20); dayCombo3.setModel(dayModel3); 
			dayCombo3.setSelectedItem(ad);
			ad=(int) dayCombo3.getSelectedItem(); 
			
			JRadioButton radio[]=new JRadioButton[2];
			
			class MyItemListener implements ItemListener{
		        @Override
		        public void itemStateChanged(ItemEvent e) {
		            if(e.getStateChange()==ItemEvent.DESELECTED){
		                return;
		            }
		            if(radio[0].isSelected()&&!radio[1].isSelected()){
		                
		            }
		            else if(radio[1].isSelected()&&!radio[0].isSelected()){
		                
		            }
		          
		        }
			}
			
			radio[0]=new JRadioButton("추가");
			p2.add(radio[0]).setBounds(20,122,50,20);
			radio[0].addItemListener(new MyItemListener());

			
			radio[1]=new JRadioButton("빼기");
			p2.add(radio[1]).setBounds(80,122,50,20);
			radio[1].addItemListener(new MyItemListener());
			

			radio[0].setSelected(true);
			
			JLabel yLbl3 = new JLabel("년 "); 
			p2.add(yLbl3).setBounds(20,162,20,20);
			
			JLabel mLbl3 = new JLabel("월"); 
			p2.add(mLbl3).setBounds(80,162,20,20);
			
			JLabel dLbl3 = new JLabel("일"); 
			p2.add(dLbl3).setBounds(140,162,20,20);
			
			JLabel nalza = new JLabel("날짜 "); 
			p2.add(nalza).setBounds(20,222,40,20);
			
			
			//나중에 다시 - 이벤트 처리 - 걍 위치만 
			
			LocalDate dd=LocalDate.of( (int) yearCombo2.getSelectedItem(),(int) monthCombo2.getSelectedItem(),(int)dayCombo2.getSelectedItem());
			DateCalc.AddDate(dd,ay,am,ad);
			
			JLabel get=new JLabel(dd.format(DateTimeFormatter.ofPattern(" yyyy년 MM월 dd일 "))+getd+"요일");
			p2.add(get).setBounds(20,235,160,30);
			//
		
			
			f.add(p2);
			

				
			
			//날짜 차이 / 날짜 더하기 빼기 2개니까 패널 2개
			combo.addActionListener(new ActionListener() {
					@Override public void actionPerformed(ActionEvent e) { // 클릭했을때 
						if(combo.getSelectedItem()=="날짜 간 차이") {
							p.setVisible(true);
							p2.setVisible(false);//창이 안 보이게
						}
						else {
						p.setVisible(false);
						p2.setVisible(true);//창이 보이게
						}
					}
					});
				
				combo2.addActionListener(new ActionListener() {
					@Override public void actionPerformed(ActionEvent e) { // 클릭했을때 
						if(combo2.getSelectedItem()=="날짜 간 차이") {
							p.setVisible(true);
							p2.setVisible(false);//창이 안 보이게
						}
						else {
						p.setVisible(false);
						p2.setVisible(true);//창이 보이게
						}
					}
					});
			
				
			p.setVisible(true);
			p2.setVisible(false);

			
			p.setSize(390,340);
			p2.setSize(390,340);
			
			f.setSize(400,350);
			f.setVisible(true);
			
			((JFrame) f).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		
	}

