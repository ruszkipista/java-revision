
class ElectricCircuit {

    public static void main(String[] args) {
        LightBulb lightBulb = new LightBulb();
        Battery battery = new Battery();
        // circuit: battery => lightBulb => battery(same)
        battery.connectThisMinusToOtherPlus(lightBulb);
        lightBulb.test();
        battery.connectThisPlusToOtherMinus(lightBulb);
        lightBulb.test();

        Wire wire1 = new Wire();
        Wire wire2 = new Wire();
        TwoEndSwitch twoEndSwitch = new TwoEndSwitch(false);

        // circuit: battery => wire1 => twoEndSwitch => wire2 => lightBulb => battery(same)
        battery.connectThisMinusToOtherPlus(lightBulb);
        battery.connectThisPlusToOtherMinus(wire1);
        wire1.connectThisPlusToOtherMinus(twoEndSwitch);
        twoEndSwitch.connectThisPlusToOtherMinus(wire2);
        wire2.connectThisPlusToOtherMinus(lightBulb);
        twoEndSwitch.test();
        lightBulb.test();
        twoEndSwitch.switchState();
        twoEndSwitch.test();
        lightBulb.test();
    }

    static abstract class TwoEndConductor{
        private TwoEndConductor plus;
        private TwoEndConductor minus;

        // connect this conductor with an other
        // +(this)- <=> +(other)-
        public void connectThisMinusToOtherPlus(TwoEndConductor other){
            this.minus = other;
            other.plus = this;
            // send signal (0) through the circuit, that new connection was made
            forwardCurrentFromMinusToPlus(0);
        }

        // connect this conductor with an other
        // +(other)- <=> +(this)-
        public void connectThisPlusToOtherMinus(TwoEndConductor other){
            this.plus = other;
            other.minus = this;
            // send signal (0) through the circuit, that new connection was made
            forwardCurrentFromMinusToPlus(0);
        }        

        public void forwardCurrentFromMinusToPlus(float current){
            if (this.plus != null)
                this.plus.forwardCurrentFromMinusToPlus(current);
        }
    }

    static class Wire extends TwoEndConductor{

    }

    static class TwoEndSwitch extends TwoEndConductor{
        private boolean switchState;

        public TwoEndSwitch(boolean switchState){
            this.switchState = switchState;
        }

        public void switchState(){
            this.switchState = ! this.switchState;
            super.forwardCurrentFromMinusToPlus(0);
        }

        @Override
        public void forwardCurrentFromMinusToPlus(float current){
            // forward current only if it is in ON state
            if (this.switchState)
                super.forwardCurrentFromMinusToPlus(current);
        }

        public void test(){
            if (this.switchState)
                System.out.println("switch: ON");
            else
                System.out.println("switch: off");
        }        
    }

    static class LightBulb extends TwoEndConductor{
        boolean isEmitLight;

        public LightBulb(){
            this.isEmitLight = false;
        }

        public boolean isEmitLight(){
            return this.isEmitLight;
        }

        @Override
        public void forwardCurrentFromMinusToPlus(float current){
            // if received current is greater than 0
            if (current > 0) this.isEmitLight = true;
            else this.isEmitLight = false;
            // forward the received current
            super.forwardCurrentFromMinusToPlus(current);
        }

        public void test(){
            if (this.isEmitLight())
                System.out.println("bulb: LIGHT!");
            else
                System.out.println("bulb: dark");
        }
    }

    static class Battery extends TwoEndConductor{

        @Override
        public void forwardCurrentFromMinusToPlus(float current){
            // if received current is 0, then new connection was made
            if (current == 0) 
                // send a -1 current around in the circuit
                super.forwardCurrentFromMinusToPlus(-1);

            else
                // the -1 current went a round => there is a circuit
                if (current < 0) 
                    // send a real current (for consumption of appliances, e.g. light bulb)
                    super.forwardCurrentFromMinusToPlus(1);
        }
    }
}