package in.thepolymath.newsflash;

/**
 * This class defines a single News Object
 */

public class News {

    private String newsTitle, newsSection, newsDate, newsLink;

    public News(String title, String section, String date, String link) {
        newsTitle = title;
        newsSection = section;
        newsDate = date;
        newsLink = link;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsSection() {
        return newsSection;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public String getNewsLink() {
        return newsLink;
    }
}
