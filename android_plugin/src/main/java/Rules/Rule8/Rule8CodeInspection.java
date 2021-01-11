package Rules.Rule8;

import Rules.BaseRuleCodeInspection;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.ProblemsHolder;
import org.jetbrains.annotations.NotNull;

public class Rule8CodeInspection extends BaseRuleCodeInspection {

    final String methodToDetect = "openFileOutput";
    final String methodArgsToDetect = "MODE_PRIVATE";

    Rule8CodeInspection() {
        super("Store private data within internal storage",
                "Rule8_Internal_Storage",
                "Call(s) to internal storage (are) not private",
                ProblemHighlightType.WARNING);
    }

    @NotNull
    @Override
    public Rule8InspectionVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {
        return new Rule8InspectionVisitor(holder, methodToDetect, methodArgsToDetect, errorMessage, type);
    }

}