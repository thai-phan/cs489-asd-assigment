# Product Management CLI (Lab 1)

This project is a Java command-line application for managing product data for National Groceries.

## Requirements Implemented

- `Product` model class in package:
  - `edu.miu.cs.cs489appsd.lab1.productmgmtapp.model`
- `ProductMgmtApp` executable class in package:
  - `edu.miu.cs.cs489appsd.lab1.productmgmtapp`
- `ProductMgmtAppWithLibraries` executable class in package:
  - `edu.miu.cs.cs489appsd.lab1.productmgmtapp`
- `printProducts(Product[] products)` method that prints products sorted by:
  1. Product name (ascending)
  2. Unit price (descending)
- Output formats:
  - JSON
  - XML
  - CSV

## Run

```bash
cd /Users/thaiphan/sources/cs489-asd/lab_1
mvn -q compile exec:java
```

Run the library-based formatter main:

```bash
cd /Users/thaiphan/sources/cs489-asd/lab_1
mvn -q compile exec:java -Dexec.mainClass=edu.miu.cs.cs489appsd.lab1.productmgmtapp.ProductMgmtAppWithLibraries
```

## Notes

- `productId` uses `BigInteger` because sample IDs exceed `long` range.
- `unitPrice` uses `BigDecimal` to represent money accurately.
- Libraries used for formatting in the second main class: Gson (JSON), Jackson XML (XML), Apache Commons CSV (CSV).

