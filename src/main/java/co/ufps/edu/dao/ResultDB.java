package co.ufps.edu.dao;

public class ResultDB {

	private int result;
	
	private long key;

	public ResultDB() {
		
	}
	
	public ResultDB(int result, long key) {
		super();
		this.setResult(result);
		this.setKey(key);
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public long getKey() {
		return key;
	}

	public void setKey(long key) {
		this.key = key;
	}
	
	
}
