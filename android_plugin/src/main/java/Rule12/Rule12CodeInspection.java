package Rule12;

import com.intellij.codeInsight.daemon.GroupNames;
import com.intellij.codeInspection.AbstractBaseJavaLocalInspectionTool;
import com.intellij.codeInspection.ProblemsHolder;
import org.jetbrains.annotations.NotNull;

public class Rule12CodeInspection extends AbstractBaseJavaLocalInspectionTool {

    public @NotNull String getDisplayName() {
        return "Use SharedPreferences in private mode";
    }

    public @NotNull String getGroupDisplayName() {
        return GroupNames.PERFORMANCE_GROUP_NAME;
    }

    public @NotNull String getShortName() {
        return "Rule12_SharedPreferences_Private_Mode";
    }

    public boolean isEnabledByDefault() {
        return true;
    }

    @NotNull
    @Override
    public Rule12InspectionVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {
        return new Rule12InspectionVisitor(holder);
    }

}