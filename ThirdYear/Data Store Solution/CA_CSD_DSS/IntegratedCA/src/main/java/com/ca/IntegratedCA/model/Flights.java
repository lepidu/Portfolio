package com.ca.IntegratedCA.model;
/* INTEGRATED CA - DATA STORAGE SOLUTIONS / COMMERCIAL SOLUTIONS DESIGN
 * Xiaohui Weng - 2020387  
 * Leisly Pino 2020303 
 * Yuri Ribeiro 2020347
 * */
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// map MongoDB collection "flights"
@Document(collection = "flights")
public class Flights {

	@Id
	private String _id;
	private int Year;
	private int Month;
	private int DayofMonth;
	private double DepTime;
	private double CRSDepTime;
	private double ArrTime;
	private double CRSArrTime;
	private String Origin;
	private String Dest;
	private double Distance;
	
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public int getMonth() {
		return Month;
	}
	public void setMonth(int month) {
		Month = month;
	}
	public int getDayofMonth() {
		return DayofMonth;
	}
	public void setDayofMonth(int dayofMonth) {
		DayofMonth = dayofMonth;
	}
	public double getDepTime() {
		return DepTime;
	}
	public void setDepTime(double depTime) {
		DepTime = depTime;
	}
	public double getCRSDepTime() {
		return CRSDepTime;
	}
	public void setCRSDepTime(double cRSDepTime) {
		CRSDepTime = cRSDepTime;
	}
	public double getArrTime() {
		return ArrTime;
	}
	public void setArrTime(double arrTime) {
		ArrTime = arrTime;
	}
	public double getCRSArrTime() {
		return CRSArrTime;
	}
	public void setCRSArrTime(double cRSArrTime) {
		CRSArrTime = cRSArrTime;
	}
	public String getOrigin() {
		return Origin;
	}
	public void setOrigin(String origin) {
		Origin = origin;
	}
	public String getDest() {
		return Dest;
	}
	public void setDest(String dest) {
		Dest = dest;
	}
	public double getDistance() {
		return Distance;
	}
	public void setDistance(double distance) {
		Distance = distance;
	}
	public String get_id() {
		return _id;
	}
	
	public Flights() {
		
	}
	
}
