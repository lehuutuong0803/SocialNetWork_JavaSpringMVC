package Javaspring.com.Society.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Javaspring.com.Society.Entities.InvoiceEntity;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long>{
	public List<InvoiceEntity> findAllByOwner_idOrderByIdDesc (long owner_id);
	public List<InvoiceEntity> findAllByBuyer_idOrderByIdDesc (long buyer_id);
	public InvoiceEntity findOneById(long id);

}
