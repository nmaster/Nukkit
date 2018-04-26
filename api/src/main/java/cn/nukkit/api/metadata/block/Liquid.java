package cn.nukkit.api.metadata.block;

import cn.nukkit.api.metadata.Metadata;
import com.google.common.base.Preconditions;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Liquid implements Metadata {
    private final byte level;

    public static Liquid of(int level) {
        Preconditions.checkArgument(level >= 0 && level < 8, "level is not valid (wanted 0-7)");
        return new Liquid((byte) level);
    }

    public byte getLevel() {
        return level;
    }

    @Override
    public int hashCode() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Liquid that = (Liquid) o;
        return this.level == that.level;
    }

    @Override
    public String toString() {
        return "Liquid(" +
                "level=" + level +
                ')';
    }
}