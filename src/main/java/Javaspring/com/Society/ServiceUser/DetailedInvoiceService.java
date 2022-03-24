package Javaspring.com.Society.ServiceUser;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import Javaspring.com.Society.DTO.CartDTO;
import Javaspring.com.Society.DTO.DetailedInvoiceDTO;

@Service
public interface DetailedInvoiceService {
	public List<DetailedInvoiceDTO> findAllByInvoice_id(long id);
	public List<DetailedInvoiceDTO> findAll();
	public void save(long id, HashMap<Long, CartDTO> invoice);

}
