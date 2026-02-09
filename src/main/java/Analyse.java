import java.io.*;
import java.util.Scanner;

/**
 * Rôle E4 : Analyse les données brutes de production pour générer des rapports.
 */
class ProductionAnalyzer {

    private static final String FILE_PATH = "data/production.csv";
    private static final String DELIMITER = ";";

    /**
     * Méthode principale de E4 : Gère l'interaction, le filtrage et les calculs.
     */
    public static void displayDailyProduction() {
        Scanner scanner = new Scanner(System.in);

        // 1. Saisie de la date
        System.out.print("Entrez la date à analyser (format YYYY-MM-DD) : ");
        String targetDate = scanner.nextLine().trim();

        // Initialisation des compteurs
        int totalOK = 0;
        int totalKO = 0;
        boolean dataFound = false;

        // 2. Lecture du fichier (Lecture seule)
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("⚠️ Erreur : Le fichier " + FILE_PATH + " est inexistant.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Sauter les lignes vides éventuelles
                if (line.trim().isEmpty()) continue;

                // 3. Découpage et Filtrage
                String[] parts = line.split(DELIMITER);

                // Vérification du format de la ligne (date;operatorId;piece;qtyOK;qtyKO)
                if (parts.length < 5) continue;

                String fileDate = parts[0];

                if (fileDate.equals(targetDate)) {
                    try {
                        // 4. Calculs des totaux
                        totalOK += Integer.parseInt(parts[3]);
                        totalKO += Integer.parseInt(parts[4]);
                        dataFound = true;
                    } catch (NumberFormatException e) {
                        // Ignore les lignes où les quantités ne sont pas des nombres
                        System.err.println("Donnée numérique invalide ignorée : " + line);
                    }
                }
            }

            // 5. Affichage des résultats (Clair et Professionnel)
            renderReport(targetDate, totalOK, totalKO, dataFound);

        } catch (IOException e) {
            System.out.println("❌ Erreur lors de la lecture du fichier : " + e.getMessage());
        }
        renderReport(targetDate, totalOK, totalKO, dataFound);
        saveReportToFile(targetDate, totalOK, totalKO, dataFound);

    }

    /**
     * Gère l'affichage structuré pour le professeur/utilisateur.
     */
    private static void renderReport(String date, int ok, int ko, boolean found) {
        System.out.println("\n========================================");
        System.out.println("       RAPPORT DE PRODUCTION           ");
        System.out.println("========================================");
        System.out.println("Date analysée : " + date);

        if (!found) {
            System.out.println("\n⚠️ Aucune production enregistrée pour cette date.");
        } else {
            int totalGeneral = ok + ko;
            System.out.println("\nTotal pièces conformes (OK)     : " + ok);
            System.out.println("Total pièces non conformes (KO) : " + ko);
            System.out.println("----------------------------------------");
            System.out.println("TOTAL GÉNÉRAL                  : " + totalGeneral);

            // Petit bonus : Calcul du taux de qualité
            if (totalGeneral > 0) {
                double qualityRate = ((double) ok / totalGeneral) * 100;
                System.out.printf("Taux de qualité                : %.2f%%\n", qualityRate);
            }
        }
        System.out.println("========================================\n");
    }

    // Point d'entrée pour test rapide
    static void main(String[] args) {
        ProductionAnalyzer analyzer = new ProductionAnalyzer();
        analyzer.displayDailyProduction();
    }

    /**
     * Enregistre le rapport d'analyse dans un fichier nommé par la date.
     */
    private static void saveReportToFile(String date, int ok, int ko, boolean found) {

        String reportPath = "data/" + date + ".txt";

        File reportFile = new File(reportPath);
        reportFile.getParentFile().mkdirs(); // crée le dossier data si nécessaire

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(reportFile))) {

            bw.write("========================================");
            bw.newLine();
            bw.write("       RAPPORT DE PRODUCTION           ");
            bw.newLine();
            bw.write("========================================");
            bw.newLine();
            bw.write("Date analysée : " + date);
            bw.newLine();
            bw.newLine();

            if (!found) {
                bw.write("Aucune production enregistrée pour cette date.");
                bw.newLine();
            } else {
                int totalGeneral = ok + ko;

                bw.write("Total pièces conformes (OK)     : " + ok);
                bw.newLine();
                bw.write("Total pièces non conformes (KO) : " + ko);
                bw.newLine();
                bw.write("----------------------------------------");
                bw.newLine();
                bw.write("TOTAL GÉNÉRAL                  : " + totalGeneral);
                bw.newLine();

                if (totalGeneral > 0) {
                    double qualityRate = ((double) ok / totalGeneral) * 100;
                    bw.write(String.format("Taux de qualité                : %.2f%%", qualityRate));
                    bw.newLine();
                }
            }

            bw.write("========================================");
            bw.newLine();

            System.out.println("📁 Rapport enregistré dans : " + reportPath);

        } catch (IOException e) {
            System.out.println("❌ Erreur lors de l'enregistrement du rapport : " + e.getMessage());
        }
    }

}
