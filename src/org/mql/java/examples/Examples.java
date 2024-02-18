package org.mql.java.examples;
import org.mql.java.views.FirstInterface;

public class Examples {
	public Examples() {
		exp01();
	}
	public void exp01() {
		FirstInterface first = new FirstInterface();
		first.drawFirstInterface();
	}
	
	public static void main(String[] args) {
		new Examples();
	}

}
