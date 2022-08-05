package model;

public class Villa extends Facility{
    private String romStandard;//tieu chuan phong...
    private String poolArea;//dien tich ho boi...
    private String numberFloors;// so tang ...

    public Villa() {
    }

    public Villa(String romStandard, String poolArea, String numberFloors) {
        this.romStandard = romStandard;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public Villa(String serviceName, String usableArea, String rentalCosts, String peopleMaximum, String rentalType, String romStandard, String poolArea, String numberFloors) {
        super(serviceName, usableArea, rentalCosts, peopleMaximum, rentalType);
        this.romStandard = romStandard;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public String getRomStandard() {
        return romStandard;
    }

    public void setRomStandard(String romStandard) {
        this.romStandard = romStandard;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(String numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "Villa tieu chuan phong: " + romStandard +
                " Die tich ho boi: " + poolArea +
                " So tang: " + numberFloors +
                "Tên dịch vụ: " + getServiceName() +
                " Diện tích sử dụng: " + getUsableArea() +
                " Chi phí thuê: " + getRentalCosts() +
                " Sô người ở tối đa:" + getPeopleMaximum() +
                " Kiểu thuê: " + getRentalType();
    }

    public Villa(String serviceName, String usableArea, String rentalCosts, String peopleMaximum, String rentalType) {
        super(serviceName, usableArea, rentalCosts, peopleMaximum, rentalType);
    }

    @Override
    public String cover() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                super.getServiceName(),
                super.getUsableArea(),
                super.getRentalCosts(),
                super.getPeopleMaximum(),
                super.getRentalType(),
                getRomStandard(),
                getPoolArea(),
                getNumberFloors()
        );
    }
}
