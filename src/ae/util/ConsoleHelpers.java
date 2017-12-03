package ae.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelpers {

    static final String intRegex = "^[-+]?[0-9]+$";
    static final String decimalRegex = "^[-+]?[0-9]+(?:\\.[0-9]+)*";

    interface Validating {

        boolean validate(String msg);

    }

    protected static String readLine() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = "";

        try {
            str = bf.readLine();
        } catch (IOException e) {
            System.out.println("Error trying to readOperand line from console");
        }

        return str;
    }

    public static String readString(String msg, Validating validator) {
        String value;
        do {
            System.out.print(msg);
            value = readLine();
        } while (!validator.validate(value));

        return value;
    }

    public static String readString(String msg) {
        return readString(msg, value -> true);
    }

    public static String readNonEmptyString(String msg) {
        return readString(msg, value -> value.length() > 0);
    }

    public static int readInt(String msg) {
        return Integer.parseInt(readString(msg, value -> value.matches(intRegex)));
    }

    public static int readDouble(String msg) {
        return Integer.parseInt(readString(msg, value -> value.matches(decimalRegex)));
    }

}
