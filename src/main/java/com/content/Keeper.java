package com.content;

public class Keeper {
	private int keeperId;
	private String keeperName;
	private String keeperDate;
	private String keeperEmail;
	private String keeperPhone;
	private String keeperRank;
	
	public int getKeeperId() {
		return keeperId;
	}
	public void setKeeperId(int keeperId) {
		this.keeperId = keeperId;
	}
	public String getKeeperName() {
		return keeperName;
	}
	public void setKeeperName(String keeperName) {
		this.keeperName = keeperName;
	}
	public String getKeeperDate() {
		return keeperDate;
	}
	public void setKeeperDate(String keeperDate) {
		this.keeperDate = keeperDate;
	}
	public String getKeeperEmail() {
		return keeperEmail;
	}
	public void setKeeperEmail(String keeperEmail) {
		this.keeperEmail = keeperEmail;
	}
	public String getKeeperPhone() {
		return keeperPhone;
	}
	public void setKeeperPhone(String keeperPhone) {
		this.keeperPhone = keeperPhone;
	}
	public String getKeeperRank() {
		return keeperRank;
	}
	public void setKeeperRank(String keeperRank) {
		this.keeperRank = keeperRank;
	}
	public Keeper (int _keeperId,String _keeperName,String _keeperDate,String _keeperEmail,String _keeperPhone,String _keeperRank) {
		this.keeperId=_keeperId;
		this.keeperName=_keeperName;
		this.keeperDate=_keeperDate;
		this.keeperEmail=_keeperEmail;
		this.keeperPhone=_keeperPhone;
		this.keeperRank=_keeperRank;
	}
	public Keeper (String _keeperName,String _keeperDate,String _keeperEmail,String _keeperPhone,String _keeperRank) {
		this.keeperName=_keeperName;
		this.keeperDate=_keeperDate;
		this.keeperEmail=_keeperEmail;
		this.keeperPhone=_keeperPhone;
		this.keeperRank=_keeperRank;
	}

}
