package com.luv2code;
import com.luv2code.model.Circle;
import com.luv2code.controller.ShapeController;
import com.luv2code.view.ShapeView;

public class Main {
    public static void main(String[] args) {
        ShapeView view = new ShapeView();
        ShapeController controller = new ShapeController(view);

        controller.showAllShapes();
        controller.showTotalArea();
        controller.showTotalAreaByType(Circle.class);
        controller.sortByArea();
        controller.sortByColor();
    }
}
