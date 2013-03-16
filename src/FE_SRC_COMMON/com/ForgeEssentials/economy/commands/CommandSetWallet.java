package com.ForgeEssentials.economy.commands;

import java.util.List;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

import com.ForgeEssentials.core.commands.ForgeEssentialsCommandBase;
import com.ForgeEssentials.economy.WalletHandler;
import com.ForgeEssentials.util.Localization;
import com.ForgeEssentials.util.OutputHandler;

import cpw.mods.fml.common.FMLCommonHandler;

public class CommandSetWallet extends ForgeEssentialsCommandBase
{
	@Override
	public String getCommandName()
	{
		return "setwallet";
	}

	@Override
	public void processCommandPlayer(EntityPlayer sender, String[] args)
	{
		if (args.length == 2)
		{
			EntityPlayer player = FMLCommonHandler.instance().getSidedDelegate().getServer().getConfigurationManager().getPlayerForUsername(args[0]);
			int amountToSet = Integer.parseInt(args[1]);

			if (player == null)
			{
				OutputHandler.chatError(sender, Localization.get(Localization.ERROR_NOPLAYER));
			}
			else
			{
				WalletHandler.setWallet(amountToSet, player);

				if (sender != player)
				{
					sender.sendChatToPlayer(Localization.get(Localization.wallet_SET_TARGET) + WalletHandler.getMoneyString(player));
				}
				player.sendChatToPlayer(Localization.get(Localization.wallet_SET_SELF) + WalletHandler.getMoneyString(player));
			}
		}
		else
		{
			OutputHandler.chatError(sender, Localization.get(Localization.ERROR_BADSYNTAX) + getSyntaxPlayer(sender));
		}

	}

	@Override
	public void processCommandConsole(ICommandSender sender, String[] args)
	{
		if (args.length == 2)
		{
			EntityPlayer player = FMLCommonHandler.instance().getSidedDelegate().getServer().getConfigurationManager().getPlayerForUsername(args[0]);
			int amountToSet = Integer.parseInt(args[1]);

			if (player == null)
			{
				sender.sendChatToPlayer(Localization.get(Localization.ERROR_NOPLAYER));
			}
			else
			{
				WalletHandler.setWallet(amountToSet, player);

				sender.sendChatToPlayer(Localization.get(Localization.wallet_SET_TARGET) + WalletHandler.getMoneyString(player));
				player.sendChatToPlayer(Localization.get(Localization.wallet_SET_SELF) + WalletHandler.getMoneyString(player));
			}
		}
		else
		{
			sender.sendChatToPlayer(Localization.get(Localization.ERROR_BADSYNTAX) + getSyntaxConsole());
		}
	}

	@Override
	public boolean canConsoleUseCommand()
	{
		return true;
	}

	@Override
	public String getCommandPerm()
	{
		return "ForgeEssentials.Economy." + getCommandName();
	}

	@Override
	public List<?> addTabCompletionOptions(ICommandSender sender, String[] args)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
