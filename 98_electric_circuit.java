
class ElectricCircuit {

    public static void main(String[] args) {
        LightBulb lightBulb = new LightBulb();
        Battery battery = new Battery();
        // battery => lightBulb => battery(same)
        battery.connectThisMinusToOtherPlus(lightBulb);
        lightBulb.test();
        battery.connectThisPlusToOtherMinus(lightBulb);
        lightBulb.test();

        Wire wire1 = new Wire();
        Wire wire2 = new Wire();
        TwoEndSwitch twoEndSwitch = new TwoEndSwitch(false);

        // battery => wire1 => twoEndSwitch => wire2 => lightBulb => battery(same)
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

        // +(this)- <=> +(c)-
        public void connectThisMinusToOtherPlus(TwoEndConductor other){
            this.minus = other;
            other.plus = this;
            forwardCurrentFromMinusToPlus(0);
        }

        // +(this)- <=> +(c)-
        public void connectThisPlusToOtherMinus(TwoEndConductor other){
            this.plus = other;
            other.minus = this;
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
        @Override
        public void forwardCurrentFromMinusToPlus(float current){
            if (current > 0) this.isEmitLight = true;
            else this.isEmitLight = false;
            super.forwardCurrentFromMinusToPlus(current);
        }
        public boolean isEmitLight(){
            return this.isEmitLight;
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
            if (current == 0) super.forwardCurrentFromMinusToPlus(-1);
            else if (current == -1) super.forwardCurrentFromMinusToPlus(1);
        }
    }
}