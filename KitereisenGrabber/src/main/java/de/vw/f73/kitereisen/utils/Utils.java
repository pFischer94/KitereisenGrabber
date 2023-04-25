package de.vw.f73.kitereisen.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static void write(String text) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(createPath()))) {
            writer.append(text);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Fehler beim Export");
        }
        System.out.println("Export abgeschlossen");
    }

    private static String createPath() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd_HH-mm-ss");
        String strDate = dateFormat.format(date);
        String path = String.format("CSV/%s.csv", strDate);
        return path;
    }

    public static String read(String fileName) {
        String html = "";
        String path = String.format("CSV/%s.csv", fileName);

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            String line = reader.readLine();
            while (line != null) {
                html += line + "\n";
                line = reader.readLine();
            }
        } catch (IOException ioe) {
            System.out.println("Fehler beim Import");
        }
        System.out.println("Import abgeschlossen");
        return html;
    }

    private static String createRegex() {
        StringBuilder regex = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            regex.append("[0-9]{0,2}\\|");
        }
        regex.append("[0-9]{0,2}");
        return regex.toString();
    }

    public static List<String> extractStrings(String html) {
        List<String> extracted = new ArrayList<>();
        Pattern pattern = Pattern.compile(Utils.createRegex());
        Matcher matcher = pattern.matcher(html);
        for (int i = 0; i < 4; i++) {
            if (matcher.find()) {
                extracted.add(matcher.group(0));
            }
        }
        return extracted;
    }

}
