class Adventure_Game { 
    public static void main(String[] args) {
        // construct a King character
        Character king = new Character("King", new Knife());
        king.describe();
        // construct a Knight
        Character knight = new Character("Knight", new Sword());
        knight.describe();
        // construct a Queen
        Character queen = new Character("Queen", new HairPin());
        queen.describe();
        // construct a Troll
        Character troll = new Character("Troll", new Axe());
        troll.describe();
        // replace Weapon behaviour
        king.setWeaponBehaviour(new Sword());
        king.describe();
    }

    // Character
    static class Character{
        private String name;
        private WeaponBehaviour WeaponBehaviour;
        public Character(String name, WeaponBehaviour WeaponBehaviour){
            this.name = name;
            this.WeaponBehaviour = WeaponBehaviour;
        }

        public void setWeaponBehaviour(WeaponBehaviour newWeaponBehaviour){
            this.WeaponBehaviour = newWeaponBehaviour;
        }
        public String fight(){
            return this.WeaponBehaviour.useWeapon();
        }

        public void describe(){
            System.out.println("I am the "+this.name+" and "+this.fight());
        }
    }

    // WEAPON
    interface WeaponBehaviour{
        public String useWeapon();
    }

    static class Knife implements WeaponBehaviour{
        @Override
        public String useWeapon(){
            return "I can cut with my knife";
        }
    }
    static class Sword implements WeaponBehaviour{
        @Override
        public String useWeapon(){
            return "I can swing my sword";
        }
    }
    static class Axe implements WeaponBehaviour{
        @Override
        public String useWeapon(){
            return "I can chop with my axe";
        }
    }
    static class BowAndArrow implements WeaponBehaviour{
        @Override
        public String useWeapon(){
            return "I can shoot an arrow with my bow";
        }
    }
    static class HairPin implements WeaponBehaviour{
        @Override
        public String useWeapon(){
            return "I can stab with my hair pin";
        }
    }
}
