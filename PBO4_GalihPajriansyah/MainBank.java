public class MainBank {
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║        PROGRAM TRANSAKSI PERBANKAN JAVA          ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.println();

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("          1. DEMO METHOD OVERLOADING (Bank)");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        Bank bankUmum = new Bank("Galih Pajriansyah", "1234-5678-9012", 5_000_000);

        // Suku bunga standar
        bankUmum.sukuBunga();
        System.out.println();

        // Overload 1: Transfer sesama bank
        bankUmum.transferUang(500_000, "9876-5432-1098");

        // Overload 2: Transfer beda bank
        bankUmum.transferUang(1_000_000, "1111-2222-3333", "BCA");

        // Overload 3: Transfer beda bank + berita
        bankUmum.transferUang(750_000, "4444-5555-6666", "BRI", "Pembayaran cicilan motor");

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("       2. DEMO METHOD OVERRIDING (BankBNI)");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        BankBNI nasabahBNI = new BankBNI("Bang Galih", "0011-2233-4455", 8_000_000);

        // Suku bunga BNI (overriding)
        nasabahBNI.sukuBunga();
        System.out.println();

        // Overriding transferUang - bankTujuan otomatis jadi "BNI"
        nasabahBNI.transferUang(2_000_000, "7788-9900-1122", "MANDIRI");

        // Overload 1 (diwarisi dari Bank) - sesama BNI, gratis
        nasabahBNI.transferUang(300_000, "5566-7788-9900");

        // Overload 3 (diwarisi dari Bank) - dengan berita
        nasabahBNI.transferUang(500_000, "3344-5566-7788", "BCA", "Transfer uang belanja");


        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("       3. DEMO METHOD OVERRIDING (BankBCA)");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        BankBCA nasabahBCA = new BankBCA("Galih njirr", "6677-8899-0011", 10_000_000);

        // Suku bunga BCA (overriding)
        nasabahBCA.sukuBunga();
        System.out.println();

        // Overriding transferUang - bankTujuan otomatis jadi "BCA"
        nasabahBCA.transferUang(3_000_000, "2233-4455-6677", "BNI");

        // Overload 1 (diwarisi dari Bank) - sesama BCA, gratis
        nasabahBCA.transferUang(1_000_000, "8899-0011-2233");

        // Overload 3 (diwarisi dari Bank) - dengan berita
        nasabahBCA.transferUang(200_000, "0011-2233-4455", "MANDIRI", "Bayar tagihan listrik");

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("        BONUS: Tabel Biaya Transfer Antar Bank");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.printf("%-10s | %-12s | %-12s | %-12s%n", "Dari \\ Ke", "BNI", "BCA", "Lainnya");
        System.out.println("-----------|--------------|--------------|------------");

        Bank[] banks = { new Bank("x","x",0), new BankBNI("x","x",0), new BankBCA("x","x",0) };
        String[] namaBank = { "Bank Umum", "BNI", "BCA" };

        for (int i = 0; i < banks.length; i++) {
            System.out.printf("%-10s | Rp %-9.0f| Rp %-9.0f| Rp %-9.0f%n",
                namaBank[i],
                banks[i].hitungBiayaTransfer("BNI"),
                banks[i].hitungBiayaTransfer("BCA"),
                banks[i].hitungBiayaTransfer("MANDIRI")
            );
        }

        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║              Program Selesai Dijalankan          ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }
}