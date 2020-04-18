package domain.commands.inputs;

public class HistoryCommandInput extends AbstractInput {
    private final int conversionsToShow;

    public HistoryCommandInput(int commandsToShow) {
        this.conversionsToShow = commandsToShow;
        this.validate();
    }

    private void validate(){
        if (this.conversionsToShow < 1){
            throw new IllegalArgumentException("Input must be a positive integer!");
        }
    }

    public int getConversionsToShow() {
        return this.conversionsToShow;
    }
}
