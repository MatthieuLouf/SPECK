package Rules.Rule8;

import Rules.BaseRuleElementVisitor;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

/**
 * Rule8CodeInspection code visitor
 */
public class Rule8InspectionVisitor extends BaseRuleElementVisitor {

    public Rule8InspectionVisitor(@NotNull ProblemsHolder holder, String methodToDetect, String methodArgsToDetect, String errorMessage, ProblemHighlightType type) {
        super(holder, methodToDetect, methodArgsToDetect, errorMessage, type);
    }

    @Override
    public void visitMethodCallExpression(PsiMethodCallExpression expression) {
        if (Objects.equals(expression.getMethodExpression().getReferenceName(), methodToDetect)) { //check if the method is the one concerned by the rule
            PsiExpression[] psiExpressions = expression.getArgumentList().getExpressions(); //we get the arguments of this method

            boolean argToDetectIsPresent = false;

            for (PsiExpression psiExpression : psiExpressions) {
                if (psiExpression != Arrays.stream(psiExpressions).findFirst().get()) { //Don't evaluate first argument that is the file name
                    if (psiExpression.getText().contains(methodArgsToDetect) || psiExpression.getText().contains("0")) {
                        argToDetectIsPresent = true;
                        break;
                    }
                }
            }
            if (!argToDetectIsPresent) {
                this.registerProblem(psiExpressions[1]); //highlight the problematic argument
            }
        }
        super.visitMethodCallExpression(expression);
    }
}