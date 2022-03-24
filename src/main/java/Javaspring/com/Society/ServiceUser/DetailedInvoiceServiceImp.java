package Javaspring.com.Society.ServiceUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Javaspring.com.Society.Converter.DetailedInvoiceConverter;
import Javaspring.com.Society.DTO.CartDTO;
import Javaspring.com.Society.DTO.DetailedInvoiceDTO;
import Javaspring.com.Society.Entities.DetailedInvoiceEntity;
import Javaspring.com.Society.Entities.InvoiceEntity;
import Javaspring.com.Society.Entities.ProductEntity;
import Javaspring.com.Society.Repository.DetailedInvoiceRepository;
import Javaspring.com.Society.Repository.InvoiceRepository;
import Javaspring.com.Society.Repository.ProductRepository;

@Service
public class DetailedInvoiceServiceImp implements DetailedInvoiceService{
	@Autowired
	private DetailedInvoiceRepository detailedInvoiceRepository;
	@Autowired
	private DetailedInvoiceConverter detailedInvoiceConverter;
	@Autowired
	private ProductRepository  productRepository;
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Override
	public List<DetailedInvoiceDTO> findAllByInvoice_id(long id) {
		List<DetailedInvoiceEntity> detailedInvoiceEntityList = detailedInvoiceRepository.findAllByInvoice_id(id);
		List<DetailedInvoiceDTO> detailedInvoiceDTOList = new ArrayList<DetailedInvoiceDTO>();
		for(DetailedInvoiceEntity detail : detailedInvoiceEntityList) {
			detailedInvoiceDTOList.add(detailedInvoiceConverter.toModel(detail));
		}
		return detailedInvoiceDTOList;
	}

	@Override
	public void save(long id, HashMap<Long, CartDTO> invoice) {
		for(Map.Entry<Long, CartDTO> itemCart : invoice.entrySet()) {
			DetailedInvoiceDTO detailedInvoiceDTO = new DetailedInvoiceDTO();
			detailedInvoiceDTO.setInvoice_id(id);
			detailedInvoiceDTO.setProduct_id(itemCart.getValue().getProductDTO().getId());
			detailedInvoiceDTO.setAmount(itemCart.getValue().getQuantity());
			detailedInvoiceDTO.setPrice(itemCart.getValue().getTotalPrice());
			
			ProductEntity productEntity = productRepository.findOneById(detailedInvoiceDTO.getProduct_id());
			InvoiceEntity invoiceEntity = invoiceRepository.findOneById(detailedInvoiceDTO.getInvoice_id());
			DetailedInvoiceEntity detailedInvoiceEntity = detailedInvoiceConverter.toEntity(detailedInvoiceDTO);
			detailedInvoiceEntity.setProduct(productEntity);
			detailedInvoiceEntity.setInvoice(invoiceEntity);
			detailedInvoiceRepository.save(detailedInvoiceEntity);
	}
	}

	@Override
	public List<DetailedInvoiceDTO> findAll() {
		List<DetailedInvoiceEntity> detailedInvoiceEntityList = detailedInvoiceRepository.findAll();
		List<DetailedInvoiceDTO> detailedInvoiceDTOList = new ArrayList<DetailedInvoiceDTO>();
		for(DetailedInvoiceEntity detail : detailedInvoiceEntityList) {
			detailedInvoiceDTOList.add(detailedInvoiceConverter.toModel(detail));
		}
		return detailedInvoiceDTOList;
	}

	
}
