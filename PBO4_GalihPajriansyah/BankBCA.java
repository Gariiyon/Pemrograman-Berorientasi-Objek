public class BankBCA extends Bank {

    public BankBCA(String namaNasabah, String nomorRekening, double saldo) {
        super(namaNasabah, nomorRekening, saldo);
    }

    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga BCA adalah 4.5%");
    }

    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        // Override: bank tujuan ditetapkan "BCA"
        String bankDitetapkan = "BCA";
        double biayaAdmin = hitungBiayaTransfer(bankDitetapkan);
        double totalPotong = jumlah + biayaAdmin;

        System.out.println("=== [BCA] Transfer Beda Bank ===");
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

    @Override
    public double hitungBiayaTransfer(String bankTujuan) {
        if (bankTujuan == null || bankTujuan.equalsIgnoreCase("BCA") || bankTujuan.equalsIgnoreCase("SAMA")) {
            return 0; // Gratis sesama BCA
        }
        return switch (bankTujuan.toUpperCase()) {
            case "BNI", "BRI", "MANDIRI" -> 6500;
            default -> 25000;
        };
    }
}