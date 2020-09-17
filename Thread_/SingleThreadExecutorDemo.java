package Thread_;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService pool = Executors.newSingleThreadExecutor();
		for (int i = 0; i <= 5; i++) {
		pool.execute(() -> System.out.println(Thread.currentThread().getName() + "[running done]"));
	}
		}

}
