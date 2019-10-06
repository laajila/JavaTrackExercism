import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

class GrepTool {
    String grep(String pattern, List<String> flags, List<String> inputFiles) {
        StringBuilder grepResult = new StringBuilder();
        for (String file :
                inputFiles) {
            //if multiple files add file name at the begining.
            String fileName;
            //flag for printing line numbers
            boolean printNumbers = flags.contains("-n");
            //flag for printing just filenames
            boolean printOnlyFilenames = flags.contains("-l");
            //flag for printing filenames ie more than one files
            if (inputFiles.size() > 1) fileName = file + ":";
            else fileName = "";
            try {
                Scanner fileScanner = new Scanner(new File(file));
                int lineNumber = 0;

                while (fileScanner.hasNextLine()) {
                    lineNumber++;
                    String line = fileScanner.nextLine();
                    System.out.println(isMatch(line, pattern, flags));

                    if (printOnlyFilenames) {
                        if (isMatch(line, pattern, flags)) {
                            grepResult.append(file).append("\n");
                            break;
                        }
                    } else if (printNumbers) {
                        if (isMatch(line, pattern, flags)) grepResult.append(fileName)
                                .append(lineNumber).append(":").append(line).append("\n");
                    } else {
                        if (isMatch(line, pattern, flags)) grepResult.append(fileName)
                                .append(line).append("\n");
                        ;
                    }
                }
            } catch (FileNotFoundException c) {
                System.out.println("file not found!");
            }


        }
        return grepResult.toString().trim();

    }

    boolean isMatch(String line, String word, List<String> flags) {

        String lineCaseInsensitive = line.toLowerCase();
        String wordCaseInsensitive = word.toLowerCase();

        if (flags.contains("-i") && flags.contains("-x") && flags.contains("-v")) {
            return !lineCaseInsensitive.equals(wordCaseInsensitive);
        } else if (flags.contains("-i") && flags.contains("-x")) {
            return lineCaseInsensitive.equals(wordCaseInsensitive);
        } else if (flags.contains("-i") && flags.contains("-v")) {
            return !lineCaseInsensitive.contains(wordCaseInsensitive);
        } else if (flags.contains("-v") && flags.contains("-x")) {
            return !line.equals(word);
        } else if (flags.contains("-i")) {
            return lineCaseInsensitive.contains(wordCaseInsensitive);
        } else if (flags.contains("-v")) {
            return !line.contains(word);
        } else if (flags.contains("-x")) {
            return line.equals(word);
        } else {
            return line.contains(word);
        }


    }


}