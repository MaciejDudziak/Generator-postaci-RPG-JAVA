package package1;

public class Staff implements Weapon {
    String name = "Staff";
    int damage = 12;
    int range = 8;
    public void presentWeapon() {
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
