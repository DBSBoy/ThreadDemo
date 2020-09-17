package Thread_;

public class Tianmao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TianmaoStore t = new TianmaoStore();
		
		new Thread(new TianmaoProduct(t)).start();
		new Thread(new TianmaoProduct(t)).start();
		new Thread(new TianmaoProduct(t)).start();
		new Thread(new TianmaoConsume(t)).start();
		new Thread(new TianmaoConsume(t)).start();
		new Thread(new TianmaoConsume(t)).start();
		new Thread(new TianmaoConsume(t)).start();
		}

	

}
