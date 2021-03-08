package com.cg.healthreminder.entity;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name="diseases_info")
public class Diseases {
	@Id
	@GeneratedValue
	public int dis_id;
	public String dis_name;
	public String dis_info;
	public String[] dis_keys;
	public int getDis_id() {
		return dis_id;
	}
	public void setDis_id(int dis_id) {
		this.dis_id = dis_id;
	}
	public String getDis_name() {
		return dis_name;
	}
	public void setDis_name(String dis_name) {
		this.dis_name = dis_name;
	}
	public String getDis_info() {
		return dis_info;
	}
	public void setDis_info(String dis_info) {
		this.dis_info = dis_info;
	}
	public String[] getDis_keys() {
		return dis_keys;
	}
	public void setDis_keys(String[] dis_keys) {
		this.dis_keys = dis_keys;
	}
	
}
