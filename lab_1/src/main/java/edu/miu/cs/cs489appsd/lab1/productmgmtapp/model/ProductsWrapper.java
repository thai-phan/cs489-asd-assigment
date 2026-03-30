package edu.miu.cs.cs489appsd.lab1.productmgmtapp.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "products")
public class ProductsWrapper {
  @JacksonXmlProperty(localName = "product")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<XmlProduct> products;

  public ProductsWrapper() {
    this.products = new ArrayList<>();
  }

  public ProductsWrapper(List<XmlProduct> products) {
    this.products = products;
  }

  public List<XmlProduct> getProducts() {
    return products;
  }

  public void setProducts(List<XmlProduct> products) {
    this.products = products;
  }
}
