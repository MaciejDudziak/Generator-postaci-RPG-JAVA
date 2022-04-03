package package1;

public class Sorcerer extends Character {
    static Staff staff = new Staff();
    static TornRobes tornRobes = new TornRobes();
    public Sorcerer(String name){
        super(name,8,staff,tornRobes);
    }
}
