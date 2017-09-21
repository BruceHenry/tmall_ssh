package com.tmall.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.tmall.service.ProductImageService;
import com.tmall.util.ImageUtil;

public class ProductImageAction extends Action4Result {

	@Action("admin_productImage_list")
	public String list() {
		productSingleImages = productImageService.list("product", product, "type", ProductImageService.type_single);
		productDetailImages = productImageService.list("product", product, "type", ProductImageService.type_detail);
		t2p(product);
		return "listProductImage";
	}

	@Action("admin_productImage_add")
	public String add() {
		productImageService.save(productImage);
		String folder = "img/";
		if (ProductImageService.type_single.equals(productImage.getType())) {
			folder += "productSingle";
		} else {
			folder += "productDetail";
		}

		File imageFolder = new File(ServletActionContext.getServletContext().getRealPath(folder));
		File file = new File(imageFolder, productImage.getId() + ".jpg");
		String fileName = file.getName();
		try {
			FileUtils.copyFile(img, file);
			BufferedImage img = ImageUtil.change2jpg(file);
			ImageIO.write(img, "jpg", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (ProductImageService.type_single.equals(productImage.getType())) {
			String imageFolder_small = ServletActionContext.getServletContext().getRealPath("img/productSingle_small");
			String imageFolder_middle = ServletActionContext.getServletContext()
					.getRealPath("img/productSingle_middle");

			File f_small = new File(imageFolder_small, fileName);
			File f_middle = new File(imageFolder_middle, fileName);

			f_small.getParentFile().mkdirs();
			f_middle.getParentFile().mkdirs();

			ImageUtil.resizeImage(file, 56, 56, f_small);
			ImageUtil.resizeImage(file, 217, 190, f_middle);
		}
		return "listProductImagePage";
	}

	@Action("admin_productImage_delete")
	public String delete() {
		t2p(productImage);
		productService.delete(productImage);
		return "listProductImagePage";
	}
}
