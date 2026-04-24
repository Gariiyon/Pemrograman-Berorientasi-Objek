public class HandPhone {
    // 1. Atribut/Variabel Instance
    String jenis_hp;
    int tahun_pembuatan;

    // 2. Method Mutator (Setter) untuk mengisi data
    // Gunakan 'this.' untuk membedakan variabel class dengan parameter
    public void setDataHP(String jenis_hp, int tahun_pembuatan) {
        this.jenis_hp = jenis_hp;
        this.tahun_pembuatan = tahun_pembuatan;
    }

    // 3. Method Accessor (Getter) untuk mengambil jenis HP
    public String getJenisHP() {
        return jenis_hp;
    }

    // 4. Method Accessor (Getter) untuk mengambil tahun pembuatan
    public int getTahunPembuatan() {
        return tahun_pembuatan;
    }

    // 5. Main Method sebagai titik awal program dijalankan
    public static void main(String[] args) {
        // Instansiasi objek baru
        HandPhone hp = new HandPhone();
        
        // Memasukkan data ke dalam objek
        hp.setDataHP("iPhone 15 Pro", 2023);
        
        // Menampilkan hasil ke terminal
        System.out.println("----- Informasi Handphone -----");
        System.out.println("Jenis HP         : " + hp.getJenisHP());
        System.out.println("Tahun Pembuatan  : " + hp.getTahunPembuatan());
        System.out.println("--------------------------------");
    }
}