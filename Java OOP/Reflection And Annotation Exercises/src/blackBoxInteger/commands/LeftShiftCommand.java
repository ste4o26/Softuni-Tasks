package blackBoxInteger.commands;

public class LeftShiftCommand extends CommandImpl {
    private static final String METHOD_NAME = "leftShift";

    public LeftShiftCommand() {
        super(METHOD_NAME);
    }

    @Override
    protected String getMethodName() {
        return METHOD_NAME;
    }
}
