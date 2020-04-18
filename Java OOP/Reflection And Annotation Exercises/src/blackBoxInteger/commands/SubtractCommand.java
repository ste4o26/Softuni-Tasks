package blackBoxInteger.commands;

public class SubtractCommand extends CommandImpl {
private static final String METHOD_NAME = "subtract";

    public SubtractCommand() {
        super(METHOD_NAME);
    }

    @Override
    protected String getMethodName() {
        return METHOD_NAME;
    }
}
