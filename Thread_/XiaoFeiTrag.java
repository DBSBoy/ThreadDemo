package Thread_;

public class XiaoFeiTrag implements Runnable {

	private Tianmao_ t;
	public XiaoFeiTrag(Tianmao_ t) {
	super();
	this.t = t;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub

		while(true){
			t.xiaoFei();
			}
	}

}
