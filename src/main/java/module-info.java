module com.mekomi.democarview {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.mekomi.democarview to javafx.fxml;
    exports com.mekomi.democarview;
}