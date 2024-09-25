package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Ludoman extends Hero {

    public Ludoman(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.STEAL_HEALTH);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int dice1 = RPG_Game.random.nextInt(6) + 1;
        int dice2 = RPG_Game.random.nextInt(6) + 1;

        System.out.println("Ludoman throw game dice.");

        if (dice1 == dice2) { //same
            int damageToBoss = dice1 * dice2;
            boss.setHealth(boss.getHealth() - damageToBoss);
            System.out.println("Ludoman hit Boss " + damageToBoss + " damage.");
        } else {
            int damageToHero = dice1 + dice2;
            int randomIndex = RPG_Game.random.nextInt(heroes.length);
            Hero randomTeammate = heroes[randomIndex];

            while (randomTeammate == this) {
                randomIndex = RPG_Game.random.nextInt(heroes.length);
                randomTeammate = heroes[randomIndex];
            }
            randomTeammate.setHealth(randomTeammate.getHealth() - damageToHero);
            System.out.println("Ludoman hit " + randomTeammate.getName() + " with damage " + damageToHero + ".");
        }
    }
}

/*Лудоман. Его способность: Он бросает две игральные кости, если они совпадают,
то он отнимает произведение чисел которые выпали из здоровья босса,
если же они не совпадают, то он отнимает сумму чисел из здоровья случайного сокомандника.*/
