package com.mycompany.a2;

public interface ICollection {
	public void add(GameObject n);
	public void remove(GameObject x);
	public IIterator getIterator();
	
}
