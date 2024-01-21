import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TekrarEdenKarakterler {


    public static void main(String[] args) {
        String[] kelimeler = {"Programlama", "Java", "Tekrar", "Metin", "Test", "Yazılım"};

        List<String> kelimelerAyniHarfli = new ArrayList<>();

        // Aynı harfi içeren kelimeleri bul
        for (String kelime : kelimeler) {
            if (ayniHarfBirdenFazlaVar(kelime)) {
                kelimelerAyniHarfli.add(kelime);
            }
        }

        // En az iki kelime varsa devam et
        if (kelimelerAyniHarfli.size() >= 2) {
            String ilkKelime = kelimelerAyniHarfli.get(0);
            String ikinciKelime = kelimelerAyniHarfli.get(1);

            String yeniKelime = turetYeniKelime(ilkKelime, ikinciKelime);

            System.out.println("Yeni kelime: " + yeniKelime);

        } else {
            System.out.println("Aynı harften birden fazla olan iki kelime bulunamadı.");
        }
    }

    // Aynı harften birden fazla var mı kontrol et
    private static boolean ayniHarfBirdenFazlaVar(String kelime) {
        for (char harf : kelime.toCharArray()) {
            if (kelime.indexOf(harf) != kelime.lastIndexOf(harf)) {
                return true;
            }
        }
        return false;
    }

    // İki kelimenin harflerini kullanarak yeni kelime türet
    private static String turetYeniKelime(String kelime1, String kelime2) {
        List<Character> harfler = new ArrayList<>();
        for (char harf : kelime1.toCharArray()) {
            harfler.add(harf);
        }
        for (char harf : kelime2.toCharArray()) {
            harfler.add(harf);
        }

        // Harfleri karıştır
        Collections.shuffle(harfler);

        // Yeni kelimeyi oluştur (harflerin yarısını kullan)
        int yarisi = harfler.size() / 2;
        StringBuilder yeniKelime = new StringBuilder();
        for (int i = 0; i < yarisi; i++) {
            yeniKelime.append(harfler.get(i));
        }

        return yeniKelime.toString();
    }
}