package Tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args)
            throws FileNotFoundException {

        System.out.println();

        File file = new File("C:\\Users\\User\\Desktop\\input.txt");
        Scanner sc = new Scanner(file);

        sc.useDelimiter("\\Z");

        System.out.println(sc.next());
    }
}