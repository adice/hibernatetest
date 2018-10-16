package com.abc.cakeonline.type.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abc.cakeonline.entity.CakeType;
import com.abc.cakeonline.util.BaseDao;

public class CakeTypeDao {
	
	public List<CakeType> findAll(){
		Connection con=BaseDao.getCon();
		try {
			List<CakeType> list=new ArrayList<CakeType>();
			PreparedStatement pstm=con.prepareStatement("select * from tbl_type");
			ResultSet rs=pstm.executeQuery();
			while(rs.next()) {
				CakeType ct=new CakeType();
				ct.setId(rs.getInt(1));
				ct.setName(rs.getString(2));
				ct.setParentId(rs.getInt(3));
				list.add(ct);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
