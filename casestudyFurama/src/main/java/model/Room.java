package model;

public class Room extends Facility {
    private String serviceFree;

    public Room() {

    }

    @Override
    public String cover() {
        return String.format("%s,%s,%s,%s,%s,%s",
                super.getServiceName(),
                super.getUsableArea(),
                super.getRentalCosts(),
                super.getPeopleMaximum(),
                super.getRentalType(),
                serviceFree);
    }

    public Room(String serviceFree) {
        this.serviceFree = serviceFree;
    }

    public Room(String serviceName, String usableArea, String rentalCosts, String peopleMaximum, String rentalType, String serviceFree) {
        super(serviceName, usableArea, rentalCosts, peopleMaximum, rentalType);
        this.serviceFree = serviceFree;
    }

    public String getServiceFree() {
        return serviceFree;
    }

    public void setServiceFree(String serviceFree) {
        this.serviceFree = serviceFree;
    }

    @Override
    public String toString() {
        return "Room co: " + serviceFree +
                "Tên dịch vụ: " + getServiceName() +
                " Diện tích sử dụng: " + getUsableArea() +
                " Chi phí thuê: " + getRentalCosts() +
                " Sô người ở tối đa:" + getPeopleMaximum() +
                " Kiểu thuê: " + getRentalType();
    }
}
