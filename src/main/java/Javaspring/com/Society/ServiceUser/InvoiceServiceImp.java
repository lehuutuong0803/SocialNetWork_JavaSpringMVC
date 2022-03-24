package Javaspring.com.Society.ServiceUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Javaspring.com.Society.Converter.InvoiceConverter;
import Javaspring.com.Society.DTO.InvoiceDTO;
import Javaspring.com.Society.Entities.InvoiceEntity;
import Javaspring.com.Society.Entities.UserEntity;
import Javaspring.com.Society.Repository.InvoiceRepository;
import Javaspring.com.Society.Repository.UserRepository;

@Service
public class InvoiceServiceImp implements InvoiceService{
	
	@Autowired
	public InvoiceRepository invoiceRepository;
	@Autowired
	public InvoiceConverter invoiceConverter;
	@Autowired
	public UserRepository userRepository;
	
	@Override
	public List<InvoiceDTO> findAllByOwner_id(long id) {
		List<InvoiceEntity> invoiceEntityList = invoiceRepository.findAllByOwner_idOrderByIdDesc(id);
		List<InvoiceDTO> invoiceDTOList = new ArrayList<InvoiceDTO>();
		for(InvoiceEntity invoice : invoiceEntityList) {
			invoiceDTOList.add(invoiceConverter.toModel(invoice));
		}
		
		return invoiceDTOList;
	}

	@Override
	public InvoiceDTO save(InvoiceDTO invoiceDTO) {
		UserEntity owner = userRepository.findOneById(invoiceDTO.getOwner_id());
		UserEntity buyer = userRepository.findOneById(invoiceDTO.getBuyer_id());
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		InvoiceEntity invoiceEntity = invoiceConverter.toEntity(invoiceDTO);
		invoiceEntity.setBuyer(buyer);
		invoiceEntity.setOwner(owner);
		invoiceEntity.setCreateAt(date);
		if(invoiceDTO.getId() != 0) {
			invoiceEntity.setId(invoiceDTO.getId());
			invoiceEntity.setStatus(1);
		}
		InvoiceEntity invoice = invoiceRepository.save(invoiceEntity);
		
		return invoiceConverter.toModel(invoice);
	}

	@Override
	public List<InvoiceDTO> findAllByBuyer_id(long id) {
		List<InvoiceEntity> invoiceEntityList = invoiceRepository.findAllByBuyer_idOrderByIdDesc(id);
		List<InvoiceDTO> invoiceDTOList = new ArrayList<InvoiceDTO>();
		for(InvoiceEntity invoice : invoiceEntityList) {
			invoiceDTOList.add(invoiceConverter.toModel(invoice));
		}
		
		return invoiceDTOList;
	}

	@Override
	public List<InvoiceDTO> findAll() {
		List<InvoiceEntity> invoiceEntityList = invoiceRepository.findAll();
		List<InvoiceDTO> invoiceDTOList = new ArrayList<InvoiceDTO>();
		for(InvoiceEntity invoice : invoiceEntityList) {
			invoiceDTOList.add(invoiceConverter.toModel(invoice));
		}
		
		return invoiceDTOList;
	}

	@Override
	public InvoiceDTO findOneById(long id) {
		InvoiceEntity invoiceEntity = invoiceRepository.findOneById(id);
		return invoiceConverter.toModel(invoiceEntity);
	}

}
