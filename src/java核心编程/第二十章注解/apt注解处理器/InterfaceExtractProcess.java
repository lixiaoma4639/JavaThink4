//:


package java核心编程.第二十章注解.apt注解处理器;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.MethodDeclaration;
import com.sun.mirror.declaration.Modifier;
import com.sun.mirror.declaration.ParameterDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 日期 : 2020/12/15.
 * 创建 : xin.li
 * 描述 :
 */
class InterfaceExtractProcess implements AnnotationProcessor {

    private AnnotationProcessorEnvironment env;
    private ArrayList<MethodDeclaration> methodDeclarations = new ArrayList<>();

    public InterfaceExtractProcess(AnnotationProcessorEnvironment env) {
        this.env = env;
    }

    @Override
    public void process() {
        for (TypeDeclaration type : env.getSpecifiedTypeDeclarations()) {
            ExtractPolicy annotation = type.getAnnotation(ExtractPolicy.class);
            if (annotation == null) break;

            for (MethodDeclaration method: type.getMethods()){
                if (method.getModifiers().contains(Modifier.PUBLIC) && !method.getModifiers().contains(Modifier.STATIC)){
                    methodDeclarations.add(method);
                }
            }

            if (methodDeclarations.size() > 0){
                try {
                    PrintWriter writer = new PrintWriter(annotation.value());
                    writer.println("package " + type.getPackage().getQualifiedName() + ";");
                    writer.println("public interface " + annotation.value() + "{");
                    for (MethodDeclaration m : methodDeclarations) {
                        writer.print("   public ");
                        writer.print(m.getReturnType() + " ");
                        writer.print(m.getSimpleName() + "(");
                        int i = 0;
                        for (ParameterDeclaration param : m.getParameters()) {
                            writer.print(param.getType() + " " + param.getSimpleName());
                            if (++i < m.getParameters().size()){
                                writer.print(", ");
                            }
                        }
                        writer.println(")");
                    }
                    writer.println("}");
                    writer.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }
}














