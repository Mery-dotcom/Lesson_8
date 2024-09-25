package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Avenger extends Hero{
private boolean isProtected;

    public Avenger(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.DEFENSE_TEAM);
        this.isProtected = false;
    }

    public void setProtected(boolean protectedHero) {
        isProtected = protectedHero;
    }

    public boolean isProtected(){
    return isProtected;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int chance = RPG_Game.random.nextInt(100) + 1;

        if (chance <= 20) {
            System.out.println("Avenger " + getName() + " activated " + SuperAbility.DEFENSE_TEAM + "!");
            for (Hero hero : heroes) {
                this.setProtected(true);
            }
        } else {
            System.out.println("Avenger " + getName() + " couldn't protect.");
        }
    }
}


/*Мститель - с шансом 20% может создать защиту всей команде на 1 раунд ,
никто из героев не получит урон от босса. */
