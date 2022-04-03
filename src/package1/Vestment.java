package package1;

public class Vestment implements Armor{
    String name = "Vestment";
    double damageReduction = 0.9;

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
