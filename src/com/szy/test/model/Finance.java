package com.szy.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Finance {
	
	private int id;
	private int studentid;
	private String status;
	private int tuitionfee;
	private int roomfee;
	private int classesfee;
	 @Id
	 @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTuitionfee() {
		return tuitionfee;
	}
	public void setTuitionfee(int tuitionfee) {
		this.tuitionfee = tuitionfee;
	}
	public int getRoomfee() {
		return roomfee;
	}
	public void setRoomfee(int roomfee) {
		this.roomfee = roomfee;
	}
	public int getClassesfee() {
		return classesfee;
	}
	public void setClassesfee(int classesfee) {
		this.classesfee = classesfee;
	}
	


}
