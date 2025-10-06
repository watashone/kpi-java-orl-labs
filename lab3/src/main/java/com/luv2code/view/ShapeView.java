package com.luv2code.view;

import com.luv2code.model.Shape;

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
