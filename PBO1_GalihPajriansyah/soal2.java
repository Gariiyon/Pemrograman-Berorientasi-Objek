import javax.swing.JOptionPane;

public class soal2 {
    public static void main(String[] args) {
        // 1. Menampilkan Input Dialog (ikon tanda tanya)
        String jawaban = JOptionPane.showInputDialog(
                null,
                "Anda sedang belajar apa?",
                "Input",
                JOptionPane.QUESTION_MESSAGE
        );

        // 2. Menampilkan Message Dialog (ikon huruf i) jika user menekan tombol OK
        if (jawaban != null && !jawaban.trim().isEmpty()) {
            String pesan = "Belajar " + jawaban + " sangat mudah";
            JOptionPane.showMessageDialog(
                    null,
                    pesan,
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}