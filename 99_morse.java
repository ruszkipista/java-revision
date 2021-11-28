/*
Eric (the villain) escaped with the help of Duke (the detective) and "borrowed" an old ship
to sail into the Carribean. Being the nice guy he is, he used an old morse machine to send Duke
a message. However, he seemed to have tasted quite some rum barrels on the ship... 
When pressing the telegraph key, some symbols were sent much too often.
So its your task to help Duke to decypher Eric's morse message and print it on the screen.
*/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Morse_code {
    public static void main(String[] args){
        Decoder fileDecoder = new Decoder();
        // The file is now decoded and printed out afterwards. 
        System.out.print(fileDecoder.decodeFile("99_morse_secretCode.txt"));
    }

    static class Decoder {
        private static final char CYPHER_ON = '+';
        private static final char CYPHER_OFF = '-';
        private static enum Status {CS_STARTED,CS_LONG,CS_ENDED,MC_ENDED};
        private HashMap<MorseCharacter, Character> morseCharToAsciiDict;
        
        public Decoder() {
            morseCharToAsciiDict = MorseCharacter.getMorseCharToAsciiDict();
        }
        
        public String decodeFile(String filename) {
            String inputText;
            try {
              inputText = new String( Files.readAllBytes( Paths.get(filename) ) );
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
            // Create a list of MorseCharacters from input text
            List<MorseCharacter> morseChars = createMorseCharacterList(inputText);
            
            // decode the list and return a cleartext string
            return decodeMorseCharacterList(morseChars);
        }

        private List<MorseCharacter> createMorseCharacterList (String inputText) {
        /* from inputText we create a CypherStream and split it up into a MorseCharacterList  
           Eventually, we have to clean the content of the read file as
           Eric pressed extensively on ON or OFF.
        a MorseCharacterList consists of multiple MorseCharacters,
        a MorseCharacter consists of multiple CypherSymbols (SHORT and LONG)
        a CypherSymbol starts with CYPHER_ON and ends with CYPHER_OFF, 
          LONG = CYPHER_ON + CYPHER_ON + <<any more CYPHER_ON>> + CYPHER_OFF 
          SHORT = CYPHER_ON + CYPHER_OFF
        if there's one more CYPHER_OFF after CYPHER_OFF, it completes a MorseCharacter. 
        */
            List<MorseCharacter> morseCharList = new ArrayList<>();
            MorseCharacter morseCharacter = new MorseCharacter();

            Status status = Status.MC_ENDED;
            char inputChar;
            for (int i=0; i<inputText.length();i++){
                inputChar = inputText.charAt(i);
                if (status == Status.CS_ENDED && inputChar==CYPHER_OFF){
                    status = Status.MC_ENDED;
                    morseCharList.add(morseCharacter);
                    morseCharacter = new MorseCharacter();
                }
                else if ((status == Status.CS_ENDED || status == Status.MC_ENDED)
                    && inputChar==CYPHER_ON){
                    status = Status.CS_STARTED;
                }
                else if (status == Status.CS_STARTED && inputChar==CYPHER_OFF){
                    status = Status.CS_ENDED;
                    morseCharacter.addShortSymbol();
                }
                else if (status == Status.CS_STARTED && inputChar==CYPHER_ON){
                    status = Status.CS_LONG;
                    morseCharacter.addLongSymbol();
                }
                else if (status == Status.CS_LONG && inputChar==CYPHER_OFF){
                    status = Status.CS_ENDED;
                }
            }
            if (!(morseCharacter.equals(new MorseCharacter()))){
                morseCharList.add(morseCharacter);
            }
            return morseCharList;            
        }
        
        private String decodeMorseCharacterList(List<MorseCharacter> morseCharacters) {
            /*
            The MorseCharacterList is decoded and returned as a human-readable text. 
            For each MorseCharacter checks if it exists in the morse alphabet. 
            In case it does, it is appended to the text, otherwise a question mark is added. 
            Each output character is followed by a whitespace.
            */            
            StringBuilder translatedText = new StringBuilder();

            for (MorseCharacter morseCharacter : morseCharacters) {
                if (morseCharToAsciiDict.containsKey(morseCharacter))
                    translatedText.append(morseCharToAsciiDict.get(morseCharacter) + " ");
                else 
                    translatedText.append("? ");
            }
            return translatedText.toString();
        }
	}

    static public class MorseCharacter{
        /* a MorseCharacter is a list of CypherSymbols */
        // the Morse Alphabet here represented as human readable strings
        // in each string the first character is the ASCII character, the rest are CypherSymbols
        private static final String[] CODESTRINGS = {
            "a.-",   "b-...", "c-.-.",  "d-..",  "e.",    "f..-.",
            "g--.",  "h....", "i..",    "j.---", "k-.-",  "l.-..",
            "m--",   "n-.",   "o---",   "p.--.", "q--.-", "r.-.",
            "s...",  "t-",    "u..-",   "v...-", "w.--",  "x-..-",
            "y-.--", "z--..", "?..--..","..-.-", ",--..--",
            "1.----","2..---","3...--", "4....-","5.....",
            "6-....","7--...","8---..", "9----.","0-----"};
        private static final char SHORT = '.'; //represents CypherSymbol.SHORT
        private static final char LONG = '-';  //represents CypherSymbol.LONG
    
        // each CypherSymbol is represented by one bit
        //   CypherSymbol.SHORT represented by bit 0
        //   CypherSymbol.LONG represented by bit 1
        // a MorseCharacter is stored in one byte (8 bits),
        // because the longest morse characters are 6 bits long
        // e.g. ".-." (SHORT LONG SHORT) 
        // stored as character:0b010, lenght:3 (bits)
        private byte character;  
        private byte length;

        public MorseCharacter(){
            // constructor for start building a character
            this.character = 0;
            this.length = 0;
        }
        public void addShortSymbol(){
            // shift all bits to the left by 1 position, lowest bits gets 0
            this.character <<= 1;
            this.length++;            
        }
        public void addLongSymbol(){
            // shift all bits to the left by 1 position
            // lowest bit is set to 1
            this.character <<= 1;
            this.character |= 0b1;
            this.length++;
        }        

        public MorseCharacter(String codestr, char cypherSymbolLong, char cypherSymbolShort){
            /* constructor from string
               e.g. from ".-.", where LONG='-', SHORT='.' 
            */
            this();
            for (int i=0; i<codestr.length(); i++){
                if (codestr.charAt(i)==cypherSymbolLong)
                    this.addLongSymbol();
                else if (codestr.charAt(i)==cypherSymbolShort)
                    this.addShortSymbol();
            }
        }

        public static HashMap<MorseCharacter, Character> getMorseCharToAsciiDict() {
            /* Create a MorseCharacter => ASCII dictionary */
            HashMap<MorseCharacter, Character> dict = new HashMap<>(60);
            char asciiChar;
            String cypherChars;
            for (int i=0; i<CODESTRINGS.length; i++){
                asciiChar = CODESTRINGS[i].charAt(0);
                cypherChars = CODESTRINGS[i].substring(1);
                MorseCharacter morseChar = new MorseCharacter(cypherChars, LONG, SHORT);
                dict.put(morseChar, asciiChar);
            }
            return dict;
        }

        @Override
        public int hashCode(){
            // combine the 2 attribute into an Integer
            return ((int) this.character)<<8 | this.length;
        }

        @Override
        public boolean equals(Object other) {
            /* two MorseCharacters are equal, if they have the same lenght and each bits are equal. */
            if (! (other instanceof MorseCharacter))
                return false;

            MorseCharacter mc = (MorseCharacter) other;
            if (this.length == mc.length && this.character == mc.character)
                return true;

            return false;
        }
    }

}
