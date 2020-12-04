package flyweight;

import java.util.UUID;

public class Bullet {
    public UUID uuid = UUID.randomUUID();
    public boolean living = true;

    public Bullet(boolean living) {
        this.living = living;
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "uuid=" + uuid +
                ", living=" + living +
                '}';
    }
}
