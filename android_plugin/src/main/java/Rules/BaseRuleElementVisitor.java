package Rules;

import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.JavaElementVisitor;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * Abstract class providing global rule scanning parameters
 *
 * extends the Java visitor implementing some callbacks when scanning methods/assignments etc
 */
public abstract class BaseRuleElementVisitor extends JavaElementVisitor {
    protected ProblemsHolder problemsHolder;

    final protected String methodToDetect;
    final protected String methodArgsToDetect;

    final protected String errorMessage;

    final protected ProblemHighlightType type;

    public BaseRuleElementVisitor(@NotNull ProblemsHolder holder, String methodToDetect, String methodArgsToDetect, String errorMessage, ProblemHighlightType type) {
        this.problemsHolder = holder;
        this.methodToDetect = methodToDetect;
        this.methodArgsToDetect = methodArgsToDetect;
        this.errorMessage = errorMessage;
        this.type = type;
    }

    /**
     * Globally used method to highlight some part of the code
     *
     * @param element PsiElement pointing to the code part
     */
    protected void registerProblem(PsiElement element) {
        problemsHolder.registerProblem(element, errorMessage, type);
    }

}
