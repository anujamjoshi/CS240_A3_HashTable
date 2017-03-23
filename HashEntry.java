package edu.csupomona.cs.cs240.A3Cs240;

public class HashEntry {
	private String key;
	private double value;
	private HashEntry next;
	public int numScores =0; 
	public HashEntry(String key, double value) {
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public HashEntry getNext() {
		return next;
	}
	public void setNext(HashEntry next) {
		this.next = next;
	}
	public int getnum(){ 
	return numScores; 
	}
	public void addNumScore(){
		numScores++;
	}
	}
