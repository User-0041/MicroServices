package org.id.billingservice;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
@AllArgsConstructor
class ProductItem{
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Transient
private Product product;
private long productID; 
private double price; 
private double quantity;
@ManyToOne
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
private Bill bill;
}