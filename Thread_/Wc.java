package Thread_;

import java.util.concurrent.Semaphore;

public class Wc {
	private Semaphore semaphore = new Semaphore(3);// �ź���

	public void paidui() {// �Ŷ����񷽷�
		try {
			semaphore.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " :����ʹ�ò���");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " :ʹ�ò������");
		semaphore.release();
	}
}
