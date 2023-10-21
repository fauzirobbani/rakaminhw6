module com.example.testbddsaucedemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testbddsaucedemo to javafx.fxml;
    exports com.example.testbddsaucedemo;
}