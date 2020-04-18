import java.util.Scanner;

public class FishingBoat {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //read input
        //check the season
        //check number of persons in group


        int groupBudget = Integer.parseInt(sc.nextLine());
        String season = sc.nextLine();
        int fishers = Integer.parseInt(sc.nextLine());

        boolean isSpring = season.equals("Spring");
        boolean isАutumn = season.equals("Autumn");
        boolean isWinter = season.equals("Winter");
        boolean isSummer = season.equals("Summer");

        boolean arePeopleUpTo6 = fishers <= 6;
        boolean arePeopleBetween7And11 = fishers >= 7 && fishers <= 11;
        boolean arePeopleMoreThan12 = fishers >= 12;

        //its better practice to check highest conditions first. that let me remove some extra code like fishers <= 11

        boolean areFishersEven = fishers % 2 == 0;

        double shipPrice = 0;

        if(isSpring){
            shipPrice = 3000;

            if(arePeopleUpTo6){
                shipPrice = shipPrice * 0.9;

                if(areFishersEven){
                    shipPrice = shipPrice * 0.95;
                }

            }else if(arePeopleBetween7And11){
                shipPrice = shipPrice * 0.85;

                if(areFishersEven){
                    shipPrice = shipPrice * 0.95;
                }

            }else if(arePeopleMoreThan12){
                shipPrice = shipPrice * 0.75;

                if(areFishersEven){
                    shipPrice = shipPrice * 0.95;
                }

            }

        }else if(isАutumn || isSummer){
            shipPrice = 4200;

            if(arePeopleUpTo6){
                shipPrice = shipPrice * 0.9;

                if(areFishersEven && !isАutumn){
                    shipPrice = shipPrice * 0.95;
                }

            }else if(arePeopleBetween7And11){
                shipPrice = shipPrice * 0.85;

                if(areFishersEven){
                    shipPrice = shipPrice * 0.95;
                }

            }else if(arePeopleMoreThan12){
                shipPrice = shipPrice * 0.75;

                if(areFishersEven){
                    shipPrice = shipPrice * 0.95;
                }

            }

        }else if(isWinter){
            shipPrice = 2600;


            if(arePeopleUpTo6){
                shipPrice = shipPrice * 0.9;

                if(areFishersEven){
                    shipPrice = shipPrice * 0.95;
                }

            }else if(arePeopleBetween7And11){
                shipPrice = shipPrice * 0.85;

                if(areFishersEven){
                    shipPrice = shipPrice * 0.95;
                }

            }else if(arePeopleMoreThan12){
                shipPrice = shipPrice * 0.75;

                if(areFishersEven){
                    shipPrice = shipPrice * 0.95;
                }

            }
        }

        if(groupBudget >= shipPrice){
            System.out.printf("Yes! You have %.2f leva left.", Math.abs(groupBudget - shipPrice));

        }else {
            System.out.printf("Not enough money! You need %.2f leva.", Math.abs(groupBudget - shipPrice));

        }

    }
}
