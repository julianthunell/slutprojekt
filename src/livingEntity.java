public abstract class livingEntity extends movingObject{

    protected int health;
    protected int damage;
    protected livingEntity(float x, float y, int width, int height, char objectDir, World world, Panel panel) {
        super(x, y, width, height, objectDir, world, panel);
    }

    //getters and setters
    protected int getDamage() {
        return damage;
    }
    protected int getHealth() {
        return health;
    }
    protected void setHealth(int health) {
        this.health = health;
    }

    protected void setDamage(int damage) {
        this.damage = damage;
    }

}
