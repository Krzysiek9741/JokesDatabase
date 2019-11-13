package services;

import comparators.JokesByLikesComparator;
import model.Joke;
import model.Jokes;
import readerWriter.ReaderWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class JokeService {

    ReaderWriter readerWriter;

    public JokeService(ReaderWriter readerWriter) {
        this.readerWriter = readerWriter;
    }

    public String saveJokes(Jokes jokes, String filePath){

        boolean isSuccessfully = readerWriter.writeData(jokes, filePath);
        if (isSuccessfully){
            return "Jokes have been saved successfully.";
        }else {
            return "Saving jokes failed.";
        }
    }

    public Jokes readJokes(String filePath){
        return readerWriter.readData(filePath);
    }

    public void addNewJoke(Jokes jokes, Scanner scanner){
        System.out.println("Enter content of joke:");
        String content = scanner.next();
        long id = getNextId(jokes);
        LocalDate creationDate = LocalDate.now();
        Joke newJoke = new Joke(id, content, creationDate);
        jokes.getJokes().add(newJoke);
    }

    private long getNextId(Jokes jokes){
        List<Joke> jokeList = jokes.getJokes();
        if (jokeList.size() == 0){
            return 0;
        }
        long id = jokeList.get(0).getJokeId();
        for (int i = 1; i < jokeList.size(); i++){
            if (jokeList.get(i).getJokeId() > jokeList.get(i - 1).getJokeId()){
                id = jokeList.get(i).getJokeId();
            }
        }
        return id + 1;
    }

    public void removeJoke (long id, Jokes jokes){
        Joke joke = findJokeById(id, jokes);
        jokes.getJokes().remove(joke);
    }

    public Joke findJokeById(long id, Jokes jokes){
        Joke joke = null;
        for (Joke j:jokes.getJokes()) {
            if (j.getJokeId() == id){
                joke = j;
                break;
            }
        }
        return joke;
    }

    public void oneJokeMenu(Joke joke, Scanner scanner) {
        System.out.println("1. Like it");
        System.out.println("2. Add comment");
        int choice = scanner.nextInt();
        switch (choice){
            case 1: joke.addLike();
            break;
            case 2:
                System.out.println("Write a comment:");
                String comment = scanner.next();
                joke.addComment(comment);
                break;
        }
    }

    public List<Joke> sortFromTheBest(Jokes jokes){
        List<Joke> jokesList = jokes.getJokes();
        jokesList.sort(new JokesByLikesComparator());
        return jokesList;
    }

    public List<Joke> sortFromTheWorst(Jokes jokes){
        List<Joke> jokesList = jokes.getJokes();
        jokesList.sort(new JokesByLikesComparator().reversed());
        return jokesList;
    }
}
