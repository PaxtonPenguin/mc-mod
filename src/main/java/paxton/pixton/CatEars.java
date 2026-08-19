package paxton.pixton;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.item.v1.ItemComponentTooltipProviderRegistry;

import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mojang.brigadier.Command;

public class CatEars implements ModInitializer {
	public static final String MOD_ID = "pixton";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Loading CatEar Resources...");
		Items.initialize();
		Blocks.initialize();
		BlockEntities.initialize();
		MenuTypes.initialize();

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(Commands.literal("test").executes(context -> {
				context.getSource().sendSuccess(() -> Component.literal("test successful"), false);
				return 1;
			}));
		});

		Command<CommandSourceStack> command = context -> {
				final ServerPlayer player = context.getSource().getPlayer();
				final String gotIt = player.getAttached(Save.isFurry);
				LOGGER.info(gotIt);
				if (gotIt == "white") {
					player.setItemSlot(EquipmentSlot.HEAD, Items.CAT_EARS.getDefaultInstance());
					player.setItemSlot(EquipmentSlot.LEGS, Items.CAT_TAIL.getDefaultInstance());
					context.getSource().sendSuccess(() -> Component.literal("You became a Cat again"), false);
				} else if (gotIt == "black") {
					player.setItemSlot(EquipmentSlot.HEAD, Items.BLACK_CAT_EARS.getDefaultInstance());
					player.setItemSlot(EquipmentSlot.LEGS, Items.BLACK_CAT_TAIL.getDefaultInstance());
					context.getSource().sendSuccess(() -> Component.literal("You became a Cat again"), false);
				} else if (gotIt == "fox") {
					player.setItemSlot(EquipmentSlot.HEAD, Items.FOP_EARS.getDefaultInstance());
					player.setItemSlot(EquipmentSlot.LEGS, Items.FOP_TAIL.getDefaultInstance());
					context.getSource().sendSuccess(() -> Component.literal("You became a Fox again"), false);
				} else {
					context.getSource().sendSuccess(() -> Component.literal("Find an Orb you dingus"), false);
				}
				return 0;
		};

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(Commands.literal("become").executes(command));
		});

		ItemComponentTooltipProviderRegistry.addAfter(DataComponents.DAMAGE, Components.TOOLTIP);
		
		LOGGER.info("Loaded, enjoy your cat ears :3");
	};

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
