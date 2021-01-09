package Rule8;

import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;

public class Rule8InspectionVisitor extends JavaElementVisitor {

    ProblemsHolder problemsHolder;

    public Rule8InspectionVisitor(@NotNull ProblemsHolder holder) {
        problemsHolder = holder;
    }

    @Override
    public void visitMethodCallExpression(PsiMethodCallExpression expression) {
        PsiExpression[] psiExpressions = expression.getArgumentList().getExpressions();
        for (PsiExpression psiExpression: psiExpressions) {
            System.out.println(psiExpression.getText());
        }
        System.out.println(expression.getText());
        super.visitMethodCallExpression(expression);
    }

    @Override
    public void visitMethod(PsiMethod method) {
        System.out.println(method.getText());
        super.visitMethod(method);
    }
}