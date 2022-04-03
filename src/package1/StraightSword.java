package package1;

public class StraightSword implements Weapon{
    String name = "Straight sword";
    int damage = 3;
    int range = 2;
    public void presentWeapon(){
        System.out.println("My weapon is: " + name);
    }
    public int returnDamage(){
        return damage;
    }
    public int returnRange(){
        return range;
    }
    public String returnName(){
        return name;
    }
}
