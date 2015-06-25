package net.xdptdr;

public class MyBean {
	private int usecount;
	public MyBean() {}
	public int getCount() {
		return ++usecount;
	}
}
