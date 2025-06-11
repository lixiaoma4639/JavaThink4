package java核心编程.第14章类型信息.空对象;

import java.util.ArrayList;

/**
 * 日期 : 2020/12/2.
 * 创建 : xin.li
 * 描述 :
 */
class Staff extends ArrayList<Position> {

    public Staff(String... titles) {
        add(titles);
    }

    public boolean positionAvailable(String title){
        for (Position p :this) {
            if (p.getTitle().equals(title) && p.getPerson() == Person.mNull){
                return true;
            }
        }
        return false;
    }

    public void fillPosition(String title , Person person){
        for (Position p :this) {
            if (p.getTitle().equals(title) && p.getPerson() == Person.mNull){
                p.setPerson(person);
                return;
            }
        }
        throw new RuntimeException("is not available....");
    }

    public void add(String title , Person person){
        add(new Position(title, person));
    }

    public void add(String... titles){
        for (String title : titles) {
            add(new Position(title));
        }
    }


}
