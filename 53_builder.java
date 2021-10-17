class Builder_pattern {
/*
The Builder pattern is an alternative way to construct complex objects.
This pattern should be used when we want to build different immutable objects
using the same object building process.
Builder pattern aims to “Separate the construction of a complex object from its 
representation so that the same construction process can create different representations.”
The below example Vehicle class uses VehicleBuilder internal class which helps in building
desired Vehicle instance with all mandatory attributes and combination of optional attributes,
without losing the immutability. The created Vehicle object does not have any setter method,
so its state can not be changed once it has been built. This provides the desired immutability.
*/
    public static void main(String[] args) {
        Vehicle car = new Vehicle.VehicleBuilder("car", "steel")
                      .engine("four stroke petrol")
                      .wheels(4)
                      // without the build() call, the object is not created
                      // more so, gives compile error
                      .build();
        System.out.println(car.toString());

        Vehicle bicycle = new Vehicle.VehicleBuilder("bicycle","wood")
                          // no engine added
                          .wheels(2)
                          .build();
        System.out.println(bicycle.toString());
    }

    static class Vehicle {
        // all final private
        private final String name;   // required
        private final String chassis;// required
        private final String engine;   // optional
        private final int wheels;      // optional
        
        // only PRIVATE constructor with Builder
        private Vehicle(VehicleBuilder builder){
            this.name = builder.name;
            this.chassis = builder.chassis;
            this.engine = builder.engine;
            this.wheels = builder.wheels;
        }
        // only Getters, no Setters, so object immutable after construction
        public String getName(){return this.name;}        
        public String getChassis(){return this.chassis;}        
        public String getEngine(){return this.engine;}        
        public int getWheels(){return this.wheels;}        

        @Override
        public String toString(){
            return "Vehicle:"+this.name +
                    ", chassis: "+this.chassis +
                    ((this.engine==null)?"":(", engine: "+this.engine)) +
                    ((this.wheels==0)?"":(", wheels: "+this.wheels));
        }

        static class VehicleBuilder{
            private String name;
            private String chassis;
            private String engine;
            private int wheels;

            // two required attributes
            public VehicleBuilder(String name, String chassis){
                this.name = name;
                this.chassis = chassis;
            }
            // optional attribute
            public VehicleBuilder engine(String engine){
                this.engine = engine;
                return this;
            }
            // optional attribute
            public VehicleBuilder wheels(int wheels){
                this.wheels = wheels;
                return this;
            }
            // return the finally constructed Vehicle object
            public Vehicle build() {
                Vehicle vehicle =  new Vehicle(this);
                validateVehicleObject(vehicle);
                return vehicle;
            }
            private void validateVehicleObject(Vehicle vehicle) {
                //Do some basic validations to check 
                //if vehicle object does not break any system assumption
            }
        }
    }
}
