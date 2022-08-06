package model;

public class EducationDegree {
    private int maTrinhDo;
    private String tenTrinhDo;

    public EducationDegree() {
    }

    public EducationDegree(int maTrinhDo, String tenTrinhDo) {
        this.maTrinhDo = maTrinhDo;
        this.tenTrinhDo = tenTrinhDo;
    }

    public int getMaTrinhDo() {
        return maTrinhDo;
    }

    public void setMaTrinhDo(int maTrinhDo) {
        this.maTrinhDo = maTrinhDo;
    }

    public String getTenTrinhDo() {
        return tenTrinhDo;
    }

    public void setTenTrinhDo(String tenTrinhDo) {
        this.tenTrinhDo = tenTrinhDo;
    }
}
