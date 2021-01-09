package Rule8;

import com.intellij.codeInsight.daemon.GroupNames;
import com.intellij.codeInspection.AbstractBaseJavaLocalInspectionTool;
import com.intellij.codeInspection.ProblemsHolder;
import org.jetbrains.annotations.NotNull;

public class Rule8CodeInspection extends AbstractBaseJavaLocalInspectionTool {

    public @NotNull String getDisplayName() {
        return "Store private data within internal storage";
    }

    public @NotNull String getGroupDisplayName() {
        return GroupNames.PERFORMANCE_GROUP_NAME;
    }

    public @NotNull String getShortName() {
        return "Rule8_Internal_Storage";
    }

    public boolean isEnabledByDefault() {
        return true;
    }

    @NotNull
    @Override
    public Rule8InspectionVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {
        return new Rule8InspectionVisitor(holder);
    }

}