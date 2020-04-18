package blackBoxInteger.commands;

public class DivideCommand extends CommandImpl {
    private static final String METHOD_NAME = "divide";

    public DivideCommand() {
        super(METHOD_NAME);
    }

    @Override
    protected String getMethodName() {
        return METHOD_NAME;
    }
}
