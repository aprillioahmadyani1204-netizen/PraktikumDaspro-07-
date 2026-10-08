import java.util.Scanner;

public class StudiKasus107copy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hargaPerCup = 18000;
        int jumlahCup, uangBayar;
        int totalHarga, diskon, totalBayar;
        int kembalian, kurang;

        System.out.println("Masukkan jumlah cup");
        jumlahCup = sc.nextInt();

        System.out.println("Masukkan uang bayar");
        uangBayar = sc.nextInt();

        totalHarga = jumlahCup*hargaPerCup;
        diskon = 0;
        totalBayar = totalHarga - diskon;

        if (totalHarga >= 100000) {
            diskon = totalHarga*10/100;
        } else {
            System.out.println("Tidak asa diskon yang diberikan");
        }
        System.out.println("Total harga: " + totalHarga);
        System.out.println("Total diskon: " + diskon);
        System.out.println("Total harga: " + totalHarga);

        if (uangBayar >= totalBayar) {
            kembalian = uangBayar - totalBayar;
            System.out.print("Kembaliannya adalah: " + kembalian);
        } else {
            kurang = totalBayar - uangBayar;
            System.out.print("Uang tidak cukup congrets, kurang: " + kurang);


        }
    }
}

