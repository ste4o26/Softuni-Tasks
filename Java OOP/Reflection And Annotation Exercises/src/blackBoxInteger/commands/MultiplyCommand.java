package blackBoxInteger.commands;

public class MultiplyCommand extends CommandImpl {
    private static final String METHOD_NAME = "multiply";

    public MultiplyCommand() {
        super(METHOD_NAME);
    }

    @Override
    protected String getMethodName() {
        return METHOD_NAME;
    }
}
