package Thread_;

public class TianmaoConsume implements Runnable {
	private TianmaoStore t;

	public TianmaoConsume(TianmaoStore t) {
		super();
		this.t = t;
	}

	@Override
	public void run() {
		while (true) {
			t.xiaoFei();
		}
	}

}
