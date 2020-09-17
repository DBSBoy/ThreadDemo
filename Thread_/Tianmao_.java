package Thread_;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tianmao_ {
	private volatile int value;// 共享变量值
	private final int MAX_VALUE = 10;
	private final int MIN_VALUE = 0;
	private Lock lock = new ReentrantLock();// 可重入锁,手动加锁和解锁，可控性强
	Condition c1 = lock.newCondition();
	Condition c2 = lock.newCondition();

	public void shengChan() {// 生产方法
		lock.lock();
		while (value >= MAX_VALUE) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				System.out.println(Thread.currentThread().getName() + " :停止生产，当前库存：" + value);
				try {
					c1.await();// 生产者等待
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			value++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " :正在生产，库存：" + value);
			c2.signalAll();// 生产者唤醒
			lock.unlock();// 生产者解锁
		}
	

	public void xiaoFei() {// 消费方法
		lock.lock();// 消费上锁
		while (value <= MIN_VALUE) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName() + " :停止消费，当前库存：" + value);
			try {
				c2.await();// 消费等待
			} catch (InterruptedException e) {
			}
		}
		value--;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " :正在消费，库存：" + value);
		c1.signalAll();// 消费唤醒
		lock.unlock();// 消费解锁
	}

}
