
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        List<String> digitLogs = new ArrayList<String>();
        List<String> letterLogs = new ArrayList<String>();

        for (String log : logs) {
            int indexOfSpace = log.indexOf(' ');
            if (Character.isLetter(log.charAt(indexOfSpace + 1))) {
                letterLogs.add(log);
            } else {
                digitLogs.add(log);
            }
        }

        Collections.sort(letterLogs, (x, y) -> {
            String remX = x.substring(x.indexOf(' ') + 1);
            String idX = x.substring(0, x.indexOf(' ') + 1);
            String remY = y.substring(y.indexOf(' ') + 1);
            String idY = y.substring(0, y.indexOf(' ') + 1);

            int comparison = remX.compareTo(remY);

            if (comparison == 0) {
                comparison = idX.compareTo(idY);
            }

            return comparison;
        });

        int i = 0;
        for (String log : letterLogs) {
            logs[i] = log;
            i++;
        }

        for (String log : digitLogs) {
            logs[i] = log;
            i++;
        }

        return logs;
    }
}
