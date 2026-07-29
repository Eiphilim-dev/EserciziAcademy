package EsercitazionePersonale.Esercizio1;

public class TestConversioneTemp {
    public static void main(String[] args) {
        Temperatura t1 = new Temperatura(68, ScalaRiferimento.FAHRENHEIT);
        Temperatura t2 = new Temperatura(35, ScalaRiferimento.CELSIUS);
        Temperatura t3 = new Temperatura(311.15, ScalaRiferimento.KELVIN);

        System.out.println(t1.toString());
        System.out.println(t1.conversioneIn(ScalaRiferimento.CELSIUS));
        System.out.println(t1.conversioneIn(ScalaRiferimento.KELVIN));
        System.out.println(t1.conversioneIn(ScalaRiferimento.FAHRENHEIT));

        System.out.println(t2.toString());
        System.out.println(t2.conversioneIn(ScalaRiferimento.FAHRENHEIT));
        System.out.println(t2.conversioneIn(ScalaRiferimento.KELVIN));

        System.out.println(t3.toString());
        System.out.println(t3.conversioneIn(ScalaRiferimento.CELSIUS));
        System.out.println(t3.conversioneIn(ScalaRiferimento.FAHRENHEIT));

    }
}