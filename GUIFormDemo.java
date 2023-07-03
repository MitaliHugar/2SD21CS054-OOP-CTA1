
package sdmcet.cse.oop;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIFormDemo implements ActionListener {

	JFrame f = new JFrame("Students Grading System");

	JLabel label1 = new JLabel("Grade Calculator");
	JLabel l1 = new JLabel("Name:         ");
	JLabel l2 = new JLabel("USN:             ");
	JLabel label2 = new JLabel("IA-1 marks:");
	JLabel label3 = new JLabel("IA-2 marks:");
	JLabel label4 = new JLabel("IA-3 marks:");
	JLabel label5 = new JLabel("CTA marks:");
	JLabel label6 = new JLabel("SEE marks:");
	JLabel label7 = new JLabel();
	JLabel label8 = new JLabel();
	JLabel label9 = new JLabel();
	JLabel label10 = new JLabel();
	JLabel la1 = new JLabel();

	JButton b = new JButton("Calculate");

	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JPanel p6 = new JPanel();
	JPanel p7 = new JPanel();
	JPanel p8 = new JPanel();
	JPanel p9 = new JPanel();
	JPanel p10 = new JPanel();
	JPanel p11 = new JPanel();
	JPanel p12 = new JPanel();

	JTextField textfield1 = new JTextField(10);
	JTextField textfield2 = new JTextField(10);
	JTextField textfield3 = new JTextField(10);
	JTextField textfield4 = new JTextField(10);
	JTextField textfield5 = new JTextField(10);
	JTextField textfield6 = new JTextField(10);
	JTextField textfield7 = new JTextField(10);

	public GUIFormDemo() {

		b.setSize(200, 300);
		b.setBackground(Color.PINK);
		f.setVisible(true);
		f.setBounds(200, 200, 700, 500);

		p1.add(label1);
		label1.setFont(new Font("Courier", Font.BOLD, 18));
		p1.setBackground(Color.pink);

		p11.add(la1);
		la1.setText(" [ NOTE:- IA marks:0-20" + "    CTA marks:0-10" + "     SEE marks:0-100 ] ");

		p9.add(l1);
		p9.add(textfield6);

		p10.add(l2);
		p10.add(textfield7);

		p2.add(label2);
		p2.add(textfield1);

		p3.add(label3);
		p3.add(textfield2);

		p4.add(label4);
		p4.add(textfield3);

		p5.add(label5);
		p5.add(textfield4);

		p6.add(label6);
		p6.add(textfield5);

		p7.add(b);

		p8.add(label7);
		p8.add(label8);
		p8.add(label9);
		p8.add(label10);

		f.add(p);
		f.add(p1);
		f.add(p9);
		f.add(p10);
		f.add(p2);
		f.add(p3);
		f.add(p4);
		f.add(p5);
		f.add(p6);
		f.add(p11);
		f.add(p7);
		f.add(p8);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(12, 20));
		f.setVisible(true);

		p8.setLayout(new GridLayout(1, 0));
		b.addActionListener(this);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUIFormDemo();
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == b) {

				int IA1 = Integer.parseInt(textfield1.getText());
				int IA2 = Integer.parseInt(textfield2.getText());
				int IA3 = Integer.parseInt(textfield3.getText());
				int CTA = Integer.parseInt(textfield4.getText());
				double SEE = Integer.parseInt(textfield5.getText());

				// input validation
				if (IA1 < 0 || IA1 > 20 || IA2 < 0 || IA2 > 20 || IA3 < 0 || IA3 > 20 || CTA < 0 || CTA > 10 || SEE < 0
						|| SEE > 100) {
					label10.setText("The entered marks are invalid");
					return;
				}

				// CIE Calculation
				int CIE;
				int sum1, sum2, largest;

				largest = IA1 + IA2;
				sum1 = IA2 + IA3;
				sum2 = IA1 + IA3;

				if (sum1 > largest) {
					largest = sum1;
				}
				if (sum2 > largest) {
					largest = sum2;
				}

				CIE = largest + CTA;

				// To check whether the student is detained
				if (CIE < 20) {
					label10.setText("Student is detained from taking SEE");
					return;
				}

				// Upgrade SEE marks to 40 if 38 or 39
				if (SEE == 38 || SEE == 39) {
					SEE = 40;
				}

				// Calculation of total marks
				double totalMarks = (CIE + Math.round(SEE / 2));
				totalMarks = Math.round(totalMarks);

				// Grade Calculation

				String grade;
				if (totalMarks >= 90) {
					grade = "S";
				} else if (totalMarks >= 80) {
					grade = "A";
				} else if (totalMarks >= 70) {
					grade = "B";
				} else if (totalMarks >= 60) {
					grade = "C";
				} else if (totalMarks >= 50) {
					grade = "D";
				} else if (totalMarks >= 40) {
					grade = "E";
				} else {
					grade = "F";
				}
				label9.setText("TotalMarks:" + totalMarks);
				label10.setText("Grade:" + grade);

				if (SEE < 38) {
					// String grade="F";
					label10.setText("Grade:F");
					return;
				}
			}
		} catch (NumberFormatException nfe) {
			label10.setText("Invalid input");
		}
	}
}