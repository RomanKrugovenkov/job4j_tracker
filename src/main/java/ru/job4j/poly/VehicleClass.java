package ru.job4j.poly;

public class VehicleClass {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Buses();
        Vehicle[] vehicles = new Vehicle[]{airplane, train, bus};
        for (Vehicle veh : vehicles) {
            veh.move();
            System.out.println(veh.speed() + " Км/час");
        }
    }
}
