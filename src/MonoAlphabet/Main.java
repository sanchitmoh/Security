package MonoAlphabet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the text(only Capselock)");
        String text =sc.nextLine();

        Mono ms=new Mono();
         String result=ms.encrypt(text);

        System.out.println(result);

    }

}
