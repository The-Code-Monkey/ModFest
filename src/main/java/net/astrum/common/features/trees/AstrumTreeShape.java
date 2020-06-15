package net.astrum.common.features.trees;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringIdentifiable;

import java.util.Locale;
import java.util.Random;

public enum AstrumTreeShape implements StringIdentifiable {
    NORMAL {
        @Override
        public int[] chooseShape(Random random) {
            switch (random.nextInt(6)) {
                case 1:
                    return NORMAL1;
                case 2:
                    return NORMAL2;
                default:
                    return NORMAL0;
            }
        }
    };

    public static final Codec<AstrumTreeShape> CODEC = StringIdentifiable.method_28140(AstrumTreeShape::values, AstrumTreeShape::byName);

    // Leaf shapes hard-coded from bottom to top
    private static final int[] NORMAL0 = { 0, 0, 1, 2, 2, 1, 2, 1, 0 };
    private static final int[] NORMAL1 = { 0, 0, 1, 2, 1, 2, 1, 0 };
    private static final int[] NORMAL2 = { 0, 0, 2, 2, 1, 2, 1, 0 };

    public abstract int[] chooseShape(Random random);

    @Override
    public String asString() {
        return this.name().toLowerCase(Locale.ROOT);
    }

    public static AstrumTreeShape byName(String name) {
        switch (name) {
            case "normal":
                return NORMAL;
            default:
                return null;
        }
    }
}
