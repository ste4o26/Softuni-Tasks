package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {
    private static final int BASE_EXPERIENCE = 10;
    private static final int BASE_HEALTH = 10;
    private Dummy dummy;

    private void setupAliveDummy() {
        this.dummy = new Dummy(BASE_HEALTH, BASE_EXPERIENCE);
    }

    private void setupDeadDummy() {
        this.dummy = new Dummy(-BASE_HEALTH, BASE_EXPERIENCE);
    }

    @Test
    public void dummyShouldLoseHealthWhenIsAttacked() {
        setupAliveDummy();
        int attackPoints = 5;
        int expected = this.dummy.getHealth() - attackPoints;

        this.dummy.takeAttack(attackPoints);

        assertEquals("Dummy does not lose health after being attacked!", expected, this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void dummyShouldThrowExceptionIfHealthIsLessThanOrEqualToZero() {
        setupDeadDummy();
        int attackPoints = 5;
        this.dummy.takeAttack(attackPoints);
    }

    @Test
    public void dummyShouldGiveExperienceIfIsDead() {
        setupDeadDummy();
        int actual = this.dummy.giveExperience();

        assertEquals("Dummy does not give experience when its dead!", BASE_EXPERIENCE, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void dummyShouldNotGiveExperienceIfIsAlive() {
        setupAliveDummy();
        this.dummy.giveExperience();
    }
}
