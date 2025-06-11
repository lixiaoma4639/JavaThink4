package java核心编程.第12章异常.自定义异常;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * 日期 : 2020/11/16.
 * 创建 : xin.li
 * 描述 :
 */
class 异常与记录日志 {

    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
//            e.printStackTrace();
//            System.err.println(e.toString());
        }

        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println(e.toString());
        }
    }

    private static class LoggingException extends Exception{
        private static Logger logger = Logger.getLogger("LoggingException");

        public LoggingException() {
            StringWriter stringWriter = new StringWriter();
            printStackTrace(new PrintWriter(stringWriter));
            logger.severe(stringWriter.toString());
        }
    }

    private static class LoggingException2 extends Exception{
        private static Logger logger = Logger.getLogger("LoggingException2");

        static void loggerException2(Exception e){
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            logger.severe(stringWriter.toString());
        }

        public static void main(String[] args) {
            try {
                throw new NullPointerException();
            } catch (NullPointerException e) {
                loggerException2(e);
            }
        }
    }
}
