//author->Shania Dalal
package com.cg.healthreminder.model;

import javax.persistence.*;

@Entity
@Table(name="mentalhealth_info")
public class mentalHealth {
	@Id
	@Column(name = "mental_rating", nullable=false)
	private int mentalRating;
	@Column(name = "mental_tip")
	private String mentalTip;
	public int getMentalRating() {
		return mentalRating;
	}
	public void setMentalRating(int mentalRating) {
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
