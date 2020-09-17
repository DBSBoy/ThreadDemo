package Thread_;

public class ShengChanTrag implements Runnable {

	private Tianmao_ t;

	public ShengChanTrag(Tianmao_ t) {
		super();
		this.t = t;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			t.shengChan();
		}

	}

}
