/*
 * Morse, 18/09/2021
 * IUT Rodez 2021, INFO2 TD3
 * pas de copyright, aucun droits
 */

import java.util.Locale;

/**
 * Outils de conversion en code morse
 *
 * @author Lucas Vabre
 */
public class Morse {

    private static final int CARATERE = 0;
    private static final int CODE = 1;
    private static final String DELIMITEUR = " ";

    public static final String[][] TABLE_CONVERSION = {
        {"A", ".-"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."}, {"E", "."},
        {"F", "..-."}, {"G", "--."}, {"H", "...."}, {"I", ".."}, {"J", ".---"},
        {"K", "-.-"}, {"L", ".-.."}, {"M", "--"}, {"N", "-."}, {"O", "---"},
        {"P", ".--."}, {"Q", "--.-"}, {"R", ".-."}, {"S", "..."}, {"T", "-"},
        {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"}, {"Y", "-.--"},
        {"Z", "--.."}, {"0", "-----"}, {"1", ".----"}, {"2", "..---"},
        {"3", "...--"}, {"4", "....-"}, {"5", "....."}, {"6", "-...."},
        {"7", "--..."}, {"8", "---.."}, {"9", "----."}, {".", ".-.-.-"},
        {",", "--..--"}, {"'", ".----."}, {"?", "..--.."}, {":", "---..."},
        {"-", "-....-"}, {"/", "-..-."}, {"[", "-.--."}, {"(", "-.--."},
        {"]", "-.--.-"}, {")", "-.--.-"}, {"\"", ".-..-."}, {"_", "..--.-"},
        {"=", "-...-"}, {"+", ".-.-."}, {"@", ".--.-."}, {"Ä", ".-.-"},
        {"Å", ".--.-"}, {"É", "..-.."}, {"Ñ", "--.--"}, {"Ö", "---."},
        {"Ü", "..--"}
    };

    public static String convertStringToMorse(String aConvertir) {
        if (aConvertir == null) throw new IllegalArgumentException();

        aConvertir = aConvertir.toUpperCase();
        StringBuilder resultat = new StringBuilder();

        for (char caractere : aConvertir.toCharArray()) {
            resultat.append(convertCharToMorse(caractere))
                    .append(DELIMITEUR);
        }

        return resultat.toString().strip();
    }

    public static String convertCharToMorse(char aConvertir) {
        char aTester;
        for (String[] conversion : TABLE_CONVERSION) {
            aTester = conversion[CARATERE].charAt(0);
            if (aTester == aConvertir) return conversion[CODE];
        }
        return "?";
    }

    public static String convertMorseToString(String aConvertir) {
        if (aConvertir == null) throw new IllegalArgumentException();

        StringBuilder resultat = new StringBuilder();

        String[] aConvertirSplitted = aConvertir.split(DELIMITEUR);
        for (String code : aConvertirSplitted) {
            resultat.append(convertMorseToChar(code));
        }

        return resultat.toString();
    }

    public static char convertMorseToChar(String aConvertir) {
        String aTester;
        for (String[] conversion : TABLE_CONVERSION) {
            aTester = conversion[CODE];
            if (aTester.equals(aConvertir)) return conversion[CARATERE].charAt(0);
        }
        return '?';
    }

    /**
     * Start
     *
     * @param args
     */
    public static void main(String[] args) {
        String test = "Message";

        String morse = convertStringToMorse(test);
        System.out.println(test + " : " + morse);
    }
}
