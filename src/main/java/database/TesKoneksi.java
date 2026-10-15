package database;

import java.sql.Connection;
import java.sql.SQLException;

public class TesKoneksi {

        public static void main(String[] args) throws SQLException {
        System.out.println("Test Koneksi");

        Connection conn = DatabaseConnection.getConnection();

        if (conn != null) {
            System.out.println("Koneksi Berhasil!");
        } else {
            System.out.println("Koneksi Gagal!");
        }
    }
}
