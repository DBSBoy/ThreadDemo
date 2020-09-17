package Thread_;

import java.util.concurrent.BrokenBarrierException;

public class MeetTask implements Runnable {
	private Meet meet;

	public MeetTask(Meet meet) {
		super();
		this.meet = meet;
	}

	@Override
	public void run() {
		try {
			meet.doMeet();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 调用开会类方法
	}

}
