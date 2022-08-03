package model;

public class Computer {
    private int id = 0;
    private String computerName;
    private String ram;
    private String cpu;
    private String dateproduce;

    public Computer() {
    }

    public Computer(int id, String computerName, String ram, String cpu, String dateproduce) {
        this.id = id;
        this.computerName = computerName;
        this.ram = ram;
        this.cpu = cpu;
        this.dateproduce = dateproduce;
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

    public String getDateproduce() {
        return dateproduce;
    }

    public void setDateproduce(String dateproduce) {
        this.dateproduce = dateproduce;
    }
}
