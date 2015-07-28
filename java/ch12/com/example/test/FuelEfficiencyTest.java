package com.example.test;

import com.example.FuelEfficiency;

abstract class Car {
    protected String name;
    protected FuelEfficiency fuelEfficiency;
    public double calculateMinGasUsage(int miles) {
        int mpg = fuelEfficiency.getMax();
        return (double) miles / mpg;
    }
    public double calculateMaxGasUsage(int miles) {
        int mpg = fuelEfficiency.getMin();
        return (double) miles / mpg;
    }
    public String getName() {
        return this.name;
    }
}

class EfficientCar extends Car {
    public EfficientCar(String name) {
        this.name = name;
        this.fuelEfficiency = FuelEfficiency.EFFICIENT;
    }
}
class AcceptableCar extends Car {
    public AcceptableCar(String name) {
        this.name = name;
        this.fuelEfficiency = FuelEfficiency.ACCEPTABLE;
    }
}
class GasGuzzler extends Car {
    public GasGuzzler(String name) {
        this.name = name;
        this.fuelEfficiency = FuelEfficiency.GAS_GUZZLER;
    }
}

public class FuelEfficiencyTest {
    public static void main(String[] args) {
        Car[] cars = new Car[3];
        cars[0] = new EfficientCar("2015 Jupiter CX");
        cars[1] = new AcceptableCar("2015 SoSo");
        cars[2] = new GasGuzzler("2015 Guzzly");
        int miles = 1000;
        for (Car car : cars) {
            System.out.printf("To drive %d miles in a \"%s\",%n"
                    + "you need between %.2f and %.2f gallons "
                    + "of gasoline.%n%n",
                    miles, car.name, 
                    car.calculateMinGasUsage(miles),
                    car.calculateMaxGasUsage(miles));
        }
    }

}

