package readerWriter;

import model.Jokes;

import javax.xml.bind.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XmlReaderWriter implements ReaderWriter {

    @Override
    public Jokes readData(String filePath){
        Jokes jokes;
        try {
            JAXBContext ctx = JAXBContext.newInstance(Jokes.class);
            Unmarshaller unmarshaller = ctx.createUnmarshaller();
            File file = new File(filePath);
            jokes = (Jokes) unmarshaller.unmarshal(file);
        }catch (JAXBException e){
            jokes = new Jokes();
        }
            return jokes;
    }

    @Override
    public boolean writeData(Jokes jokes, String filePath) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Jokes.class);
            Marshaller marshaller = ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(jokes, new File(filePath));
            return true;
        }catch (JAXBException e){
            e.printStackTrace();
            return false;
        }
    }
}
