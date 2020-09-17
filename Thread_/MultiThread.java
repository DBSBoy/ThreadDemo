package Thread_;

public class MultiThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Window w1=new Window();
		Window w2=new Window();
		//设置线程名
		w1.setName("窗口1");
		w2.setName("窗口2");
		//4.开启2个子线程
		w1.start();
		w2.start();
		}

	}

