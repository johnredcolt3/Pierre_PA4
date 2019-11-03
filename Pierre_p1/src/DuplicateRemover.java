
    import java.io.File;
    import java.util.Scanner;
    import java.util.Iterator;
    import java.util.Set;
    import java.io.FileNotFoundException;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.HashSet;

    public class DuplicateRemover {
        private Set<String> WordList;
        //Method that removes duplicate words from input
        public void remove(String dataFile) throws FileNotFoundException
        {
            String words;
            WordList = new HashSet<String>();
            Scanner scnr=new Scanner(new File(dataFile));
            while(scnr.hasNext())
            {
                words=scnr.next();
                WordList.add(words);
            }
            scnr.close();
        }
        //Writes unique words to output file
        public void write(String outputFile) throws IOException
        {
            File fi;
            FileWriter filew = null;
            fi = new File(outputFile);
        //If file exists, write to it
            if(fi.exists()) {
                filew=new FileWriter(fi,true);
                Iterator itr=WordList.iterator();

                while(itr.hasNext())
                {
                    String str=(String)itr.next();
                    filew.write(str+"\n");
                }
                filew.close();
                System.out.println("Unique Words Written To File");

            }
            else
            {
            //If no file exists, Create new File
                fi.createNewFile();
                filew=new FileWriter(fi);
                Iterator itr=WordList.iterator();

                while(itr.hasNext())
                {
                    String str=(String)itr.next();
                    filew.write(str+"\n");
                }
                filew.close();
                System.out.println("Unique Words Written To File");
            }

        }

    }

