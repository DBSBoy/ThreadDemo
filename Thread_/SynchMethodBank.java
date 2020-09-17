package Thread_;

public class SynchMethodBank {
	private int count = 0;// 账户余额

	public synchronized void addMoney(int money) { // 存钱
		count += money;
		System.out.println(System.currentTimeMillis() + "存进：" + money);
	}

	public synchronized void subMoney(int money) { // 取钱
		if (count - money < 0) {
			System.out.println("余额不足");
			return;
		}
		count -= money;
		System.out.println(+System.currentTimeMillis() + "取出：" + money);
	}

	public void lookMoney() {
		System.out.println("账户余额：" + count);
	}

	public static void main(String args[]) { // 主程序入口
		SynchMethodBank bank = new SynchMethodBank();
		Thread tadd = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
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
