package Thread_;

public class ExampleRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketWindow1 tw=new TicketWindow1();
		new Thread(tw,"����1").start(); // �����̶߳��󣬲�����Ϊ����1�������߳�
		new Thread(tw,"����2").start(); // �����̶߳��󣬲�����Ϊ����2�������߳�
		new Thread(tw,"����3").start(); // �����̶߳��󣬲�����Ϊ����3�������߳�
		new Thread(tw,"����4").start(); // �����̶߳��󣬲�����Ϊ����4�������߳�
		}
	

}
