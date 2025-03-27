package csigaverseny;

public class Jatek {
    Csiga[] csTomb = new Csiga[3];
    
    public Jatek(){
        this.csTomb[0] = new Csiga("piros", true);
        this.csTomb[1] = new Csiga("kek", false);
        this.csTomb[2] = new Csiga("zold", false);
    }
    
    public void kiir(){
        System.out.println(csTomb[0].getMegtettUtPluszCsiga() + "\n" +
                           csTomb[1].getMegtettUtPluszCsiga() + "\n" +
                           csTomb[2].getMegtettUtPluszCsiga());
    }
    
    public void kor(){
        csTomb[0].megy(false);
        csTomb[1].megy(false);
        csTomb[2].megy(false);
    }
}
