package edu.mccneb.model;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = "products")
@Entity
@Table(name = "orderp") //because order is reserved SQL keyword
public class Order {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;

	    private String name;
	    
	    public Order() {}

	    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
	    private Set<Product> products;

	    public Order(String name, Product... products) {
	        this.name = name;
	        this.products = Stream.of(products).collect(Collectors.toSet());
	        this.products.forEach(x -> x.setOrder(this));
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Set<Product> getProducts() {
			return products;
		}

		public void setProducts(Set<Product> products) {
			this.products = products;
		}
	    
}