package com.kodilla.testing.shape;

import java.util.ArrayList;


public class ShapeCollector {
    private ArrayList<Shape> figures = new ArrayList<Shape>();

    public void addFigure(Shape shape) {
        figures.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (figures.contains(shape)){
            figures.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n) {
        Shape shape = null;
        if (n >= 0 && n < figures.size()) {
            shape = figures.get(n);
        }
        return shape;
    }

    public void showFigures() {
        for (Shape shape: figures) {
            System.out.println(shape);
        }
    }

    public int getFiguresQuantity(){
        return figures.size();
    }

}
