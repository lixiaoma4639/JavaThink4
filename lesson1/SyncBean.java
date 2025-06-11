package lesson1;

/**
 * Created by lixin on 2020/3/17.
 */
class SyncBean {

    public synchronized void requestSdkRegisterCode(String id) {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                hhhh(id , i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        synchronized (this) {
//        }
    }

    private void hhhh(String id ,int index){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(id + " 我是 " + index);
            }
        });
        thread.start();
    }
}
