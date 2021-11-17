import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

class Decorator_Pattern_lowercase {
    /*
    */    
    public static void main(String[] args) throws IOException {
        Reader sr = new StringReader("I know the Decorator Pattern therefore I RULE!");
        sr = new ReaderToLowercase(sr);
        int c;
        while ((c=sr.read()) > 0){
            System.out.print((char)c);
        }
        System.out.println();
        sr.close();
    }
    // abscract decorator class
    static abstract class DecoratedReader extends Reader{
        Reader reader;
        
        public DecoratedReader(Reader reader){
            this.reader = reader;
        }
        @Override
        public int read() throws IOException{
            return this.reader.read();
        }
        @Override
        public int read(char[] charray, int offset, int len) throws IOException{
            return this.reader.read(charray,offset,len);
        }
        @Override
        public void close() throws IOException{
            this.reader.close();
        }
    }
    // concrete decorator class
    static class ReaderToLowercase extends DecoratedReader{
        public ReaderToLowercase(Reader reader){
            super(reader);
        }
        @Override
        public int read() throws IOException{
            int c = super.reader.read();
            return (c==-1)? c : Character.toLowerCase((char)c);
        }
        @Override
        public int read(char[] charray, int offset, int len) throws IOException{
            int c = super.reader.read(charray,offset,len);
            return c;
        }
    }

}