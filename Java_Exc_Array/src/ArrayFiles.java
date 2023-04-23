import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ArrayFiles {
    private ArrayFiles(){}
    //constructor is private because we do not need to create instances of this class

    //this method creates file, if it does not existss
    public static void  CreateFile(String filename)  {
        try {
            File file = new File(filename);
            if(file.createNewFile()){
                System.out.println("File " + file.getName() +" Created");}
            else if (file.exists()) {
                System.out.println("This File Already Exists");}
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }


    //This method reads 10 number from a file and writes them in the array.
    public static int[] ReadNums(String filename) throws FileNotFoundException,InvalidNumberException {
        int[] MyArray = new int[10];
        File file = new File(filename);
        if (file.exists()) {
            Scanner scanner = new Scanner(file);

            for (int i = 0; i < 10; i++) {
                try {
                    if (scanner.hasNextLine()) {
                        String data = scanner.nextLine();
                        int num = Integer.parseInt(data);
                        if (num < 0) {
                            throw new InvalidNumberException("Invalid Number Exception","Number is less than Zero!");
                        }
                        if(num == 0){
                            throw new ArithmeticException("Arithmetic Exception. Number is zero");
                        }
                        MyArray[i] = num;
                    }
                }
                catch (NumberFormatException nfe) {
                    throw new NumberFormatException("Number format exception! Are you sure that this is a integer number?");
                }
            }
        }
        else {
            throw new FileNotFoundException("File not found :(");
        }
        return MyArray;
    }



    //this method takes array as a parameter and returns sum of its elements
    public static int GetSum(int[] Array) {
        int sum = 0;
        for (int i = 0; i < Array.length; i++) {
            try {
                sum += Array[i];
            }
            catch (NumberFormatException nfe) {
                System.out.println("Number format Exception");
            }
        }
        return sum;
    }
}
