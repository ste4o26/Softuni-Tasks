import java.util.Scanner;
public class BalancedBrackets2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfInputLines = Integer.parseInt(sc.nextLine());

        int closingBracketsCounter = 0;
        int openingBracketsCounter = 0;
        boolean isBalanced = true;
        String lastBracket = "";

        for (int currentLine = 0; currentLine < numberOfInputLines; currentLine++) {
            String input = sc.nextLine();

            if(openingBracketsCounter == 0 && input.equals(")")){
                isBalanced = false;
                break;
            }

            if(input.equals(")") && lastBracket.equals(")")){
                isBalanced = false;
                break;
            }

            if(input.equals("(") && lastBracket.equals("(")){
                isBalanced = false;
                break;
            }

            if(input.equals("(")){
                openingBracketsCounter++;
                lastBracket = "(";

            }else if(input.equals(")")){
                closingBracketsCounter++;
                lastBracket = ")";
            }
        }

        if(!((closingBracketsCounter + openingBracketsCounter) % 2 == 0)){
            isBalanced = false;
        }

        if(isBalanced){
            System.out.println("BALANCED");
        }else{
            System.out.println("UNBALANCED");
        }
    }
}
