package com.basictest.annotation.apt;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/**
 * Created in 2021/4/8 10:12
 *
 * @author: huxingxin
 */
public class HibernateAnnotationFactory implements AnnotationProcessorFactory {
    /**
     * 返回所有支持的选项
     * @return
     */
    @Override
    public Collection<String> supportedOptions() {
        return Arrays.asList(new String[0]);
    }

    /**
     * 所有支持的注释类型
     * @return
     */
    @Override
    public Collection<String> supportedAnnotationTypes() {
        return Arrays.asList("Property","Persistent","IdProperty");
    }

    /**
     * 返回Annotation处理器
     * @param set
     * @param env
     * @return
     */
    @Override
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> set, AnnotationProcessorEnvironment env) {
        return new HibernateAnnotationProcessor(env);
    }
}
