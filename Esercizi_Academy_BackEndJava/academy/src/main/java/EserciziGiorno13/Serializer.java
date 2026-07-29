package EserciziGiorno13;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Serializer {
    
    public static void serialize(String nomeFile, Serializable oggetto) throws IOException {
        try(ObjectOutputStream oos = 
            new ObjectOutputStream(
                new FileOutputStream(nomeFile))) {
                    oos.writeObject(oggetto);
                }
        }
}
