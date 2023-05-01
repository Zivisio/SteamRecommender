import java.io.File;
<<<<<<< Updated upstream
import java.io.FileNotFoundException;
=======
import java.io.FileWriter;
>>>>>>> Stashed changes
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
<<<<<<< Updated upstream
        public void faster() throws FileNotFoundException {
        long begin = System.currentTimeMillis();
        Scanner sc = new Scanner(new File("steam3.csv"));
        ArrayList<Game> games = new ArrayList<>();
        //skip first line
=======
    public static void main(String[] args) throws IOException {
        int win = 0;
        int mac = 0;
        int linux = 0;
        int total = 0;
        Scanner sc = new Scanner(new File("steam.csv"));
        ArrayList<Game> games = new ArrayList<Game>();
>>>>>>> Stashed changes
        sc.nextLine();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                if (!(line.charAt(i) == '"')) {// skips quotes
                    temp.append(line.charAt(i));
                }
            }
<<<<<<< Updated upstream
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
=======
            String[] data = temp.split("≡");
            if(data[6].contains("windows")){
                win += 1;
            }else{
                System.out.println(data[1]);
            }
            if(data[6].contains("mac")){
                mac += 1;
            }
            if(data[6].contains("linux")){
                linux += 1;
            }
            total += 1;
            Game game = new Game(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11], data[12], data[13], data[14], data[15], data[16], data[17]);
            games.add(game);
        }
        sc.close();

        FileWriter fileWriter = new FileWriter("Game.csv");
        fileWriter.write("appid≡name≡release_date≡english≡developer≡publisher≡required_age≡achievements≡average_playtime≡median_playtime≡owners≡owners_low≡owners_high≡owners_est≡price≡windows_support≡mac_support≡linux_support\n");
        for(int i =0;i<games.size();i++){
            fileWriter.write(games.get(i).appid+"≡"+games.get(i).name+"≡"+games.get(i).release_date+"≡");

            if(games.get(i).english){
                fileWriter.write("1≡");
            }else{
                fileWriter.write("0≡");
            }

                    fileWriter.write(games.get(i).developer+"≡"+
                    games.get(i).publisher+"≡"+games.get(i).required_age+"≡"+games.get(i).achievements+"≡"+games.get(i).average_playtime+"≡"+games.get(i).median_playtime+"≡"+
                    games.get(i).owners_est+"≡"+games.get(i).owners_low+"≡"+games.get(i).owners_high+"≡"+games.get(i).owners_est+"≡"+games.get(i).price+"≡");

            if(games.get(i).windows){
                fileWriter.write("1≡");
            }else{
                fileWriter.write("0≡");
            }
            if(games.get(i).mac){
                fileWriter.write("1≡");
            }else{
                fileWriter.write("0≡");
            }
            if(games.get(i).linux){
                fileWriter.write("1≡\n");
            }else{
                fileWriter.write("0≡\n");
            }
            fileWriter.flush();
        }
>>>>>>> Stashed changes
    }
}

//    LOAD DATA INFILE '/home/jams/Game.csv'
//        INTO TABLE Game
//        FIELDS TERMINATED BY '≡';