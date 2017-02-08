package com.ggktech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ggktech.model.ProductModel;

public class ProductMapperDao implements RowMapper<ProductModel>{

	@Override
	public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductModel productModel=new ProductModel();
		//productModel.setProductId(rs.getString(1));
		productModel.setProductName(rs.getString(1));
		productModel.setBrand(rs.getString(2));
		productModel.setColor(rs.getString(3));
		productModel.setDescription(rs.getString(4));
		productModel.setPrice(rs.getDouble(5));
		/*productModel.setImagefront(rs.getString(7));
		productModel.setImagebottom(rs.getString(8));
		productModel.setImageside(rs.getString(9));
		productModel.setItemCount(rs.getInt(10));*/
	//	productModel.setDiscount(rs.getDouble(9));
		return productModel;
		
	}

}
