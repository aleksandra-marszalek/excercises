package list_exercises.service.linked;
import java.util.LinkedList;

public class Reverse {
    public LinkedList<String> reversal(LinkedList<String> arr) {
        LinkedList<String> rev = new LinkedList<String>();
        int len = arr.size();
        if (len <= 1) {
            return arr;
        }
        for (int i=0; i<len; i++) {
            rev.add(arr.get(len-1-i));
        }
        return rev;
    }
}
