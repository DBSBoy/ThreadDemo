package Thread_;

public class Window extends Thread {
	int ticket=10;
	//2.�߳���ִ������
	public void run() {
	while(true) {
	if(ticket>0) {
	System.out.println(Thread.currentThread().getName()+"��Ʊ��Ʊ��Ϊ:"+ticket--);
	}else {
	break;}
	}
	}

}
