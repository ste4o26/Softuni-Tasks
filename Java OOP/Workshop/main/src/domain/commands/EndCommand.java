package domain.commands;

import domain.commands.inputs.EndCommandInput;

public class EndCommand implements Command<EndCommandInput> {

    @Override
    public void execute(EndCommandInput input) {
        System.exit(0);
    }
}
