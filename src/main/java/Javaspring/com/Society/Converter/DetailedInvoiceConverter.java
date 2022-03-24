package Javaspring.com.Society.Converter;

import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.stereotype.Component;

import Javaspring.com.Society.DTO.DetailedInvoiceDTO;
import Javaspring.com.Society.Entities.DetailedInvoiceEntity;

@Component
public class DetailedInvoiceConverter {
		
	public DetailedInvoiceDTO toModel(DetailedInvoiceEntity detailedInvoiceEntity) {
		DetailedInvoiceDTO detailedInvoiceDTO = new DetailedInvoiceDTO();
		detailedInvoiceDTO.setId(detailedInvoiceEntity.getId());
		detailedInvoiceDTO.setAmount(detailedInvoiceEntity.getAmount());
		detailedInvoiceDTO.setPrice(detailedInvoiceEntity.getPrice());
		detailedInvoiceDTO.setInvoice_id(detailedInvoiceEntity.getInvoice().getId());
		detailedInvoiceDTO.setProduct_id(detailedInvoiceEntity.getProduct().getId());

		Locale localeEN = new Locale("en", "EN");
	    NumberFormat en = NumberFormat.getInstance(localeEN);
	    detailedInvoiceDTO.setFormatCurrency(en.format(detailedInvoiceDTO.getPrice()));
		
		return detailedInvoiceDTO;
	}
	
	public DetailedInvoiceEntity toEntity(DetailedInvoiceDTO detailedInvoiceDTO) {
		DetailedInvoiceEntity detailedInvoiceEntity = new DetailedInvoiceEntity();
		detailedInvoiceEntity.setAmount(detailedInvoiceDTO.getAmount());
		detailedInvoiceEntity.setPrice(detailedInvoiceDTO.getPrice());
		
		return detailedInvoiceEntity;
	}

}
