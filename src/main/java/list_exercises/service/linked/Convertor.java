package list_exercises.service.linked;

import java.util.ArrayList;
import java.util.LinkedList;

public class Convertor {

    public LinkedList<String> converts(ArrayList<String> arrList) {
        if (arrList.size() <= 0) {
            LinkedList<String> emptyList = new LinkedList<String>();
            return emptyList;
        }
        LinkedList<String> linkList = new LinkedList<String>(arrList);
        return linkList;
    }

}
