package com.ggktech.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ggktech.dao.ProductDao;
import com.ggktech.model.ProductModel;

@Controller
public class ProductService {
	@Autowired
	private ProductDao productDao;

	@RequestMapping(value = "addItem", method = RequestMethod.GET)
	public String addProducts() {
		return "AddProduct";

	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	@ResponseBody
	public String addProduct(@ModelAttribute ProductModel productModel,
			                 @RequestParam("image1") MultipartFile files1,
			                 @RequestParam("image2") MultipartFile files2,
			                 @RequestParam("image3") MultipartFile files3,
			                 @RequestParam("image4") MultipartFile files4) {
		//System.out.println("Inside Add Service1");
		//System.out.println(files1);
		
		//saveToDiskImage(files1,files2,files3,files4);
		
			try {
				System.out.println("inside try");
				byte[] image1 = files1.getBytes();
				Path path1 = Paths.get(files1.getOriginalFilename());
				Files.write(path1, image1);
				
				byte[] image2 = files2.getBytes();
				Path path2 = Paths.get(files2.getOriginalFilename());
				Files.write(path2, image2);
				
				byte[] image3 = files3.getBytes();
				Path path3 = Paths.get(files3.getOriginalFilename());
				Files.write(path3, image3);
				
				byte[] image4 = files4.getBytes();
				Path path4 = Paths.get(files4.getOriginalFilename());
				Files.write(path4, image4);

				//sj.add(file.getOriginalFilename());

				productDao.addProduct(productModel,image1,image2,image3,image4);
				//System.out.println("Inside Add Service");
				return "HomePage";
			} catch (IOException e) {
				e.printStackTrace();
				return "HomePage";
			}
		//return "HomePage";
	}
	
	/*public void saveToDiskImage(MultipartFile files1, MultipartFile files2, MultipartFile files3, MultipartFile files4){
		String uploadFileLocation="E://eShoppingImage/"+files1.getOriginalFilename();//+files2.getOriginalFilename()+files3.getOriginalFilename()+files4.getOriginalFilename();
		
		try{
			OutputStream out=new FileOutputStream(new File(uploadFileLocation));
			byte[] image1 = files1.getBytes();
			Path path1 = Paths.get(files1.getOriginalFilename());
			Files.write(path1, image1);
			
			out.flush();
			out.close();
				
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}*/

	@RequestMapping(value = "/viewProduct/{productName}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] viewProductImageService(@PathVariable String productName) throws IOException  {
		int count=1;
		byte[] image = null;
		List<Map<String,Object>> list = productDao.viewProductImage(productName);
		//System.out.println("SericeProductView");
		if((list!= null) || (list.size()>0)){
		for(Map<String, Object> map:list){
			image=(byte[]) map.get("imageside");//database image column name
			

		}
		} 
		return image;
	}
		

	@RequestMapping(value = "/addDetailsProductJson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProductModel> addDetailWithImageService() {
		List<ProductModel> list = productDao.addDetailWithImage();
		// System.out.println("Add json return");
		return list;
	}
	
	
	
	@RequestMapping(value = "/searchProduct/{productName}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] searchProductService(
			@PathVariable String productName, HttpSession session) {
		//int userIdSession = (int) session.getAttribute("userIdSession");
		System.out.println("productName image "+productName);
		
		byte[] imageView = null;
		List<Map<String, Object>> list = productDao.searchProductDaoImage(productName);
				
		if ((list != null) || (list.size() > 0)) {
			for (Map<String, Object> row : list) {
				imageView = (byte[]) (row.get("imagefront"));
			}
		}
		System.out.println("Return "+imageView);
		return imageView;
	}
	
	
	@RequestMapping(value = "/searchDetailsProductJson/{productName}", method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProductModel> searchDetailWithImageService(@PathVariable String productName) {
		List<ProductModel> list = productDao.searchProductDao(productName);
		return list;
	}
	
	
	
	@RequestMapping(value="/buy/{productName}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	//@ResponseBody
	public String buyProduct(@PathVariable String productName ,HttpSession session){
		String userLogin="loogedIn";
		session.setAttribute("buyProductName", productName);
		System.out.println("productName " +productName);
		System.out.println("From session "+session.getAttribute("buyProductName"));
		if(userLogin.equals(session.getAttribute("loogedIn"))){
			System.out.println("Going to payment option");
			return "PaymentGateWay";
		}else{
		return "LoginTest";
		
		}
	}
}
