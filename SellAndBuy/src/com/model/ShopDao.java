package com.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;

import com.jdbc.DBUtil;
import com.shop.BuyShop;
import com.shop.SellShop;
import com.shop.ShopInformation;

public class ShopDao {
	public void insetSellShop(SellShop sellshop) throws SQLException {
		ShopDao sd = new ShopDao();
		Vector<ShopInformation> v = new Vector<ShopInformation>();
		ShopInformation si = new ShopInformation();
		v = sd.selectSI(sellshop.getGoodID(), "");
		si = v.elementAt(0);
		if (si.getGoodNum() > sellshop.getNumber()) {
			Connection conn = DBUtil.getConnection();
			String sql = "insert into table_sellshop"
					+ "(SellID,GoodID,GoodPrice,Number,GoodUnit,SellDate)"
					+ "value( '" + sellshop.getSellID() + "',"
					+ sellshop.getGoodID() + "," + sellshop.getGoodPrice()
					+ "," + sellshop.getNumber() + ",'"
					+ sellshop.getGoodUnit() + "',current_date())";
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			int num = si.getGoodNum() - sellshop.getNumber();
			String sql1 = "" + "update table_shopinformation "
					+ " set GoodNum = " + num + " where GoodID = "
					+ sellshop.getGoodID();
			Statement st = conn.createStatement();
			st.execute(sql1);
		}

	}

	public void delSellShop(String id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "" + " delete from table_sellshop " + " where SellID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);

	}

