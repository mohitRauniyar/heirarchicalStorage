package resumeselector.Resume.models;

public class Scores {
    String username;
    int score;

    public Scores(String username, int score) {
        this.username = username;
        this.score = score;
    }
    public int getScore(){
        return this.score;
    }
    public String getUsername(){
        return this.username;
    }
}
