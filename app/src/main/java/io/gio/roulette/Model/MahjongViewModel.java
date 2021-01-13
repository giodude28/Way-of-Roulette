package io.gio.roulette.Model;

public class MahjongViewModel {
    String mahjongname;
  String mahjongdesc;
    int mahjongimg;

    public MahjongViewModel(String mahjongname, String mahjongdesc, int mahjongimg) {
        this.mahjongname = mahjongname;
      this.mahjongdesc = mahjongdesc;
        this.mahjongimg = mahjongimg;
    }

    public String getMahjongname() {
        return mahjongname;
    }

    public void setMahjongname(String mahjongname) {
        this.mahjongname = mahjongname;
    }

    public String getMahjongdesc() {
        return mahjongdesc;
    }

    public void setMahjongdesc(String mahjongdesc) {
        this.mahjongdesc = mahjongdesc;
    }

    public int getMahjongimg() {
        return mahjongimg;
    }

    public void setMahjongimg(int mahjongimg) {
        this.mahjongimg = mahjongimg;
    }
}
