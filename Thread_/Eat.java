package Thread_;

import java.util.concurrent.CountDownLatch;

public class Eat {
	private CountDownLatch countDownLatch;

	public Eat(CountDownLatch countDownLatch) {
		super();
		this.countDownLatch = countDownLatch;
	}

	public void doEat() {
		System.out.println(Thread.currentThread().getName() + " :���ڳԷ�");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		countDownLatch.countDown();// ������������㣬���ͷ����еȴ����߳�,�ں��棬��β��������
	}
}
