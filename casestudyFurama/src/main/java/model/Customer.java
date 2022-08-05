package model;

public class Customer extends Person {
    private String guestType;
    private String address;

    public Customer() {
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                super.getCode(),
                super.getFullName(),
                super.getGenDer(),
                super.getId(),
                super.getNumberPhone(),
                super.getEmail(),
                getAddress(),
                getGuestType()
        );
    }

    public Customer(String guestType, String address) {
        this.guestType = guestType;
        this.address = address;
    }

    public Customer(int code, String fullName, String genDer, int id, int numberPhone, String email, String guestType, String address) {
        super(code, fullName, genDer, id, numberPhone, email);
        this.guestType = guestType;
        this.address = address;
    }

    public Customer(String guestType) {
        this.guestType = guestType;
    }

    public String getGuestType() {
        return this.guestType;
    }

    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer co kieu khach: " + guestType +
                " dia chi: " + address +
                "co ma so: " + getCode() +
                " Ho ten: " + getFullName() +
                " Gioi tinh: " + getGenDer() +
                " id: " + getId() +
                " SDT: " + getNumberPhone() +
                " Email: " + getEmail();


    }
}
