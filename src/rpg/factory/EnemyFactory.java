package rpg.factory;

import rpg.entities.enemies.Enemy;
import rpg.entities.enemies.Enemigo;
import rpg.entities.enemies.Oso;

import java.util.Random;

public class EnemyFactory {
    private static final Random RANDOM = new Random();

    public static Enemy getEnemy() {
        // Lista de enemigos posibles
        Enemy[] enemies = {
                new Enemigo(),
                new Oso(),
        };

        // Selección aleatoria
        int index = RANDOM.nextInt(enemies.length);
        return enemies[index];
    }
}
