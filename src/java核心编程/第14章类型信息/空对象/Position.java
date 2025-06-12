package java核心编程.第14章类型信息.空对象;

/**
 * 日期 : 2020/12/2.
 * 创建 : xin.li
 * 描述 :
 */
class Position {
    private String title;
    private Person person;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        if (this.person == null){
            person = Person.mNull;
        }
    }

    public Position(String title) {
        this.title = title;
        this.person = Person.mNull;
    }

    public Position(String title, Person person) {
        this.title = title;
        this.person = person;

        if (this.person == null){
            person = Person.mNull;
        }
    }
}
