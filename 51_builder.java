class builder_pattern {
    public static void main(String[] args) {
        Builder pojo1 = new Builder("argument1").optional1(42);
        System.out.println(pojo1.toString());
        Builder pojo2 = new Builder("argument2").optional2(3);
        System.out.println(pojo2.toString());
    }

    static class Builder {
        private String mandatory;
        private int opt1;
        private int opt2;
        
        // constructor with obligatory attribute
        public Builder(String mandatory){
            this.mandatory = mandatory;
        }
        // optional attribute
        public Builder optional1(int opt1){
            this.opt1 = opt1;
            return this;
        }
        // optional attribute
        public Builder optional2(int opt2){
            this.opt2 = opt2;
            return this;
        }

        @Override
        public String toString(){
            return this.mandatory+" "+opt1+" "+opt2;
        }
    }
}
