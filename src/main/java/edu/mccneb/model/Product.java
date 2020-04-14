package edu.mccneb.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


//@Table - Because this annotation does not exist, it is assumed that the table name is Product

@Entity
public class Product {

	@Id 
	//indicates that the ID should be generated automatically.
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    
    public String name;
    public String category;
    public String description;
    public BigDecimal price;
    

    @ManyToOne
    @JoinColumn
    @JsonIgnore // to break one side of the chain, o/w will cause recursive json parsing issues. 
    private Order order;
   
    
    protected Product() {}
    
    public Product(String name, String category, String description, BigDecimal price) {
		super();
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
	}

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Override
    public String toString() {
    	return "{ " +id +","+name+","+category+","+ description +","+ price+"}";
    }
    
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
    
    

}