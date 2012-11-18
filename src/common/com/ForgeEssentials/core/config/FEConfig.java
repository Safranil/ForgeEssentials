package com.ForgeEssentials.core.config;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

import com.ForgeEssentials.core.ForgeEssentials;
import com.ForgeEssentials.core.ModuleLauncher;
import com.ForgeEssentials.core.OutputHandler;

import com.ForgeEssentials.WorldControl.ModuleWorldControl;

public class FEConfig
{
	public static final File FECONFIG = new File(ForgeEssentials.FEDIR, "config.cfg");
	
	public final Configuration config;
	
	// this is designed so it will work for any class.
	public FEConfig()
	{	
		config = new Configuration(FECONFIG);
		
		// starting permissions and stuff...
		
		OutputHandler.SOP("Loading config");
		config.load();
		
		// Rules
		
	}
	
	/**
	 * @param name: ei WorldControl, Commands, Permissions, WorldEditCompat, WOrldGuardCompat, etc... whatever comes after Module
	 * @return boolean
	 */
	public boolean isModuleEnabled(String name)
	{
		Property prop = config.get("Modules", "name"+"_Enabled", true);
		return prop.getBoolean(true);
	}
	
	/*
	public static final File FECONFIG = new File(ForgeEssentials.FEDIR, "config.cfg");

	private HashMap<String, HashMap<String, Object>> settings = new HashMap<String, HashMap<String, Object>>();

	public ModuleWorldControl wc;
	public ForgeEssentials core;
	public ModuleLauncher mdlaunch;

	public FEConfig()
	{
		HashMap<String, Object> basicMap = new HashMap<String, Object>();
		basicMap.put("motd", "ForgeEssentials is awesome. https://github.com/ForgeEssentials/ForgeEssentialsMain");
		ArrayList<String> rules = new ArrayList<String>();
		rules.add("Don't grief");
		rules.add("Please grief");
		basicMap.put("rules", rules);
		settings.put("basic", basicMap);
	}

	public void loadConfig()
	{
		Configuration config = new Configuration(FECONFIG);
		OutputHandler.SOP("Loading config");
		config.load();
		settings.get("basic").put("motd", config.get("basic", "motd", settings.get("basic").get("motd").toString()).value);
		settings.get("basic").put("rules", config.get("basic", "rules", ((String)settings.get("basic").get("rules"))));
		Property prop;
        // Version toggling
		config.addCustomCategoryComment("modules", "Turn ForgeEssentials modules on or off here.");
		prop = config.get("modules", "enableWorldControl", true);
		prop.comment = "Enable/disable the WorldControl module. Disabling this on client also disables the CUI.";
		mdlaunch.wcenabled = prop.getBoolean(true);
		prop = config.get("basic", "checkForUpdates", true);
		prop.comment = "Enables/disables the Commands module.";
		mdlaunch.cmdenabled = prop.getBoolean(true);
		// Core
		prop = config.get("basic", "checkForUpdates", true);
		prop.comment = "Check for updates to ForgeEssentials on load. If you turn this off, you can still use /feversion in game.";
		core.verCheck = prop.getBoolean(true);
		// WorldControl (depreciated)
		config.addCustomCategoryComment("WorldControl", "The config area for the WorldControl submod of ForgeEssentials.");
        prop = config.get("WorldControl", "defaultWandID", (new ItemStack(Item.axeWood)).itemID);
		prop.comment = "The default wand ID. it is set to a wooden axe to start with.";
		wc.defaultWandID = prop.getInt((new ItemStack(Item.axeWood)).itemID);

		prop = config.get("WorldControl", "useExtraSlash", true);
		prop.comment = "Use the extra slash? (eg \"//wand\" instead of \"/wand\")";
		wc.useExtraSlash = prop.getBoolean(true);
		config.save();
	}

	public void changeConfig(String category, String name, Object newValue)
	{
		if (settings.containsKey(category) && settings.get(category).containsKey(name))
			settings.get(category).put(name, newValue);
		FECONFIG.delete();
	}

	public Object getSetting(String category, String name)
	{
		return settings.get(category).get(name);
	}
	*/
}
