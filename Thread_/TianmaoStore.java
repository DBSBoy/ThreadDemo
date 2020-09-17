package Thread_;

public class TianmaoStore {
	private volatile int value;// �ص�
	private final int MAX_VALUE = 10;
	private final int MIN_VALUE = 0;

	// �������񷽷�
	public synchronized void shengChan() {
		while (value >= MAX_VALUE) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " :ֹͣ��������ǰ��棺" + value);
			try {
				this.wait(); // �����ȴ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		value++;// volatile����,�����������������while�������ͻ����������ִ������
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " :������������棺" + value);
		this.notifyAll();// ��������
	}

	public synchronized void xiaoFei() {
		while (value <= MIN_VALUE) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName() + " :ֹͣ���ѣ���ǰ��棺" + value);
			try {
				this.wait();// ���ѵȴ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		value--;// volatile����
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " :�������ѣ���棺" + value);
		this.notifyAll();// ���ѻ���
	}

}
