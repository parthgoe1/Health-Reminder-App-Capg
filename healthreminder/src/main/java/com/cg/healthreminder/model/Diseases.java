package com.cg.healthreminder.model;

import java.util.Arrays;

import javax.persistence.*;

@Entity
@Table(name="diseases_info")
public class Diseases {
	@Id
	@GeneratedValue
	private int dis_id;
	private String dis_name;
	private String dis_info;
	private String[] dis_keys;
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
	@Override
	public String toString() {
		return "Diseases [dis_id=" + dis_id + ", dis_name=" + dis_name + ", dis_info=" + dis_info + ", dis_keys="
				+ Arrays.toString(dis_keys) + "]";
	}
	public void setDis_keys(String[] dis_keys) {
		this.dis_keys = dis_keys;
	}
	
}
