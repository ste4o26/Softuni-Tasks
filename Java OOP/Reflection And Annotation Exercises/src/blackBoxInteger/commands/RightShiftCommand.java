package blackBoxInteger.commands;

public class RightShiftCommand extends CommandImpl {
    private static final String METHOD_NAME = "rightShift";

    public RightShiftCommand() {
        super(METHOD_NAME);
    }

    @Override
    protected String getMethodName() {
        return METHOD_NAME;
    }
}
