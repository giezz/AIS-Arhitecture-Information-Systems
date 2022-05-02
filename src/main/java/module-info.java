module giezz.jdbc_jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens giezz.jdbc_jfx to javafx.fxml;
    exports giezz.jdbc_jfx;
    exports giezz.jdbc_jfx.tables;
    opens giezz.jdbc_jfx.tables to javafx.fxml;
    exports giezz.jdbc_jfx.controllers;
    opens giezz.jdbc_jfx.controllers to javafx.fxml;
}