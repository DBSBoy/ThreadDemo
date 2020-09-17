package Thread_;

public class SynchBlockBank {
	private int count = 0;// 账户余额

	public void addMoney(int money) { // 存钱
		synchronized (this) { // 同步代码块
			count += money;
		}
		System.out.println(System.currentTimeMillis() + "存进：" + money);
	}

	public void subMoney(int money) { // 取钱
		synchronized (this) {
			if (count - money < 0) {
				System.out.println("余额不足");
				return;
			}
			count -= money;
		}
		System.out.println(+System.currentTimeMillis() + "取出：" + money);
	}

	public void lookMoney() { // 查询余额
		System.out.println("账户余额：" + count);
	}

	public static void main(String args[]) {
		SynchBlockBank bank = new SynchBlockBank();
		Thread tadd = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					bank.addMoney(100); // 存钱方法调用
					bank.lookMoney(); // 查看余额
					System.out.println("\n");
				}
			}
		});
		Thread tsub = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					bank.subMoney(100); // 取钱
					bank.lookMoney();
					System.out.println("\n");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		tsub.start();
		tadd.start();
	}
}
