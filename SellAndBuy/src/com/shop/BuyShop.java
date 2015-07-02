package com.shop;

import java.util.Date;

public class BuyShop {
     private String BuyID;
     private String GoodNum;
     private float Price;
     private Integer Number;
     private String BusinessName;
     private String GoodUnit;
     private Date BuyDate;
     private String GoodName;

	@Override
	public String toString() {
		return "BuyShop [BuyID=" + BuyID + ", GoodNum=" + GoodNum + ", Price="
				+ Price + ", Number=" + Number + ", BusinessName="
				+ BusinessName + ", GoodUnit=" + GoodUnit + ", BuyDate="
				+ BuyDate + ", GoodName=" + GoodName + "]";
	}

	public String getGoodName() {
		return GoodName;
	}

	public void setGoodName(String goodName) {
		GoodName = goodName;
	}     
	public String getBuyID() {
		return BuyID;
	}

	public void setBuyID(String buyID) {
		BuyID = buyID;
	}

	public String getGoodNum() {
		return GoodNum;
	}

	public void setGoodNum(String goodNum) {
		GoodNum = goodNum;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public Integer getNumber() {
		return Number;
	}

	public void setNumber(Integer number) {
		Number = number;
	}

	public String getBusinessName() {
		return BusinessName;
	}

	public void setBusinessName(String businessName) {
		BusinessName = businessName;
	}

	public String getGoodUnit() {
		return GoodUnit;
	}

	public void setGoodUnit(String goodUnit) {
		GoodUnit = goodUnit;
	}

	public Date getBuyDate() {
		return BuyDate;
	}

	public void setBuyDate(Date buyDate) {
		BuyDate = buyDate;
	}
}
