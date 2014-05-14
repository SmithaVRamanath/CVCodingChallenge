package com.cv.vo;

import java.math.BigDecimal;
/**
 * Value Object or DTO for SchoolResults list.
 * 
 * @author Smitha
 *
 */
public class SchoolResult {

	private School school;
	private String subject;
	private BigDecimal latestY3;
	private BigDecimal latestY5;
	private BigDecimal latestY7;
	private BigDecimal latestY9;
	private BigDecimal rawGainY3Y5;
	private BigDecimal factoredGainY3Y5;
	private BigDecimal glgY3Y5;
	private int latestGainInGainY3Y5;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public BigDecimal getLatestY3() {
		return latestY3;
	}

	public void setLatestY3(BigDecimal latestY3) {
		this.latestY3 = latestY3;
	}

	public BigDecimal getLatestY5() {
		return latestY5;
	}

	public void setLatestY5(BigDecimal latestY5) {
		this.latestY5 = latestY5;
	}

	public BigDecimal getLatestY7() {
		return latestY7;
	}

	public void setLatestY7(BigDecimal latestY7) {
		this.latestY7 = latestY7;
	}

	public BigDecimal getLatestY9() {
		return latestY9;
	}

	public void setLatestY9(BigDecimal latestY9) {
		this.latestY9 = latestY9;
	}

	public BigDecimal getRawGainY3Y5() {
		return rawGainY3Y5;
	}

	public void setRawGainY3Y5(BigDecimal rawGainY3Y5) {
		this.rawGainY3Y5 = rawGainY3Y5;
	}

	public BigDecimal getFactoredGainY3Y5() {
		return factoredGainY3Y5;
	}

	public void setFactoredGainY3Y5(BigDecimal factoredGainY3Y5) {
		this.factoredGainY3Y5 = factoredGainY3Y5;
	}

	public BigDecimal getGlgY3Y5() {
		return glgY3Y5;
	}

	public void setGlgY3Y5(BigDecimal glgY3Y5) {
		this.glgY3Y5 = glgY3Y5;
	}

	public int getLatestGainInGainY3Y5() {
		return latestGainInGainY3Y5;
	}

	public void setLatestGainInGainY3Y5(int latestGainInGainY3Y5) {
		this.latestGainInGainY3Y5 = latestGainInGainY3Y5;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}
}

