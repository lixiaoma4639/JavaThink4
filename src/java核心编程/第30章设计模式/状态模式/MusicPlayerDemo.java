package java核心编程.第30章设计模式.状态模式;

// 状态接口
interface PlayerState {
    void play(PlayerContext context);
    void pause(PlayerContext context);
    void stop(PlayerContext context);
}

// 具体状态 - 准备状态
class ReadyState implements PlayerState {
    @Override
    public void play(PlayerContext context) {
        System.out.println("开始播放音乐");
        context.setState(new PlayingState());
    }

    @Override
    public void pause(PlayerContext context) {
        System.out.println("准备状态不能暂停");
    }

    @Override
    public void stop(PlayerContext context) {
        System.out.println("音乐已停止");
    }
}

// 具体状态 - 播放状态
class PlayingState implements PlayerState {
    @Override
    public void play(PlayerContext context) {
        System.out.println("音乐已经在播放中");
    }

    @Override
    public void pause(PlayerContext context) {
        System.out.println("暂停播放");
        context.setState(new PausedState());
    }

    @Override
    public void stop(PlayerContext context) {
        System.out.println("停止播放");
        context.setState(new ReadyState());
    }
}

// 具体状态 - 暂停状态
class PausedState implements PlayerState {
    @Override
    public void play(PlayerContext context) {
        System.out.println("继续播放");
        context.setState(new PlayingState());
    }

    @Override
    public void pause(PlayerContext context) {
        System.out.println("已经是暂停状态");
    }

    @Override
    public void stop(PlayerContext context) {
        System.out.println("停止播放");
        context.setState(new ReadyState());
    }
}

// 上下文类
class PlayerContext {
    private PlayerState currentState;

    public PlayerContext() {
        this.currentState = new ReadyState(); // 初始状态
    }

    public void setState(PlayerState state) {
        this.currentState = state;
    }

    public void play() {
        currentState.play(this);
    }

    public void pause() {
        currentState.pause(this);
    }

    public void stop() {
        currentState.stop(this);
    }
}

// 使用示例
public class MusicPlayerDemo {
    public static void main(String[] args) {
        PlayerContext player = new PlayerContext();

        player.play();  // 开始播放音乐
        player.pause(); // 暂停播放
        player.play();  // 继续播放
        player.stop();  // 停止播放
        player.pause(); // 准备状态不能暂停
    }
}
