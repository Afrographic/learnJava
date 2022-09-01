package recursion;

public class Recursion {
    public static void main(String[] args) {

        System.out.println("15!="+factorial(5));
    }

    public static int factorial(int n) throws IllegalArgumentException{
        if (n < 0)
            throw new IllegalArgumentException();
        if(n == 0){
             return  1;
        }else{
             return n*factorial(n-1);
        }    
    }
}
