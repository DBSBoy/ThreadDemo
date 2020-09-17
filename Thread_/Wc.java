package Thread_;

import java.util.concurrent.Semaphore;

public class Wc {
	private Semaphore semaphore = new Semaphore(3);// 信号量

	public void paidui() {// 排队任务方法
		try {
			semaphore.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " :正在使用厕所");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " :使用厕所完毕");
		semaphore.release();
	}
}
