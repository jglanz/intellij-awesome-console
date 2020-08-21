package awesome.console;

import com.intellij.execution.filters.ConsoleDependentFilterProvider;
import com.intellij.execution.filters.ConsoleFilterProvider;
import com.intellij.execution.filters.Filter;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;

public class AwesomeLinkFilterProvider extends ConsoleDependentFilterProvider implements ConsoleFilterProvider  {

	private static final LinkedHashMap<ConsoleView, Filter[]> consoleFilters = new LinkedHashMap<>();
	private static final LinkedHashMap<Project, Filter[]> projectFilters = new LinkedHashMap<>();


	@NotNull
	@Override
	public Filter[] getDefaultFilters(@NotNull ConsoleView consoleView, @NotNull Project project, @NotNull GlobalSearchScope globalSearchScope) {
		return consoleFilters.computeIfAbsent(consoleView, e -> new Filter[]{new AwesomeLinkFilter(project)} );
	}

	@NotNull
	@Override
	public Filter[] getDefaultFilters(@NotNull Project project) {
		return projectFilters.computeIfAbsent(project, e -> new Filter[]{new AwesomeLinkFilter(project)} );

	}
}
