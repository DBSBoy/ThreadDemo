package Thread_;

public class MultiThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Window w1=new Window();
		Window w2=new Window();
		//�����߳���
		w1.setName("����1");
		w2.setName("����2");
		//4.����2�����߳�
		w1.start();
		w2.start();
		}

	}

