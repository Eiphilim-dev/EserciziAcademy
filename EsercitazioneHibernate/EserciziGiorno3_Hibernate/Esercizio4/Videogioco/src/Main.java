public class Main {
    public static void main(String[] args) {
        VideogiocoRpg rpg = new VideogiocoRpg("The Witcher", 49.99, 18, 100, 50);
        VideogiocoCompetitivo comp = new VideogiocoCompetitivo("Tekken", 59.99, 12, 1000);

        rpg.gioca();
        comp.gioca();
        comp.sfida();

        System.out.println(rpg);
        System.out.println(comp);
    }
}