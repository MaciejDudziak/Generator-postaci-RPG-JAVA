package package1;

public class HeavyArmor implements Armor {
    String name = "Heavy armor";
    double damageReduction = 0.5;

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