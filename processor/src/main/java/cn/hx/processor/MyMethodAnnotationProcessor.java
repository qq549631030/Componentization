package cn.hx.processor;

import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

import cn.hx.annotations.MyMethodAnnotation;


/**
 * Created by huangx on 2017/9/1.
 */
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes({"MyMethodAnnotation"})
public class MyMethodAnnotationProcessor extends AbstractProcessor {
    Filer filer;
    Messager messager;
    Elements elementUtils;
    Types typeUtils;
    Map<String, String> options;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
        elementUtils = processingEnv.getElementUtils();
        typeUtils = processingEnv.getTypeUtils();
        options = processingEnv.getOptions();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if (set != null && !set.isEmpty()) {
            Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(MyMethodAnnotation.class);
            try {
                parseMyMethodAnnotations(elements);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    private void parseMyMethodAnnotations(Set<? extends Element> set) {
        if (set != null && !set.isEmpty()) {
            for (Element element : set) {
                MyMethodAnnotation annotation = element.getAnnotation(MyMethodAnnotation.class);
                messager.printMessage(Diagnostic.Kind.NOTE, "MyMethodAnnotation name :" + annotation.name());
            }
        }
    }
}
