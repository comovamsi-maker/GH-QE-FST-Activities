interface BicycleParts{
    int tyres=2;
    int maxSpeed=25;
    public void applyBrake(int decrement); 

}
interface BicycleOperations{
    public void applyBrake(int decrement);   
    public void speedUp(int increment);
}
class Bicycle implements BicycleOperations,BicycleParts{
    int currentSpeed;
    int gears;
    public Bicycle(int gears,int currentSpeed){
        this.gears=gears;
        this.currentSpeed=currentSpeed;
    }
    public void applyBrake(int decrement){
        this.currentSpeed-=decrement;

    }
    public void speedUp(int increment){
        this.currentSpeed+=increment;
    }
    public String bicycleDesc(){
        return ("No of Gears: " + gears + "\nCurrent speed: " + currentSpeed);
    }
}

class MoutainBike extends Bicycle{
    int seatHeight;
    public MoutainBike(int gears,int currentSpeed,int seatHeight ){
        super(gears,currentSpeed);
        this.seatHeight=seatHeight;
    }
    public void setHeight(int seatHeight){
        this.seatHeight=seatHeight;
    }
    @Override
    public String bicycleDesc(){
        return (super.bicycleDesc() + "\nSeatHeight: " + seatHeight);
    }
}

public class Driver{
    public static void main(String[] args){
        MoutainBike mb=new MoutainBike(3, 0 ,25);
        System.out.print(mb.bicycleDesc());
        mb.speedUp(20);
        mb.applyBrake(5);

    }
}