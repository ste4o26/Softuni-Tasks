import java.util.Scanner;
public class Elevator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(sc.nextLine());
        int elevatorLimit = Integer.parseInt(sc.nextLine());
        int courses = 0;
        int peopleLeft;

        courses = numberOfPeople / elevatorLimit;
        peopleLeft = numberOfPeople - courses * elevatorLimit;

        if(peopleLeft == 0){
            System.out.println(courses);
        }else{
            courses++;
            System.out.println(courses);
        }

    }
}
