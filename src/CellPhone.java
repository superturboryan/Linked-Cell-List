import java.util.*;

public class CellPhone {

	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	///////////////////////////////////////////////////////////////////////////
	
	public long getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	public CellPhone(long sn, String b, int y, double p) {
		this.serialNum = sn;
		this.brand = b;
		this.year = y;
		this.price = p;
	}
	
	public CellPhone(CellPhone c, long sn) {
		this.serialNum = sn;
		this.brand = c.getBrand();
		this.year = c.getYear();
		this.price = c.getPrice();
	}
	
	public CellPhone clone() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter a new serial # for the Cell Phone to be cloned: ");
		long newSN = kb.nextLong();
		kb.close();
		
		return new CellPhone(this, newSN);	
	}
	
	public String toString() {
		return serialNum + ": " + brand + " " + price + "$ " + year;	
	}
	
	public boolean equals(Object o) {
		
		if (o == null)
			return false;
		else if (this.getClass() != o.getClass())
			return false;
		else {	
			CellPhone c = (CellPhone)o;
			// EXPLICITLY RETURNS TRUE IF SERIAL # IS DIFFERENT
			return (this.getBrand().equals(c.getBrand())) && (this.getPrice() == c.getPrice()) && (this.getYear() == c.getYear());
		}
	}
	
}
