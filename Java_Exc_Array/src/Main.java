import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws NumberFormatException{

        //First, create file
        //ArrayFiles.CreateFile("myfile.txt");

        try {
            int[] myArray = ArrayFiles.ReadNums("myfile.txt");
            System.out.println(ArrayFiles.GetSum(myArray));
//          for(int i= 0; i< myArray.length;i++){
//              System.out.println(myArray[i]);
//           }

        }
        catch ( NumberFormatException | FileNotFoundException  | ArithmeticException exception){
            System.out.println(exception.getMessage());
        }
        catch(InvalidNumberException ine){
            System.out.println(ine.getMessage());
            System.out.println(ine.getDescription());
        }

    }
}