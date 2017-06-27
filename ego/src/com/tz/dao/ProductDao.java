package com.tz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.tanzhou.jdbc.util.MJdbcTemplate;
import com.tanzhou.jdbc.util.MRowMapper;
import com.tz.entity.Productinfo;

public class ProductDao {
	static MJdbcTemplate mj = new MJdbcTemplate();
	
	/**
	 * 得到所有的商品集合
	 * @return
	 */
	public static List<Productinfo> getProList(){
		List<Productinfo> list = mj.queryForList(new MRowMapper<Productinfo>() {
			@Override
			public Productinfo mappingRow(ResultSet rs, int rownum)
					throws SQLException {
				Productinfo p = new Productinfo();
				//productid productname price p_typeid pic description qty
				p.setProductid(rs.getInt("productid"));
				p.setProductname(rs.getString("productname"));
				p.setPrice(rs.getDouble("price"));
				p.setPic(rs.getString("pic"));
				p.setP_typeid(rs.getInt("p_typeid"));
				p.setDescription(rs.getString("description"));
				p.setQty(rs.getInt("qty"));
				return p;
			}
		} , "select * from productinfo", null);
		return list;
	}
	
	
	public static Productinfo getPro(String id){
		Productinfo pro = mj.queryForObject(new MRowMapper<Productinfo>() {
			@Override
			public Productinfo mappingRow(ResultSet rs, int rownum)
					throws SQLException {
				Productinfo p = new Productinfo();
				//productid productname price p_typeid pic description qty
				p.setProductid(rs.getInt("productid"));
				p.setProductname(rs.getString("productname"));
				p.setPrice(rs.getDouble("price"));
				p.setPic(rs.getString("pic"));
				p.setP_typeid(rs.getInt("p_typeid"));
				p.setDescription(rs.getString("description"));
				p.setQty(rs.getInt("qty"));
				return p;
			}
		} , "select * from productinfo where productid = ?", Integer.parseInt(id));
		return pro;
	}
//	public static void main(String[] args) {
//		System.out.println(getProList());
//	}
}
