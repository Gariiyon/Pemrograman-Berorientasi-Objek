public class BankBNI extends Bank {

    public BankBNI(String namaNasabah, String nomorRekening, double saldo) {
        super(namaNasabah, nomorRekening, saldo);
    }

    // ============================================================
    // METHOD OVERRIDING - sukuBunga BNI = 4%
    // ============================================================
    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga BNI adalah 4%");
    }

    // ============================================================
    // METHOD OVERRIDING - transferUang beda bank
    // bankTujuan otomatis "BNI"
    // ============================================================
    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        // Override: bank tujuan ditetapkan "BNI"
        String bankDitetapkan = "BNI";
        double biayaAdmin = hitungBiayaTransfer(bankDitetapkan);
        double totalPotong = jumlah + biayaAdmin;

        System.out.println("=== [BNI] Transfer Beda Bank ===");
        System.out.println("Dari        : " + nomorRekening + " (" + namaNasabah + ")");
        System.out.println("Tujuan      : " + rekeningTujuan);
        System.out.println("Bank Tujuan : " + bankDitetapkan + " (otomatis disetel)");
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

    // ============================================================
    // BONUS: Override biaya transfer BNI (lebih murah sesama BNI)
    // ============================================================
    @Override
    public double hitungBiayaTransfer(String bankTujuan) {
        if (bankTujuan == null || bankTujuan.equalsIgnoreCase("BNI") || bankTujuan.equalsIgnoreCase("SAMA")) {
            return 0; // Gratis sesama BNI
        }
        return switch (bankTujuan.toUpperCase()) {
            case "BCA", "BRI", "MANDIRI" -> 6500;
            default -> 25000;
        };
    }
}