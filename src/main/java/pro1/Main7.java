package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main7 {
    public static void main(String[] args) {
        System.out.println(specializationDeadlines(2025));
    }

    public static String specializationDeadlines(int year) {
        String json = Api.getSpecializations(year);
        SpecializationsList specializations = new Gson().fromJson(json, SpecializationsList.class);
        HashMap<String, Integer> map = new HashMap<>();

        for (Specialization s : specializations.items) {
            if (s.datum.value != null) {
                String original = s.datum.value;
                String formatted = formatDate(original);
                try {
                    int dateAsInt = Integer.parseInt(formatted);
                    map.put(original, dateAsInt);
                } catch (NumberFormatException e) {
                    System.out.println("špatný datum");
                }
            }
        }

        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(","));
    }

    private static String formatDate(String date) {
        String[] parts = date.split("\\.");
        if (parts.length != 3) return "00000000";
        String day = parts[0].length() == 1 ? "0" + parts[0] : parts[0];
        String month = parts[1].length() == 1 ? "0" + parts[1] : parts[1];
        String year = parts[2];
        return year + month + day;
    }
}
