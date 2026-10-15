package dao;

import database.DatabaseConnection;
import model.UMKM;
import model.Event;
import model.JenisUsaha;
import model.JenisKuliner;
import model.JenisFashion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UMKMDAO {

    // Menampilkan semua data UMKM dari database
    public ArrayList<UMKM> tampilkanSemua() {
        ArrayList<UMKM> daftarUMKM = new ArrayList<>();

        String sql = "SELECT u.id_umkm, u.nama_usaha, "
                + "u.nama_pemilik, u.jenis_usaha, "
                + "e.id_event, e.nama_event, e.lokasi "
                + "FROM umkm u "
                + "JOIN event e ON u.id_event = e.id_event";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Event event = new Event(
                        rs.getInt("id_event"),
                        rs.getString("nama_event"),
                        rs.getString("lokasi")
                );

                JenisUsaha jenisUsaha = buatJenisUsaha(
                        rs.getString("jenis_usaha")
                );

                UMKM umkm = new UMKM(
                        rs.getInt("id_umkm"),
                        rs.getString("nama_usaha"),
                        rs.getString("nama_pemilik"),
                        jenisUsaha,
                        event
                );

                daftarUMKM.add(umkm);
            }

        } catch (SQLException e) {
            System.out.println("Gagal mengambil data UMKM: "
                    + e.getMessage());
        }

        return daftarUMKM;
    }

    // Menambahkan UMKM ke database
    public boolean tambah(UMKM umkm) {
        String sql = "INSERT INTO umkm "
                + "(id_umkm, nama_usaha, nama_pemilik, "
                + "jenis_usaha, id_event) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, umkm.getIdUMKM());
            ps.setString(2, umkm.getNamaUsaha());
            ps.setString(3, umkm.getNamaPemilik());
            ps.setString(4,
                    umkm.getJenisUsaha().getNamaJenis());
            ps.setInt(5, umkm.getEvent().getIdEvent());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gagal menambahkan UMKM: "
                    + e.getMessage());
            return false;
        }
    }

    // Mengubah data UMKM
    public boolean ubah(UMKM umkm) {
        String sql = "UPDATE umkm SET nama_usaha = ?, "
                + "nama_pemilik = ?, jenis_usaha = ?, "
                + "id_event = ? WHERE id_umkm = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, umkm.getNamaUsaha());
            ps.setString(2, umkm.getNamaPemilik());
            ps.setString(3,
                    umkm.getJenisUsaha().getNamaJenis());
            ps.setInt(4, umkm.getEvent().getIdEvent());
            ps.setInt(5, umkm.getIdUMKM());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gagal mengubah UMKM: "
                    + e.getMessage());
            return false;
        }
    }

    // Menghapus UMKM berdasarkan ID
    public boolean hapus(int idUMKM) {
        String sql = "DELETE FROM umkm WHERE id_umkm = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUMKM);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gagal menghapus UMKM: "
                    + e.getMessage());
            return false;
        }
    }

    // Membuat objek JenisUsaha sesuai jenisnya
    private JenisUsaha buatJenisUsaha(String jenis) {
    if ("Kuliner".equalsIgnoreCase(jenis)) {
        return new JenisKuliner("Kuliner");
    } else if ("Fashion".equalsIgnoreCase(jenis)) {
        return new JenisFashion("Fashion");
    }

    return null;
    }
}

