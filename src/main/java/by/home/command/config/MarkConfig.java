package by.home.command.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import by.home.command.mark.impl.AddMark;
import by.home.command.mark.impl.GoToAddMark;

@Configuration
public class MarkConfig {

	@Bean(name = "GO_TO_ADD_MARK")
	public GoToAddMark getGoToAddMark() {
		return new GoToAddMark();
	}

	@Bean(name = "ADD_MARK")
	public AddMark getAddMark() {
		return new AddMark();
	}
}
