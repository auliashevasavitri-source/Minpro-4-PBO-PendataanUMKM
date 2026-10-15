# Sistem-Pendataan-UMKM

AULIA SHEVA SAVITRI | 2509116001

## Deskripsi Program

**Sistem Pendataan UMKM** merupakan program yang digunakan untuk mengelola data UMKM yang mengikuti sebuah event. Program ini merupakan pengembangan dari Mini Project 1 dengan menambahkan beberapa konsep Pemrograman Berorientasi Objek (PBO).

Program dapat digunakan untuk menambah, menampilkan, mengubah, dan menghapus data UMKM. Data yang disimpan terdiri dari ID UMKM, nama usaha, nama pemilik, jenis usaha, dan event yang diikuti.

Pada Mini Project 4, program dikembangkan dengan menghubungkan aplikasi Java ke database MySQL menggunakan JDBC (Java Database Connectivity), PreparedStatement, dan DAO (Data Access Object). Data UMKM disimpan dalam database agar dapat diakses kembali ketika program dijalankan. Konsep PBO dari mini project sebelumnya tetap digunakan, sedangkan proses CRUD diintegrasikan dengan database.

---

## Fitur Program

Program memiliki beberapa fitur utama:

1. Menambah data UMKM
2. Menampilkan data UMKM
3. Mengubah data UMKM
4. Menghapus data UMKM
5. Validasi input pengguna
6. Pemilihan jenis usaha Kuliner dan Fashion
7. Dummy data sebagai data awal
8. Menampilkan data UMKM secara lengkap dan singkat
9. Penerapan polymorphism melalui overloading dan overriding
10. Penerapan abstraction pada jenis usaha
11. Penerapan interface untuk menampilkan informasi UMKM
12. Koneksi aplikasi Java dengan database MySQL menggunakan JDBC.
13. Penggunaan PreparedStatement untuk menjalankan perintah SQL.
14. Penggunaan DAO untuk mengelola akses database.
15. Penyimpanan data UMKM secara permanen di database.

---

## Alur Program

Program dijalankan melalui class Pendataan_UMKM.java. Program membuat objek event, Controller, dan View sebelum menampilkan menu utama kepada pengguna.

Ketika pengguna memilih menu, UMKMView menerima input dan meneruskan permintaan ke UMKMController. Controller kemudian memanggil method pada UMKMDAO untuk menjalankan operasi database melalui JDBC dan PreparedStatement.

Alur setiap fitur adalah sebagai berikut:

Tambah Data UMKM
Pengguna memasukkan data UMKM. Setelah validasi berhasil, data diteruskan melalui Controller ke DAO untuk disimpan ke database menggunakan perintah INSERT.

Tampilkan Data UMKM
DAO mengambil data dari database menggunakan perintah SELECT. Hasil query ditampung sementara ke dalam ArrayList dan diteruskan untuk ditampilkan kepada pengguna.

Ubah Data UMKM
Pengguna memilih ID UMKM dan memasukkan data baru. DAO menjalankan perintah UPDATE untuk memperbarui data di database.

Hapus Data UMKM
Pengguna memasukkan ID UMKM yang akan dihapus. DAO menjalankan perintah DELETE berdasarkan ID tersebut.

Keluar
Pengguna memilih menu keluar untuk mengakhiri program.

Data awal disediakan melalui file SQL yang dijalankan pada database sebelum aplikasi digunakan. Dengan demikian, data dapat langsung ditampilkan tanpa harus dimasukkan ulang melalui menu program.

ArrayList tetap digunakan sebagai wadah sementara untuk menampung hasil query, sedangkan database MySQL menjadi tempat penyimpanan permanen data UMKM.

<img width="601" height="310" alt="image" src="https://github.com/user-attachments/assets/5bc4f6e4-a68d-4399-985f-af1e0aa88590" />




# Struktur Project

Program dibagi menjadi beberapa package agar setiap bagian memiliki tugas yang berbeda.

model berisi class yang berhubungan dengan data dan konsep PBO, seperti UMKM, Event, JenisUsaha, JenisKuliner, JenisFashion, dan InfoUMKM.

controller berisi class UMKMController yang mengatur alur pengolahan data dan meneruskan permintaan ke DAO.

view berisi class UMKMView yang menangani menu, input pengguna, dan tampilan hasil.

