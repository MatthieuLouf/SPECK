package Rule12;

import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.JavaElementVisitor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiJavaFile;
import org.jetbrains.annotations.NotNull;

public class Rule12InspectionVisitor extends JavaElementVisitor {

    ProblemsHolder problemsHolder;

    public Rule12InspectionVisitor(@NotNull ProblemsHolder holder) {
        problemsHolder = holder;
    }

    @Override
    public void visitJavaFile(PsiJavaFile file) {
        super.visitJavaFile(file);
    }

    @Override
    public void visitElement(@NotNull PsiElement element) {
        super.visitElement(element);
    }

}