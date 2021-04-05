import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<User1> user1List = randomUser();
        user1List.sort(Comparator.comparing(User1::getName));
        Set<String> user1s = new TreeSet<>();
        for (User1 u : user1List){
            user1s.add(u.getName());
        }
//        for (User1 u : user1List){
//            System.out.println(u);
//        }
        System.out.println(user1s.size());
        System.out.println(user1List.size());
        for (String u1 : user1s){
            System.out.println(u1);
        }
    }
    public static List<User1> randomUser(){
        List<User1> user1s = new ArrayList<>();
        for (int i = 1; i <=300; i++){
            User1 user1 = new User1(i, randomName(3), randomGender(), randomNum(20, 22));
            user1s.add(user1);
        }
        return user1s;
    }
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
}
