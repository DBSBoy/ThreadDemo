package Thread_;

import java.util.concurrent.CyclicBarrier;

public class MeetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclicBarrier barrier = new CyclicBarrier(10, new Runnable() {
			@Override
			public void run() {
				System.out.println("人来齐了，开始开会");
			}
		});
		Meet meet = new Meet(barrier);
		for (int i = 0; i < 10; i++) {
			new Thread(new MeetTask(meet)).start();
		}

	}

}
