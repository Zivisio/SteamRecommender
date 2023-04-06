public class Score {
    int positive_ratings;
    int negative_ratings;

    double ratio;
    int appid;
    public Score(String positive_ratings, String negative_ratings, int appid) {
        this.positive_ratings = Integer.parseInt(positive_ratings);
        this.negative_ratings = Integer.parseInt(negative_ratings);
        this.ratio = this.positive_ratings/this.negative_ratings;
        this.appid = appid;
    }
}
