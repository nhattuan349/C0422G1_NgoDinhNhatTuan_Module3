package model;

public class Position {
    private int maViTri;
    private String TenViTri;

    public Position() {
    }

    public Position(int maViTri, String tenViTri) {
        this.maViTri = maViTri;
        TenViTri = tenViTri;
    }

    public int getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(int maViTri) {
        this.maViTri = maViTri;
    }

    public String getTenViTri() {
        return TenViTri;
    }

    public void setTenViTri(String tenViTri) {
        TenViTri = tenViTri;
    }
}
