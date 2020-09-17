package Thread_;

import java.util.concurrent.Exchanger;

public class DataTest {
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();
		Data shuju = new Data(exchanger);
		new Thread(new DataTaskA(shuju)).start();
		new Thread(new DataTaskB(shuju)).start();
		}

}
