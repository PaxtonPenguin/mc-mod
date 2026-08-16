package paxton.catears;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;

import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.commands.Commands;
import net.minecraft.server.PlayerAdvancements;
import net.minecraft.server.level.ServerPlayer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;


public class CatEars implements ModInitializer {
	public static final String MOD_ID = "cat-ears";

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
		Screens.initialize();
		//ItemTooltipCallback.EVENT.register((stack, context, type, tooltip) -> {
		//	tooltip.add(Component.translatable("item.cat-ears.cat_ears", ":3").withStyle(ChatFormatting.GOLD));
		//});
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(Commands.literal("test").executes(context -> {
				context.getSource().sendSuccess(() -> Component.literal("test successful"), false);
				return 1;
			}));
		});

		/*CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(Commands.literal("become").executes(context -> {
				if (serverPlayer.getAdvancements().getOrStartProgress(advancement).isDone()) {

				}
			}));
		});*/
		/*serverPlayerEntity.getAdvancementTracker().getProgress(advancement).isDone() */
		
		LOGGER.info("Loaded, enjoy your cat ears :3");
	};

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	static boolean hasAdvancement(ServerPlayer serverPlayer, AdvancementHolder advancement) {
		return serverPlayer.getAdvancements().getOrStartProgress(advancement).isDone();
	}
}
