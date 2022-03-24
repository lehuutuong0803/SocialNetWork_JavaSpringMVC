package Javaspring.com.Society.ServiceUser;

import java.util.List;

import org.springframework.stereotype.Service;

import Javaspring.com.Society.DTO.InvoiceDTO;

@Service
public interface InvoiceService {
	public List<InvoiceDTO> findAll();
	public List<InvoiceDTO> findAllByOwner_id(long id);
	public List<InvoiceDTO> findAllByBuyer_id(long id);
	public InvoiceDTO save(InvoiceDTO invoiceDTO);
	public InvoiceDTO findOneById(long id);

}
