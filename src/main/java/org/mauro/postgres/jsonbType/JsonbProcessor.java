package org.mauro.postgres.jsonbType;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.Serializable;
import java.util.Set;

import static java.lang.String.format;

@SupportedAnnotationTypes("org.mauro.postgres.lib.Jsonb")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class JsonbProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (annotations.size() == 0) {
            return false;
        }
        for (Element element : roundEnv.getElementsAnnotatedWith(Jsonb.class)) {
            Jsonb jsonb = element.getAnnotation(Jsonb.class);

            if (!element.getKind().isClass()) {
                return error("@jsonb can only be applied on classes", element);
            } else if (element instanceof Serializable) {
                return error(format("class %s must implement 'Serializable'", element.getSimpleName().toString()), element);
            } else {
                return error(format("class %s ", element.getSimpleName().toString()), element);
            }
        }
        return true;
    }

    private void buildClass(final String Element) {

    }

    private boolean error(String msg, Element e) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, msg, e);
        return false;
    }
}
