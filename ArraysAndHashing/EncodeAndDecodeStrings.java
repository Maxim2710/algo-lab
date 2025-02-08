import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int indexS = str.indexOf("#", i);

            int length = Integer.parseInt(str.substring(i, indexS));

            String peaceStr = str.substring(indexS + 1, length + indexS + 1);

            list.add(peaceStr);

            i = indexS + 1 + length;
        }

        return list;
    }
}
