import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
public class Main {
    public static void main(String[] args) throws IOException {
        //appid,name,release_date,english,developer,publisher,platforms,required_age,categories,genres,steamspy_tags,achievements,positive_ratings,negative_ratings,average_playtime,median_playtime,owners,price
        //genre has Genre, steam tags, catagories
        //score has positive and negative ratings
        //game has everything else
        Scanner sc = new Scanner(new File("steam.csv"));
        ArrayList<Game> games = new ArrayList<Game>();
        //skip first line
        sc.nextLine();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            //go thorugh each line and find commas in between quotes and replace them with '≡' and then remove the quotes
            //this is so that the commas in the steamspy_tags don't get split
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
        ArrayList<jamespainobject> allgenres = new ArrayList<jamespainobject>();
        for(int i = 0; i < games.size(); i++){
            for(int j = 0; j < games.get(i).genre.steamspy_tags.length; j++){
                //check if the genre is already in the list and if it is then add one to timesseen in that jamespainobject
                boolean found = false;
                for(int k = 0; k < allgenres.size(); k++){
                    if(allgenres.get(k).name.equals(games.get(i).genre.steamspy_tags[j])){
                        allgenres.get(k).timesseen++;
                        found = true;
                    }
                }
                if(!found){
                    allgenres.add(new jamespainobject(games.get(i).genre.steamspy_tags[j], 1));
                }
            }
        }
        //sort the list of genres by timesseen
        for(int i = 0; i < allgenres.size(); i++){
            for(int j = 0; j < allgenres.size(); j++){
                if(allgenres.get(i).timesseen > allgenres.get(j).timesseen){
                    jamespainobject temp = allgenres.get(i);
                    allgenres.set(i, allgenres.get(j));
                    allgenres.set(j, temp);
                }
            }
        }
        //put the list in a txt file
        System.out.println(allgenres.size());
        for(int i = 0; i < allgenres.size(); i++){
            System.out.println(allgenres.get(i).name + " " + allgenres.get(i).timesseen);
        }
    }
}