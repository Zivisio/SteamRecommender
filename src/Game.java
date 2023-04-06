import java.util.Date;

public class Game {
    Score score;
    Genre genre;
    int appid;
    String name;
    String release_date;
    boolean english;
    String developer;
    String publisher;
    String[] platforms;
    int required_age;
    String achievements;
    int average_playtime;
    int median_playtime;
    String owners;
    int owners_low;
    int owners_high;
    int owners_est;
    double price;
    public Game(String appid, String name, String release_date, String english, String developer, String publisher, String platforms, String required_age, String categories, String genres, String steamspy_tags, String achievements, String positive_ratings, String negative_ratings, String average_playtime, String median_playtime, String owners, String price) {
        this.appid = Integer.parseInt(appid);
        this.name = name;
        //turn this 2008-10-08 year month day into a unix timestamp
        this.release_date = release_date;
        this.english = Boolean.parseBoolean(english);
        this.developer = developer;
        this.publisher = publisher;
        this.platforms = platforms.split(";");
        this.required_age = Integer.parseInt(required_age);
        this.achievements = achievements;
        this.average_playtime = Integer.parseInt(average_playtime);
        this.median_playtime = Integer.parseInt(median_playtime);
        this.owners = owners;
        String[] owners_data = owners.split("-");
        this.owners_low = Integer.parseInt(owners_data[0]);
        this.owners_high = Integer.parseInt(owners_data[1]);
        this.owners_est = (owners_low + owners_high) / 2;
        this.price = Double.parseDouble(price);
        this.score = new Score(positive_ratings, negative_ratings+1,this.appid);
        this.genre = new Genre(genres, steamspy_tags, categories,this.appid);
    }
}
