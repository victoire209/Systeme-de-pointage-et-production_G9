package manager;

import java.io.*;
import java.util.Scanner;

public class ProductionManager {

    private Scanner scanner;

    public ProductionManager() {
        scanner = new Scanner(System.in);
    }

    public void saisirProduction() {
        System.out.println("=== Saisie d'une production ===");

        // 1. Date
        System.out.print("Entrez la date (YYYY-MM-DD) : ");
        String date = scanner.nextLine().trim();
        if (date.isEmpty()) {
            System.out.println("Date vide, saisie annulée.");
            return;
        }

        // 2. ID opérateur
        System.out.print("Entrez l'ID opérateur : ");
        String operatorId = scanner.nextLine().trim();
        if (!OperatorManager.exists(operatorId)) {
            System.out.println("Opérateur introuvable, saisie annulée.");
            return;
        }

        // 3. Pièce
        System.out.print("🔧 Entrez le nom de la pièce : ");
        String piece = scanner.nextLine().trim();
        if (piece.isEmpty()) {
            System.out.println("Pièce vide, saisie annulée.");
            return;
        }

        // 4. Quantité OK
        System.out.print("Entrez la quantité OK : ");
        int qtyOK = lireEntier();
        if (qtyOK < 0) {
            System.out.println("Quantité OK négative, saisie annulée.");
            return;
        }

        // 5. Quantité KO
        System.out.print("Entrez la quantité KO : ");
        int qtyKO = lireEntier();
        if (qtyKO < 0) {
            System.out.println("Quantité KO négative, saisie annulée.");
            return;
        }

        if (qtyOK == 0 && qtyKO == 0) {
            System.out.println("Production vide (0 OK et 0 KO), saisie refusée.");
            return;
        }

        // Construire la ligne
        String ligne = date + ";" + operatorId + ";" + piece + ";" + qtyOK + ";" + qtyKO;

        // Écrire directement dans production.csv
        try {
            File file = new File("data/production.csv");
            file.getParentFile().mkdirs(); // crée dossier si inexistant

            FileWriter fw = new FileWriter(file, true); // true = append
            fw.write(ligne + System.lineSeparator());
            fw.close();

            System.out.println("Production enregistrée : " + ligne);
        } catch (IOException e) {
            System.out.println("Erreur écriture fichier : " + e.getMessage());
        }
    }

    private int lireEntier() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Valeur invalide, utilisation de 0 par défaut.");
            return 0;
        }
    }
}