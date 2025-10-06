package com.luv2code.controller;

import com.luv2code.model.*;
import com.luv2code.view.ShapeView;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ShapeController {
    private Shape[] shapes;
    private ShapeView view;

    public ShapeController(ShapeView view) {
        this.view = view;
        initShapes();
    }

    private void initShapes() {
        String[] colors = {"Red", "Blue", "Green", "Yellow", "Black"};
        Random r = new Random();

        shapes = new Shape[10];
        for (int i = 0; i < shapes.length; i++) {
            String color = colors[r.nextInt(colors.length)];
            switch (r.nextInt(3)) {
                case 0 -> shapes[i] = new Rectangle(color, 1 + r.nextInt(10), 1 + r.nextInt(10));
                case 1 -> shapes[i] = new Triangle(color, 1 + r.nextInt(10), 1 + r.nextInt(10));
                case 2 -> shapes[i] = new Circle(color, 1 + r.nextInt(10));
            }
        }
    }

    public void showAllShapes() {
        view.displayMessage("All shapes:");
        view.displayShapes(shapes);
    }

    public void showTotalArea() {
        double total = Arrays.stream(shapes).mapToDouble(Shape::calcArea).sum();
        view.displayTotalArea(total);
    }

    public void showTotalAreaByType(Class<?> type) {
        double total = Arrays.stream(shapes)
                .filter(s -> s.getClass() == type)
                .mapToDouble(Shape::calcArea)
                .sum();
        view.displayMessage("Total area for " + type.getSimpleName() + " = " + total);
    }

    public void sortByArea() {
        Arrays.sort(shapes, Comparator.comparingDouble(Shape::calcArea));
        view.displayMessage("Shapes sorted by area:");
        view.displayShapes(shapes);
    }

    public void sortByColor() {
        Arrays.sort(shapes, Comparator.comparing(Shape::getColor));
        view.displayMessage("Shapes sorted by color:");
        view.displayShapes(shapes);
    }
}

