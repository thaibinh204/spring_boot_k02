package com.k02.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.k02.dto.CustomerDto;
import com.k02.entity.Customer;
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	@Query("SELECT c FROM Customer c WHERE customer_id = :id")
	 Customer findCustomerByIdQuery(@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query(value="update Customers set customer_name = :customername, "
			+ "contact_name = :contactname, city = :city, address = :address, postalcode = :postalcode, "
			+ "country = :country "
			+ "where customer_id = :id",
			nativeQuery = true)
	int updateCustomer(@Param("customername") String customername,
			           @Param("contactname") String contactname,
			           @Param("address") String address,
			           @Param("city") String city,
			           @Param("postalcode") String postalcode,
			           @Param("country") String country,
			           @Param("id") Long id
			);
	
	@Query("Select c from Customer c where customerName like %?1%")
	List<Customer> searchCustomer(String txtsearch);
	
	@Query(value="Select new com.k02.dto.CustomerDto(c.customer_name,c.country,c.address,d.name,c.sex) from Customers c inner join department d on c.dept_id=d.id ",
			nativeQuery = true)
	List<CustomerDto> ListCustomerDepartment();
	
	
}
