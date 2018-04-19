package callcenter.models;

/**
 * @author Andrea
 *
 */
public class Call {
	private String customerName;
	private int duration;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Call(String customerName){
		this.customerName=customerName;
		this.duration=(int) ((Math.random() * 5)+5)*1000;
	}
}
