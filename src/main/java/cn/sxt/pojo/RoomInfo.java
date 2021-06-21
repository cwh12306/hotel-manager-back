package cn.sxt.pojo;

import java.util.List;

public class RoomInfo {
	private String rname;
	private double price;
	private int count;
	private String image;
	private String description;
	private List<Integer> rnos;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public RoomInfo(String rname, double price, String image, String description,List<Integer> rnos) {
		super();
		this.rname = rname;
		this.price = price;
		this.image = image;
		this.description = description;
		this.rnos = rnos;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "RoomInfo [price=" + price + ", count=" + count + "]";
	}

	public RoomInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addCount() {
		this.count++;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public List<Integer> getRnos() {
		return rnos;
	}

	public void setRnos(List<Integer> rnos) {
		this.rnos = rnos;
	}

}
