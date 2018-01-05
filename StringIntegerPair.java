package walmart.assessment.solution.two;
/**
 * POJO class to hold value and count of the word frequency.
 * */  
public class StringIntegerPair {
	String value;
	Integer count;
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public Integer getCount() {
		return count;
	}
	
	public void setCount(Integer count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "StringIntegerPair [value=" + value + ", count=" + count + "]";
	}
}
