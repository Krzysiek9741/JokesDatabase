import model.Joke;
import model.Jokes;
import readerWriter.XmlReaderWriter;
import services.JokeService;

import java.io.FileNotFoundException;
import java.rmi.UnmarshalException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        main.runApp(args);
    }


    private void runApp(String[] args){

        JokeService jokeService = new JokeService(new XmlReaderWriter());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path of file with jokes");
        String filePath = scanner.next();
        Jokes jokes = jokeService.readJokes(filePath);
        boolean isFinished = false;
        while (!isFinished){
            System.out.println("1. Add new joke");
            System.out.println("2. Remove joke");
            System.out.println("3. Show list of jokes from the best");
            System.out.println("4. Show list of jokes from the worst");
            System.out.println("5. Find joke by ID");
            System.out.println("6. Save jokes");
            System.out.println("7. Close");
            System.out.println("Enter number of option:");
            int optionSelected = scanner.nextInt();
            switch (optionSelected){
                case 1:
                    jokeService.addNewJoke(jokes, scanner);
                    break;
                case 2:
                    System.out.println("Enter ID of joke which you want to remove:");
                    long removedId = scanner.nextLong();
                    jokeService.removeJoke(removedId, jokes);
                case 3:
                    jokeService.sortFromTheBest(jokes).forEach(System.out::println);
                    break;
                case 4:
                    jokeService.sortFromTheWorst(jokes).forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Enter ID of finding joke:");
                    long findingId = scanner.nextLong();
                    Joke joke = jokeService.findJokeById(findingId, jokes);
                    System.out.println(joke);
                    jokeService.oneJokeMenu(joke, scanner);
                    break;
                case 6:
                    System.out.println(jokeService.saveJokes(jokes, filePath));
                    break;
                case 7:
                    isFinished = true;
                    scanner.close();
                    break;
            }
        }
    }

    }

