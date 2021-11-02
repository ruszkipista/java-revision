class CharacterSimU {
    /*

    */      
    public static void main(String[] args) {
        // construct a King
        Character king = new Character("King", new Knife());
        king.describe();
        // construct a Knight
        Character knight = new Character("Knight", new Sword());
        knight.describe();
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
        public void fight(){
            this.WeaponBehaviour.useWeapon();
        }

        public void describe(){
            System.out.print("I am the "+this.name+" and ");
            this.fight();
            System.out.println();
        }
    }

    // WEAPON
    interface WeaponBehaviour{
        public void useWeapon();
    }

    static class Knife implements WeaponBehaviour{
        @Override
        public void useWeapon(){
            System.out.print("I can stab with knife");
        }
    }
    static class Sword implements WeaponBehaviour{
        @Override
        public void useWeapon(){
            System.out.print("I can cut with sword");
        }
    }
}
