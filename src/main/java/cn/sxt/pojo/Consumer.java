package cn.sxt.pojo;


public class Consumer {
	private int id;
	private String uid;
	private String uname;
	private String phone;
	private int rno;
	private int sex;
	private int cdays;
	private double payment;
	private double price;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Consumer(int id, String uid, String uname, String phone, int rno, int sex, int cdays, double payment) {
		super();
		this.id = id;
		this.uid = uid;
		this.uname = uname;
		this.phone = phone;
		this.rno = rno;
		this.sex = sex;
		this.cdays = cdays;
		this.payment = payment;
	}
	public int getCdays() {
		return cdays;
	}
	public void setCdays(int cdays) {
		this.cdays = cdays;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public Consumer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Consumer [id=" + id + ", uid=" + uid + ", uname=" + uname + ", phone=" + phone + ", rno=" + rno
				+ ", sex=" + sex + ", cdays=" + cdays + ", payment=" + payment + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Consumer(int id, String uid, String uname, String phone, int rno, int sex) {
		super();
		this.id = id;
		this.uid = uid;
		this.uname = uname;
		this.phone = phone;
		this.rno = rno;
		this.sex = sex;
	}
}
