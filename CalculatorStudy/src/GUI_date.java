import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.time.LocalDate;
import java.awt.Color;
import java.awt.Font;

//https://codesandbox.io/s/vue2-wijmo-forked-wk50t?file=/src/components/HelloWorld.vue:378-391

public class GUI_date extends DateCalc {
	
	//월마다 일수가 다르니까 그거에 따라서 바꾸는 함수 -> 31일인 달 or 30일 or 28일 or 29일
	public static void ChangeDay(LocalDate date,DefaultComboBoxModel<Integer> model) {
		int l=lengthOfMon;
		GetDayOfMonth(date);
		int ex=lengthOfMon-l;
		if(ex>0) { //2월이어서 l이 28일이고 현재 선택한 월의 일수가 31일이면 29 30 31을 추가해야함
			for(int i=0;i<ex;i++) {
				model.addElement(++l);
			}
		}
		else if(ex<0) {
			for(int i=0;i>ex;i--)
				model.removeElement(l--);
		}
	}
	//날짜 차이를 알려주는 Label을 바꿔줌 
	public static void ChangeLabel(JLabel get1,JLabel gylb,JLabel gmlb, JLabel gwlb,JLabel gdlb,JLabel gadlb) {
		
		int xdistance=35;
		
		if(toDateTime.isEqual(fromDateTime)==true)
			get1.setVisible(true);
	
			if(getyear==0) 
				gylb.setVisible(false);
			else {
				get1.setVisible(false);
				 gylb.setText(getyear+"년,");
				 gylb.setBounds(xdistance-10,264,60,20);
				 gylb.setVisible(true);
				 xdistance+=60;
			}
			if(getmonth==0)
				gmlb.setVisible(false);
			else {
				get1.setVisible(false);
				gmlb.setText(getmonth+"월,");
				gmlb.setBounds(xdistance,264,60,20);
				gmlb.setVisible(true);
				xdistance+=60;
			}
			
			if(week==0) 
				gwlb.setVisible(false);
			else {
				get1.setVisible(false);
				 gwlb.setText(week+"주,");
				 gwlb.setBounds(xdistance,264,60,20);
				 gwlb.setVisible(true);
				 xdistance+=50;
			}
			
			if(getdays==0) 
				gdlb.setVisible(false);
			else {
				get1.setVisible(false);
				gdlb.setText(getdays+"일,");
				gdlb.setBounds(xdistance,264,60,20);
				gdlb.setVisible(true);
				xdistance+=50;
			}
			if(getalldays==0)
				gadlb.setVisible(false);
			else {
				get1.setVisible(false);
				gadlb.setText("총 "+getalldays+"일");
				gadlb.setBounds(xdistance,264,150,20);
				gadlb.setVisible(true);
			}
	}
	
	//날짜 더하거나 빼고나서 바뀐 결과 나오게 하는 함수
	public static void ChangeLabel2(JLabel get,JRadioButton radio[]) {
		if(radio[0].isSelected()){
            get.setText((AddDate(startDate,ay,am,ad)).format(formatter)+getd);
        }
		else {
			get.setText(MinusDate(startDate,ay,am,ad).format(formatter)+getd);
		}
	}
		
