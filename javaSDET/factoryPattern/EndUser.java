package factoryPattern;

public class EndUser {
    public static CarFactory carfactory;               //Bình thường ở đây new đối tượng lên: CarFactory carfactory = new CarFactory(); -> Thay phần = getCar("");
    public static void main(String[] args) {
        carfactory = getCar("huyndai");     //Chỗ này sao lại có return type là CarFactory nhỉ....
        //Đoạn này detect được xe gì -> New hàm lên (1 dạng như tạo new hàm đó)
        //New class rồi nên mới lôi ra được đống methods dưới đây trong Carfactory. Và ...Head thì extends lại CarFactory nên là
        carfactory.viewCar();
        carfactory.bookCar();
        carfactory.driveCar();
    }

    public static CarFactory getCar(String carName) {       //CarFactory là return type: Trả về một kiểu xe trong CarFactory?
        CarFactory carFactory = null;
        switch (carName){
            case "honda" -> carFactory = new HondaHead();
            case "huyndai" -> carFactory = new HuyndaiHead();
            case "ford" -> carFactory = new FordHead();
        }
        return carFactory;

    }

}

//Đây là việc tại sao lại xây dựng ra 1 cái Factory Pattern là CarFactory mà không gọi new riêng từng hãng xe.