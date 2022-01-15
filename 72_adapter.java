class Adapter_pattern {
/*
you have at least two classes with incompatible interfaces:
- A useful service class, which you can’t change (often 3rd-party, legacy 
or with lots of existing dependencies).
- One or several client classes that would benefit from using the service class.

An ADAPTER wraps one of the objects to hide the complexity of conversion happening behind the scenes.
Also can help objects with different interfaces to collaborate. The wrapped object isn’t even aware of the adapter.
Sometimes it’s even possible to create a two-way adapter that can convert the calls in both directions.

Facade defines a new interface for existing objects, whereas Adapter tries to make the existing
interface usable. Adapter usually wraps just one object, while Facade works with an entire
subsystem of objects.
*/
    public static void main(String[] args) {

        //current way of doing
        ExistingInterface library = new ExistingLibrary();
        library.request();

        // new way of doing with the replacement library
        library = new ReplacementLibraryAdapter(new ReplacementLibrary());
        // same method call
        library.request();

    }

    interface ExistingInterface{
        public void request();
    }

    static class ExistingLibrary implements ExistingInterface{
        public void request(){
            // Do something
        }
    }

    // Adapter: allows the call of ReplacementLibrary through the ExistingIntarface
    static class ReplacementLibraryAdapter implements ExistingInterface{
        ReplacementLibrary replacementLibrary;

        public ReplacementLibraryAdapter(ReplacementLibrary replacementLibrary){
            this.replacementLibrary = replacementLibrary;
        }

        public void request(){
            this.replacementLibrary.specialRequest();
        }
    }

    // Adaptee
    static class ReplacementLibrary{
        public void specialRequest(){
            // Do something, but in a different way
        }
    }

}
