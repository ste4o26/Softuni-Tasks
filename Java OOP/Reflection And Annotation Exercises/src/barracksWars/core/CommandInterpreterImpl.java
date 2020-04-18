package barracksWars.core;

import barracksWars.core.commands.Command;
import barracksWars.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String PATH_TO_COMMANDS = "barracksWars.core.commands.";

    private UnitFactory unitFactory;
    private Repository repository;

    public CommandInterpreterImpl(UnitFactory unitFactory, Repository repository) {
        this.unitFactory = unitFactory;
        this.repository = repository;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String commandClassName = getCorrectClassName(commandName);

        Executable executable = null;
        try {
            Class<?> clazz = Class.forName(commandClassName);
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            Object object = constructor.newInstance();
            if (object instanceof Executable) {
                executable = (Executable) object;
            }

            setFields(executable, data);

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return executable;
    }

    private void setFields(Executable executable, String[] data) throws IllegalAccessException {
        Field[] executableFields = executable.getClass().getDeclaredFields();
        Field[] localFields = this.getClass().getDeclaredFields();

        //obikalqm po vsichiki poleta na konkretnata istanciq na executable obekta(AddCommand, RetireCommand i tn)
        for (Field field : executableFields) {
            //na vsqko pole mu vzemam anotaciqta ot tip Injectable.class
            Injectable annotation = field.getAnnotation(Injectable.class);
            //ako poleto ima tazi anotaciq setni go ot otwan (injektirai go)
            if (annotation != null){
                field.setAccessible(true);
                if (field.getType().equals(String[].class)){
                    field.set(executable, data);
                }else {
                    //za vsqko lokalno pole na tekushtiq klas CommandInterpreterImpl koito dyrvi vskichki obekti koito trqbva da injektira
                    for (Field localField : localFields) {
                        //proverqvam dali dekushtoto lokalno pole e ravno na tekushtoto pole ot konkretnata implementaciq na executable obekta
                        if (localField.getType().equals(field.getType())){
                            //ako poletata sa ot edin i sysht tip znachi konkretnata implementaciq na executable interface ima tova pole
                            //i trqbva da go injektiram
                            //na konkretnoto pole koeto sym otkril che sushtestvuva v obekta v koito iskam
                            // da go injektiram mu davam referenciqta kym koqto trqbva da sochi
                            field.set(executable, localField.get(this));
                        }
                    }
                }
            }
        }
    }

    private String getCorrectClassName(String commandName) {
        return PATH_TO_COMMANDS +
                commandName.substring(0, 1).toUpperCase() +
                commandName.substring(1)
                + "Command";
    }
}
