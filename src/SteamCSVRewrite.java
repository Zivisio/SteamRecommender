import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SteamCSVRewrite{
    public static void main(String [] args) throws IOException {
        Scanner sc = new Scanner(new File("steam.csv"));
        FileWriter fw = new FileWriter("steam3.csv");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String temp = "";
            boolean inQuotes = false;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '"')
                    inQuotes = !inQuotes;
                else {
                        if (line.charAt(i) == ','&& (!(inQuotes)))
                            temp += '≡';
                        else {
                            temp += line.charAt(i);
                        }
                }
            }
            //write temp to file
            fw.write(temp+'\n');
        }
    }
}
