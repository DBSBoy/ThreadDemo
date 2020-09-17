package Thread_;

import java.util.concurrent.Exchanger;

public class Data {
	private Exchanger<String> exchanger;// �ص�Ҫ��

	public Data(Exchanger<String> exchanger) {
		super();
		this.exchanger = exchanger;
	}

	public void wajueA() {
		String str = "aaa";
		System.out.println(Thread.currentThread().getName() + " :��ʼ�ھ�����");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " :�ھ�������ϣ�����Ϊ��" + str);

		try {
			String ss = exchanger.exchange(str);
			System.out.println(Thread.currentThread().getName() + " :������õ����ݣ�����Ϊ��" + ss);
		} catch (InterruptedException e) {
		}
	}

	public void wajueB() {// �ھ򷽷�B
		String str = "bbb";
		System.out.println(Thread.currentThread().getName() + " :��ʼ�ھ�����");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " :�ھ�������ϣ�����Ϊ��" + str);
		try {
			String ss = exchanger.exchange(str);
			System.out.println(Thread.currentThread().getName() + " :������õ����ݣ�����Ϊ��" + ss);
		} catch (InterruptedException e) {
		}
	}
}
