package Thread_;

public class ExampleRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketWindow1 tw=new TicketWindow1();
		new Thread(tw,"窗口1").start(); // 创建线程对象，并命名为窗口1，开启线程
		new Thread(tw,"窗口2").start(); // 创建线程对象，并命名为窗口2，开启线程
		new Thread(tw,"窗口3").start(); // 创建线程对象，并命名为窗口3，开启线程
		new Thread(tw,"窗口4").start(); // 创建线程对象，并命名为窗口4，开启线程
		}
	

}
