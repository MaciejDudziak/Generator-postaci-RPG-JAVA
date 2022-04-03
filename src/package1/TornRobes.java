package package1;

public class TornRobes implements Armor{
    String name = "Torn robes";
    double damageReduction = 0.1;

    public void presentArmor() {
        System.out.println("My armor is: " + name);
    }
    public double returnDamageReduction(){
        return damageReduction;
    }
    public String returnName(){
        return name;
    }
}
