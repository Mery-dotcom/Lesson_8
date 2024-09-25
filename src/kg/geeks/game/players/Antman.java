package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Antman extends Hero{
    private int baseHealth;
    private int baseDamage;

    public Antman(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.CHANGE_SIZE);
        this.baseHealth = health;
        this.baseDamage = damage;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] hero) {
        int change = RPG_Game.random.nextInt(2);
        int coefficient = RPG_Game.random.nextInt(3) + 1;

        if (change == 1) {
            this.setHealth (this.getHealth() + baseHealth * coefficient);
            this.setDamage(this.getDamage() + baseDamage * coefficient);
            System.out.println("Antman increased size! Health: " + this.getHealth() +
                    ". Damage: " + this.getDamage());
        }else {
            this.setHealth (this.getHealth() - baseHealth * coefficient);
            this.setDamage(this.getDamage() - baseDamage * coefficient);
            System.out.println("Antman decreased size: " + this.getHealth() +
                    ". Damage: " + this.getDamage());
        }
        this.setHealth(baseHealth);
        this.setDamage(baseDamage);
        System.out.println("Antman returned to normal size. Health: " +
                baseHealth + " Damage: " + baseDamage);
    }
}
/*в каждом раунде он может увеличиться или же уменьшится на N-ный размер,
также увеличиваются/уменьшаются жизнь и урон,
после раунда он возвращается в исходный размер*/
