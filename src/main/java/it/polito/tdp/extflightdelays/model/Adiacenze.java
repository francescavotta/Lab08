package it.polito.tdp.extflightdelays.model;

public class Adiacenze {
	private int id1;
	private int id2;
	private int distance;
	private int num;
	
	public Adiacenze(int id1, int id2, int distance, int num) {
		super();
		this.id1 = id1;
		this.id2 = id2;
		this.distance = distance;
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public int getId2() {
		return id2;
	}
	public void setId2(int id2) {
		this.id2 = id2;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	@Override
	public String toString() {
		return "Adiacenze [id1=" + id1 + ", id2=" + id2 + ", distance=" + distance + "]\n";
	}
	

}