dao berisi class UMKMDAO yang menjalankan operasi CRUD ke database.

database berisi class DatabaseConnection yang mengatur koneksi aplikasi Java dengan MySQL.

com.mycompany.pendataan_umkm berisi class utama Pendataan_UMKM.java untuk menjalankan program.

Pemisahan package ini membuat kode lebih terstruktur karena bagian tampilan, pengolahan data, dan akses database memiliki tanggung jawab masing-masing.
  
<img width="598" height="629" alt="image" src="https://github.com/user-attachments/assets/c6444a2e-7c88-4b2e-878b-fc7282e342a1" />


# Penerapan Konsep PBO

## 1. Access Modifier

Pada program ini, atribut dalam class dibuat menggunakan access modifier `private`.

Contohnya pada class `UMKM`:

<img width="438" height="119" alt="image" src="https://github.com/user-attachments/assets/12a341e8-dcd8-4c3e-ac74-b4006e7905c0" />

### Alasan Menggunakan Access Modifier

`private` digunakan agar atribut pada object UMKM tidak dapat diakses dan diubah secara langsung dari class lain.

Data seperti nama usaha, nama pemilik, dan jenis usaha perlu dikontrol ketika akan diubah. Oleh karena itu, data tersebut tidak dibuat `public`.

Data tersebut nantinya diakses menggunakan getter dan setter.

Dengan menggunakan access modifier, data di dalam class menjadi lebih terkontrol dan tidak dapat diubah secara langsung dari luar class.

## 2. Encapsulation

Encapsulation diterapkan dengan membuat atribut menjadi `private`, kemudian menyediakan getter dan setter untuk mengakses atau mengubah data.

Contohnya:

<img width="441" height="299" alt="image" src="https://github.com/user-attachments/assets/6ff314ae-7c05-4464-bcd7-f47d2ea193f4" />

### Alasan Menggunakan Encapsulation

Encapsulation digunakan karena program memiliki data UMKM yang perlu disimpan dan dapat diubah melalui menu program.

Jika atribut dibuat `public`, class lain dapat mengubah data secara langsung. Dengan encapsulation, data tidak dapat diubah secara langsung dan harus melalui method yang sudah disediakan.

Contohnya ketika pengguna memilih menu **Ubah Data UMKM**, program menggunakan:

<img width="539" height="82" alt="image" src="https://github.com/user-attachments/assets/9f4b75ba-51f7-4093-88c9-c1c216146fdc" />


Dengan cara tersebut, pengelolaan data menjadi lebih teratur dan data yang ada di dalam object tetap terkontrol.

### Screenshot Encapsulation

<img width="679" height="519" alt="image" src="https://github.com/user-attachments/assets/1658b045-7b80-44d6-b9b9-0254be6fad9a" />

## 3. Inheritance

Inheritance digunakan pada bagian jenis usaha.

Program memiliki satu superclass yaitu `JenisUsaha` dan dua subclass yaitu `JenisKuliner` dan `JenisFashion`.

Contoh penerapan pada class :

<img width="526" height="351" alt="image" src="https://github.com/user-attachments/assets/12393b3d-b07b-423b-a42a-d7ecffe35748" />


<img width="519" height="161" alt="image" src="https://github.com/user-attachments/assets/4699c3a6-2908-4bd9-b6b8-50a87d903dcb" />


<img width="533" height="174" alt="image" src="https://github.com/user-attachments/assets/23970156-cbe7-4829-ac1f-6fea6ca9f85d" />


### Alasan Menggunakan Inheritance

Inheritance digunakan karena Kuliner dan Fashion merupakan jenis dari usaha.

`JenisUsaha` digunakan sebagai class induk yang mewakili jenis usaha secara umum. Kemudian `JenisKuliner` dan `JenisFashion` dibuat sebagai turunannya.

Dengan cara ini, hubungan antar-class menjadi lebih jelas. Selain itu, penerapan ini memenuhi ketentuan Mini Project 2 yang meminta minimal satu superclass dan dua subclass.

Inheritance tidak diterapkan pada class `UMKM` karena Kuliner dan Fashion lebih sesuai menjadi turunan dari `JenisUsaha`, bukan turunan dari UMKM.


## 4. Polymorphism

