package readerWriter;

import model.Jokes;

import java.io.FileNotFoundException;
import java.rmi.UnmarshalException;

public interface ReaderWriter {

    Jokes readData(String filePath);
    boolean writeData(Jokes jokes, String filePath);
}
