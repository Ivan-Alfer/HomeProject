package by.home.command.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import by.home.command.impl.GoToMainPage;
import by.home.command.impl.ShowAll;

@Configuration
@ComponentScan("by.home")
@Import({StudentConfig.class, SubjectConfig.class, MarkConfig.class})
public class ConfigurationBean {

	@Bean(name = "GO_TO_MAIN_PAGE")
	public GoToMainPage getGoToMainPage() {
		return new GoToMainPage();
	}

	@Bean(name = "SHOW_ALL")
	public ShowAll getShowAll() {
		return new ShowAll();
	}

	@Bean
	public CommandsFactory getCommandsFactory(){
		return new CommandsFactory();
	}
}
