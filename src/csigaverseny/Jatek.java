package csigaverseny;

import java.util.Random;
import java.util.Scanner;

public class Jatek {
    private Csiga[] csTomb = new Csiga[3];
    private String fogadas;
    private static final Random RND = new Random();
    private static final Scanner SC = new Scanner(System.in);
    
    public Jatek(int korSzam){
        this.fogadas = fogadasKero();
        this.csTomb[0] = new Csiga("piros", "piros".equals(this.fogadas));
        this.csTomb[1] = new Csiga("kek", "kek".equals(this.fogadas));
        this.csTomb[2] = new Csiga("zold", "zold".equals(this.fogadas));
        this.jatekIndito(korSzam);
    }
    
    public String fogadasKero(){
        System.out.println("Kire akar fogadni? (piros, kek, zold) ");
        return SC.nextLine();
    }
    
    public void kiir(){
        System.out.println(this.csTomb[0].getMegtettUtPluszCsiga() + "\n" +
                           this.csTomb[1].getMegtettUtPluszCsiga() + "\n" +
                           this.csTomb[2].getMegtettUtPluszCsiga());
    }
    
    public void kor(){
        Boolean vanGyorsito = RND.nextInt(5) == 0;
        if(vanGyorsito){
            int melyik = RND.nextInt(this.csTomb.length);
            for (int i = 0; i < this.csTomb.length; i++) {
                if(i == melyik){
                    this.csTomb[i].megy(true);
                }else{
                    this.csTomb[i].megy(false);
                }
            }
        }else {
            this.csTomb[0].megy(false);
            this.csTomb[1].megy(false);
            this.csTomb[2].megy(false);
        }
    }

    public void jatekIndito(int korSzam) {
        System.out.println("A játék kezdete");
        for (int i = 0; i < korSzam; i++) {
            System.out.printf("%d. kör: \n", i+1);
            this.kor();
            this.kiir();
        }
        this.kiertekel();
    }

    public void kiertekel() {
        int maxI = 0;
        for (int i = 1; i < this.csTomb.length; i++) {
            if(this.csTomb[i].getmegtettUt().length() > this.csTomb[maxI].getmegtettUt().length()){
                maxI = i;
            }
        }
        //System.out.println(csTomb[maxI].getSzin());
        //System.out.println((this.fogadas).equals(csTomb[maxI].getSzin()));
        if((this.fogadas).equals(this.csTomb[maxI].getSzin())){
            System.out.println("Ön nyert!");
        }else{
            System.out.println("Ön vesztett!");
        }
    }
    
    
}
