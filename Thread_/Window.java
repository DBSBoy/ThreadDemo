package Thread_;

public class Window extends Thread {
	int ticket=10;
	//2.线程体执行内容
	public void run() {
	while(true) {
	if(ticket>0) {
	System.out.println(Thread.currentThread().getName()+"售票，票号为:"+ticket--);
	}else {
	break;}
	}
	}

}
