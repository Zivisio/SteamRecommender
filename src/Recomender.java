import java.util.ArrayList;
public class Recomender {
    ArrayList<Game> games;
    public Recomender(ArrayList<Game> games) {
        this.games = games;
    }

    public void gameslikeusingfancy(String name){
        int Indexofappid = nametoappid(name);
        ArrayList<GameWithScore> med = new ArrayList<>();
        for (Game game : games) {
            double score = gamescore(game, games.get(Indexofappid));
            med.add(new GameWithScore(game, score));
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
    public int nametoappid(String name) {
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).name.equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
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
        }else{
            for (int i = 0; i < blong; i++) {
                for (int j = 0; j < along; j++) {
                    if(b.genre.steamspy_tags[i].equals(a.genre.steamspy_tags[j])){
                        shared++;
                    }
                }
            }
        }
        return shared;
    }
}
