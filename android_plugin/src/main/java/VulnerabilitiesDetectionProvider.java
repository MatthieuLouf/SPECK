import Rules.Rule12.Rule12CodeInspection;
import Rules.Rule8.Rule8CodeInspection;
import com.intellij.codeInspection.InspectionToolProvider;
import org.jetbrains.annotations.NotNull;

public class VulnerabilitiesDetectionProvider implements InspectionToolProvider {
    public Class @NotNull [] getInspectionClasses() {
        return new Class[]{
                Rule8CodeInspection.class,
                Rule12CodeInspection.class
        };
    }
}