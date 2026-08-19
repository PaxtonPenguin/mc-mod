package paxton.pixton;

import com.mojang.blaze3d.platform.InputConstants;

import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.resources.Identifier;

public class KeyMappings implements ClientModInitializer{
    private net.minecraft.world.item.Items builtin;
    KeyMapping.Category CATEGORY = KeyMapping.Category.register(
			Identifier.fromNamespaceAndPath(CatEars.MOD_ID, "custom_category"));
			KeyMapping meow = KeyMappingHelper.registerKeyMapping(
				new KeyMapping(
					"key.pixton.meow", // The translation key for the key mapping.
					InputConstants.Type.KEYSYM, // The type of the keybinding; KEYSYM for keyboard, MOUSE for mouse.
					InputConstants.KEY_M, // The keycode of the key.
					CATEGORY // The category of the mapping.
				)
			);

        @Override
        public void onInitializeClient() {
            ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (meow.consumeClick()) {
				if (client.player != null) {
					final ItemStack slot = client.player.getItemBySlot(EquipmentSlot.HEAD);				
					if (slot.is(Items.CAT_EARS) || slot.is(Items.BLACK_CAT_EARS)) {
						client.player.playSound(SoundEvents.CAT_PURREOW_BABY.value(), 2f, 0.7f);
						if (client.player.isHolding(builtin.GLASS_BOTTLE)) {
							//client.player.addItem(Items.BOTTLE.getDefaultInstance());
							client.player.setItemInHand(InteractionHand.MAIN_HAND, Items.BOTTLE.getDefaultInstance());
						}
						if (client.player.isHolding(builtin.EGG)) {
							//client.player.addItem(Items.BOTTLE.getDefaultInstance());
							client.player.setItemInHand(InteractionHand.MAIN_HAND, builtin.CAT_SPAWN_EGG.getDefaultInstance());
						}
					} else if (slot.is(Items.FOP_EARS)) {
						client.player.playSound(SoundEvents.FOX_SCREECH, 2f, 0.7f);
						if (client.player.isHolding(builtin.GLASS_BOTTLE)) {
							//client.player.addItem(Items.BOTTLE.getDefaultInstance());
							client.player.setItemInHand(InteractionHand.MAIN_HAND, Items.BOTTLE.getDefaultInstance());
						}
						if (client.player.isHolding(builtin.EGG)) {
							//client.player.addItem(Items.BOTTLE.getDefaultInstance());
							client.player.setItemInHand(InteractionHand.MAIN_HAND, builtin.FOX_SPAWN_EGG.getDefaultInstance());
						}
					} else {
						CatEars.LOGGER.info("nah");
					}
				}
			}
		});
        }
}
