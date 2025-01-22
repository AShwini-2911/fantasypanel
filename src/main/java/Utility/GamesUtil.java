package Utility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;


import Pages.Master.GamesPage;

public class GamesUtil {

	    private static Properties gamesProperties;

	    static {
	        // Load `games.properties` file
	        gamesProperties = new Properties();
	        try (FileInputStream input = new FileInputStream("D:\\automation\\practice\\src\\test\\resources\\property\\games.properties")) {
	            gamesProperties.load(input);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // Method to get values from `games.properties`
	    public static String getGameProperty(String key) {
	        return gamesProperties.getProperty(key);
	    }

	    // Method to fill the game form using properties from `games.properties`
	    public static void fillGameForm(GamesPage gamesPage) {
	        gamesPage.enterSequence(getGameProperty("game.Sequence"));

	        gamesPage.enterLink(getGameProperty("games.Link"));
	        
	        gamesPage.EnglishName(getGameProperty("English.name"));
	        
	        gamesPage.HindiName(getGameProperty("Hindi.name"));
	        
	        gamesPage.updateGamesSequence(getGameProperty("games.SequenceUpdate"));
	        
	        gamesPage.filterGameName(getGameProperty("games.TitleFilter"));
	        
	    }

	    
	}


