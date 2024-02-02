package flyweight;

import java.util.ArrayList;
import java.util.List;

public class BulletPool {
    List<Bullet> bullets = new ArrayList<>();

    {
        for (int i = 0; i < 10; i++) {
            bullets.add(new Bullet(true));
        }
    }

    public Bullet getBullet() {
        for (Bullet bullet : bullets) {
            if (bullet.living) {
                return bullet;
            }
        }
        return new Bullet(true);
    }
}
