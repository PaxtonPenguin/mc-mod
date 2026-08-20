package paxton.pixton;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Util;
import net.minecraft.core.Holder.Reference;

public class Songs {
   private static ResourceKey<JukeboxSong> create(final String id) {
      return ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(CatEars.MOD_ID, id));
   }

    private static Reference<SoundEvent> registerForHolder(final String id) {
      return registerForHolder(Identifier.fromNamespaceAndPath(CatEars.MOD_ID, id));
   }

   private static Reference<SoundEvent> registerForHolder(final Identifier id) {
      return registerForHolder(id, id);
   }

   private static Reference<SoundEvent> registerForHolder(final Identifier id, final Identifier soundId) {
      return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(soundId));
   }

   private static void register(
      final BootstrapContext<JukeboxSong> context,
      final ResourceKey<JukeboxSong> registryKey,
      final Reference<SoundEvent> soundEvent,
      final int lengthInSeconds,
      final int comparatorOutput
   ) {
      context.register(
         registryKey,
         new JukeboxSong(
            soundEvent, Component.translatable(Util.makeDescriptionId("jukebox_song", registryKey.identifier())), lengthInSeconds, comparatorOutput
         )
      );
   }

   //static final Reference<SoundEvent> INFERNO = registerForHolder("music.creative");

   static ResourceKey<JukeboxSong> INFERNODISC = create("inferno");

   static void bootstrap(final BootstrapContext<JukeboxSong> context) {
      register(context, INFERNODISC, INFERNOSOUND, 271, 1);
   }

   private static SoundEvent registerSound(String id) {
		Identifier identifier = Identifier.fromNamespaceAndPath("pixton", id);
		return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
	}

   public static final Reference<SoundEvent> INFERNOSOUND = registerForHolder("infernosound");

   public static void initialize() {
   }
}
