package paxton.pixton;

import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.resources.Identifier;

import com.mojang.serialization.Codec;

public class Save {
    public static final AttachmentType<String> isFurry = AttachmentRegistry.create(
		Identifier.fromNamespaceAndPath(CatEars.MOD_ID, "isfurry"), // The ID of your Attachment
        builder -> builder
			.initializer(() -> "") // The default value of the Attachment, if one has not been set.
			.persistent(Codec.STRING) // Dictates how this Attachment's data should be saved and loaded.
			.copyOnDeath()
);
	public static final AttachmentType<Double> addedx = AttachmentRegistry.create(
		Identifier.fromNamespaceAndPath(CatEars.MOD_ID, "addedx"), // The ID of your Attachment
        builder -> builder
			.initializer(() -> 0.0) // The default value of the Attachment, if one has not been set.
);
	public static final AttachmentType<Double> addedz = AttachmentRegistry.create(
		Identifier.fromNamespaceAndPath(CatEars.MOD_ID, "addedz"), // The ID of your Attachment
        builder -> builder
			.initializer(() -> 0.0) // The default value of the Attachment, if one has not been set.
);

	public static final AttachmentType<Boolean> freezey = AttachmentRegistry.create(
		Identifier.fromNamespaceAndPath(CatEars.MOD_ID, "freezey"), // The ID of your Attachment
        builder -> builder
			.initializer(() -> false) // The default value of the Attachment, if one has not been set.
);
	public static void initialize() {}
}
