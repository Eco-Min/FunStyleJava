package com.asm.ModernJava;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class j_StreamExample4 {
    public static void main(String[] args) {
        final List<Product1> products =
                Arrays.asList(
                        new Product1(1L, "A", new BigDecimal("100.50")),
                        new Product1(2L, "B", new BigDecimal("23.00")),
                        new Product1(3L, "C", new BigDecimal("31.45")),
                        new Product1(4L, "D", new BigDecimal("80.20")),
                        new Product1(5L, "E", new BigDecimal("7.50"))
                );

        System.out.println("Product.price >= 30 : " +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
                        .collect(toList()));

        System.out.println("======================================================");

        System.out.println("Product.price >= 30 (With joining) : \n" +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
                        .map(product -> product.toString())
                        .collect(joining("\n")));

        System.out.println("======================================================");

        System.out.println(
                products.stream()
                        .map(product -> product.getPrice())
                        .reduce((price1, price2) -> price1.add(price2))
//                        .reduce(BigDecimal.ZERO, (product1, product2) ->
//                                product1.getPrice().add(product2.getPrice())) 이건 안됨
        );

        System.out.println("======================================================");

        System.out.println("Total price of Products.price >= 30 : " +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
                        .map(product -> product.getPrice())
                        .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2))
        );

        System.out.println("======================================================");
        System.out.println("# of Products.price >= 30 : " +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
                        .map(product -> product.getPrice())
                        .count()
        );

        final OrderedItem item1 = new OrderedItem(1L, products.get(0), 1);
        final OrderedItem item2 = new OrderedItem(2L, products.get(2), 3);
        final OrderedItem item3 = new OrderedItem(3L, products.get(4), 10);

        final Order order = new Order(1L, Arrays.asList(item1, item2, item3));

        System.out.println("======================================================");
        System.out.println("order.totalPrice() : " + order.totalPrice());
    }
}

@AllArgsConstructor
@Data
class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}

@AllArgsConstructor
@Data
class OrderedItem {
    private Long id;
    private Product1 product;
    private int quantity;

    public BigDecimal getTotalPrice() {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}

@AllArgsConstructor
@Data
class Order {
    private Long id;
    private List<OrderedItem> items;

    public BigDecimal totalPrice() {
        return items.stream()
                .map(item -> item.getTotalPrice())
                .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2));
    }
}

