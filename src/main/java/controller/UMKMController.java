
package controller;

import dao.UMKMDAO;
import java.util.ArrayList;
import model.UMKM;

public class UMKMController {

    private final UMKMDAO umkmDAO;

    public UMKMController() {
        umkmDAO = new UMKMDAO();
    }

    // Mengambil semua data dari database
    public ArrayList<UMKM> getDaftarUMKM() {
        return umkmDAO.tampilkanSemua();
    }

    // Menambahkan data ke database
    public boolean tambahUMKM(UMKM umkm) {
        return umkmDAO.tambah(umkm);
    }

    // Mencari UMKM berdasarkan ID
    public UMKM cariUMKM(int id) {
        for (UMKM umkm : umkmDAO.tampilkanSemua()) {
            if (umkm.getIdUMKM() == id) {
                return umkm;
            }
        }

        return null;
    }

    // Mengubah data UMKM di database
    public boolean ubahUMKM(UMKM umkm) {
        return umkmDAO.ubah(umkm);
    }

    // Menghapus data UMKM dari database
    public boolean hapusUMKM(int id) {
        return umkmDAO.hapus(id);
    }
}
