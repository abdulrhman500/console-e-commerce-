# Console E-Commerce

A simple Java-based console application simulating an e-commerce system.

## 🛠 Requirements

- **Java 21 or higher**

```bash
java --version
```

# openjdk 21.0.7 2025-04-15


## 🚀 How to Run
```
git clone https://github.com/abdulrhman500/console-e-commerce-.git
cd console-e-commerce-

javac *.java

java Main

```


## 📝 Project Structure

```
console-e-commerce-/
├── Main.java                  # Entry point of the app
├── ReadME.md

├── cart/
│   ├── Cart.java
│   └── CartItem.java

├── customer/
│   └── Customer.java

├── Examples/
│   └── Ex1.java

├── exceptions/
│   ├── EmptyCartException.java
│   ├── ExceedStockException.java
│   ├── InsufficientBalanceException.java
│   └── ProductExpiredException.java

├── payment/
│   └── PaymentService.java

├── product/
│   ├── ITrait.java
│   ├── Product.java
│   ├── ProductBuilder.java
│   ├── ExpirableProductTrait.java
│   └── ShippableProductTrait.java

├── shipping/
│   ├── IshipableItem.java
│   └── ShippingService.java

├── utils/
│   └── PrinterUtil.java
```