Polymorphism diterapkan pada program melalui **overloading** dan **overriding**. Penerapannya digunakan agar method dapat digunakan dengan cara yang berbeda sesuai dengan kebutuhan program.

### a. Overloading

Overloading diterapkan pada class `UMKM` melalui dua method `tampilkanInfo()` yang memiliki parameter berbeda.

Contohnya:

<img width="600" height="500" alt="image" src="https://github.com/user-attachments/assets/51a4a9af-bec2-4aa3-bd77-5e00e54916ea" />


Kedua method tersebut memiliki nama yang sama tetapi parameter yang berbeda.

Method `tampilkanInfo()` digunakan untuk menampilkan data UMKM secara lengkap. Sedangkan `tampilkanInfo(boolean detail)` digunakan untuk menentukan tampilan data berdasarkan nilai `detail`.

Pada menu **Tampilkan Data UMKM**, pengguna dapat memilih:

1. Tampilkan Data Lengkap
2. Tampilkan Data Singkat

Jika pengguna memilih **Data Lengkap**, program menggunakan:

```java
InfoUMKM info = umkm;
info.tampilkanInfo();
```

Sedangkan untuk **Data Singkat**, program menggunakan:

```java
umkm.tampilkanInfo(false);
```

Dengan demikian, overloading pada program tidak hanya dibuat sebagai tambahan method, tetapi benar-benar digunakan untuk memberikan pilihan tampilan data UMKM kepada pengguna.

### b. Overriding

Overriding diterapkan pada class `JenisKuliner` dan `JenisFashion`.

Kedua class tersebut mengimplementasikan kembali method `getKategori()` yang berasal dari abstract class `JenisUsaha`.

Pada `JenisKuliner`, method `getKategori()` menghasilkan kategori **Kuliner**:


<img width="500" height="400" alt="image" src="https://github.com/user-attachments/assets/2c47692b-4076-4527-acd7-d40f68ffc8ae" />


Sedangkan pada `JenisFashion`, method tersebut menghasilkan kategori **Fashion**:


<img width="400" height="270" alt="image" src="https://github.com/user-attachments/assets/2c00b9a0-cf27-40a8-a539-063dd68b39ea" />


Dengan overriding, masing-masing subclass dapat memberikan hasil yang sesuai dengan jenis usahanya.

### Alasan Menggunakan Polymorphism

Polymorphism digunakan karena program membutuhkan method yang dapat digunakan dengan bentuk yang berbeda. Overloading digunakan untuk memberikan pilihan tampilan data UMKM, sedangkan overriding digunakan agar setiap jenis usaha dapat menentukan kategori sesuai dengan class masing-masing.

### Screenshot Polymorphism

**Overloading pada `UMKM.java`:**

<img width="500" height="400" alt="image" src="https://github.com/user-attachments/assets/2673b3c3-7018-4cd2-aca4-3b6dcfe492a0" />


**Overriding pada `JenisKuliner.java`:**

<img width="400" height="200" alt="image" src="https://github.com/user-attachments/assets/668cb2fd-7a3e-49c9-9640-e5708346f968" />


**Overriding pada `JenisFashion.java`:**

<img width="427" height="271" alt="image" src="https://github.com/user-attachments/assets/e491b557-d753-4c4e-89b9-545b40332306" />


**Hasil Data Lengkap:**

<img width="614" height="660" alt="image" src="https://github.com/user-attachments/assets/b484ece9-8ef0-4250-851d-b3e87e8c50ca" />


**Hasil Data Singkat:**

<img width="614" height="659" alt="image" src="https://github.com/user-attachments/assets/e5cb66e9-3c73-4a7d-abd7-5c0d07f7feff" />



## 5. Abstraction

Abstraction diterapkan dengan mengubah class `JenisUsaha` menjadi **abstract class**.

`JenisUsaha` digunakan sebagai class umum untuk jenis usaha dan memiliki abstract method `getKategori()`.

Contohnya:

<img width="566" height="481" alt="image" src="https://github.com/user-attachments/assets/adf49cb5-f971-4e64-bb6f-f61e6e8941ec" />


Abstract method `getKategori()` tidak memiliki isi pada class `JenisUsaha`. Method tersebut kemudian harus diimplementasikan oleh subclass seperti `JenisKuliner` dan `JenisFashion`.

