
    public class Application {

        private static final String Input = "problem2.txt";
        private static final String Output = "unique_word_counts.txt";

        public static void main(String[] args)
        {
            DuplicateCounter duplicateCounter = new DuplicateCounter();
            duplicateCounter.count(Input);
            duplicateCounter.write(Output);
        }
    }

