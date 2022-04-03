package package1;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static ArrayList<Character> characters = new ArrayList<>();

    public static void main(String[] args) {
        int amountOfCharacters = -1;
        while(true){
            Scanner myObj = new Scanner(System.in);
            System.out.println("Welcome to main menu what do you want to do?");
            System.out.println("Type an according number to select an option:");
            System.out.println("1) Create new base character and give it a name");
            System.out.println("2) Select existing character and perform an action");
            System.out.println("3) Create new character with weapon and armor of choice");
            System.out.println("4) Select two characters and make them fight");
            System.out.println("5) Exit");
            int userSelection = myObj.nextInt();
            if(userSelection == 1 || userSelection == 3){
                System.out.println("Select an origin:");
                System.out.println("Type an according number to select an origin:");
                System.out.println("1) Knight");
                System.out.println("2) Sorcerer");
                System.out.println("3) Priest");
                int originSelection = myObj.nextInt();
                System.out.println("What name do you want your character to have?");
                myObj.nextLine();
                String nameSelection = myObj.nextLine();
                if(originSelection == 1){
                    Knight knight = new Knight(nameSelection);
                    characters.add(knight);
                    amountOfCharacters += 1;
                }
                else if(originSelection == 2){
                    Sorcerer sorcerer = new Sorcerer(nameSelection);
                    characters.add(sorcerer);
                    amountOfCharacters += 1;
                }
                else if(originSelection == 3){
                    Priest priest = new Priest(nameSelection);
                    characters.add(priest);
                    amountOfCharacters += 1;
                }
                if(userSelection == 3){
                    System.out.println("What weapon do you want to use?");
                    System.out.println("Type an according number to select an option:");
                    System.out.println("1) Straight sword");
                    System.out.println("2) Staff");
                    System.out.println("3) Cross");
                    int weaponSelection = myObj.nextInt();
                    System.out.println("What armor do you want to use?");
                    System.out.println("Type an according number to select an option:");
                    System.out.println("1) Heavy armor");
                    System.out.println("2) Torn robes");
                    System.out.println("3) Vestment");
                    int armorSelection = myObj.nextInt();
                    if(weaponSelection == 1){
                        StraightSword straightSword = new StraightSword();
                        characters.get(amountOfCharacters).setWeapon(straightSword);
                    }
                    else if(weaponSelection == 2){
                        Staff staff = new Staff();
                        characters.get(amountOfCharacters).setWeapon(staff);
                    }
                    else if(weaponSelection == 3){
                        Cross cross = new Cross();
                        characters.get(amountOfCharacters).setWeapon(cross);
                    }
                    if(armorSelection == 1){
                        HeavyArmor heavyArmor = new HeavyArmor();
                        characters.get(amountOfCharacters).setArmor(heavyArmor);
                    }
                    else if(armorSelection == 2){
                        TornRobes tornRobes = new TornRobes();
                        characters.get(amountOfCharacters).setArmor(tornRobes);
                    }
                    else if(armorSelection == 3){
                        Vestment vestment = new Vestment();
                        characters.get(amountOfCharacters).setArmor(vestment);
                    }
                }
            }
            else if(userSelection == 2 || userSelection == 4) {
                System.out.println("Your characters are:");
                for (int i = 0; i < characters.size(); i++) {
                    System.out.println(i + ")" + " " + characters.get(i).toString());
                }
                if (userSelection == 2) {
                    System.out.println("Type an according number to choose your character");
                    int existingCharacterSelection = myObj.nextInt();
                    System.out.println("What do you want to do?");
                    System.out.println("Type an according number to choose your action");
                    System.out.println("1) Walk");
                    System.out.println("2) Present weapon and armor");
                    int playerActionChoice = myObj.nextInt();
                    if (playerActionChoice == 1) {
                        characters.get(existingCharacterSelection).walk();
                    } else if (playerActionChoice == 2) {
                        characters.get(existingCharacterSelection).currentWeapon.presentWeapon();
                        characters.get(existingCharacterSelection).currentArmor.presentArmor();
                    }
                }
                else{
                    if(characters.size()>=2) {
                        System.out.println("Type an according number to choose first fighter");
                        int firstFightingCharacter = myObj.nextInt();
                        System.out.println("Type an according number to choose second fighter");
                        int secondFightingCharacter = myObj.nextInt();
                        Character fighter1 = characters.get(firstFightingCharacter);
                        Character fighter2 = characters.get(secondFightingCharacter);
                        Character firstAttacker;
                        Character secondAttacker;
                        if(fighter1.currentWeapon.returnRange()>=fighter2.currentWeapon.returnRange()){
                            firstAttacker = fighter1;
                            secondAttacker = fighter2;
                        }
                        else{
                            firstAttacker = fighter2;
                            secondAttacker = fighter1;
                        }
                        int turnCounter = 1;
                        while(firstAttacker.hitPoints > 0 & secondAttacker.hitPoints > 0){
                            System.out.println("Turn " + turnCounter);
                            double damageCounter = secondAttacker.hitPoints;
                            secondAttacker.hitPoints -= (firstAttacker.currentWeapon.returnDamage()-firstAttacker.currentWeapon.returnDamage()*secondAttacker.currentArmor.returnDamageReduction());
                            damageCounter -= secondAttacker.hitPoints;
                            System.out.println(firstAttacker.name + " hits " + secondAttacker.name + " for " + String.format("%.2f", damageCounter) + " damage" + " leaving them with " + String.format("%.2f", secondAttacker.hitPoints) + " hp");
                            if(secondAttacker.hitPoints <= 0){
                                System.out.println("The winner is: " + firstAttacker.name);
                                characters.remove(secondFightingCharacter);
                                amountOfCharacters -= 1;
                                break;
                            }
                            double damageCounter2 = firstAttacker.hitPoints;
                            firstAttacker.hitPoints -= (secondAttacker.currentWeapon.returnDamage()-secondAttacker.currentWeapon.returnDamage()*firstAttacker.currentArmor.returnDamageReduction());
                            damageCounter2 -= firstAttacker.hitPoints;
                            System.out.println(secondAttacker.name + " hits " + firstAttacker.name + " for " + String.format("%.2f", damageCounter2) + " damage" + " leaving them with " + String.format("%.2f", firstAttacker.hitPoints) + " hp");
                            if(firstAttacker.hitPoints <= 0){
                                System.out.println("The winner is: " + secondAttacker.name);
                                characters.remove(firstFightingCharacter);
                                amountOfCharacters -= 1;
                                break;
                            }
                            turnCounter += 1;
                        }
                    }
                    else{
                        System.out.println("Not enough characters");
                    }
                }
            }
            else if(userSelection == 5){
                System.exit(0);
            }
        }
    }
}
