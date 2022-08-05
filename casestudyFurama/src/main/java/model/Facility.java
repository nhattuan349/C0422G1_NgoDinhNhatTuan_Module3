package model;

public abstract class Facility {
    private String serviceName;// ten dich vu..
    private String usableArea;//dien tich su dung..
    private String rentalCosts;//chi phi thue..
    private String peopleMaximum;//so luong nguoi o toi da..
    private String rentalType; //kieu thue..

    public Facility() {
    }

    public Facility(String serviceName, String usableArea, String rentalCosts, String peopleMaximum, String rentalType) {
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.peopleMaximum = peopleMaximum;
        this.rentalType = rentalType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(String usableArea) {
        this.usableArea = usableArea;
    }

    public String getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(String rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public String getPeopleMaximum() {
        return peopleMaximum;
    }

    public void setPeopleMaximum(String peopleMaximum) {
        this.peopleMaximum = peopleMaximum;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public abstract String cover();

    @Override
    public String toString() {
        return "Facility: " + serviceName +
                " --Diện tích sử dụng: " + usableArea +
                " --Chi phí thuê: " + rentalCosts +
                " --Sô người ở tối đa:" + peopleMaximum +
                " --Kiểu thuê: " + rentalType;
    }
}