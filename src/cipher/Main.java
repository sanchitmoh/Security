package cipher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);

        System.out.println("Enter the Text");
        String char1= sc.nextLine();

        System.out.println("enter the shift");
        int shift= sc.nextInt();


        CeaserCipher cs=new CeaserCipher();


        String result=  CeaserCipher.encrypt(char1,shift);
        System.out.println(result);
        sc.close();
    }
}
