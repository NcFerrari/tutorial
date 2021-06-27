package jednoduchyPriklad;

import java.util.List;
import java.util.ArrayList;

public class PrvocislaModel {

    private Integer[] list;
    private int userValue;

    public void setList(int userValue) {
        this.userValue = userValue;
        list = new Integer[userValue - 1];
        int index = 2;
        for (int i = 0; i < userValue - 1; i++) {
            list[i] = index++;
        }
    }

    public List<Integer> getPrvocisla() {
        List<Integer> resultList = new ArrayList<>();
        resultList.add(1);
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                int prvocislo = list[i];
                resultList.add(prvocislo);
                for (int j = i + prvocislo; j < list.length; j += prvocislo) {
                    list[j] = null;
                }
            }
        }
        return resultList;
    }

    public void zapracujPrvocislo(int index) {
        int prvocislo = list[index];
        for (int j = index + prvocislo; j < list.length; j += prvocislo) {
            list[j] = null;
        }
    }

    public Integer[] getList() {
        return list;
    }

    public int getUserValue() {
        return userValue;
    }
}
