package java核心编程.第14章类型信息.空对象;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 :
 */
class NullRobotProxyHandler implements InvocationHandler {
    private String nullName;
    private Robot proxied = new NRobot();

    public NullRobotProxyHandler(Class<? extends Robot> type) {
        this.nullName = type.getSimpleName() + " null robot";
    }

    private class NRobot implements Robot , Null{
        @Override
        public String name() {
            return nullName;
        }

        @Override
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied , args);
    }
}
