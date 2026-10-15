package view;

import controller.UMKMController;
import java.util.Scanner;
import model.Event;
import model.InfoUMKM;
import model.JenisFashion;
import model.JenisKuliner;
import model.JenisUsaha;
import model.UMKM;

public class UMKMView {

    private Scanner scanner;
    private UMKMController controller;
    private Event event;

    public UMKMView(UMKMController controller, Event event) {
        this.scanner = new Scanner(System.in);
        this.controller = controller;
        this.event = event;
    }

    public void tampilkanMenu() {

        int pilihan;

        do {
            System.out.println();
            System.out.println("==================================");
            System.out.println("     SISTEM PENDATAAN UMKM");
            System.out.println("==================================");
            System.out.println("1. Tambah Data UMKM");
            System.out.println("2. Tampilkan Data UMKM");
            System.out.println("3. Ubah Data UMKM");
            System.out.println("4. Hapus Data UMKM");
            System.out.println("5. Keluar");
            System.out.println("==================================");

            pilihan = inputInteger("Pilih menu: ");

            switch (pilihan) {

                case 1:
                    tambahData();
                    break;

                case 2:
                    tampilkanData();
                    break;

                case 3:
                    ubahData();
                    break;

                case 4:
                    hapusData();
                    break;

                case 5:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 5);
    }

    private void tambahData() {

        System.out.println();
        System.out.println("--- Tambah Data UMKM ---");

        int id = inputInteger("ID UMKM: ");

        if (controller.cariUMKM(id) != null) {
            System.out.println("ID UMKM sudah digunakan.");
            return;
        }

        String namaUsaha = inputString("Nama Usaha: ");
        String namaPemilik = inputString("Nama Pemilik: ");

        JenisUsaha jenisUsaha = pilihJenisUsaha();

        UMKM umkm = new UMKM(
                id,
                namaUsaha,
                namaPemilik,
                jenisUsaha,
                event
        );

        controller.tambahUMKM(umkm);

        System.out.println("Data UMKM berhasil ditambahkan.");
    }

    private void tampilkanData() {

        System.out.println();
        System.out.println("--- Data UMKM ---");

        if (controller.getDaftarUMKM().isEmpty()) {
            System.out.println("Belum ada data UMKM.");
            return;
        }

        System.out.println("1. Tampilkan Data Lengkap");
        System.out.println("2. Tampilkan Data Singkat");

        int pilihan = inputInteger("Pilih tampilan: ");

        if (pilihan == 1) {

            for (UMKM umkm : controller.getDaftarUMKM()) {

                System.out.println("----------------------------------");

                InfoUMKM info = (InfoUMKM) umkm;
                info.tampilkanInfo();
            }
          

        } else if (pilihan == 2) {

            for (UMKM umkm : controller.getDaftarUMKM()) {

                System.out.println("----------------------------------");

                umkm.tampilkanInfo(false);
            }

        } else {

            System.out.println("Pilihan tidak tersedia.");
        }
    }

    private void ubahData() {

        System.out.println();
        System.out.println("--- Ubah Data UMKM ---");

        int id = inputInteger("Masukkan ID UMKM: ");

        UMKM umkm = controller.cariUMKM(id);

        if (umkm == null) {
            System.out.println("Data UMKM tidak ditemukan.");
            return;
        }

        String namaUsaha = inputString("Nama Usaha Baru: ");
        String namaPemilik = inputString("Nama Pemilik Baru: ");

        JenisUsaha jenisUsaha = pilihJenisUsaha();

        umkm.setNamaUsaha(namaUsaha);
        umkm.setNamaPemilik(namaPemilik);
        umkm.setJenisUsaha(jenisUsaha);

        System.out.println("Data UMKM berhasil diubah.");
    }

    private void hapusData() {

        System.out.println();
        System.out.println("--- Hapus Data UMKM ---");

        int id = inputInteger("Masukkan ID UMKM: ");

        if (controller.hapusUMKM(id)) {
            System.out.println("Data UMKM berhasil dihapus.");
        } else {
            System.out.println("Data UMKM tidak ditemukan.");
        }
    }

    private JenisUsaha pilihJenisUsaha() {

        int pilihan;

        do {
            System.out.println();
            System.out.println("Pilih Jenis Usaha:");
            System.out.println("1. Kuliner");
            System.out.println("2. Fashion");

            pilihan = inputInteger("Pilihan: ");

            if (pilihan == 1) {
                return new JenisKuliner("Kuliner");
            }

            if (pilihan == 2) {
                return new JenisFashion("Fashion");
            }

            System.out.println("Pilihan tidak tersedia.");

        } while (true);
    }

    private int inputInteger(String pesan) {

        while (true) {

            try {
                System.out.print(pesan);

                int angka = Integer.parseInt(scanner.nextLine());

                if (angka <= 0) {
                    System.out.println("Input harus lebih dari 0.");
                } else {
                    return angka;
                }

            } catch (NumberFormatException e) {

                System.out.println("Input harus berupa angka.");
            }
        }
    }

    private String inputString(String pesan) {

        while (true) {

            System.out.print(pesan);

            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input tidak boleh kosong.");
            } else {
                return input;
            }
        }
    }
}