package edu.miu.cs.cs489appsd.lab1.productmgmtapp.model;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class XmlProduct {
  @JacksonXmlProperty(isAttribute = true)
  private BigInteger productId;

  @JacksonXmlProperty(isAttribute = true)
  private String name;

  @JacksonXmlProperty(isAttribute = true)
  private LocalDate dateSupplied;

  @JacksonXmlProperty(isAttribute = true)
  private int quantityInStock;

  @JacksonXmlProperty(isAttribute = true)
  private BigDecimal unitPrice;

  public XmlProduct() {
  }

  public XmlProduct(BigInteger productId, String name, LocalDate dateSupplied, int quantityInStock, BigDecimal unitPrice) {
    this.productId = productId;
    this.name = name;
    this.dateSupplied = dateSupplied;
    this.quantityInStock = quantityInStock;
    this.unitPrice = unitPrice;
  }

  public static XmlProduct fromProduct(Product product) {
    return new XmlProduct(
        product.getProductId(),
        product.getName(),
        product.getDateSupplied(),
        product.getQuantityInStock(),
        product.getUnitPrice()
    );
  }

  public BigInteger getProductId() {
    return productId;
  }

  public void setProductId(BigInteger productId) {
    this.productId = productId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getDateSupplied() {
    return dateSupplied;
  }

  public void setDateSupplied(LocalDate dateSupplied) {
    this.dateSupplied = dateSupplied;
  }

  public int getQuantityInStock() {
    return quantityInStock;
  }

  public void setQuantityInStock(int quantityInStock) {
    this.quantityInStock = quantityInStock;
  }

  public BigDecimal getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(BigDecimal unitPrice) {
    this.unitPrice = unitPrice;
  }
}