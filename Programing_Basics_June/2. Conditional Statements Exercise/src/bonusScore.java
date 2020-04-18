import java.util.Scanner;

public class bonusScore {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //1 - read input
        int beginingScores = Integer.parseInt(sc.nextLine());
        double bonusScores = 0;
        //2 - bonus scores and hole score
        //3 - if num < 100

        boolean areScoresUnder100 = beginingScores <= 100;
        boolean areScoresMoreThen100 = beginingScores > 100 && beginingScores <= 1000 ;
        boolean areScoresMoreThen1000 = beginingScores > 1000;

        if(areScoresUnder100){
            bonusScores = 5;

        }else if(areScoresMoreThen100){
            bonusScores = beginingScores * 0.2;

        }else if(areScoresMoreThen1000){
            bonusScores = beginingScores * 0.1;

        }

        boolean isScoreEven = beginingScores % 2 == 0;
        boolean isScoreLastAt5 = beginingScores % 5 == 0;

        if(isScoreEven){
            bonusScores = bonusScores + 1;

        }else if(isScoreLastAt5){
            bonusScores = bonusScores + 2;

        }

        double totalScore = bonusScores + beginingScores;
        boolean isHoleNumber = totalScore % 1 == 0;

        if(isHoleNumber) {
            System.out.printf("%.0f \n%.0f", bonusScores, totalScore);

        }else {
            System.out.printf("%.1f \n%.1f", bonusScores, totalScore);

        }
    }
}
