package EsercitazionePersonale.Esercizio1;

@SuppressWarnings("all")
public class Temperatura {
    private double temperaturaNum;
    private ScalaRiferimento scala;

    public Temperatura(double temperaturaNum, ScalaRiferimento scala) {
        this.temperaturaNum = temperaturaNum;
        this.scala = scala;
    }

    public double conversioneIn(ScalaRiferimento nuovaScala) {
        double valoreConvertito = 0;

        if(this.scala != nuovaScala) {
            switch (this.scala) {
                case CELSIUS:
                    if (nuovaScala == ScalaRiferimento.FAHRENHEIT) {
                        valoreConvertito = ((temperaturaNum * 9) / 5) + 32;
                        System.out.print("\nIl valore da Celsius a Fahrenheit è: ");

                    } else if (nuovaScala == ScalaRiferimento.KELVIN) {
                        valoreConvertito = temperaturaNum + 273.15;
                        System.out.print("\nIl valore da Celsius a Kelvin è: ");

                    }
                    break;

                case FAHRENHEIT:
                    if (nuovaScala == ScalaRiferimento.CELSIUS) {
                        valoreConvertito = (temperaturaNum - 32) * 5 / 9;
                        System.out.print("\nIl valore da Fahrenheit a Celsius è: ");

                    } else if (nuovaScala == ScalaRiferimento.KELVIN) {
                        valoreConvertito = (((temperaturaNum - 32) * 5) / 9) + 273.15;
                        System.out.print("\nIl valore da Fahrenheit a Kelvin è: ");

                    }
                    break;

                case KELVIN:
                    if (nuovaScala == ScalaRiferimento.CELSIUS) {
                        valoreConvertito = temperaturaNum - 273.15;
                        System.out.print("\nIl valore da Kelvin a Celsius è: ");

                    } else if (nuovaScala == ScalaRiferimento.FAHRENHEIT) {
                        valoreConvertito = (((temperaturaNum - 273.15) * 9) / 5) + 32;
                        System.out.print("\nIl valore da Kelvin a Fahrenheit è: ");

                    }
                    break;

                default:
                    System.out.print("Valore non compatibile per la conversione");

            }
            return valoreConvertito;

        } else {
            System.out.println("\nNon posso convertire per la stessa scala.");
            return temperaturaNum;

        }
    }

    @Override
    public String toString() {
        return "\nLa temperatura è di " + String.format("%.2f", temperaturaNum) + " " + scala;
    }
}
