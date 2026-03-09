package Activity;

public class Activity1{
    public static void main(String[] args) {
        Car BMW = new Car();
        BMW.make = 2014;
        BMW.color = "Black";
        BMW.transmission = "Manual";
        BMW.displayCharacteristics();
        BMW.accelarate();
        BMW.brake();
    }
}

class Car{
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;
    
    public Car(){
        //color = "Black";
        //transmission = "manual";
        //make = 2014;
        tyres = 4;
        doors = 4;
    }

    public void displayCharacteristics(){
        System.out.println("Color of the car: " + color);
        System.out.println("Transmission type: " + transmission);
        System.out.println("Make of the car: " + make);
        System.out.println("Number of tyres: " + tyres);
        System.out.println("Number of doors: " + doors);
    }

    public void accelarate(){
        System.out.println("Car is moving forward.");
    } 

    public void brake(){
        System.out.println("Car has stopped.");
    }

    
}
