package jin.tool.annotation;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("jin.tool.annotation.PrintMsg")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class PrintNameProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Messager messager = processingEnv.getMessager();
        for (Element element : roundEnv.getRootElements()) {
            messager.printMessage(Diagnostic.Kind.NOTE,"my name is "+element.toString());
        }
        return false;
    }
}

