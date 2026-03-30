package edu.miu.cs.cs489appsd.lab1.productmgmtapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.google.gson.*;
import edu.miu.cs.cs489appsd.lab1.productmgmtapp.model.LocalDateAdapter;
import edu.miu.cs.cs489appsd.lab1.productmgmtapp.model.ProductsWrapper;
import edu.miu.cs.cs489appsd.lab1.productmgmtapp.model.XmlProduct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import edu.miu.cs.cs489appsd.lab1.productmgmtapp.model.Product;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ProductMgmtAppWithLibraries {

    public static void main(String[] args) {
        Product[] products = new Product[]{
                new Product(new BigInteger("31288741190182539912"), "Banana", LocalDate.parse("2026-01-24"), 124, new BigDecimal("0.55")),
                new Product(new BigInteger("29274582650152771644"), "Apple", LocalDate.parse("2025-12-09"), 18, new BigDecimal("1.09")),
                new Product(new BigInteger("91899274600128155167"), "Carrot", LocalDate.parse("2026-03-31"), 89, new BigDecimal("2.99")),
        };

        printProducts(products);
    }

    public static void printProducts(Product[] products) {
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, Comparator
                .comparing(Product::getName)
                .thenComparing(Product::getUnitPrice, Comparator.reverseOrder()));

        printAsJson(sortedProducts);
        printAsXml(sortedProducts);
        printAsCsv(sortedProducts);
    }

    private static void printAsJson(Product[] products) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        System.out.println("JSON:");
        System.out.println(gson.toJson(products));
        System.out.println();
    }

    private static void printAsXml(Product[] products) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<XmlProduct> xmlProducts = Arrays.stream(products)
                .map(XmlProduct::fromProduct)
                .toList();
        ProductsWrapper wrapper = new ProductsWrapper(xmlProducts);

        System.out.println("XML:");

        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        try {
            System.out.println(xmlMapper.writeValueAsString(wrapper));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize products as XML", e);
        }
        System.out.println();
    }

    private static void printAsCsv(Product[] products) {
        System.out.println("CSV:");
        StringWriter stringWriter = new StringWriter();

        try (CSVPrinter csvPrinter = new CSVPrinter(stringWriter, CSVFormat.DEFAULT
                .builder()
                .setHeader("productId", "name", "dateSupplied", "quantityInStock", "unitPrice")
                .build())) {
            for (Product product : products) {
                csvPrinter.printRecord(
                        product.getProductId(),
                        product.getName(),
                        product.getDateSupplied(),
                        product.getQuantityInStock(),
                        product.getUnitPrice()
                );
            }
            csvPrinter.flush();
        } catch (IOException e) {
            throw new RuntimeException("Failed to format products as CSV", e);
        }

        System.out.print(stringWriter);
    }


}

