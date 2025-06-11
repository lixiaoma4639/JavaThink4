package java核心编程.第30章设计模式.原型模式;

import java.util.ArrayList;
import java.util.List;

public class DeepBook implements Cloneable {
    private String title;
    private String author;
    private List<String> chapters;

    public DeepBook(String title, String author, List<String> chapters) {
        this.title = title;
        this.author = author;
        this.chapters = chapters;
    }

    // 深拷贝实现
    @Override
    public DeepBook clone() {
        try {
            DeepBook cloned = (DeepBook) super.clone();
            // 对引用类型进行深拷贝
            cloned.chapters = new ArrayList<>(this.chapters);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getChapters() {
        return chapters;
    }

    public void setChapters(List<String> chapters) {
        this.chapters = chapters;
    }
}