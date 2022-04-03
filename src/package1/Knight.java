package package1;

public class Knight extends Character {
    static StraightSword straightSword = new StraightSword();
    static HeavyArmor heavyArmor = new HeavyArmor();
    public Knight(String name){
        super(name,20,straightSword,heavyArmor);
    }
}
