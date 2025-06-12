package java核心编程.第30章设计模式.责任链模式;

public class Activity implements EventHandler {
    private ViewGroup mDecorView;

    public static void main(String[] args) {
        // 1. 创建责任链
        Activity activity = new Activity();
        ViewGroup rootView = new ViewGroup(activity);
        ViewGroup middleView = new ViewGroup(rootView);
        View childView = new View();
//        View childView2 = new View();

        // 2. 构建视图层级
        middleView.addView(childView);
//        middleView.addView(childView2);
        rootView.addView(middleView);
        activity.setContentView(rootView);

        // 3. 设置触摸监听器
        childView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                System.out.println("OnTouchListener处理了事件");
                return false; // 返回false表示不消费，继续传递
            }
        });

        // 4. 模拟事件分发
        System.out.println("=== DOWN事件 ===");
        MotionEvent downEvent = new MotionEvent(MotionEvent.ACTION_DOWN, 100, 100);
        activity.dispatchTouchEvent(downEvent);

//        System.out.println("\n=== MOVE事件 ===");
//        MotionEvent moveEvent = new MotionEvent(MotionEvent.ACTION_MOVE, 101, 101);
//        activity.dispatchTouchEvent(moveEvent);
//
//        System.out.println("\n=== UP事件 ===");
//        MotionEvent upEvent = new MotionEvent(MotionEvent.ACTION_UP, 100, 100);
//        activity.dispatchTouchEvent(upEvent);
    }

    public void setContentView(ViewGroup view) {
        this.mDecorView = view;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        System.out.println("Activity dispatchTouchEvent");
        if (mDecorView != null) {
            return mDecorView.dispatchTouchEvent(event);
        }
        return onTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("Activity onTouchEvent");
        return false;
    }
}