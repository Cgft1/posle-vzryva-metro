package ru.metroafter;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.metroafter.item.GasMaskItem;
@Mod.EventBusSubscriber(modid = MetroAfter.MODID)
public class RadiationHandler {
    private static final int CHECK_INTERVAL=40;
    @SubscribeEvent public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.phase!=TickEvent.Phase.END || event.player.level().isClientSide || !(event.player instanceof ServerPlayer player) || player.tickCount%CHECK_INTERVAL!=0) return;
        Level level=player.level(); BlockPos pos=player.blockPosition();
        boolean surface=pos.getY()>=100 && level.canSeeSky(pos);
        if(surface && !GasMaskItem.isWorn(player)) {
            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION,100,0,false,true));
            player.addEffect(new MobEffectInstance(MobEffects.POISON,80,0,false,true));
            player.displayClientMessage(net.minecraft.network.chat.Component.literal("☢ Радиация! Надень противогаз!"),true);
        }
    }
}
