package java核心编程.第二十章注解.生成外部文件;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 日期 : 2020/12/15.
 * 创建 : xin.li
 * 描述 :
 */
class TableCreate {

    public static void main(String[] args) throws ClassNotFoundException {
        args = new String[]{ "java核心编程.第二十章注解.生成外部文件.MemberBean"};
        if (args.length < 1) {
            System.out.println("annotated class");
            System.exit(0);
        }
        for (String classname : args) {
            Class<?> aClass = Class.forName(classname);
            DBTable dbTable = aClass.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("no db table annotation in class...");
                continue;
            }

            String tabName = dbTable.name();
            if (tabName.length() < 1) {
                tabName = aClass.getName().toUpperCase();
            }

            List<String> columns = new ArrayList<>();
            for (Field field : aClass.getDeclaredFields()) {
                String columnName = null;
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                if (declaredAnnotations.length < 1) continue;
                if (declaredAnnotations[0] instanceof SQLInteger) {
                    SQLInteger sqlInteger = (SQLInteger) declaredAnnotations[0];
                    if (sqlInteger.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlInteger.name();
                    }
                    columns.add(columnName + " INT" + getConstrains(sqlInteger.constrains()));
                }

                if (declaredAnnotations[0] instanceof SQLString) {
                    SQLString sqlString = (SQLString) declaredAnnotations[0];
                    if (sqlString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlString.name();
                    }
                    columns.add(columnName + " VARCHAR (" + sqlString.value() + ")" + getConstrains(sqlString.constrains()));
                }


                StringBuilder sb = new StringBuilder("创建表 " + tabName + "(");
                for (String s : columns) {
                    sb.append("\n    " + s + ", ");
                }
                sb.append(" )");
                System.out.println("Table Sql created for " + classname + "is : " + sb);
            }
        }
    }


    private static String getConstrains(Constrains con) {
        String constrains = "";
        if (!con.allowNull()) {
            constrains += " Not Null ";
        }
        if (con.primaryKey()) {
            constrains += " Primary Key ";
        }
        if (con.unique()) {
            constrains += " Unique ";
        }
        return constrains;
    }
}
