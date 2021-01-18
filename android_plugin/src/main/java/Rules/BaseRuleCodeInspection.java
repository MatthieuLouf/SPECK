package Rules;

import Rules.Rule12.Rule12InspectionVisitor;
import com.intellij.codeInsight.daemon.GroupNames;
import com.intellij.codeInspection.AbstractBaseJavaLocalInspectionTool;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.ProblemsHolder;
import org.jetbrains.annotations.NotNull;

/**
 * Abstract class providing global rule configuration and display variables
 */
public abstract class BaseRuleCodeInspection extends AbstractBaseJavaLocalInspectionTool {

    final protected String displayName;
    final protected String shortName;
    final protected String groupName = "VulnerabilityRules";

    final protected String errorMessage;
    final protected ProblemHighlightType type;

    public BaseRuleCodeInspection(String displayName, String shortName, String errorMessage, ProblemHighlightType type) {
        this.displayName = displayName;
        this.shortName = shortName;
        this.errorMessage = errorMessage;
        this.type = type;
    }

    /**
     * @return Name displayed in the IDE inspection rules list
     */
    public @NotNull String getDisplayName() {
        return displayName;
    }

    /**
     * @return Name used as a key for the inspection rule
     */
    public @NotNull String getShortName() {
        return shortName;
    }

    /**
     * @return Group Name displayed in the IDE inspection rules list
     */
    public @NotNull String getGroupDisplayName() {
        return groupName;
    }

    public boolean isEnabledByDefault() {
        return true;
    }
}
