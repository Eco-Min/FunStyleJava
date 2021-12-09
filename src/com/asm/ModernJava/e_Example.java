package com.asm.ModernJava;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class e_Example {
    public static void main(String[] args) {

        Product productA = new Product(1L, "A", new BigDecimal("10.00"));
        Product productB = new Product(2L, "B", new BigDecimal("55.50"));
        Product productC = new Product(3L, "C", new BigDecimal("17.45"));
        Product productD = new Product(4L, "D", new BigDecimal("23.00"));
        Product productE = new Product(5L, "E", new BigDecimal("110.99"));

        final List<Product> products = Arrays.asList(
                productA,
                productB,
                productC,
                productD,
                productE
        );


        /*List<Product> result = new ArrayList<>();
        for(final Product product : products){
            if(product.getPrice().compareTo(new BigDecimal("20")) >= 0){
                result.add(product);
            }
        }*/
        final BigDecimal twenty = new BigDecimal("10");
        List<Product> result = filter(products, product -> product.getPrice().compareTo(twenty) <= 0);
        System.out.println(result);

        final List<Product> expensiveProducts =
                filter(products, product -> product.getPrice().compareTo(new BigDecimal("50")) > 0);


        /* map 이란 함수 만들기전
        final List<Product> discountProduct = new ArrayList<>();
        for (final Product product : expensiveProducts) {
            discountProduct.
                    add(new DiscountedProduct(product.getId(), product.getName(), product.getPrice()));
        }
        System.out.println("discount products: " + discountProduct);
        */

        final List<Product> discountProduct =
                map(expensiveProducts, product ->
                        new DiscountedProduct(product.getId(), product.getName(),
                                product.getPrice().multiply((new BigDecimal("0.5")))));

        System.out.println("expensive Products : " + expensiveProducts);
        System.out.println("discout products : " + discountProduct);
        System.out.println("discout product <= 30 : " +
                filter(discountProduct, product ->
                        product.getPrice().compareTo(new BigDecimal("30")) <= 0));

        /*final List<BigDecimal> prices = map(products, product -> product.getPrice());
        BigDecimal total = BigDecimal.ZERO;
        for (final BigDecimal price : prices) {
            total = total.add(price);
        }
        System.out.println("total :" + total);*/

        final BigDecimal total = total(products, product -> product.getPrice());
        System.out.println("total : " + total);

        final BigDecimal discountedTotal = total(discountProduct, product -> product.getPrice());
        System.out.println("discountedTotal : " + discountedTotal);

        Order order = new Order(1L, "on-1234", Arrays.asList(
                new OrderedItem(1L, productA, 2),
                new OrderedItem(2L, productC, 1),
                new OrderedItem(3L, productD, 10)
        ));
        BigDecimal orderTotal = BigDecimal.ZERO;
        for (OrderedItem item : order.getItems()) {
            orderTotal =
                    orderTotal.add(item.getProduct().getPrice().multiply(new BigDecimal(item.quantity)));
        }
        System.out.println("order total price : " + orderTotal);
        System.out.println("order total price2 : " + order.totalPrice());
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (final T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    private static <T> BigDecimal total(List<T> list, Function<T, BigDecimal> mapper) {
//        final List<BigDecimal> result = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;
        for (final T t : list) {
            total = total.add(mapper.apply(t));
        }
        return total;
    }

    @AllArgsConstructor
    @Data
    static class Product {
        private Long id;
        private String name;
        private BigDecimal price;
    }

    @ToString(callSuper = true)
    static class DiscountedProduct extends Product {

        public DiscountedProduct(Long id, String name, BigDecimal price) {
            super(id, name, price);
        }
    }

    @AllArgsConstructor
    @Data
    static class OrderedItem {
        private Long id;
        private Product product;
        private int quantity;

        public BigDecimal getItemTotal() {
            return product.getPrice().multiply(new BigDecimal(quantity));
        }
    }

    @AllArgsConstructor
    @Data
    static class Order {
        private Long id;
        private String orderNumber;
        private List<OrderedItem> items;


        public BigDecimal totalPrice() {
            // item 은 quantity 까지 가지고있음 product 만 가지고 있는게 아니기때문에 OrderedItem 에도 해야함
            return total(items, item -> item.getItemTotal());
        }
    }

}


