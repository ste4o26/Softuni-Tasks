package domain.commands;

import domain.commands.inputs.AbstractInput;

public interface Command<T extends AbstractInput> {
    void execute(T input);
}
