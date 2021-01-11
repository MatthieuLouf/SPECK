package Rules.Rule8;

import Rules.Rule12.Rule12InspectionVisitor;
import com.intellij.codeInsight.daemon.GroupNames;
import com.intellij.codeInspection.AbstractBaseJavaLocalInspectionTool;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.ProblemsHolder;
import org.jetbrains.annotations.NotNull;

public class Rule8CodeInspection extends AbstractBaseJavaLocalInspectionTool {

    public @NotNull String getDisplayName() {
        return "Store private data within internal storage";
    }

    public @NotNull String getGroupDisplayName() {
        return "VulnerabilityRules";
    }

    public @NotNull String getShortName() {
        return "Rule8_Internal_Storage";
    }

    public boolean isEnabledByDefault() {
        return true;
    }

    final String methodToDetect = "openFileOutput";
    final String methodArgsToDetect = "MODE_PRIVATE";
    final String errorMessage = "Call(s) to internal storage (are) not private";

    ProblemHighlightType type = ProblemHighlightType.WARNING;

    @NotNull
    @Override
    public Rule8InspectionVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {
        return new Rule8InspectionVisitor(holder, methodToDetect, methodArgsToDetect, errorMessage, type);
    }

}