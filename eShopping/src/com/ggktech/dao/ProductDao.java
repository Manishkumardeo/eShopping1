package com.ggktech.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ggktech.model.ProductModel;

@Repository
public class ProductDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean addProduct(ProductModel productModel, byte[] image1,
			byte[] image2, byte[] image3, byte[] image4) {
		String sql = "insert into product (productName,brand,color,description,price,imagefront,imagebottom,imageside,imageback,itemCount) values(?,?,?,?,?,?,?,?,?,?)";
		//String sql = "insert into product (productName,brand,color,description,price,imagefront,itemCount) values(?,?,?,?,?,?,?)";
		jdbcTemplate
				.update(sql,
						new Object[] { productModel.getProductName(),
								productModel.getBrand(),
								productModel.getColor(),
								productModel.getDescription(),
								productModel.getPrice(),
								image1,image2,image3,image4,
								/*productModel.getImagebottom(),
								productModel.getImageside(),
								productModel.getImageback(),*/
								productModel.getItemCount(),
								});
		System.out.println("Add Dao");
		return true;
		

	}

	public  List<Map<String,Object>> viewProductImage(String productName) {
		String sql="select imagefront,imagebottom,imageside,imageback from product where productName=?";
		List<Map<String,Object>> imageList=jdbcTemplate.queryForList(sql,  new Object[]{productName});
		//List<ProductModel> productModel=jdbcTemplate.query(sql, new ProductMapperDao());
		return imageList;
		
	}
	
	/*public  List<ProductModel> viewProductDetailWithImage(String productName) {
		System.out.println("View Dao");
		String sql="select productName,brand,color, categoryId,description, price from product";
		List<ProductModel> list=jdbcTemplate.query(sql,   new Object[]{productName},new ProductMapperDao());
		System.out.println("Mapper");
		return list;
		
	}*/

	public  List<ProductModel> addDetailWithImage() {
		//System.out.println("View Dao");
		String sql="select productName,brand,color,description, price from product";
		List<ProductModel> details=jdbcTemplate.query(sql,  new ProductMapperDao());
		//System.out.println("add Detail");
	
		return details;
		
	}
	public List<ProductModel> searchProductDao(String productName) {
		String sql="select  productName,brand,color,description, price from product where productName=?";
		List<ProductModel >list=jdbcTemplate.query(sql, new ProductMapperDao(), new Object[]{productName});
		System.out.println(list.size()+" size");
		return list;
	}
	
	
	public List<Map<String, Object>> searchProductDaoImage(String productName) {
		System.out.println(productName+"In image dao search");
		String sql="select imagefront,imagebottom,imageside,imageback from product where productName=?";
		List<Map<String,Object>> imageList=jdbcTemplate.queryForList(sql,  new Object[]{productName});
		return imageList;
	}

}
