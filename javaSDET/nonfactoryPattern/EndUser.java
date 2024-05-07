package nonfactoryPattern;

public class EndUser {
    public static void main(String[] args) {

        //Sáng
        //Đến hãng xem xe
        HondaHead honda = new HondaHead();

        //xem
        honda.viewCar();

        //book xe
        honda.bookCar();

        //lai thu
        honda.driveCar();


        //Chiều

        FordHead ford = new FordHead();
        ford.viewCar();
        ford.bookCar();
        ford.driveCar();

        //Tương tự với Huyndai  -> Cần apply factory pattern
    }
}

