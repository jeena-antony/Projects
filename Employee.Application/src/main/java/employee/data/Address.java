package employee.data;

public class Address {
	private String city;
	private String state;
	private String country;
	private int pin;
	public Address(String city, String state, String country, int pin) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
		this.pin = pin;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	
	

}
