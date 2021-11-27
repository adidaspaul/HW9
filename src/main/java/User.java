import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private static final String TXT = "src/main/resources/Names.txt";
    private static final String JSON = "src/main/resources/User.json";
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        createList(new File(TXT), users);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        checkAndCreateNewFile(new File(TXT), new File(JSON));
        writeToJson(gson.toJson(users), new File(JSON));

    }

    private static void createList(File file, List<User> users) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.ready()) {
                String[] str = bufferedReader.readLine().split(" ");
                if (str[1].matches("[0-9]+")) {
                    User user = new User();
                    user.setName(str[0]);
                    user.setAge(Integer.parseInt(str[1]));
                    users.add(user);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void checkAndCreateNewFile(File file, File jsonFile) {
        if (!jsonFile.exists()) {
            jsonFile.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static void writeToJson(String jsonUser, File jsonFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(jsonFile))) {
            bufferedWriter.write(jsonUser);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}