//author->Shania Dalal
package com.cg.healthreminder.model;

import javax.persistence.*;

@Entity
@Table(name="mentalhealth_info")
public class mentalHealth {
	@Id
	@Column(name = "mental_rating", nullable=false)
	private Integer mentalRating;
	@Column(name = "mental_tip")
	private String mentalTip;
	public Integer getMentalRating() {
		return mentalRating;
	}
	public void setMentalRating(Integer mentalRating) {
		this.mentalRating = mentalRating;
	}
	public String getMentalTip() {
		return mentalTip;
	}
	public void setMentalTip(String mentalTip) {
		this.mentalTip = mentalTip;
	}
	@Override
	public String toString() {
		return "mentalHealth [mentalRating=" + mentalRating + ", mentalTip=" + mentalTip + "]";
	}
	
	
}
