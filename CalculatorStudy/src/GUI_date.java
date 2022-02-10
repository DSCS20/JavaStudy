import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.time.LocalDate;


public class GUI_date extends DateCalc {
			
	public static void main(String[] args) {

		
		JFrame f=new JFrame("날짜 계산기");
		
		Panel p=new Panel();
		Panel p2=new Panel();
		
		String menu[]= {"날짜 간 차이","일 합산 또는 빼기"};
		
		JComboBox<String> combo;
		combo=new JComboBox<String>(menu);
		p.add(combo).setBounds(20,10,100,30);
		
		JComboBox<String> combo2;
		combo2=new JComboBox<String>(menu);
		p2.add(combo2).setBounds(20,10,100,30);

		
		JLabel l1=new JLabel("시작일");
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
		

		JLabel l2=new JLabel("종료일");
		p.add(l2).setBounds(20,124,40,20);
		
		p.add(EyearCombo).setBounds(80,120,60,30); EyearCombo.setModel(EyearModel); 
		EyearCombo.setSelectedItem(eyear); p.add(EyLbl).setBounds(142,120,60,30); 
		
		p.add(EmonthCombo).setBounds(162,120,60,30); EmonthCombo.setModel(EmonthModel); 
		EmonthCombo.setSelectedItem(emonth); p.add(EmLbl).setBounds(224,120,60,30); 
		
		
		p.add(EdayCombo).setBounds(244,120,60,30); EdayCombo.setModel(EdayModel); 
		EdayCombo.setSelectedItem(eday); p.add(EdLbl).setBounds(306,120,60,30); 
		

		
		JLabel get1=new JLabel("동일한 날짜");
		p.add(get1).setBounds(80,173,190,20);
		
		JLabel dif=new JLabel("차이");
		p.add(dif).setBounds(20,166,60,30);	
		
		JLabel gylb=new JLabel();
		p.add(gylb);
		
		JLabel gmlb=new JLabel();
		 p.add(gmlb);
	
		JLabel gwlb=new JLabel();
		 p.add(gwlb);
		 
		JLabel gdlb=new JLabel();
		 p.add(gdlb);
		 
		JLabel gadlb=new JLabel();
		 p.add(gadlb);
		
		 yearCombo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					int y= (int) e.getItem();
					toDateTime=toDateTime.withYear(y);
					
					int xdistance=100;
					DateCalc.FromToDate(toDateTime,fromDateTime);
					
						
					if(toDateTime.isEqual(fromDateTime)==true)
						get1.setVisible(true);
				
						if(getyear==0) 
							gylb.setVisible(false);
						else {
							get1.setVisible(false);
							 gylb.setText(getyear+"년,");
							 gylb.setBounds(xdistance-10,173,40,20);
							 gylb.setVisible(true);
							 xdistance+=40;
						}
						if(getmonth==0)
							gmlb.setVisible(false);
						else {
							get1.setVisible(false);
							gmlb.setText(getmonth+"월,");
							gmlb.setBounds(xdistance,173,40,20);
							gmlb.setVisible(true);
							xdistance+=40;
						}
						
						if(week==0) 
							gwlb.setVisible(false);
						else {
							get1.setVisible(false);
							 gwlb.setText(week+"주,");
							 gwlb.setBounds(xdistance,173,40,20);
							 gwlb.setVisible(true);
							 xdistance+=40;
						}
						
						if(getdays==0) 
							gdlb.setVisible(false);
						else {
							get1.setVisible(false);
							gdlb.setText(getdays+"일,");
							gdlb.setBounds(xdistance,173,40,20);
							gdlb.setVisible(true);
							xdistance+=40;
						}
						if(getalldays==0)
							gadlb.setVisible(false);
						else {
							get1.setVisible(false);
							gadlb.setText("총 "+getalldays+"일");
							gadlb.setBounds(xdistance,173,150,20);
							gadlb.setVisible(true);
						}
				}
			});
			
			monthCombo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					int m= (int) e.getItem();
					toDateTime=toDateTime.withMonth(m);
					int xdistance=100;
					DateCalc.FromToDate(toDateTime,fromDateTime);
					
						
					if(toDateTime.isEqual(fromDateTime)==true)
						get1.setVisible(true);
				
						if(getyear==0) 
							gylb.setVisible(false);
						else {
							get1.setVisible(false);
							 gylb.setText(getyear+"년,");
							 gylb.setBounds(xdistance-10,173,40,20);
							 gylb.setVisible(true);
							 xdistance+=40;
						}
						if(getmonth==0)
							gmlb.setVisible(false);
						else {
							get1.setVisible(false);
							gmlb.setText(getmonth+"월,");
							gmlb.setBounds(xdistance,173,40,20);
							gmlb.setVisible(true);
							xdistance+=40;
						}
						
						if(week==0) 
							gwlb.setVisible(false);
						else {
							get1.setVisible(false);
							 gwlb.setText(week+"주,");
							 gwlb.setBounds(xdistance,173,40,20);
							 gwlb.setVisible(true);
							 xdistance+=40;
						}
						
						if(getdays==0) 
							gdlb.setVisible(false);
						else {
							get1.setVisible(false);
							gdlb.setText(getdays+"일,");
							gdlb.setBounds(xdistance,173,40,20);
							gdlb.setVisible(true);
							xdistance+=40;
						}
						if(getalldays==0)
							gadlb.setVisible(false);
						else {
							get1.setVisible(false);
							gadlb.setText("총 "+getalldays+"일");
							gadlb.setBounds(xdistance,173,150,20);
							gadlb.setVisible(true);
						}
				}
			});

			
			dayCombo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					int d= (int) e.getItem();
					toDateTime=toDateTime.withDayOfMonth(d);
					int xdistance=100;
					DateCalc.FromToDate(toDateTime,fromDateTime);
					
						
					if(toDateTime.isEqual(fromDateTime)==true)
						get1.setVisible(true);
				
						if(getyear==0) 
							gylb.setVisible(false);
						else {
							get1.setVisible(false);
							 gylb.setText(getyear+"년,");
							 gylb.setBounds(xdistance-10,173,40,20);
							 gylb.setVisible(true);
							 xdistance+=40;
						}
						if(getmonth==0)
							gmlb.setVisible(false);
						else {
							get1.setVisible(false);
							gmlb.setText(getmonth+"월,");
							gmlb.setBounds(xdistance,173,40,20);
							gmlb.setVisible(true);
							xdistance+=40;
						}
						
						if(week==0) 
							gwlb.setVisible(false);
						else {
							get1.setVisible(false);
							 gwlb.setText(week+"주,");
							 gwlb.setBounds(xdistance,173,40,20);
							 gwlb.setVisible(true);
							 xdistance+=40;
						}
						
						if(getdays==0) 
							gdlb.setVisible(false);
						else {
							get1.setVisible(false);
							gdlb.setText(getdays+"일,");
							gdlb.setBounds(xdistance,173,40,20);
							gdlb.setVisible(true);
							xdistance+=40;
						}
						if(getalldays==0)
							gadlb.setVisible(false);
						else {
							get1.setVisible(false);
							gadlb.setText("총 "+getalldays+"일");
							gadlb.setBounds(xdistance,173,150,20);
							gadlb.setVisible(true);
						}
				}
			});

		 
		 EyearCombo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					int y= (int) e.getItem();
					fromDateTime=fromDateTime.withYear(y);
					int xdistance=100;
					DateCalc.FromToDate(toDateTime,fromDateTime);
					
						
					if(toDateTime.isEqual(fromDateTime)==true)
						get1.setVisible(true);
				
						if(getyear==0) 
							gylb.setVisible(false);
						else {
							get1.setVisible(false);
							 gylb.setText(getyear+"년,");
							 gylb.setBounds(xdistance-10,173,40,20);
							 gylb.setVisible(true);
							 xdistance+=40;
						}
						if(getmonth==0)
							gmlb.setVisible(false);
						else {
							get1.setVisible(false);
							gmlb.setText(getmonth+"월,");
							gmlb.setBounds(xdistance,173,40,20);
							gmlb.setVisible(true);
							xdistance+=40;
						}
						
						if(week==0) 
							gwlb.setVisible(false);
						else {
							get1.setVisible(false);
							 gwlb.setText(week+"주,");
							 gwlb.setBounds(xdistance,173,40,20);
							 gwlb.setVisible(true);
							 xdistance+=40;
						}
						
						if(getdays==0) 
							gdlb.setVisible(false);
						else {
							get1.setVisible(false);
							gdlb.setText(getdays+"일,");
							gdlb.setBounds(xdistance,173,40,20);
							gdlb.setVisible(true);
							xdistance+=40;
						}
						if(getalldays==0)
							gadlb.setVisible(false);
						else {
							get1.setVisible(false);
							gadlb.setText("총 "+getalldays+"일");
							gadlb.setBounds(xdistance,173,150,20);
							gadlb.setVisible(true);
						}
				}
			});
			
			EmonthCombo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					int m= (int) e.getItem();
					fromDateTime=fromDateTime.withMonth(m);
					int xdistance=100;
					DateCalc.FromToDate(toDateTime,fromDateTime);
					
						
					if(toDateTime.isEqual(fromDateTime)==true)
						get1.setVisible(true);
				
						if(getyear==0) 
							gylb.setVisible(false);
						else {
							get1.setVisible(false);
							 gylb.setText(getyear+"년,");
							 gylb.setBounds(xdistance-10,173,40,20);
							 gylb.setVisible(true);
							 xdistance+=40;
						}
						if(getmonth==0)
							gmlb.setVisible(false);
						else {
							get1.setVisible(false);
							gmlb.setText(getmonth+"월,");
							gmlb.setBounds(xdistance,173,40,20);
							gmlb.setVisible(true);
							xdistance+=40;
						}
						
						if(week==0) 
							gwlb.setVisible(false);
						else {
							get1.setVisible(false);
							 gwlb.setText(week+"주,");
							 gwlb.setBounds(xdistance,173,40,20);
							 gwlb.setVisible(true);
							 xdistance+=40;
						}
						
						if(getdays==0) 
							gdlb.setVisible(false);
						else {
							get1.setVisible(false);
							gdlb.setText(getdays+"일,");
							gdlb.setBounds(xdistance,173,40,20);
							gdlb.setVisible(true);
							xdistance+=40;
						}
						if(getalldays==0)
							gadlb.setVisible(false);
						else {
							get1.setVisible(false);
							gadlb.setText("총 "+getalldays+"일");
							gadlb.setBounds(xdistance,173,150,20);
							gadlb.setVisible(true);
						}
				}
			});

			
			EdayCombo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					int d= (int) e.getItem();
					fromDateTime=fromDateTime.withDayOfMonth(d);
					int xdistance=100;
					DateCalc.FromToDate(toDateTime,fromDateTime);
					
						
					if(toDateTime.isEqual(fromDateTime)==true)
						get1.setVisible(true);
				
						if(getyear==0) 
							gylb.setVisible(false);
						else {
							get1.setVisible(false);
							 gylb.setText(getyear+"년,");
							 gylb.setBounds(xdistance-10,173,40,20);
							 gylb.setVisible(true);
							 xdistance+=40;
						}
						if(getmonth==0)
							gmlb.setVisible(false);
						else {
							get1.setVisible(false);
							gmlb.setText(getmonth+"월,");
							gmlb.setBounds(xdistance,173,40,20);
							gmlb.setVisible(true);
							xdistance+=40;
						}
						
						if(week==0) 
							gwlb.setVisible(false);
						else {
							get1.setVisible(false);
							 gwlb.setText(week+"주,");
							 gwlb.setBounds(xdistance,173,40,20);
							 gwlb.setVisible(true);
							 xdistance+=40;
						}
						
						if(getdays==0) 
							gdlb.setVisible(false);
						else {
							get1.setVisible(false);
							gdlb.setText(getdays+"일,");
							gdlb.setBounds(xdistance,173,40,20);
							gdlb.setVisible(true);
							xdistance+=40;
						}
						if(getalldays==0)
							gadlb.setVisible(false);
						else {
							get1.setVisible(false);
							gadlb.setText("총 "+getalldays+"일");
							gadlb.setBounds(xdistance,173,150,20);
							gadlb.setVisible(true);
						}
				}
			});
		 
		//해야 할 것!!!
		//이벤트처리에서  겹치는 거 줄이기 - 그룹화?
		//오류 뜨는거 4월이 30일까진데 31클릭하면 오류뜸 그래서 오류처리하삼
		//다 하고나면 폰트랑 글씨 크기랑 글씨 위치 바꾸기 + 배경색
		
		
		
		f.add(p);
		
		
		//p2 구성
		
		
		JLabel p2start=new JLabel("시작일");
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
		
		p2.add(monthCombo3).setBounds(80,182,45,20); monthCombo3.setModel(monthModel3); 
		
		p2.add(dayCombo3).setBounds(140,182,45,20); dayCombo3.setModel(dayModel3); 
		
	
		LocalDate nw=LocalDate.now();
		GetDayOfWeek(nw);
		JLabel get=new JLabel(nw.format(formatter)+getd);
		p2.add(get).setBounds(20,240,160,30);
	
		
		
		
		JRadioButton radio[]=new JRadioButton[2];
		
		
		radio[0]=new JRadioButton("추가");
		p2.add(radio[0]).setBounds(20,122,50,20);

		
		radio[1]=new JRadioButton("빼기");
		p2.add(radio[1]).setBounds(80,122,50,20);
	
		
		radio[0].setSelected(true);
		
		
		//시작일 선택하는 거 이벤트
				yearCombo2.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						int y= (int) e.getItem();
						startDate=startDate.withYear(y);
						if(radio[0].isSelected()){
			               
			                get.setText((AddDate(startDate,ay,am,ad)).format(formatter)+getd);
			                get.setVisible(true);
			            }
						else if(radio[1].isSelected()) {
							
			                get.setText(MinusDate(startDate,ay,am,ad).format(formatter)+getd);
			                get.setVisible(true);
						}
					}
				});
				
				monthCombo2.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						int m= (int) e.getItem();
						startDate=startDate.withMonth(m);
						if(radio[0].isSelected()){
			             
			                get.setText((AddDate(startDate,ay,am,ad)).format(formatter)+getd);
			                get.setVisible(true);
			            }
						else if(radio[1].isSelected()) {
							
			                get.setText(MinusDate(startDate,ay,am,ad).format(formatter)+getd);
			                get.setVisible(true);
						}
					}
				});

				
				dayCombo2.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						int d= (int) e.getItem();
						startDate=startDate.withDayOfMonth(d);
						if(radio[0].isSelected()){
			             
			                get.setText((AddDate(startDate,ay,am,ad)).format(formatter)+getd);
			                get.setVisible(true);
			            }
						else if(radio[1].isSelected()) {
							
			                get.setText(MinusDate(startDate,ay,am,ad).format(formatter)+getd);
			                get.setVisible(true);
						}
					}
				});
				
		
		
		//더하거나 뺄 꺼 선택할 때 이벤트
		yearCombo3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ay= (int) e.getItem();
				if(radio[0].isSelected()){
	                
	                get.setText((AddDate(startDate,ay,am,ad)).format(formatter)+getd);
	                get.setVisible(true);
	            }
				else if(radio[1].isSelected()) {
				 
	                get.setText(MinusDate(startDate,ay,am,ad).format(formatter)+getd);
	                get.setVisible(true);
				}
				
			}
		});
		
		monthCombo3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				am= (int) e.getItem();
				if(radio[0].isSelected()){
	            
	                get.setText((AddDate(startDate,ay,am,ad)).format(formatter)+getd);
	                get.setVisible(true);
	            }
				else {
					
					get.setText(MinusDate(startDate,ay,am,ad).format(formatter)+getd);
	                get.setVisible(true);
				}
			}
		});

		
		dayCombo3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ad= (int) e.getItem();
				if(radio[0].isSelected()){
	              
	                get.setText((AddDate(startDate,ay,am,ad)).format(formatter)+getd);
	                get.setVisible(true);
	            }
				else {
			
					get.setText(MinusDate(startDate,ay,am,ad).format(formatter)+getd);
	                get.setVisible(true);
				}
			}
		});
		
		 
		
		//라디오 버튼 이벤트 - 빼기에서 추가로 바뀔 때 바로 빼져야 함
		radio[0].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				radio[1].setSelected(false);
				  get.setText((AddDate(startDate,ay,am,ad)).format(formatter)+getd);
	              get.setVisible(true);
			}
		});
		radio[1].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				radio[0].setSelected(false);
				 get.setText(MinusDate(startDate,ay,am,ad).format(formatter)+getd);
	                get.setVisible(true);
			}
		});
		
		
		JLabel yLbl3 = new JLabel("년 "); 
		p2.add(yLbl3).setBounds(20,162,20,20);
		
		JLabel mLbl3 = new JLabel("월"); 
		p2.add(mLbl3).setBounds(80,162,20,20);
		
		JLabel dLbl3 = new JLabel("일"); 
		p2.add(dLbl3).setBounds(140,162,20,20);
		
		JLabel nalza = new JLabel("날짜 "); 
		p2.add(nalza).setBounds(20,222,40,20);
		
	
		
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
