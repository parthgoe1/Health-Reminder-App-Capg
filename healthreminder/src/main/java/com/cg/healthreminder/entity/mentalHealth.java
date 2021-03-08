package com.cg.healthreminder.entity;

import javax.persistence.*;

@Entity
@Table(name="mentalhealth_info")
public class mentalHealth {
	@Id
	public int mental_rating;
	public String mental_tip;
	
	public int getMental_rating() {
		return mental_rating;
	}
	public void setMental_rating(int mental_rating) {
		this.mental_rating = mental_rating;
	}
	public String getMental_tip() {
		return mental_tip;
	}
	public void setMental_tip(String mental_tip) {
		this.mental_tip = mental_tip;
	}
}