### Alasan Menggunakan Abstraction

Abstraction digunakan agar `JenisUsaha` dapat menjadi dasar untuk berbagai jenis usaha tanpa menentukan kategori secara langsung pada class induk.

Kategori usaha kemudian ditentukan oleh masing-masing subclass melalui method `getKategori()`. Dengan cara ini, `JenisKuliner` dapat menghasilkan kategori **Kuliner** dan `JenisFashion` dapat menghasilkan kategori **Fashion**.

### Screenshot Abstraction

**Abstract class `JenisUsaha.java`:**

<img width="666" height="581" alt="image" src="https://github.com/user-attachments/assets/ef1d1eaf-a8f5-475f-8d5f-a04210f8e1f5" />


**Subclass `JenisKuliner.java`:**

<img width="686" height="539" alt="image" src="https://github.com/user-attachments/assets/949cc4a9-4174-4ad6-af7a-2ef08aabdb6b" />


**Subclass `JenisFashion.java`:**

<img width="675" height="536" alt="image" src="https://github.com/user-attachments/assets/4b7a9b82-c3dd-4226-b069-1996e7240ae1" />


## 6. Input Validation

Program menggunakan validasi input untuk memastikan data yang dimasukkan pengguna sesuai dengan kebutuhan program.

Contoh validasi input angka:

<img width="589" height="335" alt="image" src="https://github.com/user-attachments/assets/23cf5008-8e65-4ac2-b3af-4c84f60e7388" />


Program juga melakukan validasi untuk input teks:

<img width="517" height="112" alt="image" src="https://github.com/user-attachments/assets/e2dcdfa3-56fb-40f8-adc0-f8783c786b7a" />


Program juga melakukan pengecekan ID agar tidak terdapat dua UMKM dengan ID yang sama.

### Alasan Menggunakan Input Validation

Input validation digunakan karena program menerima data secara langsung dari pengguna.

Pengguna dapat memasukkan data yang salah, misalnya memasukkan huruf ketika program meminta ID. Jika tidak dilakukan validasi, input tersebut dapat menyebabkan error pada program.

Oleh karena itu, validasi digunakan agar program dapat menangani input yang tidak sesuai dan memberikan pesan kepada pengguna tanpa membuat program langsung berhenti.

### Screenshot Input Validation

<img width="395" height="242" alt="image" src="https://github.com/user-attachments/assets/d2e96eb5-b476-4d59-b8b1-c334658c008b" />


## 7. Dummy Data

Pada Mini Project 4, dummy data disediakan melalui file SQL dan dimasukkan langsung ke database MySQL sebelum program dijalankan. Data awal tidak dibuat melalui kode Java.

Database yang digunakan bernama pendataan_umkm dan memiliki dua tabel utama, yaitu event dan umkm.

Tabel event menyimpan informasi event, sedangkan tabel umkm menyimpan data usaha, nama pemilik, jenis usaha, dan ID event yang diikuti.

Data awal yang digunakan dalam program meliputi event Bazar UMKM Samarinda 2026, UMKM Dapur Aulia, dan UMKM Samarinda Fashion.

File SQL berisi perintah untuk membuat database, membuat tabel beserta relasinya, dan memasukkan data awal. Ketika aplikasi dijalankan, fitur tampil data mengambil informasi dari database melalui DAO.

Dengan cara ini, data awal sudah tersedia saat fitur Read digunakan. Data juga tetap tersimpan ketika aplikasi ditutup karena MySQL digunakan sebagai penyimpanan permanen.

<img width="640" height="323" alt="image" src="https://github.com/user-attachments/assets/bdef287e-413c-492d-be26-38a9cf3ef610" />


## Model, View, dan Controller (MVC)

Program Sistem Pendataan UMKM menggunakan pola arsitektur Model-View-Controller (MVC) untuk memisahkan bagian data, tampilan, dan pengolahan program agar lebih terstruktur.

Model: Berisi class yang merepresentasikan data program, seperti UMKM, Event, JenisKuliner, dan JenisFashion.

View: Berada pada class UMKMView dan bertugas menampilkan menu, menerima input pengguna, serta menampilkan hasil pengolahan data.

Controller: Berada pada class UMKMController dan bertugas menghubungkan View dengan DAO untuk menjalankan operasi pengolahan data UMKM.

