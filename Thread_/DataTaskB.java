package Thread_;

public class DataTaskB implements Runnable {

	private Data shuju;

	public DataTaskB(Data shuju) {
		super();
		this.shuju = shuju;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		shuju.wajueB();
	}

}
