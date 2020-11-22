package zilic.luk;

import java.util.Date;

public class Luk {

    private int sifra;
    private int slojevi;
    private Date vrijeme;
    private float mlSuza;

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public int getSlojevi() {
        return slojevi;
    }

    public void setSlojevi(int slojevi) {
        this.slojevi = slojevi;
    }

    public Date getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(Date vrijeme) {
        this.vrijeme = vrijeme;
    }

    public float getMlSuza() {
        return mlSuza;
    }

    public void setMlSuza(float mlSuza) {
        this.mlSuza = mlSuza;
    }
}
