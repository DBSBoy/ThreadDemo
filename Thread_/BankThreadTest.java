package Thread_;

public class BankThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank bank = new Bank();
		Thread tadd = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
					}
					bank.addMoney(100); // ��Ǯ��������
					bank.lookMoney(); // �鿴���
					System.out.println("\n");
				}
			}
		});
		Thread tsub = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					bank.subMoney(100); // ȡǮ
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
