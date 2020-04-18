package blackBoxInteger.commands;

public class AddCommand extends CommandImpl {
    private static final String METHOD_NAME = "add";

    public AddCommand() {
        super(METHOD_NAME);
    }

    @Override
    protected String getMethodName() {
        return METHOD_NAME;
    }
}
