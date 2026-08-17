package paxton.pixton;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.item.v1.ItemComponentTooltipProviderRegistry;

import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.KeyMapping;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.brigadier.Command;


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
		//CatNoises.initialize();
		//ItemTooltipCallback.EVENT.register((stack, context, type, tooltip) -> {
		//	tooltip.add(Component.translatable("item.cat-ears.cat_ears", ":3").withStyle(ChatFormatting.GOLD));
		//});
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(Commands.literal("test").executes(context -> {
				context.getSource().sendSuccess(() -> Component.literal("test successful"), false);
				return 1;
			}));
		});

		KeyMapping.Category CATEGORY = KeyMapping.Category.register(
			Identifier.fromNamespaceAndPath("cat-ears", "custom_category"));
			KeyMapping sendToChatKey = KeyMappingHelper.registerKeyMapping(
				new KeyMapping(
					"key.cat-ears.meow", // The translation key for the key mapping.
					InputConstants.Type.KEYSYM, // The type of the keybinding; KEYSYM for keyboard, MOUSE for mouse.
					InputConstants.KEY_M, // The keycode of the key.
					CATEGORY // The category of the mapping.
				)
			);
		
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (sendToChatKey.consumeClick()) {
				if (client.player != null) {
					//client.player.sendSystemMessage(Component.literal("Key Pressed!"));
					final ItemStack slot = client.player.getItemBySlot(EquipmentSlot.HEAD);				
					if (slot.is(Items.CAT_EARS) || slot.is(Items.BLACK_CAT_EARS)) {
						client.player.playSound(SoundEvents.CAT_PURREOW_BABY.value(), 2f, 0.7f);
					} else if (slot.is(Items.FOP_EARS)) {
						client.player.playSound(SoundEvents.FOX_SCREECH, 2f, 0.7f);
					} else {
						LOGGER.info("nah");
					}
				}
			}
		});

		Command<CommandSourceStack> command = context -> {
				final ServerPlayer player = context.getSource().getPlayer();
				final String gotIt = player.getAttached(Save.isFurry);
				LOGGER.info(gotIt);
				if (gotIt == "white") {
					player.setItemSlot(EquipmentSlot.HEAD, Items.CAT_EARS.getDefaultInstance());
					player.setItemSlot(EquipmentSlot.LEGS, Items.CAT_TAIL.getDefaultInstance());
					context.getSource().sendSuccess(() -> Component.literal("Became a Cat again"), false);
				} else if (gotIt == "black") {
					player.setItemSlot(EquipmentSlot.HEAD, Items.BLACK_CAT_EARS.getDefaultInstance());
					player.setItemSlot(EquipmentSlot.LEGS, Items.BLACK_CAT_TAIL.getDefaultInstance());
					context.getSource().sendSuccess(() -> Component.literal("Became a Cat again"), false);
				} else if (gotIt == "fox") {
					player.setItemSlot(EquipmentSlot.HEAD, Items.FOP_EARS.getDefaultInstance());
					player.setItemSlot(EquipmentSlot.LEGS, Items.FOP_TAIL.getDefaultInstance());
					context.getSource().sendSuccess(() -> Component.literal("Became a Fox again"), false);
				} else {
					context.getSource().sendSuccess(() -> Component.literal("Find an Orb you dingus"), false);
				}
				return 0;
		};

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(Commands.literal("become").executes(command));
		});

		ItemComponentTooltipProviderRegistry.addAfter(DataComponents.DAMAGE, Components.TOOLTIP);
		/*serverPlayerEntity.getAdvancementTracker().getProgress(advancement).isDone() */
		
		LOGGER.info("Loaded, enjoy your cat ears :3");
	};

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
