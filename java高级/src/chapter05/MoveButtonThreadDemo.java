package chapter05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//ʹ���߳���ɰ�ť�ƶ�
public class MoveButtonThreadDemo extends JFrame implements Runnable {
	JPanel p;
	JButton btnMove;
	
	//����һ���̶߳���t
	Thread t;
	
	//��ť�ƶ�����
	int movex = 5;
	int movey = 5;

	public MoveButtonThreadDemo() {
		super("��ť�ƶ����̷߳�ʽ��");
		p = new JPanel(null);
		btnMove = new JButton("�ƶ�");
		btnMove.setBounds(0, 100, 80, 25);

		p.add(btnMove);
		this.add(p);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// �����̶߳���
		t = new Thread(this);
		// �߳�����
		t.start();
	}

	// ʵ��run()����
	public void run() {
		while (t.isAlive()) {
			// ��ȡ��ťx������,������movex
			int x = btnMove.getX() + movex;
			// ��ȡ��ťy������,������movey
			int y = btnMove.getY() + movey;
			if (x <= 0) {
				// ��Сֵ
				x = 0;
				// ������
				movex = -movex;
			} else if (x >= this.getWidth() - btnMove.getWidth()) {
				// ���ֵ,���ڵĿ��-��ť�Ŀ��
				x = this.getWidth() - btnMove.getWidth();
				// ������
				movex = -movex;
			}
			if (y <= 0) {
				// ��Сֵ
				y = 0;
				// ������
				movey = -movey;
			} else if (y >= this.getHeight() - 30 - btnMove.getHeight()) {
				// ���ֵ,���ڵĸ߶�-�������ĸ߶�-��ť�ĸ߶�
				y = this.getHeight() - 30 - btnMove.getHeight();
				// ������
				movey = -movey;
			}
			// ���ð�ť����Ϊ�µ�����
			btnMove.setLocation(x, y);
			try {
				// ����100����
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		MoveButtonThreadDemo f = new MoveButtonThreadDemo();
		f.setVisible(true);
	}
}
