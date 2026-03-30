package edu.miu.cs.cs489appsd.lab1.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1.productmgmtapp.model.Product;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class ProductMgmtApp {

    public static void main(String[] args) {
        Product[] products = new Product[]{
                new Product(new BigInteger("31288741190182539912"), "Banana", LocalDate.parse("2026-01-24"), 124, new BigDecimal("0.55")),
                new Product(new BigInteger("29274582650152771644"), "Apple", LocalDate.parse("2025-12-09"), 18, new BigDecimal("1.09")),
                new Product(new BigInteger("91899274600128155167"), "Carrot", LocalDate.parse("2026-03-31"), 89, new BigDecimal("2.99")),
                new Product(new BigInteger("31288741190182539913"), "Banana", LocalDate.parse("2026-02-13"), 240, new BigDecimal("0.65"))
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
        System.out.println("JSON:");
        System.out.println("[");
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            System.out.println("  {");
            System.out.println("    \"productId\": \"" + product.getProductId() + "\",");
            System.out.println("    \"name\": \"" + product.getName() + "\",");
            System.out.println("    \"dateSupplied\": \"" + product.getDateSupplied() + "\",");
            System.out.println("    \"quantityInStock\": " + product.getQuantityInStock() + ",");
            System.out.println("    \"unitPrice\": " + product.getUnitPrice());
            System.out.println(i < products.length - 1 ? "  }," : "  }");
        }
        System.out.println("]");
        System.out.println();
    }

    private static void printAsXml(Product[] products) {
        System.out.println("XML:");
        System.out.println("<products>");
        for (Product product : products) {
            System.out.println("  <product>");
            System.out.println("    <productId>" + product.getProductId() + "</productId>");
            System.out.println("    <name>" + product.getName() + "</name>");
            System.out.println("    <dateSupplied>" + product.getDateSupplied() + "</dateSupplied>");
            System.out.println("    <quantityInStock>" + product.getQuantityInStock() + "</quantityInStock>");
            System.out.println("    <unitPrice>" + product.getUnitPrice() + "</unitPrice>");
            System.out.println("  </product>");
        }
        System.out.println("</products>");
        System.out.println();
    }

    private static void printAsCsv(Product[] products) {
        System.out.println("CSV:");
        System.out.println("productId,name,dateSupplied,quantityInStock,unitPrice");
        for (Product product : products) {
            System.out.println(product.getProductId() + ","
                    + product.getName() + ","
                    + product.getDateSupplied() + ","
                    + product.getQuantityInStock() + ","
                    + product.getUnitPrice());
        }
    }
}

