package package1;

public class Cross implements Weapon{
    String name = "Cross";
    int damage = 5;
    int range = 3;
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
