public class Bank {
    protected String namaNasabah;
    protected String nomorRekening;
    protected double saldo;

    public Bank(String namaNasabah, String nomorRekening, double saldo) {
        this.namaNasabah = namaNasabah;
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
    }

    // ============================================================
    // METHOD OVERLOADING
    // ============================================================

    // 1) Transfer ke rekening lain (bank yang sama)
    public void transferUang(int jumlah, String rekeningTujuan) {
        double biayaAdmin = hitungBiayaTransfer("SAMA");
        double totalPotong = jumlah + biayaAdmin;

        System.out.println("=== Transfer Sesama Bank ===");
        System.out.println("Dari      : " + nomorRekening + " (" + namaNasabah + ")");
        System.out.println("Tujuan    : " + rekeningTujuan);
        System.out.println("Jumlah    : Rp " + String.format("%,.0f", (double) jumlah));
        System.out.println("Biaya     : Rp " + String.format("%,.0f", biayaAdmin));
        System.out.println("Total     : Rp " + String.format("%,.0f", totalPotong));

        if (saldo >= totalPotong) {
            saldo -= totalPotong;
            System.out.println("Status    : BERHASIL");
            System.out.println("Sisa Saldo: Rp " + String.format("%,.0f", saldo));
        } else {
            System.out.println("Status    : GAGAL - Saldo tidak mencukupi");
        }
        System.out.println();
    }

    // 2) Transfer ke rekening lain di bank berbeda
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        double biayaAdmin = hitungBiayaTransfer(bankTujuan);
        double totalPotong = jumlah + biayaAdmin;

        System.out.println("=== Transfer Beda Bank ===");
        System.out.println("Dari        : " + nomorRekening + " (" + namaNasabah + ")");
        System.out.println("Tujuan      : " + rekeningTujuan);
        System.out.println("Bank Tujuan : " + bankTujuan);
        System.out.println("Jumlah      : Rp " + String.format("%,.0f", (double) jumlah));
        System.out.println("Biaya Admin : Rp " + String.format("%,.0f", biayaAdmin));
        System.out.println("Total Potong: Rp " + String.format("%,.0f", totalPotong));

        if (saldo >= totalPotong) {
            saldo -= totalPotong;
            System.out.println("Status      : BERHASIL");
            System.out.println("Sisa Saldo  : Rp " + String.format("%,.0f", saldo));
        } else {
            System.out.println("Status      : GAGAL - Saldo tidak mencukupi");
        }
        System.out.println();
    }

    // 3) Transfer dengan tambahan berita
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        double biayaAdmin = hitungBiayaTransfer(bankTujuan);
        double totalPotong = jumlah + biayaAdmin;

        System.out.println("=== Transfer Beda Bank dengan Berita ===");
        System.out.println("Dari        : " + nomorRekening + " (" + namaNasabah + ")");
        System.out.println("Tujuan      : " + rekeningTujuan);
        System.out.println("Bank Tujuan : " + bankTujuan);
        System.out.println("Jumlah      : Rp " + String.format("%,.0f", (double) jumlah));
        System.out.println("Biaya Admin : Rp " + String.format("%,.0f", biayaAdmin));
        System.out.println("Total Potong: Rp " + String.format("%,.0f", totalPotong));
        System.out.println("Berita      : " + berita);

        if (saldo >= totalPotong) {
            saldo -= totalPotong;
            System.out.println("Status      : BERHASIL");
            System.out.println("Sisa Saldo  : Rp " + String.format("%,.0f", saldo));
        } else {
            System.out.println("Status      : GAGAL - Saldo tidak mencukupi");
        }
        System.out.println();
    }

    // 4) Cetak suku bunga standar
    public void sukuBunga() {
        System.out.println("Suku Bunga standar adalah 3%");
    }

    // ============================================================
    // BONUS: Hitung biaya transfer berdasarkan bank tujuan
    // ============================================================
    public double hitungBiayaTransfer(String bankTujuan) {
        if (bankTujuan == null || bankTujuan.equalsIgnoreCase("SAMA")) {
            return 0; // Gratis sesama bank
        }
        return switch (bankTujuan.toUpperCase()) {
            case "BNI" -> 6500;
            case "BCA" -> 6500;
            case "BRI" -> 6500;
            case "MANDIRI" -> 6500;
            default -> 25000;
        }; // Bank lain / luar negeri
    }

    // Getter
    public double getSaldo() { return saldo; }
    public String getNamaNasabah() { return namaNasabah; }
}