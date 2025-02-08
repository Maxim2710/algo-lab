import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"act","pots","tops","cat","stop","hat"};

        GroupAnagrams groupAnagrams = new GroupAnagrams();

        System.out.println(groupAnagrams.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] cntLetters = new int[26];
            for (char c : s.toCharArray()) {
                cntLetters[c - 'a']++;
            }

            String key = Arrays.toString(cntLetters);

            if (!map.containsKey(key)) map.put(key, new ArrayList<>());

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}


/*
1. Создаем мапу:
    ключ строка: представление массива кол-ва встречающихся букв
    значение: список полученных значений в виде слов

2. Пробегаемся по всем строкам из условия:
    - Записываем то, сколько каждая из букв встречалась в слове
    - Преобразовываем массив количеств в строку
    - Проверяем, не было ли уже такого бакета с ключом - если не было создаем новый
 */