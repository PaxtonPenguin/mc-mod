package paxton.pixton.dyed.cat_tails.items;

import eu.pb4.trinkets.api.DefaultTrinketSlots;
import eu.pb4.trinkets.api.component.TrinketDataComponents;
import eu.pb4.trinkets.api.component.TrinketEquippable;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.util.Unit;
import paxton.pixton.ItemIds;
import paxton.pixton.Components;
import paxton.pixton.Tooltip;

public class RedCatTailItem extends Item{
    public RedCatTailItem() {
        super(new Item.Properties().stacksTo(1).setId(ItemIds.RED_DYED_CAT_TAIL)
                .component(TrinketDataComponents.EQUIPMENT, TrinketEquippable.DEFAULT
                        .withSlots(DefaultTrinketSlots.LEGS_BELT)
                        .withEquipOnInteract(true))
                .component(Components.TOOLTIP, new Tooltip("purr :3"))
                .component(DataComponents.UNBREAKABLE, Unit.INSTANCE));
    }
}
