package Thread_;

public class TianmaoProduct implements Runnable {
	private TianmaoStore t;

	public TianmaoProduct(TianmaoStore t) {
		super();
		this.t = t;
	}

	@Override
	public void run() {
		while (true) {
			t.shengChan();// 调用仓库类方法
		}
	}

}
