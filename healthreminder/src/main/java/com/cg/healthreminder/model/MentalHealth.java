/*
 * Author-> Shania Dalal
 * This is the Model Class for mentalHealth entity
 * 
 */
package com.cg.healthreminder.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="mentalhealth_info")
public class MentalHealth {
	@Id
	@Column(name = "mental_rating", nullable=false)
	@Min(1)
	@Max(10)
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
