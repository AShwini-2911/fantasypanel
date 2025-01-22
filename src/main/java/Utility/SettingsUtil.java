package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import Pages.GeneralSettings.SettingsPage;
import Pages.Master.GamesPage;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

public class SettingsUtil {
	    private static Properties settingsproperties;

	    static {
	        try {
	        	settingsproperties = new Properties();
	            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\User\\Desktop\\Automation\\fantasypanel\\src\\test\\resources\\property\\settings.properties");
	            settingsproperties.load(fileInputStream);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static String getSettingsProperty(String key) {
	        return settingsproperties.getProperty(key);
	    }
	    
	    public static void fillGameForm(SettingsPage settingsPage) {
	    	settingsPage.enterSystemEmail(getSettingsProperty("SystemE-mail"));
	    	settingsPage.enterSystemContactNo(getSettingsProperty("SystemContactNo"));
	    	
	    	
	    	settingsPage.entertwitterLink(getSettingsProperty("Twitter"));
	    	settingsPage.enterfacebookLink(getSettingsProperty("Facebook"));
	    	settingsPage.enteryoutubeLink(getSettingsProperty("YouTube"));
	    	
	    	settingsPage.minimum_deposit_amount(getSettingsProperty("MinimumDepositAmount"));
	    	settingsPage.maximum_deposit_amount(getSettingsProperty("MaximumDepositAmount"));
	    	settingsPage.minimum_withdrawal_amount(getSettingsProperty("MinimumWithdrawalAmount"));
	    	settingsPage.maximum_withdrawal_amount(getSettingsProperty("MaximumWithdrawalAmount"));
	    	
	    	settingsPage.android_url(getSettingsProperty("Android"));
	    	settingsPage.ios_url(getSettingsProperty("IOS"));
	        
	    	settingsPage.android_version(getSettingsProperty("AndroidVer"));
	    	settingsPage.ios_version(getSettingsProperty("IOSVer"));
	        
	    }
	}



