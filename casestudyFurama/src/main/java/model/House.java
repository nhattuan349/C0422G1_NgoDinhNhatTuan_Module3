package model;

public class House extends Facility {
    private String romStandard;//tieu chuan phong...
    private String numberFloors;// so tang ...

    public House() {

    }

    @Override
    public String cover() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                super.getServiceName(),
                super.getUsableArea(),
                super.getRentalCosts(),
                super.getPeopleMaximum(),
                super.getRentalType(),
                getRomStandard(),
                getNumberFloors());
    }

    public House(String romStandard, String numberFloors) {
        this.romStandard = romStandard;
        this.numberFloors = numberFloors;
    }

    public House(String serviceName, String usableArea, String rentalCosts, String peopleMaximum, String rentalType, String romStandard, String numberFloors) {
        super(serviceName, usableArea, rentalCosts, peopleMaximum, rentalType);
        this.romStandard = romStandard;
        this.numberFloors = numberFloors;
    }

    public String getRomStandard() {
        return romStandard;
    }

    public void setRomStandard(String romStandard) {
        this.romStandard = romStandard;
    }

    public String getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(String numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "House : " + romStandard +
                " so tang: " + numberFloors +
                "Tên dịch vụ: " + getServiceName() +
                " Diện tích sử dụng: " + getUsableArea() +
                " Chi phí thuê: " + getRentalCosts() +
                " Sô người ở tối đa:" + getPeopleMaximum() +
                " Kiểu thuê: " + getRentalType();
    }
}
