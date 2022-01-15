class Proxy_pattern {
/*
Proxy is a structural design pattern that lets you provide a substitute or placeholder
for another object. A proxy controls access to the original object, allowing you to perform
something either before or after the request gets through to the original object.
*/
    public static void main(String[] args) {
        // expensive way to get service
        Service service1 = new ExpensiveService();
        service1.request();

        // delayed instantiaton of ExpensiveService via a proxy
        Service service2 = new LazyExpensiveServiceProxy();
        service2.request();
    }
    
    interface Service{
        public int request();
    }

    static class ExpensiveService implements Service{

        public ExpensiveService(){
            // this is an expensive instatiation
        }

        public int request(){
            // do something, cheap to answer this call
            return 0;
        }
    }
    
    static class LazyExpensiveServiceProxy implements Service{
        static private ExpensiveService s;

        public LazyExpensiveServiceProxy(){
            // this is a cheap instatiation
        }

        private ExpensiveService getService(){
            // this is an expensive instatiation, so we do it only once
            if (s==null) s = new ExpensiveService();
            return s;
        }

        public int request(){
            // cheap to answer this call
            return getService().request();
        }
    }     
}    