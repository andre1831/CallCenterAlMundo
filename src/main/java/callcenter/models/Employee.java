package callcenter.models;


import java.util.concurrent.atomic.AtomicBoolean;


/**
 * @author Andrea
 *
 */
public class Employee {
	
	public static final int OPERATOR=1;
	public static final int SUPERVISOR=2;
	public static final int DIRECTOR=3;
	
	private String name;
	
	private AtomicBoolean isAvailable= new AtomicBoolean(true);
	
	private int type;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AtomicBoolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(AtomicBoolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public Employee(String name,int type){
		this.name=name;
		this.type=type;
	}
}
