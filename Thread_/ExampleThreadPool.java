package Thread_;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExampleThreadPool implements Runnable {

	private CountDownLatch count;
	private CyclicBarrier barrier;

	public ExampleThreadPool(CountDownLatch count, CyclicBarrier barrier) {
		this.count = count;
		this.barrier = barrier;
	}

	private int num = 100; // ��Ʊ��
	Object lock = new Object();

	public void sellTicket() {
		synchronized (lock) {
			if (num > 0) {
				System.out.print(Thread.currentThread().getName() + "�۳�Ʊ��" + num);
				num--;
				if (num != 0)
					System.out.println(",��ʣ" + num + "��Ʊ--");
				else
					System.out.println("��Ʊ�Ѿ�Ʊ��!--");
			}
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + "����,�ȴ���...");
		try {
			barrier.await(); // �˴����� �������̶߳���λ��һ�������Ʊ
			if (Thread.currentThread().getName().equals("pool-1-thread-1")) {
				System.out.println("---------------ȫ���߳�׼������,��ʼ��Ʊ----------------");
			} else {
				Thread.sleep(10);
			}
		} catch (Exception e) {
		}
		while (num > 0) {
			sellTicket();
		}
		count.countDown(); // ��ǰ�߳̽����󣬼�����-1
	}

	public static void main(String[] args) {
		int threadNum = 4; // ģ�������� ������Ʊ
		final CyclicBarrier barrier = new CyclicBarrier(threadNum);
		final CountDownLatch count = new CountDownLatch(threadNum); // ����ͳ�� ִ��ʱ��
		ExampleThreadPool tickets = new ExampleThreadPool(count, barrier);
		ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
		for (int i = 0; i < threadNum; i++) { // �˴� ������ֵ ������ �̳߳��е�����
			executorService.submit(tickets);
		}
		try {
			count.await();
			executorService.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
