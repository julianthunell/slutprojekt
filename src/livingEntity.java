public abstract class livingEntity extends movingObject{

    int health;
    int damage;
    public livingEntity(float x, float y, int width, int height, char objectDir, World world) {
        super(x, y, width, height, objectDir, world);
    }
    public int getDamage() {
        return damage;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}
