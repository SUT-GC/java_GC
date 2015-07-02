package com.shop;

import java.util.Date;

public class SellShop {
	public String toString() {
		return "SellShop [SellID=" + SellID + ", GoodID=" + GoodID
				+ ", GoodPrice=" + GoodPrice + ", Number=" + Number
				+ ", GoodUnit=" + GoodUnit + ", SellDate=" + SellDate + "]";
	}

	private String SellID;
      private String GoodID;
      private float GoodPrice;
      private Integer Number;
      private String GoodUnit;
      private Date SellDate;
      
	public String getSellID() {
		return SellID;
	}

	public void setSellID(String sellID) {
		SellID = sellID;
	}

	public String getGoodID() {
		return GoodID;
	}

	public void setGoodID(String goodID) {
		GoodID = goodID;
	}

	public float getGoodPrice() {
		return GoodPrice;
	}

	public void setGoodPrice(float goodPrice) {
		GoodPrice = goodPrice;
	}

	public Integer getNumber() {
		return Number;
	}

	public void setNumber(Integer number) {
		Number = number;
	}

	public String getGoodUnit() {
		return GoodUnit;
	}

	public void setGoodUnit(String goodUnit) {
		GoodUnit = goodUnit;
	}

	public Date getSellDate() {
		return SellDate;
	}

	public void setSellDate(Date sellDate) {
		SellDate = sellDate;
	}
}
