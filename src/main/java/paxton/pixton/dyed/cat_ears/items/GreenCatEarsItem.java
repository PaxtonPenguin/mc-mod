package paxton.pixton.dyed.cat_ears.items;

import eu.pb4.trinkets.api.DefaultTrinketSlots;
import eu.pb4.trinkets.api.component.TrinketDataComponents;
import eu.pb4.trinkets.api.component.TrinketEquippable;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.util.Unit;
import paxton.pixton.ItemIds;
import paxton.pixton.Components;
import paxton.pixton.Tooltip;

public class GreenCatEarsItem extends Item{
    public GreenCatEarsItem() {
        super(new Item.Properties().stacksTo(1).setId(ItemIds.GREEN_DYED_CAT_EARS)
                .component(TrinketDataComponents.EQUIPMENT, TrinketEquippable.DEFAULT
                        .withSlots(DefaultTrinketSlots.HEAD_HAT)
                        .withEquipOnInteract(true))
                .component(Components.TOOLTIP, new Tooltip("meow :3"))
                .component(DataComponents.UNBREAKABLE, Unit.INSTANCE));
    }
}
