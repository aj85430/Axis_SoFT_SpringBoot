package com.manipal.bean;

public class ConversionRate {

	private String from;
	private String to;
	private double conversionMultiple;
	private String port;
	
	public ConversionRate() {}
	
	public ConversionRate(String from, String to,double conversionMultiple, String port) {
		super();
		this.from = from;
		this.to = to;
		this.conversionMultiple=conversionMultiple;
		this.port=port;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}

	public double getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(double conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	

}
