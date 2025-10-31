package com.luv2code.task2;

import com.luv2code.task2.model.Circle;
import com.luv2code.task2.controller.ShapeController;
import com.luv2code.task2.view.ShapeView;

public class Main {
    public static void main(String[] args) {
        ShapeView view = new ShapeView();
        ShapeController controller = new ShapeController(view);

//        controller.showAllShapes();
//        controller.showTotalArea();
//        controller.showTotalAreaByType(Circle.class);
//        controller.sortByArea();
//        controller.sortByColor();

        controller.showAllShapes();
        controller.saveShapes("shapes.dat");

        controller.loadShapes("shapes.dat");
        controller.showAllShapes();
    }
}
