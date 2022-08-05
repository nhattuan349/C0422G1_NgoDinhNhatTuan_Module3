package model;

public abstract class Person {
    private int code;//ma so...
    private String fullName;//ho ten...
    private String genDer;//gioi tinh...
    private int id;//so cmnd...
    private int numberPhone;//sdt...
    private String email;

    public Person() {

    }

    public Person(int code, String fullName, String genDer, int id, int numberPhone, String email) {
        this.code = code;
        this.fullName = fullName;
        this.genDer = genDer;
        this.id = id;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGenDer() {
        return genDer;
    }

    public void setGenDer(String genDer) {
        this.genDer = genDer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public abstract String getInfo();

    @Override
    public String toString() {
        return "Person co ma so: " + code +
                " Ho ten: " + fullName +
                " Gioi tinh: " + genDer +
                " id: " + id +
                " SDT: " + numberPhone +
                " Email: " + email;
    }
}
