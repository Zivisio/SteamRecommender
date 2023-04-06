import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Collections.reverse;

public class Recomender {
    ArrayList<Game> games;
    public Recomender(ArrayList<Game> games) {
        this.games = games;
    }

    public ArrayList<Game> gameslike(int appid) {
        int Indexofappid = findappid(appid);
        ArrayList<Game> gameslike = new ArrayList<Game>();
        for(int i = 0; i < games.size(); i++) {
            if (games.get(i).genre.genres == games.get(Indexofappid).genre.genres) {
                gameslike.add(games.get(i));
            }
        }
        return gameslike;
    }
    public ArrayList<Game> gameslike(String name) {
        int Indexofappid = nametoappid(name);
        ArrayList<Game> gameslike = new ArrayList<Game>();
        for(int i = 0; i < games.size(); i++) {
            if (games.get(i).genre.genres == games.get(Indexofappid).genre.genres) {
                gameslike.add(games.get(i));
            }
        }
        return gameslike;
    }
    public void gameslikeusingfancy(String name){
        int Indexofappid = nametoappid(name);
        ArrayList<Game> gameslike = new ArrayList<Game>();
        ArrayList<GameWithScore> med = new ArrayList<GameWithScore>();
        for(int i = 0; i < games.size(); i++) {
            double score = gamescore(games.get(i), games.get(Indexofappid));
            med.add(new GameWithScore(games.get(i), score));
        }
        //sort med by score
        for(int i = 0; i < med.size(); i++){
            for(int j = 0; j < med.size()-1; j++){
                if(med.get(j).similarity < med.get(j+1).similarity){
                    GameWithScore temp = med.get(j);
                    med.set(j, med.get(j+1));
                    med.set(j+1, temp);
                }
            }
        }


        for(int i =0;i<10;i++){
            med.get(i).game.printname();
        }
    }
    public int findappid(int appid) {
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).appid == appid) {
                return i;
            }
        }
        return -1;
    }
    public int nametoappid(String name) {
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).name.toLowerCase().equals( name.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    public void printtopgames(ArrayList<Game> recs) {
        for (int i = 0; i < recs.size(); i++) {
            for (int j = 0; j < recs.size() - 1; j++) {
                if (recs.get(j).score.positive_ratings < recs.get(j + 1).score.positive_ratings) {
                    Game temp = recs.get(j);
                    recs.set(j, recs.get(j + 1));
                    recs.set(j + 1, temp);
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(recs.get(i).name);
        }
    }
    public double gamescore(Game a, Game b){
        if((a.score.positive_ratings == 0 || b.score.positive_ratings == 0)||(a.score.negative_ratings>a.score.positive_ratings)){
            return -100;
        }
        //go through steam_spytags and see how many are shared put genres shared *2 over total tags
        double along = a.genre.steamspy_tags.length;
        double blong = b.genre.steamspy_tags.length;
        double shared = 0;
        if(along >= blong){
            for (int i = 0; i < along; i++) {
                for (int j = 0; j < blong; j++) {
                    if(a.genre.steamspy_tags[i].equals(b.genre.steamspy_tags[j])){
                        shared++;
                    }
                }
            }
            return shared;
        }else{
            for (int i = 0; i < blong; i++) {
                for (int j = 0; j < along; j++) {
                    if(b.genre.steamspy_tags[i].equals(a.genre.steamspy_tags[j])){
                        shared++;
                    }
                }
            }
            return shared;
        }
    }
    public void printgame(String name, ArrayList<Game> games) {
        int Indexofappid = nametoappid(name);
        Game game = games.get(Indexofappid);
        System.out.println("Name: " + game.name);
        System.out.println("Release Date: " + game.release_date);
        System.out.println("English: " + game.english);
        System.out.println("Developer: " + game.developer);
        System.out.println("Publisher: " + game.publisher);
        System.out.println("Platforms: " + game.platforms);
        System.out.println("Required Age: " + game.required_age);
        game.genre.print();
        System.out.println("Achievements: " + game.achievements);
        System.out.println("Positive Ratings: " + game.score.positive_ratings);
        System.out.println("Negative Ratings: " + game.score.negative_ratings);
        System.out.println("Average Playtime: " + game.average_playtime);
        System.out.println("Median Playtime: " + game.median_playtime);
        System.out.println("Owners: " + game.owners);
        System.out.println("Price: " + game.price);
    }
}
