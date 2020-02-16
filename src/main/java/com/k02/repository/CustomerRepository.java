package com.k02.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.k02.entity.Customer;
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	// selct khong can 2 annotation @Transactional @Modifying
	@Query("SELECT c FROM Customer c WHERE customer_id = :id")
	 Customer findCustomerByIdQuery(@Param("id") Long id);

	// delete, insert, update thi can 2 annotation (@Transactional @Modifying)
	//va co su dung nativeQuery = true con search thi khong can
	@Transactional
	@Modifying
	@Query(value = "delete from customers where customer_id = :id", nativeQuery = true )
	void deleteSql (@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query( value = "insert into  customers (customer_name, contact_name, address, city, postalcode, country ) "
	 + "values(:customerName, :contactName , :address, :city, :postalcode, :country )" ,nativeQuery = true)
	void saveSql(@Param("customerName") String customerName, 
			     @Param("contactName") String contactName,
				 @Param("address") String address,
				 @Param("city") String city,
				 @Param("postalcode") String postalcode,
				 @Param("country") String country);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE customers " 
	+ " SET customer_name = :customerName, contact_name = :contactName, address= :address, "
	+ " city= :city, postalcode = :postalcode , country = :country "
	+ "  WHERE customer_id = :id "
	, nativeQuery = true)
	void updateSql(@Param("customerName") String customerName, 
			     @Param("contactName") String contactName,
				 @Param("address") String address,
				 @Param("city") String city,
				 @Param("postalcode") String postalcode,
				 @Param("country") String country,
				 @Param("id") Long id);
	
	// search theo ten customerName
	@Query(value = "select c from Customer c  where customerName like %:customerName% " )
	List<Customer> search(@Param("customerName") String customerName);
}