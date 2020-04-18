    import java.util.Scanner;

    public class Hospital {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int calculationTime = Integer.parseInt(sc.nextLine());
            int doctors = 7;
            int reviewedPatients = 0;
            int notReviewedPatients = 0;

            for (int day = 1; day <= calculationTime; day++) {
                if(day % 3 == 0){
                    if(notReviewedPatients > reviewedPatients){
                        doctors++;
                    }
                }

                int patientsNumber = Integer.parseInt(sc.nextLine());

                if(patientsNumber > doctors){
                    reviewedPatients += doctors;
                    notReviewedPatients = notReviewedPatients + (patientsNumber - doctors);
                }else {
                    reviewedPatients += patientsNumber;
                }
            }

            System.out.printf("Treated patients: %d.%n", reviewedPatients);
            System.out.printf("Untreated patients: %d.", notReviewedPatients);
        }
    }
