package paxton.catears;

import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.resources.Identifier;

import com.mojang.serialization.Codec;

public class Save {
    public static final AttachmentType<String> isFurry = AttachmentRegistry.create(
		Identifier.fromNamespaceAndPath("cat-ears", "isfurry"), // The ID of your Attachment
        builder -> builder
			.initializer(() -> "") // The default value of the Attachment, if one has not been set.
			.persistent(Codec.STRING) // Dictates how this Attachment's data should be saved and loaded.
			.copyOnDeath()
);
}
