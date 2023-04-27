public class Genre {
    String[] genres;
    String[] steamspy_tags;
    String[] categories;
    int appid;
    public Genre(String genres, String steamspy_tags, String categories, int appid){
        this.genres = genres.split(";");
        this.steamspy_tags = steamspy_tags.split(";");
        this.categories = categories.split(";");
        this.appid = appid;
    }
}
