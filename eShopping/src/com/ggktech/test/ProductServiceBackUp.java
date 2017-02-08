/*package com.ggktech.test;




	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;
	import java.util.List;
	import java.util.StringJoiner;

	import javax.servlet.http.HttpSession;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.MediaType;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
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
	public class ProductServiceBackUp {
		@Autowired
		private ProductDao productDao;

		@RequestMapping(value = "addItem", method = RequestMethod.GET)
		public String addProducts() {
			return "AddProduct";

		}

		@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
		@ResponseBody
		public String addProduct(@ModelAttribute ProductModel productModel,
				                 @RequestParam("image1") List<MultipartFile> files) {
			System.out.println("Inside Add Service1");
			System.out.println(files.size());

			StringJoiner sj = new StringJoiner(" , ");

			for (MultipartFile file : files) {
				System.out.println("for");
				
				 * if (file.isEmpty()) { continue; // next pls }
				 
				try {
					System.out.println("inside try");
					byte[] image = file.getBytes();
					Path path = Paths.get(file.getOriginalFilename());
					Files.write(path, image);

					sj.add(file.getOriginalFilename());

					productDao.addProduct(productModel,image);
					System.out.println("Inside Add Service");
					return "HomePage";
				} catch (IOException e) {
					e.printStackTrace();
					return "HomePage";
				}
			}
			return "HomePage";
		}

		@RequestMapping(value = "/ViewProduct", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public List<ProductModel> viewProductService() {
			List<ProductModel> list = productDao.viewProduct();
			// System.out.println("SericeProductView");
			return list;
		}

		@RequestMapping(value = "/SearchProduct/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public List<ProductModel> searchProductService(
				@PathVariable String productId, HttpSession session) {
			int userIdSession = (int) session.getAttribute("userIdSession");
			List<ProductModel> list = productDao.searchProductDao(productId,
					userIdSession);
			// System.out.println("SericeProductView");
			return list;
		}

	

}
*/