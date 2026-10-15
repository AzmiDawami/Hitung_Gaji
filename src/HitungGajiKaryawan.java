import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class HitungGajiKaryawan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Mengatur format angka menggunakan titik (.) sebagai pemisah ribuan
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.of("id", "ID"));
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat formatTigaDigit = new DecimalFormat("#,###", symbols);

        // Deklarasi variabel untuk input golongan dan jam lembur
        char golongan = ' ';
        int jamLembur = -1;
        boolean golonganValid = false;
        boolean jamLemburValid = false;

        // Menampilkan judul program
        System.out.println("=== PROGRAM PENGHITUNG GAJI KARYAWAN ===");

        // --- VALIDASI INPUT GOLONGAN ---
        while (!golonganValid) {
            System.out.print("Masukkan Golongan Karyawan (A / B / C): ");
            String inputGolongan = input.next();

            // Memeriksa apakah input hanya 1 karakter dan berupa huruf a, b, atau c (case insensitive)
            if (inputGolongan.length() == 1) {
                golongan = Character.toUpperCase(inputGolongan.charAt(0));
                if (golongan == 'A' || golongan == 'B' || golongan == 'C') {
                    golonganValid = true; // Input valid, keluar dari loop golongan
                } else {
                    System.out.println("Golongan tidak valid, harap ketikkan ulang golongan karyawan dengan benar!\n");
                }
            } else {
                System.out.println("Golongan tidak valid, harap ketikkan ulang golongan karyawan dengan benar!\n");
            }
        }

        // Input dan validasi jumlah jam lembur
        while (!jamLemburValid) {
            System.out.print("Masukkan Jumlah Jam Lembur: ");
            
            // Validasi apakah input jam lembur adalah angka dan bukan negatif
            if (input.hasNextInt()) {
                jamLembur = input.nextInt();
                if (jamLembur >= 0) {
                    jamLemburValid = true; // Input valid, keluar dari loop jam lembur
                } else {
                    System.out.println("Jam lembur tidak boleh bernilai negatif. Harap ketikkan ulang!\n");
                }
            } else {
                // Jika input bukan angka (misal huruf atau simbol)
                System.out.println("Jam lembur harus berupa angka. Harap ketikkan ulang jam lembur yang sesuai!\n");
                input.next(); // Membersihkan input yang salah di buffer scanner
            }
        }

        // Deklarasi variabel perhitungan gaji
        double gajiPokok = 0;
        double persentaseLembur = 0;

        // Menentukan dan menghitung Gaji Pokok berdasarkan Golongan
        if (golongan == 'A') {
            gajiPokok = 5000000;
        } else if (golongan == 'B') {
            gajiPokok = 6500000;
        } else if (golongan == 'C') {
            gajiPokok = 9500000;
        }

        // Menentukan Persentase Lembur berdasarkan Jam Lembur
        if (jamLembur == 1) {
            persentaseLembur = 0.30;
        } else if (jamLembur == 2) {
            persentaseLembur = 0.32;
        } else if (jamLembur == 3) {
            persentaseLembur = 0.34;
        } else if (jamLembur == 4) {
            persentaseLembur = 0.36;
        } else if (jamLembur >= 5) {
            persentaseLembur = 0.38;
        } else {
            persentaseLembur = 0.0; // Jika 0 jam lembur
        }

        // Menghitung Gaji Lembur dan Total Penghasilan
        double gajiLembur = persentaseLembur * gajiPokok;
        double totalPenghasilan = gajiPokok + gajiLembur;

        // Output hasil akhir rincian penghasilan karyawan
        System.out.println("\n----------------------------------------");
        System.out.println("         RINCIAN PENGHASILAN            ");
        System.out.println("----------------------------------------");
        System.out.println("Golongan         : " + golongan);
        System.out.println("Gaji Pokok       : Rp " + formatTigaDigit.format(gajiPokok));
        System.out.println("Jam Lembur       : " + jamLembur + " Jam");
        System.out.println("Gaji Lembur      : Rp " + formatTigaDigit.format(gajiLembur));
        System.out.println("----------------------------------------");
        System.out.println("Total Penghasilan: Rp " + formatTigaDigit.format(totalPenghasilan));
        System.out.println("----------------------------------------");

        input.close();
    }
}