DAO (Data Access Object): Berada pada class UMKMDAO dan bertugas menjalankan operasi CRUD ke database MySQL menggunakan JDBC dan PreparedStatement.

Alur MVC pada Mini Project 4

Ketika pengguna memilih menu pada View, permintaan diteruskan ke Controller. Controller kemudian memanggil DAO untuk menjalankan operasi yang diperlukan pada database MySQL. Hasil operasi dikembalikan ke Controller dan ditampilkan melalui View.

Dengan penerapan MVC, kode program menjadi lebih terorganisir karena tampilan, logika pengolahan data, representasi objek, dan akses database memiliki tugas masing-masing.

## Penerapan JDBC dan DAO

1. JDBC (Java Database Connectivity)

JDBC digunakan untuk menghubungkan aplikasi Java dengan database MySQL. Pada program ini, koneksi diatur melalui class DatabaseConnection.java yang berada dalam package database.

Class tersebut menggunakan DriverManager.getConnection() dengan URL database, username, dan password sesuai konfigurasi MySQL.

Dengan JDBC, aplikasi dapat menjalankan perintah SQL untuk mengambil, menambahkan, mengubah, dan menghapus data UMKM.

<img width="604" height="349" alt="image" src="https://github.com/user-attachments/assets/96a5ea0d-07aa-4d26-a854-fd80efd7e117" />


2. PreparedStatement

PreparedStatement digunakan untuk menjalankan perintah SQL dengan parameter yang diisi melalui program Java.

Pada program ini, PreparedStatement digunakan dalam operasi CRUD. Parameter seperti ID UMKM dan nama usaha dimasukkan menggunakan method seperti setInt() dan setString().

Penggunaan PreparedStatement membuat query lebih terstruktur dan membantu mengurangi risiko SQL injection dibandingkan menggabungkan input pengguna langsung ke dalam teks SQL.


<img width="649" height="527" alt="image" src="https://github.com/user-attachments/assets/44d27c20-04fd-41a3-ad9a-cbccffb7f213" />


3. Data Access Object (DAO)

DAO merupakan bagian program yang bertanggung jawab menangani akses ke database. Pada proyek ini, DAO diterapkan melalui class UMKMDAO.java di package dao.

Method yang digunakan meliputi:

tampilkanSemua() untuk mengambil seluruh data UMKM.

tambah() untuk menyimpan data UMKM baru.

ubah() untuk memperbarui data UMKM.

hapus() untuk menghapus data berdasarkan ID.

DAO memisahkan perintah SQL dari bagian tampilan dan Controller sehingga kode lebih mudah dikelola.


<img width="578" height="323" alt="image" src="https://github.com/user-attachments/assets/7e73c5d1-aa9c-4b2e-8ad5-0206c9a42203" />


4. Hubungan MVC, DAO, dan Database

Pada Mini Project 4, MVC tetap digunakan dan dilengkapi dengan DAO serta database MySQL.

Model merepresentasikan data UMKM dan event.

View menampilkan menu dan menerima input pengguna.

Controller menerima permintaan dari View dan memanggil DAO.

DAO menjalankan perintah SQL menggunakan JDBC dan PreparedStatement.

Database MySQL menyimpan data secara permanen.

Dengan pembagian ini, setiap bagian program memiliki tugas yang jelas dan proses CRUD dapat dilakukan melalui aplikasi yang terhubung dengan database.

# Tampilan Program

## 1. Menu Utama

<img width="430" height="197" alt="image" src="https://github.com/user-attachments/assets/fe5a6039-ff00-4f0d-ae56-d74afdf51ca2" />

## 2. Tambah Data UMKM

<img width="506" height="241" alt="image" src="https://github.com/user-attachments/assets/1e3b3cfe-c073-4ff7-8d46-aab6c83594d8" />


## 3. Tampilkan Data UMKM

### Data Lengkap

<img width="699" height="656" alt="image" src="https://github.com/user-attachments/assets/47afd122-d8c7-413e-97d1-32029222cabe" />

### Data Singkat

<img width="611" height="659" alt="image" src="https://github.com/user-attachments/assets/06f81a86-3324-4020-9073-8f9c479168da" />



## 4. Ubah Data UMKM

