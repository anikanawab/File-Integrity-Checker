import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;

public class FileIntegrityChecker {

    public static void main(String[] args) {

        try {

            File file = new File("application.log");

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                System.out.println(line);

            }

            scanner.close();

            // STEP 3: GENERATE SHA-256 HASH

            byte[] fileBytes = Files.readAllBytes(file.toPath());

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] hashBytes = md.digest(fileBytes);

            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {

                hexString.append(String.format("%02x", b));

            }

            String currentHash = hexString.toString();

            System.out.println("SHA-256 Hash: " + currentHash);

            // STEP 4: SAVE ORIGINAL HASH

            File hashFile = new File("original_hash.txt");

            if (!hashFile.exists()) {

                Files.writeString(Paths.get("original_hash.txt"), currentHash);

                System.out.println("Original hash saved!");

            
     } else {

    // STEP 5: COMPARE HASHES

    // Read the saved original hash
    String originalHash = Files.readString(
        Paths.get("original_hash.txt")
    );

    // Compare the two hashes
    if (currentHash.equals(originalHash)) {

        System.out.println("File integrity verified!");
        System.out.println("No changes detected.");

    } else {

        System.out.println("WARNING: File has been modified!");
        System.out.println("Possible file tampering detected.");

    }

}


        } catch (FileNotFoundException e) {

            System.out.println("File not found!");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }

    }
}

