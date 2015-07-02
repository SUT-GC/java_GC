package com.shop;

public class ShopInformation {
     
	private String GoodName;
	private String GoodID;
	private float  GoodPrice;
	private Integer GoodNum;
	private String GoodUnit;
	
	@Override
	public String toString() {
		return "ShopInformation [GoodName=" + GoodName + ", GoodID=" + GoodID
				+ ", GoodPrice=" + GoodPrice + ", GoodNum=" + GoodNum
				+ ", GoodUnit=" + GoodUnit + "]";
	}

	public String getGoodName() {
		return GoodName;
	}

	public void setGoodName(String goodName) {
		GoodName = goodName;
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

	
	public Integer getGoodNum() {
		return GoodNum;
	}

	public void setGoodNum(Integer goodNum) {
		GoodNum = goodNum;
	}

	public String getGoodUnit() {
		return GoodUnit;
	}

	public void setGoodUnit(String goodUnit) {
		GoodUnit = goodUnit;
	}
}
