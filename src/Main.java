import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(new File("steam.csv"));
        ArrayList<Game> games = new ArrayList<Game>();
        sc.nextLine();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String temp = "";
            boolean inQuotes = false;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '"')
                    inQuotes = !inQuotes;
                else {
                    if (!inQuotes) {
                        if (line.charAt(i) == ',')
                            temp += '≡';
                        else {
                            temp += line.charAt(i);
                        }
                    }
                }
            }
            String[] data = temp.split("≡");
            Game game = new Game(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11], data[12], data[13], data[14], data[15], data[16], data[17]);
            games.add(game);
        }
        Recomender rec = new Recomender(games);
        rec.gameslikeusingfancy("Celeste");
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Time taken: " + duration + "ms");
    }
}