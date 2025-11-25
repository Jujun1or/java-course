package huffman;

import java.nio.file.Files;
import java.nio.file.Path;

public final class HuffmanApp {

    private static final Path RESOURCES_DIR = Path.of("resources");

    public static void main(String[] args) throws Exception {

        if (args.length == 3) {
            runWithArgs(args);
            return;
        }

        System.out.println("No valid parameters provided.");
        System.out.println("Switching to console mode.");

        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("Choose mode (encode/decode):");
        String mode;
        while (true) {
            System.out.print("> ");
            mode = sc.nextLine().trim().toLowerCase();
            if (mode.equals("encode") || mode.equals("decode")) {
                break;
            }
            System.out.println("Invalid mode. Enter 'encode' or 'decode'.");
        }

        System.out.println("Enter INPUT file name (ONLY name, not path):");
        System.out.print("> ");
        Path input = RESOURCES_DIR.resolve(sc.nextLine().trim());

        if (!Files.exists(input)) {
            System.out.println("File not found: " + input);
            return;
        }

        System.out.println("Enter OUTPUT file name:");
        System.out.print("> ");
        Path output = RESOURCES_DIR.resolve(sc.nextLine().trim());

        run(mode, input, output);
    }

    private static void runWithArgs(String[] args) throws Exception {
        String mode = args[0];
        Path input = RESOURCES_DIR.resolve(args[1]);
        Path output = RESOURCES_DIR.resolve(args[2]);

        if (!Files.exists(input)) {
            System.out.println("Input file not found: " + input);
            return;
        }

        run(mode, input, output);
    }

    private static void run(String mode, Path input, Path output) throws Exception {
        if (mode.equals("encode")) {
            HuffmanEncoder.encode(input, output);
            System.out.println("Encoding complete.");
        } else if (mode.equals("decode")) {
            HuffmanDecoder.decode(input, output);
            System.out.println("Decoding complete.");
        } else {
            System.out.println("Unknown mode: " + mode);
            printUsage();
        }
    }

    private static void printUsage() {
        System.out.println("Usage (file names only, files will be taken from /resources):");
        System.out.println("  java HuffmanApp encode <inputName> <outputName>");
        System.out.println("  java HuffmanApp decode <inputName> <outputName>");
    }
}
