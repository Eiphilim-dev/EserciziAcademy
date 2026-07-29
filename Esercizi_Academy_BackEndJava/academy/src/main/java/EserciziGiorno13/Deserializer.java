package EserciziGiorno13;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public abstract class Deserializer {
    
    public static Object deserialize(String nomeFile) throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = 
            new ObjectInputStream(
                new FileInputStream(nomeFile))) {
                    return ois.readObject();
                    
                }
        }
} 
