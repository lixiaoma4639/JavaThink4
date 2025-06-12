package java核心编程.第30章设计模式.责任链模式;

public class View implements EventHandler {
    private OnTouchListener mOnTouchListener;

    public void setOnTouchListener(OnTouchListener listener) {
        this.mOnTouchListener = listener;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        System.out.println("View dispatchTouchEvent");

        // 1. 先检查OnTouchListener
        if (mOnTouchListener != null && mOnTouchListener.onTouch(this, event)) {
            return true;
        }

        // 2. 再调用onTouchEvent
        return onTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("View onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("View处理了DOWN事件");
                return false;
            case MotionEvent.ACTION_UP:
                System.out.println("View处理了UP事件");
                return true;
        }
        return false;
    }

    public interface OnTouchListener {
        boolean onTouch(View v, MotionEvent event);
    }
}
