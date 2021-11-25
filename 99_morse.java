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
        private List<MorseCharacter> morseAlphabet;
        
        public Decoder() {
            morseAlphabet = MorseDictionary.get();
        }
        
        public String decodeFile(String filename) {
            char[] inputText = getFileContent(filename);
            /* Create a list of MorseCharacters (morseStream) from input text */
            List<MorseSymbol> morseSymbolStream = createMorseSymbolStream(inputText);
            /* decode the morseSymbolStream and return the result */
            return decodeMorseSymbolStream(morseSymbolStream);
        }

        private char[] getFileContent(String filename) {
            String content;
            try {
                content = new String ( Files.readAllBytes( Paths.get(filename) ) );
                return content.toCharArray();
            } 
            catch (IOException e) {
                e.printStackTrace();
                return null;
            } 
        }

        private enum Status {CS_STARTED,CS_LONG,CS_ENDED,MC_ENDED};

        private List<MorseSymbol> createMorseSymbolStream (char[] inputStream) {
        /* from inputStrem we create a CypherStream and split it up into a MorseSymbolStream  
           Eventually, we have to clean the content of the read file as
           Eric pressed extensively on ON or OFF.
        a MorseStream (which is implemented as an ArrayList) consists of multiple MorseCharacters,
        a MorseCharacter consists of multiple CypherSymbols
        a CypherSymbol starts with CYPHER_ON and ends with CYPHER_OFF, 
          LONG = CYPHER_ON + CYPHER_ON + <<any more CYPHER_ON>> + CYPHER_OFF 
          SHORT = CYPHER_ON + CYPHER_OFF
        if there's one more CYPHER_OFF after CYPHER_OFF, it completes a MorseCharacter. 
        */
            List<MorseSymbol> morseStream = new ArrayList<>();
            List<CypherSymbol> cypherSymbols = new ArrayList<>();

            Status status = Status.MC_ENDED;
            for (char inputChar:inputStream){
                if (status == Status.MC_ENDED && inputChar==CYPHER_OFF) {
                    continue;
                }
                else if (status == Status.CS_ENDED && inputChar==CYPHER_OFF){
                    status = Status.MC_ENDED;
                    morseStream.add(new MorseSymbol(cypherSymbols));
                    cypherSymbols = new ArrayList<>();
                    continue;
                }
                else if ((status == Status.CS_ENDED || status == Status.MC_ENDED)
                    && inputChar==CYPHER_ON){
                    status = Status.CS_STARTED;
                    continue;
                }
                else if (status == Status.CS_STARTED && inputChar==CYPHER_OFF){
                    status = Status.CS_ENDED;
                    cypherSymbols.add(CypherSymbol.SHORT);
                    continue;
                }
                else if (status == Status.CS_STARTED && inputChar==CYPHER_ON){
                    status = Status.CS_LONG;
                    cypherSymbols.add(CypherSymbol.LONG);
                    continue;
                }
                else if (status == Status.CS_LONG && inputChar==CYPHER_ON){
                    continue;
                }
                else if (status == Status.CS_LONG && inputChar==CYPHER_OFF){
                    status = Status.CS_ENDED;
                    continue;
                }
            }
            if (cypherSymbols.size()>0){
                morseStream.add(new MorseSymbol(cypherSymbols));
            }
            return morseStream;            
        }
        
        private String decodeMorseSymbolStream(List<MorseSymbol> morseStream) {
            /*
            * The morseStream is decoded and returned as a human-readable text. 
            * Therefore, it has to be checked whether the morse code symbol (MorseCharacter) 
            * exists in the morseAlphabet. 
            * In case it does, it is appended to the text, otherwise a question mark is added. 
            * Each character is followed by a whitespace.
            */
            
            StringBuilder translatedText = new StringBuilder();
            /* Please check whether morseCharacter is found in the morseAlphabet here. 
            * If it has been found, append the (translated) character to the translated text.
            * Otherwise, a question mark is appended at this position in the text.
            */
            boolean foundMatch;
            for (MorseSymbol morseSymbol : morseStream) {
                foundMatch = false;
                for (MorseCharacter potentialMatch : morseAlphabet) {
                    if (morseSymbol.equals(potentialMatch.morseSymbol)) {
                        foundMatch = true;
                        translatedText.append(potentialMatch.getCharacter() + " ");
                        break;
                    }
                }
                if (!foundMatch){
                    translatedText.append("?");
                }
            }
            return translatedText.toString();
        }
	}

    public static enum CypherSymbol {
        /* A MorseCharacter consists of a unique sequence of CypherSymbols */
        SHORT, LONG, BLANK
    }
    static public class MorseSymbol{
        public CypherSymbol[] cypherSymbols;

        public MorseSymbol(int lenght){
            cypherSymbols = new CypherSymbol[lenght];
        }
        public MorseSymbol(List<CypherSymbol> cypherSymbolsList){
            cypherSymbols = cypherSymbolsList.toArray(new CypherSymbol[cypherSymbolsList.size()]);
        }
        public boolean equals(MorseSymbol other) {
            /* If two MorseSymbols have the same size and 
            * each of their CypherSymbols are equal, the MorseSymbols are equal.
            */
            boolean result = true;
            if (this.cypherSymbols.length == other.cypherSymbols.length){
                for (int i=0; i<cypherSymbols.length; i++)
                    if (this.cypherSymbols[i] != other.cypherSymbols[i]){
                        result = false;
                        break;
                    }
            } else result = false;
            return result;
        }
        public int length(){
            return cypherSymbols.length;
        }
        public CypherSymbol get(int index){
            return cypherSymbols[index];
        }
        public void add(int index, CypherSymbol cypherSymbol){
            cypherSymbols[index] = cypherSymbol;
        }
    }

    static public class MorseCharacter {
        /* A MorseCharacter consists of multiple concatenated CypherSymbols
         * and the corresponding ASCII character (the translation of the code).
         */
        private MorseSymbol morseSymbol;
        private char character;
        
        public MorseCharacter(Character character, MorseSymbol morseSymbol){
            this.character = character;
            this.morseSymbol = morseSymbol;
        }

        public char getCharacter(){
            return character;
        }
        public MorseSymbol getMorseSymbol(){
            return morseSymbol;
        }
    }

    static class MorseDictionary {
        private static final char[] characters = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '?', '.', ',', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
        // Morse codes as strings
        private static final String[] codes
            = { ".-",   "-...", "-.-.",  "-..",  ".",    "..-.", //abcdef
                "--.",  "....", "..",    ".---", "-.-",  ".-..", //ghijkl
                "--",   "-.",   "---",   ".--.", "--.-", ".-.",  //mnopqr
                "...",  "-",    "..-",   "...-", ".--",  "-..-", //stuvwx
                "-.--", "--..", "..--..",".-.-", "--..--",       //yz?.,
                ".----","..---", "...--","....-",".....",        //12345
                "-....","--...", "---..","----.","-----"};       //67890

        public static List<MorseCharacter> get() {
            /* Here we create the MorseDictionary for our code. */
            List<MorseCharacter> morseAlphabet = new ArrayList<MorseCharacter>();
            for (int i=0;i<characters.length;i++){
                morseAlphabet.add(new MorseCharacter(characters[i], getMorseSymbol(codes[i])));
            }
            return morseAlphabet;
        }

        private static MorseSymbol getMorseSymbol(String codestr){
            MorseSymbol ms = new MorseSymbol(codestr.length());
            int i;
            for (i=0; i<ms.length(); i++){
                if (codestr.charAt(i)=='.')
                    ms.add(i,CypherSymbol.SHORT);
                else 
                    ms.add(i,CypherSymbol.LONG);
            }
            return ms;
        }
    }    
}
