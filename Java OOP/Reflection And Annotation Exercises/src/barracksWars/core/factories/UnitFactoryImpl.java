package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import barracksWars.units.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME = "barracksWars.units.";

    @Override
    public Unit createUnit(String unitType) {
        Unit unit = null;

        try {
            Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            Object object = constructor.newInstance();

            if (object instanceof Unit) {
                unit = (Unit) object;
            }

        } catch (ClassNotFoundException |
                NoSuchMethodException |
                InstantiationException |
                InvocationTargetException |
                IllegalAccessException e) {
            e.printStackTrace();
        }

        return unit;
    }
}
