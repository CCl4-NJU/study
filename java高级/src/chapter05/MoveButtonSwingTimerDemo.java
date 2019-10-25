package chapter05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

//ʹ��javax.swing.Timer��ɰ�ť�ƶ�
public class MoveButtonSwingTimerDemo extends JFrame {
	JPanel p;
	JButton btnMove;

	// ����һ��Timer
	Timer t;

	// ��ť�ƶ�����
	int movex = 5;
	int movey = 5;

	public MoveButtonSwingTimerDemo() {
		super("��ť�ƶ���Swing Timer��ʽ��");
		p = new JPanel(null);
		btnMove = new JButton("�ƶ�");
		btnMove.setBounds(0, 100, 80, 25);

		p.add(btnMove);
		this.add(p);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 2. ʵ����Swing Timer����
		t = new Timer(100, new ButtonMoveListener());

		// 3.����Swing Timer
		t.start();
	}

	// 1. ����һ���ڲ������࣬ʵ��ActionListener
	class ButtonMoveListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// ��ȡ��ťx������,������movex
			int x = btnMove.getX() + movex;
			// ��ȡ��ťy������,������movey
			int y = btnMove.getY() + movey;
			if (x <= 0) {
				// ��Сֵ
				x = 0;
				// ������
				movex = -movex;
			} else if (x >= MoveButtonSwingTimerDemo.this.getWidth()
					- btnMove.getWidth()) {
				// ���ֵ,���ڵĿ��-��ť�Ŀ��
				x = MoveButtonSwingTimerDemo.this.getWidth()
						- btnMove.getWidth();
				// ������
				movex = -movex;
			}
			if (y <= 0) {
				// ��Сֵ
				y = 0;
				// ������
				movey = -movey;
			} else if (y >= MoveButtonSwingTimerDemo.this.getHeight() - 30
					- btnMove.getHeight()) {
				// ���ֵ,���ڵĸ߶�-�������ĸ߶�-��ť�ĸ߶�
				y = MoveButtonSwingTimerDemo.this.getHeight() - 30
						- btnMove.getHeight();
				// ������
				movey = -movey;
			}
			// ���ð�ť����Ϊ�µ�����
			btnMove.setLocation(x, y);

		}
	}

	public static void main(String[] args) {
		MoveButtonSwingTimerDemo f = new MoveButtonSwingTimerDemo();
		f.setVisible(true);
	}
}
