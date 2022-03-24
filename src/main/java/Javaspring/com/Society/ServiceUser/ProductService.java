package Javaspring.com.Society.ServiceUser;

import java.util.List;

import org.springframework.stereotype.Service;

import Javaspring.com.Society.DTO.ProductDTO;

@Service
public interface ProductService {
	public List<ProductDTO> findAll();
	public List<ProductDTO> findAllByUser_id(long id);
	public void save(ProductDTO productDTO);
	public ProductDTO findOneById(long id);
	
}
