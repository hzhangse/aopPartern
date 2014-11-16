package com.train;

public class TalkProxy implements ITalk {

	ITalk target;

	public TalkProxy(ITalk target) {
		this.target = target;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.train.ITalk#talk()
	 */
	public void talk() {

		System.out.println("begin proxy");
		this.target.talk();
		System.out.println("end proxy");
	}

}
