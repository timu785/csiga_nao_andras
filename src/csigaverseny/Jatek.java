package csigaverseny;

import java.util.Random;
import java.util.Scanner;

public class Jatek {
    Csiga[] csTomb = new Csiga[3];
    String fogadas;
    public static final Random RND = new Random();
    public static final Scanner SC = new Scanner(System.in);
    
    public Jatek(int korSzam){
        this.fogadas = fogadasKero();
        this.csTomb[0] = new Csiga("piros", "piros".equals(fogadas));
        this.csTomb[1] = new Csiga("kek", "kek".equals(fogadas));
        this.csTomb[2] = new Csiga("zold", "zold".equals(fogadas));
        this.jatekIndito(korSzam);
    }
    
    public String fogadasKero(){
        System.out.println("Kire akar fogadni? (piros, kek, zold) ");
        return SC.nextLine();
    }
    
    public void kiir(){
        System.out.println(csTomb[0].getMegtettUtPluszCsiga() + "\n" +
                           csTomb[1].getMegtettUtPluszCsiga() + "\n" +
                           csTomb[2].getMegtettUtPluszCsiga());
    }
    
    public void kor(){
        Boolean vanGyorsito = RND.nextInt(5) == 0;
        if(vanGyorsito){
            int melyik = RND.nextInt(csTomb.length);
            for (int i = 0; i < csTomb.length; i++) {
                if(i == melyik){
                    csTomb[i].megy(true);
                }else{
                    csTomb[i].megy(false);
                }
            }
        }else {
            csTomb[0].megy(false);
            csTomb[1].megy(false);
            csTomb[2].megy(false);
        }
    }

    private void jatekIndito(int korSzam) {
        System.out.println("A játék kezdete");
        for (int i = 0; i < korSzam; i++) {
            System.out.printf("%d. kör: \n", i+1);
            this.kor();
            this.kiir();
        }
        this.kiertekel();
    }

    private void kiertekel() {
        int maxI = 0;
        for (int i = 1; i < csTomb.length; i++) {
            if(csTomb[i].getmegtettUt().length() > csTomb[maxI].getmegtettUt().length()){
                maxI = i;
            }
        }
        //System.out.println(csTomb[maxI].getSzin());
        //System.out.println((this.fogadas).equals(csTomb[maxI].getSzin()));
        if((this.fogadas).equals(csTomb[maxI].getSzin())){
            System.out.println("Ön nyert!");
        }else{
            System.out.println("Ön vesztett!");
        }
    }
    
    
}
