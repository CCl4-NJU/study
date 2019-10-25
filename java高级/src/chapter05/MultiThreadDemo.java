package chapter05;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MultiThreadDemo extends JFrame {

	JPanel p;
	JLabel lblTitle;
	JButton btnMove;
	String s[] = { "QST����ʵѵ", "��ƸѧԺ", "��ʵ���гɳ�����" };
	int index = 0;
	int movex = 5;

	public MultiThreadDemo() {
		super("���̶߳�����");
		p = new JPanel(null);
		lblTitle = new JLabel(s[0]);
		// ���ñ�ǩ����
		lblTitle.setFont(new Font("����", Font.BOLD, 28));

		btnMove = new JButton("QST��ӭ����");

		// ��������
		lblTitle.setBounds(80, 50, 250, 50);
		btnMove.setBounds(0, 150, 120, 25);

		p.add(lblTitle);
		p.add(btnMove);
		this.add(p);
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// �������߳�ColorChange��������
		new ColorChange().start();
		// ����java.util.Timer���󣬲���������ÿ��1��任�ı�
		new java.util.Timer().schedule(new TextChange(), 0, 1000);
		// javax.swing.Timer���󣬣����������ð�ťÿ��100����ˮƽ�ƶ�һ��
		new javax.swing.Timer(100, new ButtonMoveListener()).start();
	}

	// 1���������̣߳��ô��ڱ�����ɫ���ϱ仯
	class ColorChange extends Thread {
		public void run() {
			while (this.isAlive()) {
				// ���������ɫ��3������0~255
				int r = (int) (Math.random() * 256);
				int g = (int) (Math.random() * 256);
				int b = (int) (Math.random() * 256);
				// �������ı�����ɫ
				p.setBackground(new Color(r, g, b));
				try {
					// ����1����
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 2. �����ڲ��࣬�̳�TimerTask���ñ�ǩ�ı����ϱ仯
	class TextChange extends TimerTask {
		// ���񷽷�
		public void run() {
			lblTitle.setText(s[index++]);
			if (index == s.length) {
				index = 0;
			}
		}
	}

	// 3. ����һ�������࣬ʵ�ְ�ť�����ƶ�
	class ButtonMoveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// ��ȡ��ťx������,������movex
			int x = btnMove.getX() + movex;
			if (x <= 0) {
				// ��Сֵ
				x = 0;
				// ������
				movex = -movex;
			} else if (x >= getWidth() - btnMove.getWidth()) {
				// ���ֵ,���ڵĿ��-��ť�Ŀ��
				x = getWidth() - btnMove.getWidth();
				// ������
				movex = -movex;
			}
			btnMove.setLocation(x, btnMove.getY());
		}
	}

	public static void main(String[] args) {
		MultiThreadDemo f = new MultiThreadDemo();
		f.setVisible(true);
	}
}
