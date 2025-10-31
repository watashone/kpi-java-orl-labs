package com.luv2code.task2.view;

import com.luv2code.task2.model.Shape;

public class ShapeView {
    public void displayShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayTotalArea(double area) {
        System.out.println("Total area = " + area);
    }
}