	public void updateSellShop(SellShop sellshop) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = ""
				+ " update table_sellshop "
				+ " set GoodID = ?,GoodPrice = ?,Number = ?,GoodUnit = ?,SellDate = ? "
				+ "where SellID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, sellshop.getGoodID());
		ps.setFloat(2, sellshop.getGoodPrice());
		ps.setInt(3, sellshop.getNumber());
		ps.setString(4, sellshop.getGoodUnit());
		ps.setDate(5, new Date(sellshop.getSellDate().getTime()));
		ps.setString(6, sellshop.getSellID());

	}

	public Vector<SellShop> selectSellShop(String id, String goodid)
			throws SQLException {
		String whereS;
		if (id.equals("") && !goodid.equals("")) {
			whereS = " where" + " GoodID = '" + goodid + "'";
		} else if (goodid.equals("") && !id.equals("")) {
			whereS = " where" + " SellID ='" + id + "'";
		} else if (id.equals("") && goodid.equals("")) {
			whereS = "";
		} else {
			whereS = " where" + " SellID = " + id + " AND" + " GoodID = "
					+ goodid;
		}
		SellShop sellshop = null;
		Vector<SellShop> ve = new Vector();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from table_sellshop " + whereS;
		System.out.println(sql);
		Statement ps = conn.createStatement();
		ResultSet rs = ps.executeQuery(sql);
		while (rs.next()) {
			sellshop = new SellShop();
			sellshop.setSellID(rs.getString("SellID"));
			sellshop.setGoodID(rs.getString("GoodID"));
			sellshop.setGoodPrice(rs.getFloat("GoodPrice"));
			sellshop.setGoodUnit(rs.getString("GoodUnit"));
			sellshop.setNumber(rs.getInt("Number"));
			sellshop.setSellDate(rs.getDate("SellDate"));
			ve.add(sellshop);
		}
		return ve;
	}
	public Vector<SellShop> selectSellShopUseDate(java.util.Date from,
			java.util.Date to) throws SQLException {
		String whereS;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateFrom = "'" + sdf.format(from) + "'";
		String dateTo = "'" + sdf.format(to) + "'";
		whereS = " where " + "SellDate > " + dateFrom + " AND SellDate "
				+ " < " + dateTo;
		System.out.println(whereS);
		SellShop sellshop = null;
		Vector<SellShop> ve = new Vector();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from table_sellshop " + whereS;
		System.out.println(sql);
		Statement ps = conn.createStatement();
		ResultSet rs = ps.executeQuery(sql);
		while (rs.next()) {
			sellshop = new SellShop();
			sellshop.setSellID(rs.getString("SellID"));
			sellshop.setGoodID(rs.getString("GoodID"));
			sellshop.setGoodPrice(rs.getFloat("GoodPrice"));
			sellshop.setGoodUnit(rs.getString("GoodUnit"));
			sellshop.setNumber(rs.getInt("Number"));
			sellshop.setSellDate(rs.getDate("SellDate"));
			ve.add(sellshop);
		}
		return ve;
	}

	public Vector<BuyShop> selectBuyShop(String id, String goodid)
			throws SQLException {
		String whereS;
		if (id.equals("") && !goodid.equals("")) {
			whereS = " where" + " GoodNum = '" + goodid + "'";
		} else if (goodid.equals("") && !id.equals("")) {
			whereS = " where" + " BuyID ='" + id + "'";
		} else if (id.equals("") && goodid.equals("")) {
			whereS = "";
		} else {
			whereS = " where" + " BuyID = " + id + " AND" + " GoodNum = "
					+ goodid;
		}
		BuyShop buyshop;
		Vector<BuyShop> ve = new Vector();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from table_buyshop " + whereS;
		System.out.println(sql);
		Statement ps = conn.createStatement();
		ResultSet rs = ps.executeQuery(sql);
		while (rs.next()) {
			buyshop = new BuyShop();
			buyshop.setBuyID(rs.getString(1));
			buyshop.setGoodNum(rs.getString(2));
			buyshop.setGoodName(rs.getString(3));
			buyshop.setPrice(rs.getFloat(4));
			buyshop.setNumber(rs.getInt(5));
			buyshop.setBusinessName(rs.getString(6));
			buyshop.setGoodUnit(rs.getString(7));
			buyshop.setBuyDate(rs.getDate(8));
			ve.add(buyshop);
		}
		return ve;
	}

	public Vector<BuyShop> selectBuyShopUesDate(java.util.Date from, java.util.Date to)
			throws SQLException {
		String whereS;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateFrom = "'" + sdf.format(from) + "'";
		String dateTo = "'" + sdf.format(to) + "'";
		whereS = " where " + "BuyDate > " + dateFrom + " AND BuyDate "
				+ " < " + dateTo;
		System.out.println(whereS);
		BuyShop buyshop;
		Vector<BuyShop> ve = new Vector();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from table_buyshop " + whereS;
		System.out.println(sql);
		Statement ps = conn.createStatement();
		ResultSet rs = ps.executeQuery(sql);
		while (rs.next()) {
			buyshop = new BuyShop();
			buyshop.setBuyID(rs.getString(1));
			buyshop.setGoodNum(rs.getString(2));
			buyshop.setGoodName(rs.getString(3));
			buyshop.setPrice(rs.getFloat(4));
			buyshop.setNumber(rs.getInt(5));
			buyshop.setBusinessName(rs.getString(6));
			buyshop.setGoodUnit(rs.getString(7));
			buyshop.setBuyDate(rs.getDate(8));
			ve.add(buyshop);
		}
		return ve;
	}

	// public Vector<SellShop> selectSellShop(Date d1,Date d2) throws
	// SQLException{
	// SellShop sellshop = null;
	// Vector<SellShop> ve = new Vector();
	// Connection conn = DBUtil.getConnection();
	// String sql = ""+"select * from table_SellShop "
	// + " where SellID > ? AND SellID < ?";
	// PreparedStatement ps = conn.prepareStatement(sql);
	// ps.setDate(1, d1);
	// ps.setDate(2, d2);
	// ResultSet rs = ps.executeQuery();
	// while(rs.next()){
	// sellshop = new SellShop();
	// sellshop.setSellID(rs.getString("SellID"));
	// sellshop.setGoodID(rs.getString("GoodID"));
	// sellshop.setGoodPrice(rs.getFloat("GoodPrice"));
	// sellshop.setGoodUnit(rs.getString("GoodUnit"));
	// sellshop.setNumber(rs.getInt("Number"));
	// sellshop.setSellDate(rs.getDate("SellDate"));
	// ve.add(sellshop);
	// }
	//
	// return ve;
	// }
	// public ShopInformation selectSI(String goodid) throws SQLException{
	// ShopInformation shopin = null;
	// Connection conn = DBUtil.getConnection();
	// String sql = ""+"select * from table_shopinformation "
	// + " where GoodID = "+goodid;
	//
	// Statement ps = conn.createStatement() ;
	//
	// ResultSet rs = ps.executeQuery(sql);
	//
	// while(rs.next()){
	// shopin = new ShopInformation();
	// shopin.setGoodName(rs.getString("GoodName"));
	// shopin.setGoodID(rs.getString("GoodID"));
	// shopin.setGoodPrice(rs.getFloat("GoodPrice"));
	// shopin.setGoodUnit(rs.getString("GoodUnit"));
	// shopin.setGoodNum(rs.getInt("GoodNum"));
	// }
	// return shopin;
	// }
	public void insetBuyShop(BuyShop buyshop) throws SQLException {
		ShopDao sd = new ShopDao();
		Vector<ShopInformation> v = new Vector<ShopInformation>();
		ShopInformation si = new ShopInformation();
		v = sd.selectSI(buyshop.getGoodNum(), "");
		si = v.elementAt(0);
		Connection conn = DBUtil.getConnection();
		String sql = ""
				+ "insert into table_buyshop"
				+ "(BuyID,GoodNum,Price,Number,GoodUnit,BuyDate,GoodName,BusinessName)"
				+ "value(?,?,?,?,?,current_date(),?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, buyshop.getBuyID());
		ps.setString(2, buyshop.getGoodNum());
		ps.setFloat(3, buyshop.getPrice());
		ps.setInt(4, buyshop.getNumber());
		ps.setString(5, buyshop.getGoodUnit());
		ps.setString(6, buyshop.getGoodName());
		ps.setString(7, buyshop.getBusinessName());
		ps.execute();

		int num = si.getGoodNum() + buyshop.getNumber();
		String sql1 = "" + "update table_shopinformation " + " set GoodNum = "
				+ num + " where GoodID = " + buyshop.getGoodNum();
		Statement st = conn.createStatement();
		st.execute(sql1);
	}

	public void delBuyShop(String id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from table_buyshop " + " where BuyID = " + id;
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);

	}

	public void delShopIN(String id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "" + " delete from table_shopinformation "
				+ " where GoodID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.execute();
	}

	public void insetShopIn(ShopInformation shop) throws SQLException {

		Connection conn = DBUtil.getConnection();
		String sql = "" + "insert into table_shopinformation"
				+ "(GoodID,GoodName,GoodPrice,GoodNum,GoodUnit)"
				+ "value(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, shop.getGoodID());
		ps.setString(2, shop.getGoodName());
		ps.setFloat(3, shop.getGoodPrice());
		ps.setInt(4, shop.getGoodNum());
		ps.setString(5, shop.getGoodUnit());

		ps.execute();
	}

	public Vector<ShopInformation> selectSI(String id, String name)
			throws SQLException {
		String whereS;
		ShopInformation shopin = null;
		if (!id.equals("") && name.equals("")) {
			whereS = "where GoodID = " + id;
		} else if (id.equals("") && !name.equals("")) {
			whereS = "where GoodName = '" + name + "'";
		} else {
			whereS = "";
		}
		System.out.println(whereS);
		Vector<ShopInformation> ve = new Vector();
		Connection conn = DBUtil.getConnection();
		String sql = "" + "select * from table_shopinformation " + whereS;

		Statement ps = conn.createStatement();

		ResultSet rs = ps.executeQuery(sql);

		while (rs.next()) {
			shopin = new ShopInformation();
			shopin.setGoodName(rs.getString("GoodName"));
			shopin.setGoodID(rs.getString("GoodID"));
			shopin.setGoodPrice(rs.getFloat("GoodPrice"));
			shopin.setGoodUnit(rs.getString("GoodUnit"));
			shopin.setGoodNum(rs.getInt("GoodNum"));
			ve.add(shopin);
		}
		return ve;
	}
	public Vector<ShopInformation> selectSILikeID(String id)
			throws SQLException {
		String whereS;
		ShopInformation shopin = null;
		if(id.equals("")){
			whereS ="";
		}else{
			whereS ="where GoodID like "+"'%"+id+"%'";
		}
		System.out.println(whereS);
		Vector<ShopInformation> ve = new Vector();
		Connection conn = DBUtil.getConnection();
		String sql = "" + "select * from table_shopinformation " + whereS;

		Statement ps = conn.createStatement();

		ResultSet rs = ps.executeQuery(sql);

		while (rs.next()) {
			shopin = new ShopInformation();
			shopin.setGoodName(rs.getString("GoodName"));
			shopin.setGoodID(rs.getString("GoodID"));
			shopin.setGoodPrice(rs.getFloat("GoodPrice"));
			shopin.setGoodUnit(rs.getString("GoodUnit"));
			shopin.setGoodNum(rs.getInt("GoodNum"));
			ve.add(shopin);
		}
		return ve;
	}
	public Vector<ShopInformation> selectSILikeName(String name)
			throws SQLException {
		String whereS;
		ShopInformation shopin = null;
		if(name.equals("")){
			whereS ="";
		}else{
			whereS = "where GoodName like"+"'%"+name+"%'";
		}
		System.out.println(whereS);
		Vector<ShopInformation> ve = new Vector();
		Connection conn = DBUtil.getConnection();
		String sql = "" + "select * from table_shopinformation " + whereS;

		Statement ps = conn.createStatement();

		ResultSet rs = ps.executeQuery(sql);

		while (rs.next()) {
			shopin = new ShopInformation();
			shopin.setGoodName(rs.getString("GoodName"));
			shopin.setGoodID(rs.getString("GoodID"));
			shopin.setGoodPrice(rs.getFloat("GoodPrice"));
			shopin.setGoodUnit(rs.getString("GoodUnit"));
			shopin.setGoodNum(rs.getInt("GoodNum"));
			ve.add(shopin);
		}
		return ve;
	}
//	public void delSI(String id){
//		Connection conn = DBUtil.getConnection();
//		String sql = " delete from table_shopinformation "
//				+ " where GoodID = ?";
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setString(1, id);
//	}
}
