package com.ems.EMS.model;

import java.util.List;

public class Performance {
	private int empId;
	double rating;
	String feedback;
	List<String> projectHandled;
	boolean eligibleForPromotion;
	
	public Performance() {};
	
	public Performance(int empId, double rating, String feedback, List<String> projectHandled,
			boolean eligibleForPromotion) {
		super();
		this.empId = empId;
		this.rating = rating;
		this.feedback = feedback;
		this.projectHandled = projectHandled;
		this.eligibleForPromotion = eligibleForPromotion;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public List<String> getProjectHandled() {
		return projectHandled;
	}
	public void setProjectHandled(List<String> projectHandled) {
		this.projectHandled = projectHandled;
	}
	public boolean isEligibleForPromotion() {
		return eligibleForPromotion;
	}
	public void setEligibleForPromotion(boolean eligibleForPromotion) {
		this.eligibleForPromotion = eligibleForPromotion;
	}
	@Override
	public String toString() {
		return "Performance [empId=" + empId + ", rating=" + rating + ", feedback=" + feedback + ", projectHandled="
				+ projectHandled + ", eligibleForPromotion=" + eligibleForPromotion + "]";
	}
	
	
}
