package Thread_;

import java.util.concurrent.CountDownLatch;

public class EatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch countDownLatch = new CountDownLatch(10);
		Eat eat = new Eat(countDownLatch);
		for (int i = 0; i < 10; i++) {
			new Thread(new EatTask(eat)).start();//��eatʵ��������ȥ���ܵ���doeat()
		}
		try {
			countDownLatch.await();// �����ȴ�
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�������ˣ����߳̿�ʼ�Է�");
	}

}
