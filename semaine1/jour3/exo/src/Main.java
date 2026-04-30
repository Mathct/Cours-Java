public class Main {
    public static void main(String[] args) {
        Task t1 = new Task(1, "Apprendre Java", "Suivre le cours de la semaine 1", false);
        Task t2 = new Task(2, "Faire les exercices", "Jour 3 : classes et objets", false);

        t1.printSummary();
        t2.printSummary();

        // Modifier une tâche
        t1.setDone(true);
        t1.setTitle("Apprendre Java (POO)");

        t1.printSummary();
    }
}
