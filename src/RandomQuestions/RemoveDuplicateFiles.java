
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RemoveDuplicateFiles {

    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap();

        for (String path : paths) {
            String[] arr = path.split(" ");
            String directory = arr[0];
            for (int i = 1; i < arr.length; i++) {
                int contentStart = arr[i].indexOf('(');
                String content = arr[i].substring(contentStart + 1);
                String fileName = arr[i].substring(0, contentStart);
                List<String> list = map.getOrDefault(content, new ArrayList());
                list.add(directory + "/" + fileName);
                map.put(content, list);
            }
        }
        List<List<String>> result = new ArrayList();
        for (var list : map.values()) {
            if (list.size() > 1) {
                result.add(list);
            }
        }

        return result;

    }
}
