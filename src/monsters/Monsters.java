//this is the version from kayla on slack

package monsters;

import java.util.Random;


abstract public class Monsters {
    
    public static Random r = new Random();

    private static String name;
    public int health = 10;
    private int attackPower;
//    public static int activeDamage = r.nextInt(10);
    
    abstract public boolean isAlive(int health);
    abstract public void takeDamage(int damage);
    abstract public void attack(Monsters lt);
    
//    public static void combat(Hero hercules, Monsters activeMonster) {
//        while (hercules.health > 0 && activeMonster.health > 0) {
//            hercules.attack(activeMonster);
//            System.out.println(name + " has been hit.");
//            if(activeMonster.health <= 0) {
//            	System.out.println(name + " was defeated!");
////            	if the first monster dies, we want to rotate to the next one, rather than break.
//            	System.out.println("a " + name + " now comes to fight Hercules!");
//                break;
//            }
//            System.out.println("Hercules score: " + hercules.health + " " + name + " score: " + activeMonster.health);
//            activeMonster.attack(hercules);
//            System.out.println("Hercules has been hit.");
//            if(hercules.health <= 0) {
//            	System.out.println("Hercules was defeated!");
//            	break;
//            }
//            System.out.println("Hercules score: " + hercules.health + " " + name + " score: " + activeMonster.health);
//        }
////        if(activeMonster.health <= 0) {
////            System.out.println(name + " was defeated!");
////        } else {
////            System.out.println("Hercules was defeated!");
////        }
//    }
    
    public static void main(String[] args) {
        Hero hercules = new Hero();
        
        Monsters[] creatures = new Monsters[3];
        creatures[0] = new Rat();
        creatures[1] = new Ogre();
        creatures[2] = new Goblin();
//        return hercules.fight(creatures);
        System.out.println(hercules.fight(creatures));
        //Monsters activeMonster = creatures[Monsters.r.nextInt(3)];

//        System.out.println(activeMonster);
//        System.out.println(activeDamage);
//        System.out.println(hercules.health);
//        System.out.println(creatures[0].health);
//        System.out.println(new Rat().health);
//        creatures[0].takeDamage(activeDamage);
        //Monsters.loop(hercules);
    }

}

class Rat extends Monsters {
    
    public boolean isAlive(int health) {
        if(this.health > 0) {
        return true;
    } else {return false;}
        }
    
    public void takeDamage(int damage) {
        this.health = this.health - damage;
//        System.out.println(this.health);
        if(isAlive(this.health) == true) {
//            System.out.println("I'm not dead.");
        };
    }
    public void attack(Monsters lt) {
        int ran = Monsters.r.nextInt(9)+1;
        lt.takeDamage(ran);
    }
    
}

class Ogre extends Monsters {
    
    public boolean isAlive(int health) {
        return true;
    }
    
    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public void attack(Monsters lt) {
        int ran = Monsters.r.nextInt(9)+1;
        lt.takeDamage(ran);
    }
}

class Goblin extends Monsters {
    
    public boolean isAlive(int health) {
        return true;
    }
    
    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public void attack(Monsters lt) {
        int ran = Monsters.r.nextInt(9)+1;
        lt.takeDamage(ran);
    }
}

class Hero extends Monsters {
    int health = 10;
    
    public String fight(Monsters[] monsters) {
    	String returnString = "";
    	boolean heroWins = true;
    	for (int i = 0; i < monsters.length; i++) {
    		combat(this, monsters[i]);	
    		if (!(this.isAlive(this.health))) {
    			heroWins = false;
    		}
    	}
    	if (heroWins) {
    	returnString = "Hercules wins!";
    	} else {
    		returnString =  "he died";
    	}
    	return returnString;
    }
    
    public void combat(Hero hercules, Monsters activeMonster) {
        while (hercules.health > 0 && activeMonster.health > 0) {
            hercules.attack(activeMonster);
            System.out.println(activeMonster.getClass().getName() + " has been hit.");
            if(activeMonster.health <= 0) {
            	System.out.println(activeMonster.getClass().getName() + " was defeated!");
//            	if the first monster dies, we want to rotate to the next one, rather than break.
//            	System.out.println("a " + activeMonster.getClass().getName() + " now comes to fight Hercules!");
                break;
            }
            System.out.println("Hercules score: " + hercules.health + " " + activeMonster.getClass().getName() + " score: " + activeMonster.health);
            activeMonster.attack(hercules);
            System.out.println("Hercules has been hit.");
            if(hercules.health <= 0) {
            	System.out.println("Hercules was defeated!");
            	break;
            }
            System.out.println("Hercules score: " + hercules.health + " " + activeMonster.getClass().getName() + " score: " + activeMonster.health);
        }
//        if(activeMonster.health <= 0) {
//            System.out.println(name + " was defeated!");
//        } else {
//            System.out.println("Hercules was defeated!");
//        }
    }
    
   
//    public boolean combat(Monsters m, Hero h) {
//        if(Monsters.r.nextInt(3) == 0) {
//            name = "Rat";
//        } else if(Monsters.r.nextInt(3) == 1) {
//            name = "Ogre";
//        } else {
//            name = "Goblin";
//        }

//    }
    
    public boolean isAlive(int health) {
        if(health > 0) {
        return true;
    } else {return false;}
        }
    
    public void takeDamage(int damage) {
        this.health -= damage;
//        System.out.println(this.health);
//        if(isAlive(this.health) == true) {
//            System.out.println("I'm not dead.");
        };
    

    public void attack(Monsters lt) {
        int ran = Monsters.r.nextInt(9)+1;
        lt.takeDamage(ran);
    }
}