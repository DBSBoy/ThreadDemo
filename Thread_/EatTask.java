package Thread_;

public class EatTask implements Runnable {
	private Eat eat;// �Է������

	public EatTask(Eat eat) {
		super();
		this.eat = eat;
	}

	@Override
	public void run() {
		eat.doEat();// ���óԷ��෽��
	}
}