	public static void main(String[] args) {
		
		JFrame f=new JFrame("날짜 계산기");
		
		Panel p=new Panel();
		Panel p2=new Panel();
		
		Font font = new Font("고딕", Font.BOLD, 13);
		Font font2 = new Font("고딕", Font.BOLD, 20);
		
		String menu[]= {" 날짜 간 차이"," 일 합산 또는 빼기"};
		
		JComboBox<String> combo;
		combo=new JComboBox<String>(menu);
		p.add(combo).setBounds(20,50,130,30);
		combo.setFont(font);
		
		JComboBox<String> combo2;
		combo2=new JComboBox<String>(menu);
		p2.add(combo2).setBounds(20,50,130,30);
		combo.setFont(font);
		
		JLabel l1=new JLabel("시작일");
		l1.setFont(font);
		l1.setBounds(20,98,40,20); 
		p.add(l1);
		
		p.setLayout(null);
		p2.setLayout(null);
		
		
		JComboBox<Integer> yearCombo = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>(); 
		JLabel yLbl = new JLabel("년 "); 
		yLbl.setFont(font);
		
		JComboBox<Integer> monthCombo = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();
		JLabel mLbl = new JLabel("월"); 
		mLbl.setFont(font);
		
		
		JComboBox<Integer> dayCombo = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> dayModel = new DefaultComboBoxModel<Integer>();
		JLabel dLbl = new JLabel("일"); 
		dLbl.setFont(font);
		
		
		JComboBox<Integer> EyearCombo = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> EyearModel = new DefaultComboBoxModel<Integer>(); 
		JLabel EyLbl = new JLabel("년 "); 
		EyLbl.setFont(font);
		
		JComboBox<Integer> EmonthCombo = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> EmonthModel = new DefaultComboBoxModel<Integer>();
		JLabel EmLbl = new JLabel("월"); 
		EmLbl.setFont(font);
		
		JComboBox<Integer> EdayCombo = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> EdayModel = new DefaultComboBoxModel<Integer>();
		JLabel EdLbl = new JLabel("일"); 
		EdLbl.setFont(font);
		
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
		
		GetDayOfMonth(toDateTime);
		for(int i=1;i<=lengthOfMon ;i++)
			dayModel.addElement(i);
		
		GetDayOfMonth(fromDateTime);
		for(int i=1;i<=lengthOfMon ;i++)
			EdayModel.addElement(i);
		
		
		
		p.add(yearCombo).setBounds(20,126,60,30); yearCombo.setModel(yearModel); 
		yearCombo.setSelectedItem(syear); p.add(yLbl).setBounds(83,126,60,30); 
		
		
		p.add(monthCombo).setBounds(102,126,60,30); monthCombo.setModel(monthModel); 
		monthCombo.setSelectedItem(smonth); p.add(mLbl).setBounds(165,126,60,30); 
		

		p.add(dayCombo).setBounds(184,126,60,30); dayCombo.setModel(dayModel); 
		dayCombo.setSelectedItem(sday); p.add(dLbl).setBounds(247,126,60,30); 
		

		JLabel l2=new JLabel("종료일");
		l2.setFont(font);
		p.add(l2).setBounds(20,167,40,20);
		
		p.add(EyearCombo).setBounds(20,195,60,30); EyearCombo.setModel(EyearModel); 
		EyearCombo.setSelectedItem(eyear); p.add(EyLbl).setBounds(83,195,60,30); 
		EyearCombo.setFont(font);
		
		p.add(EmonthCombo).setBounds(102,195,60,30); EmonthCombo.setModel(EmonthModel); 
		EmonthCombo.setSelectedItem(emonth); p.add(EmLbl).setBounds(165,195,60,30); 
		EmonthCombo.setFont(font);
		
		p.add(EdayCombo).setBounds(184,195,60,30); EdayCombo.setModel(EdayModel); 
		EdayCombo.setSelectedItem(eday); p.add(EdLbl).setBounds(247,195,60,30); 
		EdayCombo.setFont(font);

		
		JLabel get1=new JLabel("동일한 날짜");
		get1.setFont(font2);
		p.add(get1).setBounds(20,264,190,20);
		
		JLabel dif=new JLabel("차이");
		dif.setFont(font);
		p.add(dif).setBounds(20,236,60,30);
		
		JLabel gylb=new JLabel();
		gylb.setFont(font2);
		p.add(gylb);
		
		JLabel gmlb=new JLabel();
		gmlb.setFont(font2);
		 p.add(gmlb);
	
		JLabel gwlb=new JLabel();
		gwlb.setFont(font2);
		 p.add(gwlb);
		 
		JLabel gdlb=new JLabel();
		gdlb.setFont(font2);
		 p.add(gdlb);
		 
		JLabel gadlb=new JLabel();
		gadlb.setFont(font2);
		 p.add(gadlb);
		
		 yearCombo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					
					int y= (int) e.getItem();
					toDateTime=toDateTime.withYear(y);
					DateCalc.FromToDate(toDateTime,fromDateTime);
					
					ChangeDay(toDateTime,dayModel);
					
					ChangeLabel(get1, gylb, gmlb,gwlb, gdlb, gadlb);
	
				}
			});
			
			monthCombo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					int m= (int) e.getItem();
					toDateTime=toDateTime.withMonth(m);
					DateCalc.FromToDate(toDateTime,fromDateTime);
					
					ChangeDay(toDateTime,dayModel);
					
					ChangeLabel(get1, gylb, gmlb,gwlb, gdlb, gadlb);
					
				}
			});

			
			dayCombo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					int d= (int) e.getItem();
					GetDayOfMonth(toDateTime);
					
					if(d>lengthOfMon) //2월이 28일일인데 31이 클릭돼있으면 오류가 나므로 31을 28로 바꾼다
						d=lengthOfMon;
					
					toDateTime=toDateTime.withDayOfMonth(d);
					DateCalc.FromToDate(toDateTime,fromDateTime);
					
					ChangeLabel(get1, gylb, gmlb,gwlb, gdlb, gadlb);
					
					ChangeDay(toDateTime,dayModel);
				}
			});

		 
		 EyearCombo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					int y= (int) e.getItem();
					fromDateTime=fromDateTime.withYear(y);
					DateCalc.FromToDate(toDateTime,fromDateTime);
				
					ChangeLabel(get1, gylb, gmlb,gwlb, gdlb, gadlb);
						
					ChangeDay(fromDateTime,EdayModel);
						
				}
			});
			
			EmonthCombo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					int m= (int) e.getItem();
					fromDateTime=fromDateTime.withMonth(m);	
					DateCalc.FromToDate(toDateTime,fromDateTime);
					
					ChangeLabel(get1, gylb, gmlb,gwlb, gdlb, gadlb);
						
					ChangeDay(fromDateTime,EdayModel);
				}
			});

			
			EdayCombo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					int d= (int) e.getItem();
					GetDayOfMonth(fromDateTime);
					
					if(d>lengthOfMon) //2월이 28일일인데 31이 클릭돼있으면 오류가 나므로 31을 28로 바꾼다
						d=lengthOfMon;
					
					fromDateTime=fromDateTime.withDayOfMonth(d);
					DateCalc.FromToDate(toDateTime,fromDateTime);
		
					ChangeLabel(get1, gylb, gmlb,gwlb, gdlb, gadlb);
						
					ChangeDay(fromDateTime,EdayModel);
				}
			});
			
		
		
		f.add(p);
		
		
		//p2 구성
		
		
		
		
		JLabel p2start=new JLabel("시작일");
		p2start.setFont(font);
		p2start.setBounds(20,98,40,20);
		p2.add(p2start);	
		
		JComboBox<Integer> yearCombo2 = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> yearModel2 = new DefaultComboBoxModel<Integer>(); 
		JLabel yLbl2 = new JLabel("년 ");  
		yLbl2.setFont(font);
		
		JComboBox<Integer> monthCombo2 = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> monthModel2 = new DefaultComboBoxModel<Integer>();
		JLabel mLbl2 = new JLabel("월"); 
		mLbl2.setFont(font);
		
		JComboBox<Integer> dayCombo2 = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> dayModel2 = new DefaultComboBoxModel<Integer>();
		JLabel dLbl2 = new JLabel("일"); 
		dLbl2.setFont(font);
		
		for(int i=(int) (year-150); i<=year+150; i++)
			yearModel2.addElement(i);
		
		for(int i=1; i<=12; i++) 
			monthModel2.addElement(i); 
		
		GetDayOfMonth(startDate);
		for(int i=1; i<=lengthOfMon; i++) 
		    dayModel2.addElement(i);
		
		
		p2.add(yearCombo2).setBounds(20,126,60,30); yearCombo2.setModel(yearModel2); 
		yearCombo2.setSelectedItem(year); p2.add(yLbl2).setBounds(83,126,60,30); 
		
		p2.add(monthCombo2).setBounds(102,126,60,30); monthCombo2.setModel(monthModel2); 
		monthCombo2.setSelectedItem(month); p2.add(mLbl2).setBounds(165,126,60,30); 
		
		p2.add(dayCombo2).setBounds(184,126,60,30); dayCombo2.setModel(dayModel2); 
		dayCombo2.setSelectedItem(day); p2.add(dLbl2).setBounds(247,126,60,30); 
		
		
		
		JComboBox<Integer> yearCombo3 = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> yearModel3 = new DefaultComboBoxModel<Integer>(); 
		yearCombo3.setFont(font);
		
		JComboBox<Integer> monthCombo3 = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> monthModel3 = new DefaultComboBoxModel<Integer>();
		monthCombo3.setFont(font);
		
		JComboBox<Integer> dayCombo3 = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> dayModel3 = new DefaultComboBoxModel<Integer>();
		dayCombo3.setFont(font);
		
		for(int ie=0;ie<1000;ie++) {
			yearModel3.addElement(ie);
			monthModel3.addElement(ie);
			dayModel3.addElement(ie);
		}
		

		p2.add(yearCombo3).setBounds(20,246,45,20); yearCombo3.setModel(yearModel3); 
		
		p2.add(monthCombo3).setBounds(80,246,45,20); monthCombo3.setModel(monthModel3); 
		
		p2.add(dayCombo3).setBounds(140,246,45,20); dayCombo3.setModel(dayModel3); 
		
	
		LocalDate nw=LocalDate.now();
		GetDayOfWeek(nw);
		JLabel get=new JLabel(nw.format(formatter)+getd);
		get.setFont(font2);
		p2.add(get).setBounds(20,307,270,30);
	
		
		
		
		JRadioButton radio[]=new JRadioButton[2];
		ButtonGroup group=new ButtonGroup();
		
		radio[0]=new JRadioButton("추가");
		p2.add(radio[0]).setBounds(20,182,60,20);
		radio[0].setBackground(Color.lightGray);
		radio[0].setFont(font);
		
		radio[1]=new JRadioButton("빼기");
		p2.add(radio[1]).setBounds(80,182,60,20);
		radio[1].setBackground(Color.lightGray);
		radio[1].setFont(font); 
		
		radio[0].setSelected(true);
		group.add(radio[0]);
		group.add(radio[1]);

		//시작일 선택하는 거 이벤트
				yearCombo2.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						int y= (int) e.getItem();
						  GetDayOfMonth(startDate);
						startDate=startDate.withYear(y);
						ChangeDay(startDate,dayModel2);
						ChangeLabel2(get,radio);
					}
				});
				
				monthCombo2.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						int m= (int) e.getItem();
						GetDayOfMonth(startDate);
						startDate=startDate.withMonth(m);
						ChangeDay(startDate,dayModel2);
						ChangeLabel2(get,radio);
					}
				});

				
				dayCombo2.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						int d= (int) e.getItem();
						GetDayOfMonth(startDate);
						
						if(d>lengthOfMon) 
							d=lengthOfMon;
						
						startDate=startDate.withDayOfMonth(d);
						ChangeLabel2(get,radio);
					}
				});
				
		
		
		//더하거나 뺄 꺼 선택할 때 이벤트
		yearCombo3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ay= (int) e.getItem();
				
				ChangeLabel2(get,radio);
				
			}
		});
		
		monthCombo3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				am= (int) e.getItem();
				
				ChangeLabel2(get,radio);
			}
		});

		
		dayCombo3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ad= (int) e.getItem();
				
				ChangeLabel2(get,radio);
			}
		});
		
		 
		
		//라디오 버튼 이벤트 - 빼기에서 추가로 바뀔 때 바로 빼져야 함
		radio[0].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				  get.setText((AddDate(startDate,ay,am,ad)).format(formatter)+getd);
			}
		});
		radio[1].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				 get.setText(MinusDate(startDate,ay,am,ad).format(formatter)+getd);
			}
		});
		
		
		JLabel yLbl3 = new JLabel("년 "); 
		yLbl3.setFont(font); 
		p2.add(yLbl3).setBounds(20,217,20,20);
		
		
		JLabel mLbl3 = new JLabel("월"); 
		mLbl3.setFont(font); 
		p2.add(mLbl3).setBounds(80,217,20,20);
		
		
		JLabel dLbl3 = new JLabel("일"); 
		dLbl3.setFont(font);
		p2.add(dLbl3).setBounds(140,217,20,20);
		
		
		JLabel nalza = new JLabel("날짜 "); 
		nalza.setFont(font); 
		p2.add(nalza).setBounds(20,287,40,20);
		
	
		
		f.add(p2);
		

			
		
		//날짜 차이 / 날짜 더하기 빼기 2개니까 패널 2개
		combo.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent e) { // 클릭했을때 
					if(combo.getSelectedItem()==" 날짜 간 차이") {
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
					if(combo2.getSelectedItem()==" 날짜 간 차이") {
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

		
		p.setSize(400,540);
		p2.setSize(400,540);
		
		f.getContentPane().setBackground(Color.lightGray);
		
		f.setSize(400,540);
		f.setVisible(true);
	
		
		((JFrame) f).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}
	}


