package model;

public class Division {
    private int maBoPhan;
    private String tenBoPhan;

    public Division() {
    }

    public Division(int maBoPhan, String tenBoPhan) {
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
    }

    public int getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(int maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }
}
