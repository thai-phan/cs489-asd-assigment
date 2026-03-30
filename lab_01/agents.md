Assume that a National Groceries supply company has hired you to develop a CommandLine Interface (CLI) application for their Products Management system, which they will be using to manage data about the Products they supply.
Here are the attributes for the Product entity, including some useful descriptions and/or sample data values:
Product:

productId, (e.g. 31288741190182539912, 29274582650152771644, etc.)
Note: These productIds are numeric data
name, (e.g. Banana, Apple, Carrot etc.)
dateSupplied, (e.g. 2025-01-24, 2024-12-09, 2025-03-31 etc.)
quantityInStock, (e.g. 124, 18, 89 etc.)
unitPrice, This is money (in dollars and cents) (e.g. $0.55, $1.09, $2.99 etc.)

Products data:

31288741190182539912 Banana 2026-01-24 124 0.55
29274582650152771644 Apple 2025-12-09 18 1.09
91899274600128155167 Carrot 2026-03-31 89 2.99
31288741190182539913 Banana 2026-02-13 240 0.65


For this question, do the following:
1. Create a new Command-Line Interface application project.
2. In the project, implement code for the class named, Product, including each of the data
   fields required by the specification above, add 3 constructors including the default
   constructor, and getter (accessor) and setter (mutator) methods. Make the class be
   inside a package/namespace named,
   “edu.miu.cs.cs489appsd.lab1.productmgmtapp.model”.
3. Add and code an executable class named, ProductMgmtApp, and in it include the main
   method. And, in the main method, create an array of Products using the company’s
   data, as given above. Also, implement a method named, printProducts, that takes as
   input the array of products data and it prints them out to the console, sorted in
   ascending order of the Product Name and then descending order by the product Unit
   Price, in each of the following formats: JSON, XML and CSV.
   Make the ProductMgmtApp class be inside a package named,
   “edu.miu.cs.cs489appsd.lab1.productmgmtapp”.
4. In the main method, add code to invoke your printProducts(…) method and execute
   your program, take a screenshot of the IDE showing the output/result 
