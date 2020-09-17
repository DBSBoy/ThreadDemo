package Thread_;

public class SynchBlockBank {
	private int count = 0;// �˻����

	public void addMoney(int money) { // ��Ǯ
		synchronized (this) { // ͬ�������
			count += money;
		}
		System.out.println(System.currentTimeMillis() + "�����" + money);
	}

	public void subMoney(int money) { // ȡǮ
		synchronized (this) {
			if (count - money < 0) {
				System.out.println("����");
				return;
			}
			count -= money;
		}
		System.out.println(+System.currentTimeMillis() + "ȡ����" + money);
	}

	public void lookMoney() { // ��ѯ���
		System.out.println("�˻���" + count);
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
