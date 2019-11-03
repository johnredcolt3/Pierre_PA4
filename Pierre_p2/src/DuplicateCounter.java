import java.io.File;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Set;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class DuplicateCounter {
    private Integer wordCount;
    private Map<String, Integer> newmap;
    public DuplicateCounter()
    {
        this.wordCount = 0;
        this.newmap = new HashMap<>();
    }

    public void count(String dataFile)
    {
    // Read the file
        Scanner fileReader;
        try
        {
            fileReader = new Scanner(new File(dataFile));
            while(fileReader.hasNextLine()) //while there is more words to be read
            {
                String text = fileReader.nextLine().trim();
                //Separate text
                String[] data = text.split("[\\W]+");
                for(String word : data)
                {
                    this.wordCount = newmap.get(word);
                    this.wordCount = (this.wordCount == null) ? 1 : ++this.wordCount;
                    newmap.put(word, this.wordCount);
                }
            }
            fileReader.close();
        }catch(FileNotFoundException NotFound){
            System.out.println("File " + dataFile + " not found!");
            System.exit(1);
        }
    }

    public void write(String outputFile)
    {
        FileWriter filew;
        PrintWriter printw;
        try {
            filew = new FileWriter(new File(outputFile));
            printw = new PrintWriter(filew);
            for(Map.Entry<String, Integer> entry : newmap.entrySet())
            {
                printw.write(entry.getKey() + " appears " + entry.getValue() + " times" + System.lineSeparator());
            }
            System.out.println("Map info written to file: " + outputFile);
            printw.flush();
            filew.close();
            printw.close();
        } catch (IOException err) {
            System.out.println("Error in writing towards " + outputFile + ": " + err.getMessage());
            System.exit(1);
        }
    }
}