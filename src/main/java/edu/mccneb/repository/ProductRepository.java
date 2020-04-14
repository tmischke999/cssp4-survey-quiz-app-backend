package edu.mccneb.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.mccneb.model.Product;

public interface  ProductRepository extends JpaRepository<Product, Long> {
	
	public List<Product> findByName(String name);
	public List<Product> findByPrice(BigDecimal price);
	public List<Product> findByDescription(String desc);
	public List<Product> findByCategory(String category);
	public List<Product> findByOrderId(Long productId);
	
	@Query("select p from #{#entityName} p where p.price between ?1 and ?2")
	public List<Product> findByPriceRange(BigDecimal lowPrice, BigDecimal highPrice);
	
	
	@Query(value = "select * from product p where p.price between :lowPrice and :highPrice", nativeQuery = true)
	public List<Product> findByPriceRangeUsingNativeQuery(@Param("lowPrice") BigDecimal lowPrice, @Param("highPrice") BigDecimal highPrice);
	
}
