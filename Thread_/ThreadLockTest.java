package Thread_;

public class ThreadLockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tianmao_ t = new Tianmao_();
		new Thread(new ShengChanTrag(t)).start();
		new Thread(new ShengChanTrag(t)).start();
		new Thread(new ShengChanTrag(t)).start();
		new Thread(new XiaoFeiTrag(t)).start();
		new Thread(new XiaoFeiTrag(t)).start();
		new Thread(new XiaoFeiTrag(t)).start();
		new Thread(new XiaoFeiTrag(t)).start();
	}

}
