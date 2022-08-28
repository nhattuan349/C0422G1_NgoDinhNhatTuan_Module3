package model;

public class Computer {
    private int id = 0;
    private String computerName;
    private String ram;
    private String cpu;
    private String dateProduce;

    public Computer() {
    }

    public Computer(int id, String computerName, String ram, String cpu, String dateProduce) {
        this.id = id;
        this.computerName = computerName;
        this.ram = ram;
        this.cpu = cpu;
        this.dateProduce = dateProduce;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getDateProduce() {
        return dateProduce;
    }

    public void setDateProduce(String dateProduce) {
        this.dateProduce = dateProduce;
    }
}
