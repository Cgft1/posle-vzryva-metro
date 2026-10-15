package ru.metroafter.item;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.projectile.ProjectileUtil;
public class ScrapWeaponItem extends Item {
    private final float damage, cooldownSeconds;
    public ScrapWeaponItem(Properties properties, float damage, float cooldownSeconds) { super(properties.stacksTo(1)); this.damage=damage; this.cooldownSeconds=cooldownSeconds; }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, net.minecraft.world.InteractionHand hand) {
        ItemStack stack=player.getItemInHand(hand);
        if (!level.isClientSide && !player.getCooldowns().isOnCooldown(this)) {
            Vec3 start=player.getEyePosition(), look=player.getLookAngle(), end=start.add(look.scale(24.0D));
            AABB box=player.getBoundingBox().expandTowards(look.scale(24.0D)).inflate(1.0D);
            EntityHitResult hit=ProjectileUtil.getEntityHitResult(player,start,end,box,e -> e instanceof LivingEntity && e != player && e.isPickable(),24.0D*24.0D);
            if (hit != null && hit.getEntity() instanceof LivingEntity target) target.hurt(level.damageSources().playerAttack(player),damage);
            stack.hurtAndBreak(1,player,p -> p.broadcastBreakEvent(hand));
            player.getCooldowns().addCooldown(this,Math.max(1,(int)(cooldownSeconds*20)));
        }
        return InteractionResultHolder.sidedSuccess(stack,level.isClientSide);
    }
}
