import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
        public void faster() throws FileNotFoundException {
        long begin = System.currentTimeMillis();
        Scanner sc = new Scanner(new File("steam3.csv"));
        ArrayList<Game> games = new ArrayList<>();
        //skip first line
        sc.nextLine();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                if (!(line.charAt(i) == '"')) {// skips quotes
                    temp.append(line.charAt(i));
                }
            }
            String[] data = temp.toString().split("≡");
            Game game = new Game(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11], data[12], data[13], data[14], data[15], data[16], data[17]);
            games.add(game);
        }
        Recomender rec = new Recomender(games);
        rec.gameslikeusingfancy("Factorio");
        long end = System.currentTimeMillis();
        System.out.println(end-begin + "ms");
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.faster();
    }
}