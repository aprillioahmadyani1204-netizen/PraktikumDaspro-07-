import java.util.Scanner;

public class Studi2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input data dasar yang pasti dibutuhkan
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = input.nextLine();

        System.out.print("Masukkan Jenis Kegiatan (BELMAWA/BAKORMA/Mandiri/PKM/Lainnya): ");
        String jenisKegiatan = input.nextLine();

        // Variabel untuk menyimpan input spesifik dan status logika
        int jumlahDokumen = 0;
        int peringkatJuara = 0;
        int statusFundingPKM = 0;
        
        boolean layakDana = false;
        String alasan = "";

        // Percabangan Tingkat 1: Pengelompokan berdasarkan Jenis Kegiatan
        if (jenisKegiatan.equalsIgnoreCase("BELMAWA") || 
            jenisKegiatan.equalsIgnoreCase("BAKORMA") || 
            jenisKegiatan.equalsIgnoreCase("Mandiri")) {
            
            // Input data khusus untuk BELMAWA, BAKORMA, Mandiri
            System.out.print("Masukkan Peringkat Juara (1, 2, 3, atau 0 jika bukan juara): ");
            peringkatJuara = input.nextInt();
            System.out.print("Masukkan Jumlah Dokumen yang Diupload (0-4): ");
            jumlahDokumen = input.nextInt();

            // Percabangan Tingkat 2: Validasi prestasi juara
            if (peringkatJuara == 1 || peringkatJuara == 2 || peringkatJuara == 3) {
                
                // Percabangan Tingkat 3: Validasi kelengkapan dokumen
                if (jumlahDokumen == 4) {
                    layakDana = true;
                    alasan = "Meraih Juara " + peringkatJuara + " dan dokumen lengkap.";
                } else {
                    int kurang = 4 - jumlahDokumen;
                    alasan = "Dokumen tidak lengkap (Kurang " + kurang + " dokumen).";
                }
                
            } else {
                alasan = "Hanya diberikan kepada peraih Juara 1, 2, atau 3 (Juara harapan/peserta tidak memperoleh dana).";
            }

        } else if (jenisKegiatan.equalsIgnoreCase("PKM")) {
            
            // Input data khusus untuk PKM
            System.out.print("Masukkan Status Pendanaan PKM (1 = lolos, 0 = tidak lolos): ");
            statusFundingPKM = input.nextInt();
            System.out.print("Masukkan Jumlah Dokumen yang Diupload (0-4): ");
            jumlahDokumen = input.nextInt();

            // Percabangan Tingkat 2: Validasi kelolosan pendanaan
            if (statusFundingPKM == 1) {
                
                // Percabangan Tingkat 3: Validasi kelengkapan dokumen
                if (jumlahDokumen == 4) {
                    layakDana = true;
                    alasan = "Tim lolos pendanaan PKM dan dokumen lengkap.";
                } else {
                    int kurang = 4 - jumlahDokumen;
                    alasan = "Dokumen tidak lengkap (Kurang " + kurang + " dokumen).";
                }
                
            } else {
                alasan = "Tim tidak lolos pendanaan PKM.";
            }

        } else {
            // Untuk jenis kegiatan "Lainnya" atau di luar ketentuan
            alasan = "Kegiatan di luar ketentuan BELMAWA, BAKORMA, Mandiri, atau PKM tidak memperoleh dana.";
        }

        // Menampilkan Output Hasil Evaluasi
        System.out.println("\n========= HASIL EVALUASI =========");
        System.out.println("Nama Mahasiswa   : " + nama);
        System.out.println("Jenis Kegiatan   : " + jenisKegiatan);
        
        if (layakDana) {
            System.out.println("Status Dana      : DIBERIKAN");
            System.out.println("Keterangan       : " + alasan);
        } else {
            System.out.println("Status Dana      : TIDAK DIBERIKAN");
            System.out.println("Alasan           : " + alasan);
        }
        System.out.println("==================================");

        input.close();
    }
}
