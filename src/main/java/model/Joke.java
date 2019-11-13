package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Joke {

    private long jokeId;
    private String content;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate creationDate;
    private int numberOfLikes;
    @XmlElement(name = "comment")
    private List<String> comments = new ArrayList<>();

    public Joke() {
    }

    public Joke(long jokeId, String content, LocalDate creationDate) {
        this.jokeId = jokeId;
        this.content = content;
        this.creationDate = creationDate;
    }

    public long getJokeId() {
        return jokeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public List<String> getComments() {
        return comments;
    }

    public void addLike(){
        this.numberOfLikes = this.numberOfLikes + 1;
    }

    public void addComment(String comment){
        this.comments.add(comment);
    }

    @Override
    public String toString() {
        return  "Joke ID: " + jokeId + "\n" +
                "Creation date: " + creationDate + "\n" +
                "Content: " + content;
    }
}
