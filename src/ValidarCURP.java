import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidarCURP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una CURP para validar: ");
        String inputCurp = scanner.nextLine();

        String curpRegex = "^[A-Z]{4}(\\d{2})(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])[HM][A-Z]{5}[A-Z0-9]{2}$";
        Pattern pattern = Pattern.compile(curpRegex);
        Matcher matcher = pattern.matcher(inputCurp);

        if (!matcher.matches()) {
            System.out.println("CURP invalida.");
        } else {
            boolean found = false;
            try (BufferedReader br = new BufferedReader(new FileReader("CURPS.TXT"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.equals(inputCurp)) {
                        found = true;
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (found) {
                System.out.println("La CURP fue encontrada exitosamente.");
            } else {
                System.out.println("La CURP no fue encontrada en el archivo.");
            }
        }

        scanner.close();
    }
}