import java.io.*;
import java.util.*;

public class Control {
    static final int c = 300;
    static List<User> users = randomUser();
    static Map<String, List<User>> userMap = new HashMap<>();

    public static String randomName(int numberOfChar){
        StringBuilder name = new StringBuilder();
        List<String> list = new ArrayList<>();
        list.add("f");
        list.add("r");
        list.add("u");
        list.add("i");
        list.add("t");
        for (int i = 0; i < numberOfChar; i++){
            int index1 = randomNum(0, list.size()-1);
            String str = list.get(index1);
            list.remove(str);
            name.append(str);
        }
        return name.toString();
    }
    public static String randomGender(){
        String arrGender[] = {"male", "feMale"};

        return arrGender[randomNum(0, 1)];
    }
    public static int randomNum(int from, int to){
        Random random = new Random();
        int num = random.nextInt(to - from +1);
        return from + num;
    }
    public static List<User> randomUser(){
        List<User> users = new ArrayList<>();
        for (int i = 1; i <=c; i++){
            User user = new User(i, randomName(3), randomGender(), randomNum(20, 22));
            users.add(user);
        }
        return users;
    }

//   1 Create Random 300 user:
    public static List<User> createUsers(){
        for (User user : users){
            System.out.println(user);
        }
        return users;
    }
//   2 Write file
    public static void writeFile() throws IOException {
        String url = "D:/New folder/BlueBottle/test1.1/src/usersList.txt";
        File file = new File(url);
        OutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        for (User user : users){
            outputStreamWriter.write(user.toString());
            outputStreamWriter.write("\n");
        }
        outputStreamWriter.close();
    }
//   3 Collect All name in list users
    public static Set<String> getAllName(){
        Set<String> userSet = new TreeSet<>();
        for (User user : users){
            userSet.add(user.getName());
        }
        for (String s : userSet){
            System.out.println(s);
        }
        return userSet;
    }

//   4 Sort all users by name
    public static List<User> sortUserByName(){
        users.sort(Comparator.comparing(User::getName));
        for (User user : users){
            System.out.println(user);
            System.out.println();
        }
        return users;
    }

//  5 Count by gender
    public static String countByGender(){
        int male = 0;
        int feMale = 0;
        for (User user : users){
            if (user.getGender().equals("male")){
                male ++;
            }else feMale ++;
        }
        System.out.println(male);
        System.out.println(feMale);
        return "Male: " + " " + male + "\n" + "FeMale: " + " " + feMale;
    }
//   6 Collect users has same name:
    public static Map<String,List<User>> collectByName(){
        for (User user : users){
            List<User> us = userMap.get(user.getName());
            if (us == null){
                us = new ArrayList<>();
                us.add(user);
                userMap.put(user.getName(), us);
            }else {
                us.add(user);
            }
        }

        Set<String> userSet = userMap.keySet();
        for (String str : userSet){
            System.out.println(str + " " + userMap.get(str));
            System.out.println();
        }
        return userMap;
    }

//   7 Collect users has same name and same age:
    public static void collectByNameAndAge(){
        for (User user : users){
            List<User> us = userMap.get(user.getKeyValue());
            if (us == null){
                us = new ArrayList<>();
                us.add(user);
                userMap.put(user.getKeyValue(), us);
            }else{
                us.add(user);
            }
        }
        Set<String> userSet = userMap.keySet();
        for (String key : userSet){
            System.out.println(key + " " + userMap.get(key));
        }
    }
}
