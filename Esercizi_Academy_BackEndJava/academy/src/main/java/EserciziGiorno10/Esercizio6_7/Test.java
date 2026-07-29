package EserciziGiorno10.Esercizio6_7;

public class Test {
    public static void main(String[] args) {
        ContrattoTelefonico cf = new ContrattoFisso("334 9347897", "Sofia", 23.56, "Via Pasmo 5");
        ContrattoTelefonico cm = new ContrattoMobile("334 83172893", "Alex", 25.54);

        cf.chiama(cf, "384 9983447", 25);
        System.out.println(cf.getBolletta());
        
        cm.chiama(cm, "346 3847987", 15);
        System.out.println(cm.getBolletta());
        

    }
}
