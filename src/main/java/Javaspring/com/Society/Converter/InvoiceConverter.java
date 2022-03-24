package Javaspring.com.Society.Converter;

import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.stereotype.Component;

import Javaspring.com.Society.DTO.InvoiceDTO;
import Javaspring.com.Society.Entities.InvoiceEntity;

@Component
public class InvoiceConverter {
	
	public InvoiceDTO toModel(InvoiceEntity invoiceEntity) {
		InvoiceDTO invoiceDTO = new InvoiceDTO();
		invoiceDTO.setBuyer_id(invoiceEntity.getBuyer().getId());
		invoiceDTO.setCreateAt(invoiceEntity.getCreateAt());
		invoiceDTO.setId(invoiceEntity.getId());
		invoiceDTO.setOwner_id(invoiceEntity.getOwner().getId());
		invoiceDTO.setTotal(invoiceEntity.getTotal());
		invoiceDTO.setQuantity(invoiceEntity.getQuantity());
		invoiceDTO.setAddress(invoiceEntity.getAddress());
		invoiceDTO.setNote(invoiceEntity.getNote());
		invoiceDTO.setStatus(invoiceEntity.getStatus());
		invoiceDTO.setPaymentmethod(invoiceEntity.getPaymentmethod());
		
		Locale localeEN = new Locale("en", "EN");
	    NumberFormat en = NumberFormat.getInstance(localeEN);
	    invoiceDTO.setFormatCurrency(en.format(invoiceDTO.getTotal()));
		
		return invoiceDTO;
	}
	
	public InvoiceEntity toEntity(InvoiceDTO invoiceDTO) {
		InvoiceEntity invoiceEntity = new InvoiceEntity();
		invoiceEntity.setCreateAt(invoiceDTO.getCreateAt());
		invoiceEntity.setTotal(invoiceDTO.getTotal());
		invoiceEntity.setQuantity(invoiceDTO.getQuantity());
		invoiceEntity.setAddress(invoiceDTO.getAddress());
		invoiceEntity.setNote(invoiceDTO.getNote());
		invoiceEntity.setStatus(invoiceDTO.getStatus());
		invoiceEntity.setPaymentmethod(invoiceDTO.getPaymentmethod());
		
		return invoiceEntity;
	}
}
