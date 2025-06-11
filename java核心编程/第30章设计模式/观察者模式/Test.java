package java核心编程.第30章设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

public class Test {
    // 1. 观察者接口
    interface Observer {
        void update(String message);
    }

    // 2. 主题接口, 被观察者
    interface Subject {
        void registerObserver(Observer o);
        void removeObserver(Observer o);
        void notifyObservers();
    }

    // 3. 具体主题
    static class NewsAgency implements Subject {
        private List<Observer> observers = new ArrayList<>();
        private String news;

        public void setNews(String news) {
            this.news = news;
            notifyObservers();
        }

        @Override
        public void registerObserver(Observer o) {
            observers.add(o);
        }

        @Override
        public void removeObserver(Observer o) {
            observers.remove(o);
        }

        @Override
        public void notifyObservers() {
            for (Observer o : observers) {
                o.update(news);
            }
        }
    }

    // 5. 使用示例
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        agency.registerObserver(new Observer() {
            @Override
            public void update(String message) {
                System.out.println("观察者1， 最新消息: " + message);
            }
        });
        agency.registerObserver(new Observer() {
            @Override
            public void update(String message) {
                System.out.println("观察者2， 最新消息: " + message);
            }
        });

        agency.setNews("Java 17正式发布");
        // 输出:
        // 最新消息: Java 17正式发布
        // 最新消息: Java 17正式发布

        agency.setNews("Spring 6.0即将推出");
        // 输出:
        // 最新消息: Spring 6.0即将推出
    }
}
