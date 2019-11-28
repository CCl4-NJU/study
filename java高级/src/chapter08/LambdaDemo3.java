package chapter08;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LambdaDemo3 extends JFrame {
	JPanel p;
	JTextArea ta;
	JButton btn1, btn2;

	public LambdaDemo3() {
		super("Lambda����");
		p = new JPanel();

		ta = new JTextArea();

		btn1 = new JButton("��ͳ��ʽ");
		btn2 = new JButton("Lambda��ʽ");

		// ��Ӽ�����
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.append("������˰�ť1\n");
			}
		});

		// Lambda���ʽ��ʽ
		btn2.addActionListener(e -> ta.append("������˰�ť2\n"));

		this.add(ta);

		p.add(btn1);
		p.add(btn2);

		this.add(p, BorderLayout.SOUTH);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new LambdaDemo3().setVisible(true);
	}
}
