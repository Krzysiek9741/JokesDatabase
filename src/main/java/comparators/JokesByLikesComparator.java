package comparators;

import model.Joke;

import java.util.Comparator;

public class JokesByLikesComparator implements Comparator<Joke> {
    @Override
    public int compare(Joke o1, Joke o2) {
        if (o1.getNumberOfLikes() < o2.getNumberOfLikes()){
            return 1;
        }
        if (o1.getNumberOfLikes() > o2.getNumberOfLikes()){
            return -1;
        }
        return 0;
    }
}
