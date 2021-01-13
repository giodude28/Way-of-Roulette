package io.gio.roulette.Model;

public class ScoreViewModel {

    String scoretitle;
    String scoredesc;
    String place;
    int imahe;
    public ScoreViewModel(String scoretitle, String scoredesc,String place,Integer imahe) {
        this.scoretitle = scoretitle;
        this.scoredesc = scoredesc;
        this.place = place;
        this.imahe = imahe;
    }

    public int getImahe() {
        return imahe;
    }

    public void setImahe(int imahe) {
        this.imahe = imahe;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getScoretitle() {
        return scoretitle;
    }

    public void setScoretitle(String scoretitle) {
        this.scoretitle = scoretitle;
    }

    public String getScoredesc() {
        return scoredesc;
    }

    public void setScoredesc(String scoredesc) {
        this.scoredesc = scoredesc;
    }
}
