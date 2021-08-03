package by.it.academy.newsportal.controller;

import java.util.HashMap;
import java.util.Map;

import by.it.academy.newsportal.controller.impl.ChangeLocale;
import by.it.academy.newsportal.controller.impl.GoToAuthorizationPage;
import by.it.academy.newsportal.controller.impl.GoToMainPage;
import by.it.academy.newsportal.controller.impl.GoToRegistrationPage;
import by.it.academy.newsportal.controller.impl.LogOut;
import by.it.academy.newsportal.controller.impl.RegistrationNewUser;
import by.it.academy.newsportal.controller.impl.SignIn;
import by.it.academy.newsportal.controller.impl.UnknownCommand;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(CommandName.AUTHORIZATION, new GoToAuthorizationPage());
		commands.put(CommandName.REGISTRATION, new GoToRegistrationPage());
		commands.put(CommandName.REGISTRATION_NEW_USER, new RegistrationNewUser());
		commands.put(CommandName.UNKNOWN_COMMAND, new UnknownCommand());
		commands.put(CommandName.SIGN_IN, new SignIn());
		commands.put(CommandName.GO_TO_MAIN_PAIGE, new GoToMainPage());
		commands.put(CommandName.CHANGE_LOCALE, new ChangeLocale());
		commands.put(CommandName.LOGOUT, new LogOut());
		

	}

	public Command findCommand(String name) {
		if (name == null) {
			name = CommandName.UNKNOWN_COMMAND.toString();
		}
		
		CommandName commandName;
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
		}catch(IllegalArgumentException e) {
			commandName = CommandName.UNKNOWN_COMMAND;
			
		}
		Command command = commands.get(commandName);
		return command;
	}
}
