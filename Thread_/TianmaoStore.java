package Thread_;

public class TianmaoStore {
	private volatile int value;// 重点
	private final int MAX_VALUE = 10;
	private final int MIN_VALUE = 0;

	// 生产任务方法
	public synchronized void shengChan() {
		while (value >= MAX_VALUE) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " :停止生产，当前库存：" + value);
			try {
				this.wait(); // 生产等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		value++;// volatile变量,如果缓冲区不满上面while不成立就会继续生产，执行自增
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " :正在生产，库存：" + value);
		this.notifyAll();// 生产唤醒
	}

	public synchronized void xiaoFei() {
		while (value <= MIN_VALUE) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName() + " :停止消费，当前库存：" + value);
			try {
				this.wait();// 消费等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		value--;// volatile变量
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " :正在消费，库存：" + value);
		this.notifyAll();// 消费唤醒
	}

}
