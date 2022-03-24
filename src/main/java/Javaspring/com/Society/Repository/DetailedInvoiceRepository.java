package Javaspring.com.Society.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Javaspring.com.Society.Entities.DetailedInvoiceEntity;

public interface DetailedInvoiceRepository extends JpaRepository<DetailedInvoiceEntity, Long>{
	public List<DetailedInvoiceEntity> findAllByInvoice_id (long invoice_id);

}
