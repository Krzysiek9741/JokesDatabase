package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Jokes {

    @XmlElement(name = "joke")
    private List<Joke> jokes = new ArrayList<>();

    public Jokes() {
    }

    public List<Joke> getJokes() {
        return jokes;
    }
}
