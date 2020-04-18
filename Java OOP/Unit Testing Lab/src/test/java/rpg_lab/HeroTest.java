package rpg_lab;

import org.junit.Test;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HeroTest {
    private static final int BASE_EXPERIENCE = 10;
    private static final String BASE_HERO_NAME = "Ste4o";

    @Test
    public void shouldGainExperienceWhenTargetDies() {
        //Arrange(Given)
        Target target = mock(Target.class);
        Weapon weapon = mock(Weapon.class);
        Hero hero = new Hero(BASE_HERO_NAME, weapon);
        int expected = hero.getExperience() + BASE_EXPERIENCE;

        //Act(When)
        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(BASE_EXPERIENCE);
        hero.attack(target);

        //Assert(Then)
        assertEquals("Wrong experience!", expected, hero.getExperience());
    }

    @Test
    public void shouldReceiveLootWhenKillsTarget() {
        //Given
        Target mockTarget = mock(Target.class);
        Weapon mockWeapon = mock(Weapon.class);
        Hero hero = new Hero(BASE_HERO_NAME, mockWeapon);
        int expected = hero.getInventory().size() + 1;

        //When
        when(mockTarget.isDead()).thenReturn(true);
        when(mockTarget.givesLootUponDeath()).thenReturn(mockWeapon);
        hero.attack(mockTarget);

        //Then
        assertEquals("does not receive item when kills Target!",expected , hero.getInventory().size());
        //v momenta contains raboti zashtoto mu sravnqvam dobaveniq mockWeapon s mockWeapon(demek sravnqvam edin obekt s nego si)
        //ako pochna da dobavqm razlichni obekti shte grumne
        assertTrue(hero.getInventory().contains(mockWeapon));

    }
}
