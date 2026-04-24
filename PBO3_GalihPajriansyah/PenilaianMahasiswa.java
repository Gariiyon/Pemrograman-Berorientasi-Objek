import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1. Pembuatan Class Objek Mahasiswa
class Mahasiswa {
    String nim;
    String nama;
    int nilai;
    String grade;
    boolean isLulus;

    // Constructor
    public Mahasiswa(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
        tentukanGrade();
    }

    // Method untuk menentukan grade dan status kelulusan
    private void tentukanGrade() {
        if (nilai >= 80 && nilai <= 100) {
            grade = "A";
            isLulus = true;
        } else if (nilai >= 70 && nilai <= 79) {
            grade = "B";
            isLulus = true;
        } else if (nilai >= 60 && nilai <= 69) {
            grade = "C";
            isLulus = true;
        } else if (nilai >= 50 && nilai <= 59) {
            grade = "D";
            isLulus = false;
        } else if (nilai >= 0 && nilai < 50) {
            grade = "E";
            isLulus = false;
        }
    }
}

// 2. Class Utama Program
public class PenilaianMahasiswa {
    public static void main(String[] args) {
        System.out.println("--- Program Entri Nilai Mahasiswa ---");
        try (Scanner input = new Scanner(System.in)) {
            ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<>();
            boolean lanjutInput = true;

            // Proses Input Data
            while (lanjutInput) {
                System.out.print("\nMasukkan NIM   : ");
                String nim = input.nextLine();

                System.out.print("Masukkan Nama  : ");
                String nama = input.nextLine();

                int nilai = -1;
                boolean nilaiValid = false;

                // Validasi Input Nilai (Syarat G)
                while (!nilaiValid) {
                    System.out.print("Masukkan Nilai : ");
                    nilai = input.nextInt();
                    input.nextLine(); // Membersihkan sisa karakter enter (newline)

                    if (nilai >= 0 && nilai <= 100) {
                        nilaiValid = true;
                    } else {
                        System.out.println("Notifikasi: Input nilai anda salah! (Harus 0-100)");
                    }
                }

                // Menyimpan objek mahasiswa ke dalam ArrayList
                dataMahasiswa.add(new Mahasiswa(nim, nama, nilai));

                System.out.print("Input data lagi? (y/t): ");
                String pilihan = input.nextLine();
                if (pilihan.equalsIgnoreCase("t")) {
                    lanjutInput = false;
                }
            }

            // ==========================================
            // PROSES OUTPUT DAN KALKULASI STATISTIK
            // ==========================================
            System.out.println("\nKetentuan hasil output dan layout seperti berikut ini:\n");

            List<String> lulus = new ArrayList<>();
            List<String> tidakLulus = new ArrayList<>();
            List<String> namaGradeA = new ArrayList<>();
            List<String> namaGradeB = new ArrayList<>();
            List<String> namaGradeC = new ArrayList<>();
            List<String> namaGradeD = new ArrayList<>();
            List<String> namaGradeE = new ArrayList<>();
            List<String> listDeretNilai = new ArrayList<>();
            double totalNilai = 0;

            // Mencetak data per mahasiswa dan mengelompokkan data
            for (Mahasiswa mhs : dataMahasiswa) {
                System.out.println("NIM   : " + mhs.nim);
                System.out.println("Nama  : " + mhs.nama);
                System.out.println("Nilai : " + mhs.nilai);
                System.out.println("Grade : " + mhs.grade);
                System.out.println("========================================");

                // Pengelompokan untuk summary
                if (mhs.isLulus) lulus.add(mhs.nama);
                else tidakLulus.add(mhs.nama);

                switch (mhs.grade) {
                    case "A" -> namaGradeA.add(mhs.nama);
                    case "B" -> namaGradeB.add(mhs.nama);
                    case "C" -> namaGradeC.add(mhs.nama);
                    case "D" -> namaGradeD.add(mhs.nama);
                    case "E" -> namaGradeE.add(mhs.nama);
                }

                listDeretNilai.add(String.valueOf(mhs.nilai));
                totalNilai += mhs.nilai;
            }

            // Mencetak Summary Data
            int jumlahMhs = dataMahasiswa.size();
            double rataRata = totalNilai / jumlahMhs;

            System.out.println("Jumlah Mahasiswa : " + jumlahMhs);
            
            if (!lulus.isEmpty()) {
                System.out.println("Jumlah Mahasiswa yg Lulus : " + lulus.size() + " yaitu " + String.join(", ", lulus));
            } else {
                System.out.println("Jumlah Mahasiswa yg Lulus : 0");
            }

            if (!tidakLulus.isEmpty()) {
                System.out.println("Jumlah Mahasiswa yg Tidak Lulus : " + tidakLulus.size() + " yaitu " + String.join(", ", tidakLulus));
            } else {
                System.out.println("Jumlah Mahasiswa yg Tidak Lulus : 0");
            }

            // Cetak rekap per grade jika ada datanya
            if (!namaGradeA.isEmpty()) System.out.println("Jumlah Mahasiswa dengan Nilai A = " + namaGradeA.size() + " yaitu " + String.join(", ", namaGradeA));
            if (!namaGradeB.isEmpty()) System.out.println("Jumlah Mahasiswa dengan Nilai B = " + namaGradeB.size() + " yaitu " + String.join(", ", namaGradeB));
            if (!namaGradeC.isEmpty()) System.out.println("Jumlah Mahasiswa dengan Nilai C = " + namaGradeC.size() + " yaitu " + String.join(", ", namaGradeC));
            if (!namaGradeD.isEmpty()) System.out.println("Jumlah Mahasiswa dengan Nilai D = " + namaGradeD.size() + " yaitu " + String.join(", ", namaGradeD));
            if (!namaGradeE.isEmpty()) System.out.println("Jumlah Mahasiswa dengan Nilai E = " + namaGradeE.size() + " yaitu " + String.join(", ", namaGradeE));

            // Cetak Rata-rata
            String deretPenjumlahan = String.join("+", listDeretNilai);
            System.out.println("Rata-rata nilai mahasiswa adalah : " + deretPenjumlahan + " / " + jumlahMhs + " = " + rataRata);
        }
    }
}