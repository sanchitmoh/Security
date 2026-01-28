package MonoAlphabet;

import java.util.HashMap;

public class Mono {
    public  static  String encrypt( String text ){

        String plain= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cypher="QWERTYUIOPASDFGHJKLZXCVBNM";

        //store into hashmap
        HashMap<Character,Character> map= new HashMap<>();
        //creating mapping
        for(int i=0;i<26;i++){
            map.put(plain.charAt(i),cypher.charAt(i));
        }
         StringBuilder result= new StringBuilder();

        //encrypt the text
        for(char ch:text.toUpperCase().toCharArray()){
            if(map.containsKey(ch)){
                result.append(map.get(ch));
            }
            else {
                result.append(ch);
            }
        }
        return result.toString();
    }

}
