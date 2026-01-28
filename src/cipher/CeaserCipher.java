package cipher;

public class CeaserCipher {

    static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        //
        shift = shift % 26;

        for (Character ch : text.toCharArray()) {
            // if the character upppercase  then shift it to further place elemnts
            if (Character.isUpperCase(ch)) {

                char c = (char) ((ch - 'A' + shift) % 26 + 'A');
                result.append(c);
            } else if (Character.isLowerCase(ch)) {

                char c = (char) ((ch - 'a' + shift) % 26 + 'a');
                result.append(c);
            }
            // its for the space

            else {
                result.append(ch);
            }

        }

        return result.toString();
    }
}


