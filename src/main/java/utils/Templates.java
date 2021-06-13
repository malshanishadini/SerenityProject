package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Templates {

    public String getRequestTemplate(final String templateName) throws IOException {
        String content = "";
        String currentDir = System.getProperty("user.dir");
        try {
            File myObj = new File(currentDir + "/src/main/resources/templates/" + templateName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                content = content + myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return content;
    }
}
