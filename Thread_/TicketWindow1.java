package Thread_;

public class TicketWindow1 implements Runnable {
	private int tickets=100;
	public void run(){
	while(true){
	synchronized (this) {
	if (tickets>0){
	// ��ȡ��ǰ�߳�
	Thread th=Thread.currentThread();
	String th_name=th.getName();
	System.out.println(th_name+"���ڷ��۵�"+tickets--+"��Ʊ");
		}
	}
	}
	}
	}

