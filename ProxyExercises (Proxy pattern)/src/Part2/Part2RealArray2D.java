package Part2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Part2RealArray2D implements Part2Array2D {
    public int[][] array;

    public Part2RealArray2D(int rows, int cols) {
        array = new int[rows][cols];
    }

    public Part2RealArray2D(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream iis = new ObjectInputStream(fis);
            array = (int[][]) iis.readObject();

        } catch (Exception e) {
            System.out.println("Error creating array from file");
        }
    }

    public void save(String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(array);

        } catch (Exception e) {
            System.out.println("Error saving");
        }
    }

    @Override
    public void set(int row, int col, int value) {
        array[row][col] = value;
    }

    @Override
    public int get(int row, int col) {
        return array[row][col];
    }
}
