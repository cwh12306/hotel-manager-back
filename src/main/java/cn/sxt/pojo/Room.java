package cn.sxt.pojo;

public class Room {
	private int rid;
	private int status;
	private int type;
	private int rno;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public Room(int rid, int status, int type, int rno) {
		super();
		this.rid = rid;
		this.status = status;
		this.type = type;
		this.rno = rno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Room(int rid, int status, int type) {
		super();
		this.rid = rid;
		this.status = status;
		this.type = type;
	}
}
