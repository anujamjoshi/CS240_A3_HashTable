package edu.csupomona.cs.cs240.A3Cs240;

public class HashEntryTable {
	private HashEntry[] hashData;
	private int size;
	//constructor of empty hash temp values which is a linked list of hash entries
	public HashEntryTable() {
		hashData = new HashEntry[100];
		size = 0;
	}
	// generates unique index values
	private int hash(String key) {
		int j = 3; 
		for (int i =0; i< key.length(); i++){
			j= (j*31+key.charAt(i))% (hashData.length);
		}
		return j;
	}
	// generate the index hash and then see if the value is occupied, 
	//check to see if the value is the same, then if it is then addto the linked list 
	public void put(String key, double value) {
		HashEntry temp = new HashEntry(key, value);
		int hashIndex = hash(key);
		//Goes to the index that the key returns 
		HashEntry current = hashData[hashIndex];
		//checks to see if the hash index is occupied already
		if (current != null) { 
			while (current.getNext()!=null && !current.getKey().equals(key)){
				current = current.getNext();
			}
			if(!current.getKey().equals(key)){
				current.setNext(temp);
				current=current.getNext(); 
			}else{
				current.setValue(value+current.getValue()); 
			}
		}
		else{ 
			hashData[hashIndex]=temp; 
			current=temp;
		}
		current.addNumScore(); 
		size++; 
	}
	public Double get(String key) {
		int indexToGet = hash(key);
		HashEntry current = hashData[indexToGet];
		//gets to the index where the key is
		while(current != null && !current.getKey().equals(key)) {
			current = current.getNext();
		}
		if (current == null) {
			return -1.0;
		}

		return current.getValue();
	}
	public Integer getNumScores(String key){ 
		int indexToGet=hash(key); 
		HashEntry current = hashData[indexToGet]; 
		while (current!=null && !current.getKey().equals(key)){

			current=current.getNext();
		}
		if(current==null){ 
			return null; 
		}
		return current.getnum();
	}
	public int size() {
		return size;
	}
	public String toString() {
		String res = "";
		for(HashEntry temp : hashData) {
			if (temp != null) {
				HashEntry current = temp;
				while(current != null) {
					res += current.getKey() + " = " + current.getValue() + "\n";
					current = current.getNext();
				}
			}
		}
		return res;
	}
}
