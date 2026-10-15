package ru.metroafter.item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
public class GasMaskItem extends Item {
    public GasMaskItem(Properties properties) { super(properties.stacksTo(1)); }
    public static boolean isWorn(LivingEntity entity) {
        ItemStack head = entity.getItemBySlot(EquipmentSlot.HEAD);
        return head.getItem() instanceof GasMaskItem && head.getDamageValue() < head.getMaxDamage();
    }
}
