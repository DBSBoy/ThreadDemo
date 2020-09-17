package Thread_;

import java.util.concurrent.CountDownLatch;

public class EatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch countDownLatch = new CountDownLatch(10);
		Eat eat = new Eat(countDownLatch);
		for (int i = 0; i < 10; i++) {
			new Thread(new EatTask(eat)).start();//把eat实例化传进去才能调用doeat()
		}
		try {
			countDownLatch.await();// 阻塞等待
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("都吃完了，主线程开始吃饭");
	}

}
