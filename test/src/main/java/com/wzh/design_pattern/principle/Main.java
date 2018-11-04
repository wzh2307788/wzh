package com.wzh.design_pattern.principle;

public class Main {
    public static void main(String[] args) {
        Cooker<Breakfast> cooker=new Mother();
        Meal meal= cooker.cook();
        Child child=new Child();
        child.enjoyMeal(meal);
    }
}
