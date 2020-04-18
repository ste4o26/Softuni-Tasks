import java.util.Scanner;

public class StreamOfLetters {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //create variable word and add characters that were read from terminal
        //read 1 character every record until the record is End
        //if the character is 'n', 'o' or 'c' and they are met for the first time do not add them to the word
        //if all of those special characters are met once print the word with space
        //start the creation of new word

        String word = "";
        String readyWord = "";

        boolean isNMet = false;
        boolean isOMet = false;
        boolean isCMet = false;


        while (true){

            String isEnd = sc.nextLine();
            if(isEnd.equals("End")){
                break;
            }

            char character = isEnd.charAt(0);
            boolean isLatinSimbol = (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z');

            if(character == 'n'){
                if(isNMet){
                    word = word + character;
                }else{
                    isNMet = true;
                }

            }else if(character == 'o'){
                if(isOMet){
                    word = word + character;
                }else{
                    isOMet = true;
                }

            }else if(character == 'c'){
                if(isCMet){
                    word = word + character;
                }else{
                    isCMet = true;
                }

            }else if(isLatinSimbol){
                word = word + character;
            }


            if(isNMet && isOMet && isCMet){
                word = word + ' ';
                readyWord = readyWord + word;
                word = "";
                isNMet = isOMet = isCMet = false;
            }
        }

        System.out.println(readyWord);
    }
}