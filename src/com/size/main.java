package com.size;

public class main {

    public static void main(String[] args) {
        System.out.println(Circle(10.0f));
        System.out.println(Triangle(3.0f, 5.0f));
        System.out.println(Rectangle(3.0f, 4.0f));
    }

    private static float Triangle(float base, float height) {
        return 0.5f * base * height;
    }

    private static float Circle(float radius) {
        return 3.14f * radius * radius;
    }

    private static float Rectangle(float base, float height) {
        return base * height;
    }

}

