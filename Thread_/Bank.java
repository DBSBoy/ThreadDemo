package Thread_;

public class Bank {
	private int count = 0;// �˻����

	public void addMoney(int money) { // ��Ǯ
		count += money;
		System.out.println(System.currentTimeMillis() + "�����" + money);
	}

	public void subMoney(int money) { // ȡǮ
		if (count - money < 0) {
			System.out.println("����");
			return;
		}
		count -= money;
		System.out.println(+System.currentTimeMillis() + "ȡ����" + money);
	}

	// ��ѯ
	public void lookMoney() {
		System.out.println("�˻���" + count);
	}

}
