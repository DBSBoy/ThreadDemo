package Thread_;

public class ConcurrenyTest {
	private static final long count = 100000;//换作count = 100000000比较效果
	public static void main(String[] args) throws InterruptedException {
	System.out.println("当前操作次数为：" + count);
	//并发执行
	concurrency();
	//串行执行
	serial();
	}

	private static void concurrency() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread thread = new Thread(new Runnable() {
@Override
	public void run() {
	long a = 0;
	for(int i = 0;i < count;i++)
			a += 5;
		}
		});
		thread.start();
		long b = 0;
		for(int j = 0;j < count;j ++)
			b--;
//将对a的累加的任务交由另外的线程执行
		thread.join();//作用是调用线程等待该线程完成后，才能继续用下运行
		long time = System.currentTimeMillis() - start;
		System.out.println("并发执行耗时:"+time+"ms");
	}
	private static void serial() {
		long start = System.currentTimeMillis();
		long a = 0;
		for(int i = 0; i < count; i++) {
			a += 5;
		}
		long b = 0;
		for(int i = 0;i < count; i++) {
			b--;
		}
		long spend = System.currentTimeMillis() - start;
	System.out.println("串行耗时:"+spend+"ms");
	}
}
