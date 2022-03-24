package Javaspring.com.Society.ServiceUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Javaspring.com.Society.Converter.ProductConverter;
import Javaspring.com.Society.DTO.ProductDTO;
import Javaspring.com.Society.Entities.ProductEntity;
import Javaspring.com.Society.Entities.UserEntity;
import Javaspring.com.Society.Repository.ProductRepository;
import Javaspring.com.Society.Repository.UserRepository;

@Service
public class ProductServiceImp  implements ProductService{

	@Autowired
	public ProductRepository productRepository;
	@Autowired
	public ProductConverter productConverter;
	@Autowired
	public UserRepository userRepository;
	
	@Override
	@Transactional
	public List<ProductDTO> findAllByUser_id(long id) {
		List<ProductEntity> productEntitiyList = productRepository.findAllByUser_id(id);
		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
		for(ProductEntity product : productEntitiyList) {
			productDTOList.add(productConverter.toModel(product));
		}
		return productDTOList;
	}

	@Override
	@Transactional
	public void save(ProductDTO productDTO) {
		UserEntity user = userRepository.findOneById(productDTO.getUser_id());
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		ProductEntity productEntity = productConverter.toEntity(productDTO);
		productEntity.setUser(user);
		productEntity.setCreateat(date);
		productRepository.save(productEntity);
		
	}
	@Override
	@Transactional
	public ProductDTO findOneById(long id) {
		ProductEntity productEntity = productRepository.findOneById(id);
		return productConverter.toModel(productEntity);
	}

	@Override
	@Transactional
	public List<ProductDTO> findAll() {
		List<ProductEntity> productEntitiyList = productRepository.findAll();
		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
		for(ProductEntity product : productEntitiyList) {
			productDTOList.add(productConverter.toModel(product));
		}
		return productDTOList;
	}

}
