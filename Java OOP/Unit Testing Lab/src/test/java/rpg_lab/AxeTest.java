package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {
    private static final int BASE_ATTACK = 10;
    private static final int BASE_DURABILITY = 10;

    private static final int BASE_HEALTH = 10;
    private static final int BASE_EXPERIENCE = 10;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setup() {
        this.axe = new Axe(BASE_ATTACK, BASE_DURABILITY);
        this.dummy = new Dummy(BASE_HEALTH, BASE_EXPERIENCE);
    }


    @Test
    public void weaponShouldLoseDurabilityAfterAttack() {
        this.axe.attack(this.dummy);
        int actual = this.axe.getDurabilityPoints();
        assertEquals("Weapon does not lose durability after attack!", BASE_DURABILITY - 1, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void attackingWithNegativeDurabilityShouldThrowException() {
        Axe axe = new Axe(BASE_ATTACK, 0);
        axe.attack(this.dummy);
    }
}
