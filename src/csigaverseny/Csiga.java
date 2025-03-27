package csigaverseny;

import java.util.Random;

public class Csiga {
    private static final Random RND = new Random();
    private String szin;
    private Boolean fogadva;
    private String megtettUt;
    private int seb;
    
    public Csiga(String szin, Boolean fogadva){
        this.szin = szin;
        this.fogadva = fogadva;
        this.megtettUt = "";
    }
    
    public void megy(Boolean vanGyorsito){
        this.seb = RND.nextInt(4);
        if(vanGyorsito){
            for (int i = 0; i < (this.seb*2); i++) {
                if(this.szin.equals("kek")){
                    this.megtettUt += "\u001B[34m=\u001B[0m";
                }
                if(this.szin.equals("piros")){
                    this.megtettUt += "\u001B[31m=\u001B[0m";
                }
                if(this.szin.equals("zold")){
                    this.megtettUt += "\u001B[32m=\u001B[0m";
                }
            }
        }else{
            for (int i = 0; i < this.seb; i++) {
                if(this.szin.equals("kek")){
                    this.megtettUt += "\u001B[34m-\u001B[0m";
                }
                if(this.szin.equals("piros")){
                    this.megtettUt += "\u001B[31m-\u001B[0m";
                }
                if(this.szin.equals("zold")){
                    this.megtettUt += "\u001B[32m-\u001B[0m";
                }
            }
        }
    }
    
    public String getMegtettUtPluszCsiga(){  
        String szoveg = "";
        if(this.szin.equals("kek")){
            szoveg = this.megtettUt + "\u001B[34mSIGA\u001B[0m";
        }
        if(this.szin.equals("piros")){
            szoveg = this.megtettUt + "\u001B[31mSIGA\u001B[0m";
        }
        if(this.szin.equals("zold")){
            szoveg = this.megtettUt + "\u001B[32mSIGA\u001B[0m";
        }
        if(this.fogadva){
            return szoveg + " zaszlo";
        }else{
            return szoveg;
        }
    }
}
