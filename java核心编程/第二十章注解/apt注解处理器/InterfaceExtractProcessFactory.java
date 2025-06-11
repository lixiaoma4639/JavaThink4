package java核心编程.第二十章注解.apt注解处理器;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * 日期 : 2020/12/15.
 * 创建 : xin.li
 * 描述 :
 */
class InterfaceExtractProcessFactory implements AnnotationProcessorFactory {
    @Override
    public Collection<String> supportedOptions() {
        return Collections.emptyList();
    }

    @Override
    public Collection<String> supportedAnnotationTypes() {
        return Collections.singleton("java核心编程.第二十章注解.apt注解处理器.ExtractPolicy");
    }

    @Override
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> set, AnnotationProcessorEnvironment annotationProcessorEnvironment) {
        return new InterfaceExtractProcess(annotationProcessorEnvironment);
    }
}
