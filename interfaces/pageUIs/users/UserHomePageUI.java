package pageUIs.users;

public class UserHomePageUI {

    public static final String REGISTER_LINK = "Xpath=//a[@class='ico-register']";
    //public: gọi hàm biến ra sdung bthg
        //private/default: khác package không dùng được
        //protected: các class bên PO không kế thừa PUI nên không áp dụng


    //static: cho phép gọi trực tiếp từ class
    //final: ngăn ko cho update giá trị trong lúc run
    //String: By locator của selenium nhận vào là String
    //REGISTER_LINK: hằng số để lưu dữ liệu không bh thay đổi (const). Để quy ước 1 biến là hằng số không đổi
    //Convention cho hằng số: phải viết hoa - nhiều hơn 1 từ phải dùng _ để tách

    public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";


    public static final String LOGIN_BUTTON = "xpath=//a[text()='Log in']";
}
