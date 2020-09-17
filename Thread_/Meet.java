package Thread_;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Meet {
	private CyclicBarrier barrier; // 重点要讲
	private Random random = new Random();

	public Meet(CyclicBarrier barrier) {
		super();
		this.barrier = barrier;
	}

	public void doMeet() throws BrokenBarrierException { // 开会方法
		System.out.println(Thread.currentThread().getName() + " :正在赶来的路上");
		try {
			Thread.sleep(random.nextInt(10000));
		} catch (InterruptedException e1) {
			System.out.println(Thread.currentThread().getName() + " :已经来到会议室");
		}
		
		try {
			barrier.await();// 线程等待
		} catch (InterruptedException e) {
		}
	}
}
