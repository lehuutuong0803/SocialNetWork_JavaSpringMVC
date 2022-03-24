package Javaspring.com.Society.Converter;

import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.stereotype.Component;

import Javaspring.com.Society.DTO.ProductDTO;
import Javaspring.com.Society.Entities.ProductEntity;

@Component
public class ProductConverter {
	
	public ProductDTO toModel(ProductEntity productEntity) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(productEntity.getId());
		productDTO.setAmount(productEntity.getAmount());
		productDTO.setCreateat(productEntity.getCreateat());
		productDTO.setNote(productEntity.getNote());
		productDTO.setPrice(productEntity.getPrice());
		productDTO.setProduct_name(productEntity.getProduct_name());
		productDTO.setStatus(productEntity.getStatus());
		productDTO.setUser_id(productEntity.getUser().getId());
		productDTO.setImage(productEntity.getImage());
		
		Locale localeEN = new Locale("en", "EN");
	    NumberFormat en = NumberFormat.getInstance(localeEN);
	    productDTO.setFormatCurrency(en.format(productEntity.getPrice()));
		
		return productDTO;
	}
	
	public ProductEntity toEntity(ProductDTO productDTO) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setAmount(productDTO.getAmount());
		productEntity.setCreateat(productDTO.getCreateat());
		productEntity.setNote(productDTO.getNote());
		productEntity.setPrice(productDTO.getPrice());
		productEntity.setProduct_name(productDTO.getProduct_name());
		productEntity.setStatus(productDTO.getStatus());
		productEntity.setImage(productDTO.getImage());
		
		return productEntity;
	}

}
