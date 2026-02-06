import java.io.Console;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

static void main(String[] args) {
    boolean quitter = false;
    String choix = "0";

    Scanner lecture = new Scanner(System.in);

    while (quitter == false){
        System.out.println("\u001B[33m========MENU PRINCIPAL========\u001B[0m");
        System.out.println("1. Ajouter un operateur\n2 .Enregistrer une production\n3.Afficher les operateurs\n4. Quitter\nChoix :");
        choix = lecture.nextLine();
        switch (choix) {

            case "1":
                System.out.println("processus en cours d'executon...\n");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                break;

            case "2":

                System.out.println("processus en cours d'executon...\n");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                break;

            case "3":

                System.out.println("processus en cours d'executon...\n");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                }
                break;
            case "4":
                System.out.println("======== à bientot ! ========");
                quitter = true;
                break;

            default:

                System.out.println("veuillez entrer un choix valide\n");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
        }

    }
}
