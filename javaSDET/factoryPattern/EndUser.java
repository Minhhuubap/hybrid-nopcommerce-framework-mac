package factoryPattern;

public class EndUser {
    public static CarFactory carfactory;               //Bình thường ở đây new đối tượng lên: CarFactory carfactory = new CarFactory(); -> Thay phần = getCar("");
    public static void main(String[] args) {
        carfactory = getCar("honda");     //Chỗ này sao lại có return type là CarFactory nhỉ....
        //Đoạn này detect được xe gì -> New hàm lên (1 dạng như tạo new hàm đó)
        //New class rồi nên mới lôi ra được đống methods dưới đây trong Carfactory. Và ...Head thì extends lại CarFactory nên là
        carfactory.viewCar();
        carfactory.bookCar();
        carfactory.driveCar();
    }

    public static CarFactory getCar(String carName) {       //CarFactory là return type: Trả về một kiểu xe trong CarFactory?
        CarFactory carFactory = null;                       // Tương tự việc tạo đối tượng mới CarFactory carfactory = new CarFactory();
        switch (carName){
            case "honda" -> carFactory = new HondaHead();
            case "huyndai" -> carFactory = new HuyndaiHead();
            case "ford" -> carFactory = new FordHead();
        }
        return carFactory;


    }

}

/* GIẢI THÍCH KỸ HƠN VỀ RETURN TYPE Carfactory:
"method getCar(String carName) được định nghĩa để trả về một đối tượng thuộc lớp CarFactory.
Lý do return type được đặt là CarFactory là vì method này sẽ trả về một đối tượng của lớp CarFactory dựa trên tên xe được cung cấp.
-> CarFactory là abstract class và các derived class (bao gồm đối tượng mới được new lên Honda, Ford, Huyndai).
Trong method này, nếu carName là "honda", "huyndai", hoặc "ford", phương thức sẽ trả về một đối tượng thuộc các lớp con của CarFactory như HondaHead, HuyndaiHead, hoặc FordHead.
Do đó, return type là CarFactory để đảm bảo rằng nó có thể trả về các loại đối tượng khác nhau nhưng vẫn thuộc kiểu dữ liệu CarFactory.

 */

//Đây là việc tại sao lại xây dựng ra 1 cái Factory Pattern là CarFactory mà không gọi new riêng từng hãng xe.