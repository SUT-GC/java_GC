package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import com.model.ShopDao;
import com.shop.BuyShop;
import com.shop.SellShop;
import com.shop.ShopInformation;

public class DBUtil {
       private static final String url = "jdbc:mysql://127.0.0.1:3306/test";
       private static final String user = "root";
       private static final String password = "gc";
       private static Connection conn = null;
       static{
    	   try {
			Class.forName("com.mysql.jdbc.Driver");
			  conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
       public static Connection getConnection(){
    		return conn;
    	}
       public static void main(String[] args) throws Exception{
    	   SellShop s1 = new SellShop();
    	   ShopDao  shopdao = new ShopDao();
    	   BuyShop s3 = new BuyShop();
    	   ShopInformation s4 = new ShopInformation();
    	   Vector<SellShop> ve = shopdao.selectSellShop("1001", "1001");
    	   for(SellShop v : ve){
    		   System.out.println(v.toString());
    	   }
    	   s1.setGoodID("1001");
    	   s1.setSellID("1302");
    	   s1.setGoodPrice(5.0f);
    	   s1.setGoodUnit("斤");
    	   s1.setNumber(5);
//    	   s4.setGoodID("2003");
//    	   s4.setGoodName("hfuh");
//    	   s4.setGoodNum(45);
//    	   s4.setGoodPrice(21.5f);
//    	   s4.setGoodUnit("hdhfg");
//    	   s2.insetShopIn(s4);
//    	   s3.setBuyID("10111112");
//    	   s3.setGoodNum("1003");
//    	   s3.setPrice(3f);
//    	   s3.setGoodUnit("个");
//    	   s3.setNumber(12);
//    	   s3.setBuyDate(new Date());
//    	   s3.setBusinessName("jsfjd");
//    	   s3.setGoodName("hdjh");
//    	   shopdao.delBuyShop(s3.getBuyID());
//    	   shopdao.insetBuyShop(s3);
    		shopdao.insetSellShop(s1);
    	   
    	   //s2.updateSellShop(s1);
//    	   if(s2.insetSellShop(s1)){
//    		   System.out.println("YES!");
//    	   }
//    	   s2.delSellShop("1004");
//    	   ShopInformation s3 = new ShopInformation();
//    	   s3 = s2.selectSI("2001");
//    	   System.out.println(s3.toString());
       }
}