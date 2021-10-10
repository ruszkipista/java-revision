class Builder_pattern {
    /*
    * Build an object with obligatory and optional attributes
    */
    public static void main(String[] args) {
        Vehicle pojo1 = new Vehicle("car", "steel").engine("four stroke petrol");
        System.out.println(pojo1.toString());
        Vehicle pojo2 = new Vehicle("bicycle","wood").wheels(2);
        System.out.println(pojo2.toString());
    }

    static class Vehicle {
        private String name;
        private String chassis;
        private String engine;
        private int wheels;
        
        // constructor with obligatory attribute
        public Vehicle(String name, String chassis){
            this.name = name;
            this.chassis = chassis;
            // default values for optional attributes
            this.engine = null;
            this.wheels = 0;
        }
        // optional attribute
        public Vehicle engine(String engine){
            this.engine = engine;
            return this;
        }
        // optional attribute
        public Vehicle wheels(int wheels){
            this.wheels = wheels;
            return this;
        }

        @Override
        public String toString(){
            return "Vehicle:"+this.name +
                    ", chassis: "+this.chassis +
                    ((this.engine==null)?"":(", engine: "+this.engine)) +
                    ((this.wheels==0)?"":(", wheels: "+this.wheels));
        }
    }
}
