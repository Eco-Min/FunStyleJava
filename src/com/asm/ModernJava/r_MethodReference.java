package com.asm.ModernJava;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.function.Function;

public class r_MethodReference {
    public static void main(String[] args) {

        final r_Section section1 = new r_Section(1);
        final Function<Integer, r_Section> sectionFactoryWithLamdaExpression
                = number -> new r_Section(number);
        final r_Section section1WithLambdaExpression = sectionFactoryWithLamdaExpression.apply(1);

        final Function<Integer, r_Section> sectionFactoryWithMethodRefenrece = r_Section::new;
        final r_Section sectionWithMethodRefernece = sectionFactoryWithMethodRefenrece.apply(1);

        System.out.println(section1);
        System.out.println(section1WithLambdaExpression);
        System.out.println(sectionWithMethodRefernece);

        /*
        final r_Product product = new r_Product(1L, "A", new BigDecimal("100"));
        System.out.println(product);

        final ProductCreator productCreator = r_Product::new;
        System.out.println(productCreator.create(1L, "A", new BigDecimal("100")));

        // -> abstract 로 바꿔주어 이부분은 못쓰게 된다 (추상 이니까)
        */

        final r_ProductA a = createProudct(
                1L, "A", new BigDecimal("100"), r_ProductA::new);
        final r_ProductB b = createProudct(
                2L, "B", new BigDecimal("200"), r_ProductB::new);
        final r_ProductC c = createProudct(
                3L, "C", new BigDecimal("300"), r_ProductC::new);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }

    //이런 방식이 좋은점은 만약 C타입이 새로 만들어 졌다고 가졍하면 C타입 클래스를 그냥 추가 하면됨
    private static <T extends r_Product> T createProudct(final Long id,
                                                         final String name,
                                                         final BigDecimal price,
                                                         final ProductCreator<T> productCreator) {
        if (id == null || id < 1L) {
            throw new IllegalArgumentException("The id must be a positve Long.");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The name is not given.");
        }
        if (price == null || BigDecimal.ZERO.compareTo(price) >= 0) { // price <= ZERO
            throw new IllegalArgumentException("The price must be greater then 0");
        }
        return productCreator.create(id, name, price);
    }

}


/*
 그럼 이부분에서 둘중 하나를 해줘야 하기때문에 iterator 방식을 이용
 -> 기존방식
 interface ProductCreator {
    r_Product create(Long id, String name, BigDecimal price);
}
 */
@FunctionalInterface
interface ProductCreator<T extends r_Product> {
    T create(Long id, String name, BigDecimal price);
}

@AllArgsConstructor
@Data
class r_Section {
    private int number;
}


/* Product 종류가 2가지가 생김 -> 일반 Product 오브젝트를 바로 생성 하지 못하게 해야함
     -> abstract 즉 추상으로 바꿔쟈아함
     // 원래 class r_Product
 */
@AllArgsConstructor
@Data
abstract class r_Product {
    private Long id;
    private String name;
    private BigDecimal price;
}

class r_ProductA extends r_Product {
    public r_ProductA(Long id, String name, BigDecimal price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "A=" + super.toString();
    }
}


class r_ProductB extends r_Product {
    public r_ProductB(Long id, String name, BigDecimal price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "B=" + super.toString();
    }
}

class r_ProductC extends r_Product {
    public r_ProductC(Long id, String name, BigDecimal price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "C=" + super.toString();
    }
}
