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
    public void print(){
        System.out.println("Genres:");
        for (int i = 0; i < genres.length; i++) {
            System.out.println(genres[i]);
        }
        System.out.println("Steamspy Tags:");
        for (int i = 0; i < steamspy_tags.length; i++) {
            System.out.println(steamspy_tags[i]);
        }
        System.out.println("Categories:");
        for (int i = 0; i < categories.length; i++) {
            System.out.println(categories[i]);
        }
    }
}
