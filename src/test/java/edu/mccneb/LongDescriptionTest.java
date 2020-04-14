package edu.mccneb;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import edu.mccneb.model.Product;
import edu.mccneb.repository.ProductRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
 
class LongDescriptionTest {
	private static final Logger log = LoggerFactory.getLogger(LongDescriptionTest.class);
	
	 @Autowired
	  private ProductRepository productRespostory;
	 @Test
	
	  @Sql(scripts={"classpath:product-with-long-description.sql"})
	  void whenProductDescriptionIsTooLong() {
	    List<Product> products = productRespostory.findByName("product-long-description");
	   log.info("In the test, evaluating "+products.get(0).toString());
	    assertNotNull(products.get(0));
	  }

}
