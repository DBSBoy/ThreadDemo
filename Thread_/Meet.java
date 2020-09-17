package Thread_;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Meet {
	private CyclicBarrier barrier; // �ص�Ҫ��
	private Random random = new Random();

	public Meet(CyclicBarrier barrier) {
		super();
		this.barrier = barrier;
	}

	public void doMeet() throws BrokenBarrierException { // ���᷽��
		System.out.println(Thread.currentThread().getName() + " :���ڸ�����·��");
		try {
			Thread.sleep(random.nextInt(10000));
		} catch (InterruptedException e1) {
			System.out.println(Thread.currentThread().getName() + " :�Ѿ�����������");
		}
		
		try {
			barrier.await();// �̵߳ȴ�
		} catch (InterruptedException e) {
		}
	}
}
