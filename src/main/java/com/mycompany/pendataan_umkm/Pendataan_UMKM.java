package com.mycompany.pendataan_umkm;

import controller.UMKMController;
import model.Event;
import model.JenisKuliner;
import model.UMKM;
import view.UMKMView;

public class Pendataan_UMKM {

    public static void main(String[] args) {

        // Membuat data event
        Event event = new Event(
                1,
                "Bazar UMKM Samarinda 2026",
                "Samarinda"
        );

        // Membuat controller
        UMKMController controller = new UMKMController();

        
        // Menjalankan tampilan program
        UMKMView view = new UMKMView(controller, event);
        view.tampilkanMenu();
    }
    
}
