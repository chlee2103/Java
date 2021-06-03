package singletonAccount;

import java.util.HashMap;

import bt210521.Ex01.AccountDtoCho;

public class Singletonclass {
	public static Singletonclass si = null;
	HashMap<String, AccountDtoCho> map ;
	
	private Singletonclass() {
		map = new HashMap <>();
	}
	
	
	public static Singletonclass getInstence() {
		if(si == null) {
			si = new Singletonclass();
		}
		return si;
	}
	
	
	
}
