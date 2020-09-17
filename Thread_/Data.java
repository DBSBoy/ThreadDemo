package Thread_;

import java.util.concurrent.Exchanger;

public class Data {
	private Exchanger<String> exchanger;// 重点要讲

	public Data(Exchanger<String> exchanger) {
		super();
		this.exchanger = exchanger;
	}

	public void wajueA() {
		String str = "aaa";
		System.out.println(Thread.currentThread().getName() + " :开始挖掘数据");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " :挖掘数据完毕，数据为：" + str);

		try {
			String ss = exchanger.exchange(str);
			System.out.println(Thread.currentThread().getName() + " :交换后得到数据，数据为：" + ss);
		} catch (InterruptedException e) {
		}
	}

	public void wajueB() {// 挖掘方法B
		String str = "bbb";
		System.out.println(Thread.currentThread().getName() + " :开始挖掘数据");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " :挖掘数据完毕，数据为：" + str);
		try {
			String ss = exchanger.exchange(str);
			System.out.println(Thread.currentThread().getName() + " :交换后得到数据，数据为：" + ss);
		} catch (InterruptedException e) {
		}
	}
}
