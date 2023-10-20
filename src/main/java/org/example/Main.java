package org.example;

public class Main {
    static Translation translation = new Translation();
    static ModelData modelData = new ModelData();
    static private String resourceText, outLang, targetLang;

    public static void main(String[] args) {
        if (args.length >= 4 && (args[0].equals("-f") || args[0].equals("--from"))) {
            resourceText = String.valueOf(args[1]);
            outLang = String.valueOf(args[2]);
            targetLang = String.valueOf(args[3]);
            translation.setApiUrl("from", resourceText, outLang, targetLang);
        } else if (args.length == 3 && (args[0].equals("-t") || args[0].equals("--to"))) {
            resourceText = String.valueOf(args[1]);
            targetLang = String.valueOf(args[2]);
            translation.setApiUrl("to", resourceText, "autodetect", targetLang);
        } else if (args.length == 1 && (args[0].equals("-l") || args[0].equals("--list"))) {
            modelData.getData();
        } else if (args.length == 1 && (args[0].equals("-h") || args[0].equals("--help"))) {
            System.out.println("rasan-translate (version 1.0, revision 1)");
            System.out.println("Usage:\n" +
                    " rasan [OPTIONS]...[VALUES]\t\n" +
                    "  -f, --from 'source' [from] [to]    Specify source-lang (id for Indonesian) and target-lang (eng for English).\n" +
                    "  -t, --to   'source' [to]    Specify target-lang (id for Indonesian) will automatically detect the source-lang.\n" +
                    "  -l, --list   'acronym,name'    List target-lang (id for Indonesian) will loop format data : acronym,name.\n" +
                    "  -h, --help          Display usage, options, and help.\n");
        } else {
            System.out.println("rasan: missing operand\n" +
                    "Try 'rasan -h or --help' for more information.");
        }
    }
}
