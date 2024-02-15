package PropertyUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PropertyUtility {
    public Properties properties;

    public PropertyUtility(String fileName) {

        loadFile(fileName);
    }

    //metoda care incarca un fisier de tip "Properties"

    private void loadFile(String fileName) {
        properties = new Properties();  //obiectul care face fisierul de tip properties
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/test/resources/TestData/"+fileName+"Data.properties"); // incarca dinamic numele testului
            properties.load(fileInputStream); // incarca fisierul de mai sus
        } catch (IOException ignored) {
        }

    }

    // Metoda care returneaza toate datele din fisierul de proprietati

    public HashMap<String,String> getAllData(){
        HashMap<String, String> testData = new HashMap<>();
        for (String Key : properties.stringPropertyNames()) {    //returneaza toate cheile
            testData.put(Key, properties.getProperty(Key));     //scoate fiecare valoare pt cheia respectiva
        }
        return testData;
    }
}
