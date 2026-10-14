# PenghasilanKaryawan

Program Java berbasis konsol untuk menghitung penghasilan karyawan berdasarkan **golongan** dan **jumlah jam lembur**. Hasilnya ditampilkan sebagai rincian gaji dalam format rupiah.

## Fitur

- Menerima masukan golongan karyawan (A, B, atau C), tidak peka huruf besar/kecil.
- Menerima masukan jumlah jam lembur berupa bilangan bulat tidak negatif.
- Memvalidasi masukan dan mengulang permintaan sampai masukan benar.
- Menghitung gaji pokok, gaji lembur, dan total penghasilan.
- Menampilkan angka dengan format rupiah (pemisah ribuan titik, contoh `8.710.000`).

## Persyaratan

- **JDK 19 atau lebih baru.** Program memakai `Locale.of("id", "ID")` yang baru tersedia mulai Java 19.
  Pada versi yang lebih lama, ganti dengan `new Locale("id", "ID")`.

## Cara Menjalankan

1. Simpan kode dengan nama `PenghasilanKaryawan.java`.
2. Kompilasi:

   ```bash
   javac PenghasilanKaryawan.java
   ```

3. Jalankan:

   ```bash
   java PenghasilanKaryawan
   ```

## Aturan Perhitungan

### Gaji pokok per golongan

| Golongan | Gaji pokok   |
|----------|--------------|
| A        | Rp 5.000.000 |
| B        | Rp 6.500.000 |
| C        | Rp 9.500.000 |

### Persentase lembur (dari gaji pokok)

| Jam lembur   | Persentase |
|--------------|------------|
| 0            | 0%         |
| 1            | 30%        |
| 2            | 32%        |
| 3            | 34%        |
| 4            | 36%        |
| 5 atau lebih | 38%        |

### Rumus

```text
gajiLembur       = persentaseLembur * gajiPokok
totalPenghasilan = gajiPokok + gajiLembur
```

## Validasi Masukan

| Masukan            | Kondisi tidak valid                         | Perilaku                              |
|--------------------|---------------------------------------------|---------------------------------------|
| Golongan           | Bukan satu karakter A, B, atau C            | Menampilkan pesan dan meminta ulang   |
| Jam lembur         | Bukan angka (huruf atau simbol)             | Menampilkan pesan dan meminta ulang   |
| Jam lembur         | Bernilai negatif                            | Menampilkan pesan dan meminta ulang   |

## Contoh Penggunaan

```text
=== PROGRAM PENGHITUNG GAJI KARYAWAN ===
Masukkan Golongan Karyawan (A / B / C): b
Masukkan Jumlah Jam Lembur: 3

-------------------------------------------------
         RINCIAN PENGHASILAN
-------------------------------------------------
Golongan         : B
Gaji Pokok       : Rp 6.500.000
Jam Lembur       : 3 Jam
Gaji Lembur      : Rp 2.210.000
-------------------------------------------------
Total Penghasilan: Rp 8.710.000
-------------------------------------------------
```

## Struktur Kode

| Bagian                      | Fungsi                                                              |
|-----------------------------|---------------------------------------------------------------------|
| Pengaturan `DecimalFormat`  | Mengatur format rupiah dengan titik sebagai pemisah ribuan          |
| Perulangan `while` golongan | Membaca dan memvalidasi golongan                                    |
| Perulangan `while` lembur   | Membaca dan memvalidasi jam lembur dengan `hasNextInt()`            |
| `if..else if` gaji pokok    | Menentukan gaji pokok berdasarkan golongan                          |
| `if..else if` lembur        | Menentukan persentase lembur berdasarkan jam lembur                 |
| Perhitungan dan keluaran    | Menghitung total penghasilan dan mencetak rincian                   |

## Catatan

- Angka keluaran _(Output)_ dibulatkan ke bilangan bulat karena memakai pola `#,###`.
- Program tidak menyimpan data; semua nilai hanya diproses di memori selama program berjalan.
