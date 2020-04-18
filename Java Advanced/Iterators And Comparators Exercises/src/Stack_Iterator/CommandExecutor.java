package Stack_Iterator;

public class CommandExecutor {

    public static <T> void executeCommand(String command,Stack<T> stack, T ... data) {

        switch (command) {
            case "Push":
                for (int i = 0; i < data.length; i++) {
                    stack.push(data[i]);
                }
                break;

            case "Pop":
                stack.pop();
                break;
        }
    }
}
