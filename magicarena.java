import java.util.Random;

class Player {
    int health;
    int strength;
    int attack;

    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public void attack(Player defender) {
        Random random = new Random();
        int attackRoll = random.nextInt(6) + 1;
        int defendRoll = random.nextInt(6) + 1;

        int attackDamage = attack * attackRoll;
        int defendStrength = defender.strength * defendRoll;

        int damageDealt = Math.max(0, attackDamage - defendStrength);
        defender.health -= damageDealt;

        System.out.println("Attacker rolled " + attackRoll + ", Defender rolled " + defendRoll);
        System.out.println("Attack damage: " + attackDamage + ", Defend strength: " + defendStrength);
        System.out.println("Defender health reduced by " + damageDealt + " to " + defender.health);
    }
}

public class MagicalArena {
    public static void main(String[] args) {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);

        while (playerA.health > 0 && playerB.health > 0) {
            if (playerA.health < playerB.health) {
                playerA.attack(playerB);
            } else {
                playerB.attack(playerA);
            }
            System.out.println();
        }

        if (playerA.health > 0) {
            System.out.println("Player A wins!");
        } else {
            System.out.println("Player B wins!");
        }
    }
}