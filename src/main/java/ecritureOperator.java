import java.io.*;
import java.util.Scanner;



//la class qui cree un ficier rapport
    class fichierRapport {
        public static void fichierRapports() {  // Méthode statique
            String reportPath = "D:/vic_java/Systeme de pointage et production_G9/data";
            File fichier = new File(reportPath);

            try{
                if (fichier.createNewFile()) {
                    System.out.println("Fichier créé avec succès");
                } else {
                    System.out.println("Fichier existe déjà");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String productionPath = "D:/vic_java/Systeme de pointage et production_G9/data";

            try(
                    Scanner lect = new Scanner(System.in);
                    BufferedWriter bw = new BufferedWriter(new FileWriter(productionPath, true)))

            {

                System.out.println("Veuillez entrer les données de la production : ");

                String infoProduction = lect.nextLine();
                bw.write(infoProduction);
                bw.newLine();

            } catch(IOException e)

            {
                System.out.println("erreur lors de l'ecriture du fichier!");
                e.printStackTrace();
            }
        }
    }
    //la class qui ecrit la production et l'enregistre dans un fichier
    class ecritureProduction {
        public static void ecritureProductions() {  // Méthode statique
            String productionPath = "D:/vic_java/Systeme de pointage et production_G9/data/production.csv";

            try (Scanner lect = new Scanner(System.in);
                 BufferedWriter bw = new BufferedWriter(new FileWriter(productionPath, true))) {

                System.out.println("Veuillez entrer les données de la production : ");
                String infoProduction = lect.nextLine();
                bw.write(infoProduction);
                bw.newLine();

            } catch (IOException e) {
                System.out.println("Erreur lors de l'écriture du fichier!");
                e.printStackTrace();
            }
        }
    }
//la class qui ecrit les operateur dans un fichier
public class ecritureOperator {

    public static void ecrireOperateurs(Scanner lect) {
        String operatorsPath = "data/operators.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(operatorsPath, true))) {

            System.out.println("Veuillez entrer les identités de l'opérateur (NOM-MATRICULE-POSTE) : ");
            String infoOperators = lect.nextLine();
            bw.write(infoOperators);
            bw.newLine();
            System.out.println("Operateur enregistre");


        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier!");
            e.printStackTrace();
        }
    }
}
