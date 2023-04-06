import java.lang.reflect.Array;
import java.util.ArrayList;

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
        for (int i = 0; i < recs.size(); i++) {
            System.out.println(recs.get(i).name);
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
