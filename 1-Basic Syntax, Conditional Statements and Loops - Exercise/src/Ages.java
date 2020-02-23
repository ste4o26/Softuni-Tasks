import java.util.Scanner;
public class Ages {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int personAge = Integer.parseInt(sc.nextLine());

        boolean isElder = personAge >= 66;
        boolean isAdult = personAge >= 20;
        boolean isTeenager = personAge >= 14;
        boolean isChild = personAge >= 3;

        if(isElder){
            System.out.println("elder");
        } else if(isAdult){
            System.out.println("adult");
        } else if(isTeenager){
            System.out.println("teenager");
        } else if(isChild){
            System.out.println("child");
        }else{
            System.out.println("baby");
        }
    }
}
