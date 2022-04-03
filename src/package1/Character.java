package package1;

public abstract class Character {
     String name;
     double hitPoints;
     Weapon currentWeapon;
     Armor currentArmor;
    public Character(String name, int baseHp, Weapon startingWeapon, Armor startingArmor){
        this.name = name;
        this.hitPoints = baseHp;
        this.currentWeapon = startingWeapon;
        this.currentArmor = startingArmor;
    }
    void walk(){
        System.out.println("What an epic journey!");
    }
    void setWeapon(Weapon weapon){
        this.currentWeapon = weapon;
    }
    void setArmor(Armor armor){
        this.currentArmor = armor;
    }
    public String toString(){
        return this.getClass().getSimpleName() + " " + name + " " + currentWeapon.returnName() + " " + currentArmor.returnName();
    }

}