<img width="513" height="235" alt="image" src="https://github.com/user-attachments/assets/1010c759-7447-4c46-94b7-f73ea627f56a" />


## 5. Hapus Data UMKM

<img width="423" height="132" alt="image" src="https://github.com/user-attachments/assets/992e2190-8bc2-4f31-b193-ebbfa89f74e1" />


## Pengujian Program

Pengujian dilakukan untuk memastikan aplikasi dapat terhubung dengan database dan menjalankan operasi CRUD.

Pengujian yang dilakukan meliputi:

Menguji koneksi aplikasi Java dengan MySQL.

Menampilkan data awal yang telah dimasukkan melalui file SQL.

Menambahkan data UMKM baru dan memeriksa apakah data tersimpan di database.

Mengubah data UMKM dan memeriksa hasil perubahan.

Menghapus data UMKM dan memastikan data tersebut tidak lagi muncul.

Dokumentasi Pengujian

Tambahkan screenshot hasil pengujian berikut:

Koneksi database.

<img width="323" height="184" alt="image" src="https://github.com/user-attachments/assets/bd3833d0-18d2-4666-bd3b-77f96dbe3bf0" />


<img width="427" height="212" alt="image" src="https://github.com/user-attachments/assets/a93a175d-4d89-42c1-99bd-63d946523829" />


Data awal di MySQL.

<img width="785" height="670" alt="image" src="https://github.com/user-attachments/assets/1033d92c-0d7a-4576-a77d-437991038b50" />


<img width="356" height="258" alt="image" src="https://github.com/user-attachments/assets/3d360874-c2c9-405d-b46d-f6998ce023b4" />


Hasil tampil data.

<img width="669" height="513" alt="image" src="https://github.com/user-attachments/assets/f35154e1-1234-463a-9a61-21cd54752e25" />


<img width="352" height="95" alt="image" src="https://github.com/user-attachments/assets/270e14c0-1c66-4e6c-9ee9-c4a0e83e71a6" />


<img width="296" height="244" alt="image" src="https://github.com/user-attachments/assets/ee0d5033-897a-4b1b-bbb8-ed8e14ca094e" />


<img width="572" height="500" alt="image" src="https://github.com/user-attachments/assets/682fccc6-5897-4c41-a4c5-7963c2ac8b50" />


<img width="441" height="499" alt="image" src="https://github.com/user-attachments/assets/c93e69ad-cc74-4d92-bf75-872f9b9ad9a5" />


<img width="391" height="323" alt="image" src="https://github.com/user-attachments/assets/40489b3e-dc48-4e4f-b221-1201f1a75c6e" />

ubah

<img width="208" height="256" alt="image" src="https://github.com/user-attachments/assets/d575ba01-725b-4a11-86f5-ce5f9fd79445" />

<img width="214" height="253" alt="image" src="https://github.com/user-attachments/assets/dfdf8207-3ff1-4ffe-8558-6bfa560857b0" />

<img width="383" height="224" alt="image" src="https://github.com/user-attachments/assets/fd06ddfa-dca0-4f38-9b5d-f5d9a3169f47" />

hapus

<img width="487" height="251" alt="image" src="https://github.com/user-attachments/assets/be20be13-2d67-4780-a2d2-3a157c9aea9b" />

<img width="259" height="250" alt="image" src="https://github.com/user-attachments/assets/8304577f-144c-42ff-995b-f9f2c19ceebb" />


# Kesimpulan

Pada Mini Project 4, Sistem Pendataan UMKM pada Event dikembangkan dengan mengintegrasikan aplikasi Java dengan database MySQL menggunakan JDBC, PreparedStatement, dan DAO. Konsep PBO dari mini project sebelumnya tetap digunakan, meliputi encapsulation, inheritance, polymorphism, dan abstraction.

Penggunaan DAO memisahkan proses akses database dari bagian tampilan dan Controller. Fitur CRUD memungkinkan pengguna menambah, menampilkan, mengubah, dan menghapus data UMKM yang tersimpan di database. Dummy data disediakan melalui file SQL sehingga data awal dapat langsung ditampilkan ketika fitur Read dijalankan.

Dengan pengembangan ini, program tidak hanya menerapkan konsep PBO, tetapi juga dapat menyimpan dan mengelola data secara permanen melalui database MySQL.
