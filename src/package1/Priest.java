package package1;

public class Priest extends Character{
    static Cross cross = new Cross();
    static Vestment vestment = new Vestment();
    public Priest(String name){
        super(name,12,cross,vestment);
    }
}
