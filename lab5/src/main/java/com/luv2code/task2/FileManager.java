package com.luv2code.task2;

import com.luv2code.task2.model.Shape;

import java.io.*;

public class FileManager {
    public static void saveShapesToFile(String filename, Shape[] shapes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(shapes);
            System.out.println("Shapes saved to file " + filename);
        } catch (IOException e) {
            System.out.println("Error saving shapes: " + e.getMessage());
        }
    }

    public static Shape[] loadShapesFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Shape[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading shapes: " + e.getMessage());
            return null;
        }
    }
}
