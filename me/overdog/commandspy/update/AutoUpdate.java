package me.overdog.commandspy.update;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Logger;

import me.overdog.commandspy.Core;
 
public class AutoUpdate {
    Core plugin;
    public AutoUpdate(Core plugin) {
        this.plugin = plugin;
        currentVersion = "1.0";
    }
 
    private String currentVersion;
    private String readurl = "https://raw.githubusercontent.com/Overdog/commandSpy/master/Update.txt";
 
    public void startUpdateCheck() {
            Logger log = plugin.getLogger();
            try {
                log.info("Checking for a new version...");
                URL url = new URL(readurl);
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                String str;
                while ((str = br.readLine()) != null) {
                    String line = str;
                    if (line.equalsIgnoreCase(currentVersion)) 
                    {
                     
                        log.info("Update found! Please install it at " + Core.linkToResource + " for highest quality!");
                    }
                }
                br.close();
            } catch (IOException e) {
                log.severe("The UpdateChecker URL is invalid! Please let me know!");
            }
    }
}