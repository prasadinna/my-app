package com.bid.app.server.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app_user")
public class User {
	private int id;
	private long mobileNumber;
	private String deviceId;
	private String subscriberId;
	private String simSerialNumber;
	private String networkCountryISO;
	private String simCountryISO;
	private String imeiNumber;
	
	protected User(){
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="MOBILE_NUMBER")
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Column(name="DEVICE_ID")
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	@Column(name="SUBSCRIBER_ID")
	public String getSubscriberId() {
		return subscriberId;
	}
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}
	@Column(name="SERIAL_NUMBER")
	public String getSimSerialNumber() {
		return simSerialNumber;
	}
	public void setSimSerialNumber(String simSerialNumber) {
		this.simSerialNumber = simSerialNumber;
	}
	@Column(name="NETWORK_COUNTRY_ISO")
	public String getNetworkCountryISO() {
		return networkCountryISO;
	}
	public void setNetworkCountryISO(String networkCountryISO) {
		this.networkCountryISO = networkCountryISO;
	}
	@Column(name="SIM_COUNTRY_ISO")
	public String getSimCountryISO() {
		return simCountryISO;
	}
	public void setSimCountryISO(String simCountryISO) {
		this.simCountryISO = simCountryISO;
	}
	@Column(name="IMEI_NUMBER")
	public String getImeiNumber() {
		return imeiNumber;
	}
	public void setImeiNumber(String imeiNumber) {
		this.imeiNumber = imeiNumber;
	}


}
