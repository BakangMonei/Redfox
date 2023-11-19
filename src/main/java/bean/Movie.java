package bean;

public class Movie {
    int id;
    String title, director, genre1, genre2, genre3, actor1, actor2, actor3, synopsis, year, imgUrl;
    double rate;

    public Movie() {
        super();
    }

    public Movie(int id, String title, String director, String genre1, String genre2, String genre3, String actor1, String actor2, String actor3, String synopsis, String year, String imgUrl, double rate) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre1 = genre1;
        this.genre2 = genre2;
        this.genre3 = genre3;
        this.actor1 = actor1;
        this.actor2 = actor2;
        this.actor3 = actor3;
        this.synopsis = synopsis;
        this.year = year;
        this.imgUrl = imgUrl;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre1() {
        return genre1;
    }

    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }

    public String getGenre2() {
        return genre2;
    }

    public void setGenre2(String genre2) {
        this.genre2 = genre2;
    }

    public String getGenre3() {
        return genre3;
    }

    public void setGenre3(String genre3) {
        this.genre3 = genre3;
    }

    public String getActor1() {
        return actor1;
    }

    public void setActor1(String actor1) {
        this.actor1 = actor1;
    }

    public String getActor2() {
        return actor2;
    }

    public void setActor2(String actor2) {
        this.actor2 = actor2;
    }

    public String getActor3() {
        return actor3;
    }

    public void setActor3(String actor3) {
        this.actor3 = actor3;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", genre1='" + genre1 + '\'' +
                ", genre2='" + genre2 + '\'' +
                ", genre3='" + genre3 + '\'' +
                ", actor1='" + actor1 + '\'' +
                ", actor2='" + actor2 + '\'' +
                ", actor3='" + actor3 + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", year='" + year + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", rate=" + rate +
                '}';
    }
}


