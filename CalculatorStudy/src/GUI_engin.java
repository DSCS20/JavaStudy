import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUI_engin extends JFrame{
	
	public GUI_engin() {
		
		super("계산기_공학용");
		
		setLayout(new GridLayout(0,1));
		
		JPanel buttonPanel1=new JPanel();
		JPanel buttonPanel2=new JPanel();
		JPanel buttonPanel3=new JPanel();
		JPanel buttonPanel4=new JPanel();
		JPanel buttonPanel5=new JPanel();
		JPanel buttonPanel6=new JPanel();
		JPanel buttonPanel7=new JPanel();
		JPanel buttonPanel8=new JPanel();
		
		JButton bDEG=new JButton("DEG");
		JButton btrifunc=new JButton("삼각법");
		
		JButton b2nd=new JButton("2nd");
		JButton bㅠ=new JButton("ㅠ");
		JButton be=new JButton("e");
		JButton bC=new JButton("C");
		JButton bback=new JButton("<-");
		
		JButton bx2=new JButton("x^2");
		JButton bbracket1=new JButton("(");
		JButton bbracket2=new JButton(")");
		JButton bfactorial=new JButton("n!");
		JButton bdivision=new JButton("/");
		
		JButton broot2=new JButton("x root 2");
		JButton b7=new JButton("7");
		JButton b8=new JButton("8");
		JButton b9=new JButton("9");
		JButton bmultiple=new JButton("*");
		
		JButton bxpowery=new JButton("x^y");
		JButton b4=new JButton("4");
		JButton b5=new JButton("5");
		JButton b6=new JButton("6");
		JButton bminus=new JButton("-");
		
		JButton b10powerx=new JButton("10^x");
		JButton b1=new JButton("1");
		JButton b2=new JButton("2");
		JButton b3=new JButton("3");
		JButton bplus=new JButton("+");
		
		JButton blog=new JButton("log");
		JButton bpormin=new JButton("+/-");
		JButton b0=new JButton("0");
		JButton bpoint=new JButton(".");
		JButton bequal=new JButton("=");
		
		JButton bln=new JButton("ln");
		
		buttonPanel1.add(bDEG);
		buttonPanel1.add(btrifunc);
		
		buttonPanel2.add(b2nd);
		buttonPanel2.add(bㅠ);
		buttonPanel2.add(be);
		buttonPanel2.add(bC);
		buttonPanel2.add(bback);
		
		buttonPanel3.add(bx2);
		buttonPanel3.add(bbracket1);
		buttonPanel3.add(bbracket2);
		buttonPanel3.add(bfactorial);
		buttonPanel3.add(bdivision);
		
		buttonPanel4.add(broot2);
		buttonPanel4.add(b7);
		buttonPanel4.add(b8);
		buttonPanel4.add(b9);
		buttonPanel4.add(bmultiple);
		
		buttonPanel5.add(bxpowery);
		buttonPanel5.add(b4);
		buttonPanel5.add(b5);
		buttonPanel5.add(b6);
		buttonPanel5.add(bminus);
		
		buttonPanel6.add(b10powerx);
		buttonPanel6.add(b1);
		buttonPanel6.add(b2);
		buttonPanel6.add(b3);
		buttonPanel6.add(bplus);
		
		buttonPanel7.add(blog);
		buttonPanel7.add(bpormin);
		buttonPanel7.add(b0);
		buttonPanel7.add(bpoint);
		buttonPanel7.add(bequal);
		
		buttonPanel8.add(bln);
		
		add(buttonPanel1); add(buttonPanel2); add(buttonPanel3); add(buttonPanel4); add(buttonPanel5); add(buttonPanel6); add(buttonPanel7); add(buttonPanel8);
		
		pack();
		setLocation(300,200);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		GUI_engin ex=new GUI_engin();

	}

}
