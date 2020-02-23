package Articles2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numberOfArticles = Integer.parseInt(sc.nextLine());
        List<Article> listOfArticles = new ArrayList<Article>();
        fillList(listOfArticles, numberOfArticles, sc);
        String input = sc.nextLine();
        sortArticles(listOfArticles, input);
    }

    static void fillList(List<Article> listOfArticles, int numberOfArticles, Scanner sc){
        for (int i = 0; i < numberOfArticles; i++) {
            String[] input = sc.nextLine().split(", ");
            String title = input[0];
            String content = input[1];
            String author = input[2];
            Article article = new Article(title, content, author);
            listOfArticles.add(article);
        }
    }

    static void sortArticles(List<Article> listOfArticles, String input){
        switch (input){
            case "title":
                listOfArticles.stream()// 1 - puskam potok ot dannite na koito se sadarjat v lista
                        .sorted((article1, article2) -> article1.getTitle().compareTo(article2.getTitle()))// 2 - izpolzvam lambda funkciq na metoda sorted s koqto sortiram elementite po azpuchen red po tehnite zaglaviq
                        .forEach(element -> System.out.println(element));
                break;

            case "content":
                listOfArticles.stream()
                        .sorted((article1, article2) -> article1.getContent().compareTo(article2.getContent()))
                        .forEach(element -> System.out.println(element));
                break;

            case "author":
                listOfArticles.stream()
                        .sorted((article1, article2) -> article1.getAuthor().compareTo(article2.getAuthor()))
                        .forEach(element -> System.out.println(element));
                break;
        }
    }


}
