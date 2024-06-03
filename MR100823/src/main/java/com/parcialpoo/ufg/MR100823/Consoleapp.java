package com.parcialpoo.ufg.MR100823;

import com.parcialpoo.ufg.MR100823.Console.*;
import com.parcialpoo.ufg.MR100823.services.MenuService;


public class Consoleapp {
	private static MenuService pMenuService;
	private static MenuConsoleApp  pMenuConsoleApp;
	private static void primaryConsoleApp() {
		pMenuService = new MenuService();
	
		pMenuConsoleApp.readMenus();
	}
	
}
