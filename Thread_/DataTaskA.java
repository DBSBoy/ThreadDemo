package Thread_;

public class DataTaskA implements Runnable {

	private Data shuju;
	public DataTaskA(Data shuju) {
	super();
	this.shuju = shuju;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		shuju.wajueA();
	}

}
