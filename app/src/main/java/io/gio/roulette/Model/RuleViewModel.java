package io.gio.roulette.Model;

public class RuleViewModel {
    String rname;
    String rdesc;
    int image;
    public RuleViewModel(String rname, String rdesc,int image) {
        this.rname = rname;
        this.rdesc = rdesc;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }
}
