package chapter05;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//ʹ��java.util.Timer��ɰ�ť�ƶ�
public class MoveButtonTimerDemo extends JFrame {
	JPanel p;
	JButton btnMove;

	// ����һ��Timer
	Timer t;

	// ��ť�ƶ�����
	int movex = 5;
	int movey = 5;

	public MoveButtonTimerDemo() {
		super("��ť�ƶ���Timer��ʽ��");
		p = new JPanel(null);
		btnMove = new JButton("�ƶ�");
		btnMove.setBounds(0, 100, 80, 25);

		p.add(btnMove);
		this.add(p);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 2. ʵ����Timer����
		t = new Timer();

		// 3.����schedule()������ִ������
		t.schedule(new ButtonMoveTask(), 0, 100);
	}

	// 1. ����һ���ڲ��࣬�̳�TimerTask
	class ButtonMoveTask extends TimerTask {
		// ���񷽷�
		public void run() {
			// ��ȡ��ťx������,������movex
			int x = btnMove.getX() + movex;
			// ��ȡ��ťy������,������movey
			int y = btnMove.getY() + movey;
			if (x <= 0) {
				// ��Сֵ
				x = 0;
				// ������
				movex = -movex;
			} else if (x >= MoveButtonTimerDemo.this.getWidth()
					- btnMove.getWidth()) {
				// ���ֵ,���ڵĿ��-��ť�Ŀ��
				x = MoveButtonTimerDemo.this.getWidth() - btnMove.getWidth();
				// ������
				movex = -movex;
			}
			if (y <= 0) {
				// ��Сֵ
				y = 0;
				// ������
				movey = -movey;
			} else if (y >= MoveButtonTimerDemo.this.getHeight() - 30
					- btnMove.getHeight()) {
				// ���ֵ,���ڵĸ߶�-�������ĸ߶�-��ť�ĸ߶�
				y = MoveButtonTimerDemo.this.getHeight() - 30
						- btnMove.getHeight();
				// ������
				movey = -movey;
			}
			// ���ð�ť����Ϊ�µ�����
			btnMove.setLocation(x, y);
		}
	}

	public static void main(String[] args) {
		MoveButtonTimerDemo f = new MoveButtonTimerDemo();
		f.setVisible(true);
	}
}
