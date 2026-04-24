import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== SIMULASI DATA AKADEMIK =====\n");

        // --- Input Mahasiswa ---
        System.out.print("Masukkan nama mahasiswa: ");
        String namaMhs = sc.nextLine();

        System.out.print("Masukkan alamat mahasiswa: ");
        String alamatMhs = sc.nextLine();

        Student mahasiswa = new Student(namaMhs, alamatMhs);

        System.out.print("Berapa mata kuliah yang diambil? ");
        int jumlahMatkul = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < jumlahMatkul; i++) {
            System.out.print("Nama mata kuliah ke-" + (i + 1) + ": ");
            String matkul = sc.nextLine();
            System.out.print("Nilai untuk " + matkul + ": ");
            int nilai = Integer.parseInt(sc.nextLine());
            mahasiswa.addCourseGrade(matkul, nilai);
        }

        // --- Input Dosen ---
        System.out.print("\nMasukkan nama dosen: ");
        String namaDosen = sc.nextLine();

        System.out.print("Masukkan alamat dosen: ");
        String alamatDosen = sc.nextLine();

        Teacher dosen = new Teacher(namaDosen, alamatDosen);

        System.out.print("Berapa mata kuliah yang diampu dosen? ");
        int jumlahAmpu = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < jumlahAmpu; i++) {
            System.out.print("Nama mata kuliah ke-" + (i + 1) + ": ");
            String matkul = sc.nextLine();
            boolean berhasil = dosen.addCourse(matkul);
            if (!berhasil) {
                System.out.println("  ⚠ Mata kuliah '" + matkul + "' sudah ada, dilewati.");
            }
        }

        // Simulasi removeCourse
        System.out.print("\nCoba hapus mata kuliah dari daftar dosen (ketik nama atau '-' untuk skip): ");
        String hapus = sc.nextLine();
        if (!hapus.equals("-")) {
            boolean hasil = dosen.removeCourse(hapus);
            System.out.println(hasil
                ? "✓ Mata kuliah '" + hapus + "' berhasil dihapus."
                : "✗ Mata kuliah '" + hapus + "' tidak ditemukan.");
        }

        // --- Output ---
        System.out.println("\n========== HASIL ==========");
        System.out.println(mahasiswa);
        System.out.println();
        mahasiswa.printGrades();
        System.out.printf("Rata-rata nilai: %.2f%n", mahasiswa.getAverageGrade());

        System.out.println();
        System.out.println(dosen);

        sc.close();
    }
}