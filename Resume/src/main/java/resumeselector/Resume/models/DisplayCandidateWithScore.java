package resumeselector.Resume.models;

public class DisplayCandidateWithScore {
    Candidate candidate;
    int score;

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public DisplayCandidateWithScore(Candidate candidate, int score) {
        this.candidate = candidate;
        this.score = score;
    }
}
