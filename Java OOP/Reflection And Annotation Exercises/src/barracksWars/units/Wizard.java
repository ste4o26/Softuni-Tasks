package barracksWars.units;

public class Wizard extends AbstractUnit {
    private static final int WIZARD_HEALTH = 25;
    private static final int WIZARD_DAMAGE = 40;

    public Wizard() {
        super(WIZARD_HEALTH, WIZARD_DAMAGE);
    }
}
