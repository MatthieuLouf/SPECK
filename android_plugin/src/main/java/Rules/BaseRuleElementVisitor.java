package Rules;

import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.JavaElementVisitor;
import org.jetbrains.annotations.NotNull;

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

}
