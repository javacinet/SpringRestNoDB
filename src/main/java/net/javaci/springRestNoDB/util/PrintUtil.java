package net.javaci.springRestNoDB.util;

public class PrintUtil {

    // Define ANSI color codes for text
    private static String blackText = "\u001B[30m";
    private static String redText = "\u001B[31m";
    private static String greenText = "\u001B[32m";
    private static String yellowText = "\u001B[33m";
    private static String blueText = "\u001B[34m";
    private static String purpleText = "\u001B[35m";
    private static String cyanText = "\u001B[36m";
    private static String whiteText = "\u001B[37m";

    // Define ANSI color codes for background
    private static String blackBg = "\u001B[40m";
    private static String redBg = "\u001B[41m";
    private static String greenBg = "\u001B[42m";
    private static String yellowBg = "\u001B[43m";
    private static String blueBg = "\u001B[44m";
    private static String purpleBg = "\u001B[45m";
    private static String cyanBg = "\u001B[46m";
    private static String whiteBg = "\u001B[47m";

    // Reset code
    private static String reset = "\u001B[0m";

    public static void printText(String format, Object... objects) {
        printText(String.format(format, objects));
    }

    public static void printText(String message) {
        System.out.println(greenText + message + reset);
    }

    public static void printTimer(String format, Object... objects) {
        printTimer(String.format(format, objects));
    }
    public static void printTimer(String message) {
        System.out.println(blueText + blackBg  + message + reset);
    }

    public static void printMemory(String format, Object... objects) {
        printMemory(String.format(format, objects));
    }
    public static void printMemory(String message) {
        System.out.println(purpleText + blackBg + message + reset);
    }

    public static void main(String[] args) {
        // Print text with different text and background colors
        System.out.println(blackText + whiteBg + "Black text on white background" + reset);
        System.out.println(redText + blackBg + "Red text on black background" + reset);
        System.out.println(greenText + blackBg + "Green text on blue background" + reset);
        System.out.println(yellowText + blackBg + "Yellow text on purple background" + reset);
        System.out.println(blueText + blackBg + "Blue text on cyan background" + reset);
        System.out.println(purpleText + blackBg + "Purple text on yellow background" + reset);
        System.out.println(cyanText + blackBg + "Cyan text on red background" + reset);
        System.out.println(whiteText + blackBg + "White text on green background" + reset);
    }
}