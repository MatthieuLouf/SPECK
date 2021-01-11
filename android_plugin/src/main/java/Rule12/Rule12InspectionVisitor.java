package Rule12;

import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Rule12InspectionVisitor extends JavaElementVisitor {

    ProblemsHolder problemsHolder;

    final String methodToDetect = "getSharedPreferences";
    final String methodArgsToDetect = "MODE_PRIVATE";

    final String errorMessage = "Shared preference(s) saving (are) not private";

    public Rule12InspectionVisitor(@NotNull ProblemsHolder holder) {
        problemsHolder = holder;
    }

    @Override
    public void visitMethodCallExpression(PsiMethodCallExpression expression) {
        if(Objects.equals(expression.getMethodExpression().getReferenceName(), methodToDetect))
        {
            PsiExpression[] psiExpressions = expression.getArgumentList().getExpressions();
            boolean argToDetectIsPresent = false;
            for (PsiExpression psiExpression: psiExpressions) {
                if (psiExpression.getText().contains(methodArgsToDetect) || psiExpression.getText().contains("0")) {
                    argToDetectIsPresent = true;
                    break;
                }
            }
            if(!argToDetectIsPresent)
            {
                problemsHolder.registerProblem(expression, errorMessage);
            }
        }
        super.visitMethodCallExpression(expression);
    }

}