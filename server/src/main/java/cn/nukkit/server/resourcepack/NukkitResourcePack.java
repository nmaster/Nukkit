package cn.nukkit.server.resourcepack;

import cn.nukkit.api.resourcepack.MinecraftPack;
import cn.nukkit.api.resourcepack.MinecraftPackManifest;
import cn.nukkit.api.util.SemVer;
import cn.nukkit.server.resourcepack.loader.file.PackFile;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public abstract class NukkitResourcePack implements MinecraftPack {
    private final MinecraftPackManifest manifest;
    private final PackFile packFile;

    public NukkitResourcePack(MinecraftPackManifest manifest, PackFile packFile) {
        this.manifest = manifest;
        this.packFile = packFile;
    }

    @Nonnull
    public UUID getId() {
        return manifest.getHeader().getUuid();
    }

    public int getFormatVersion() {
        return manifest.getFormatVersion();
    }

    @Nonnull
    public Optional<SemVer> getMinimumSupportedMinecraftVersion() {
        return Optional.ofNullable(manifest.getHeader().getMinimumSupportedMinecraftVersion());
    }

    @Nonnull
    public SemVer getVersion() {
        return manifest.getHeader().getVersion();
    }

    @Nonnull
    public String getName() {
        return manifest.getHeader().getName();
    }

    @Nonnull
    public String getDescription() {
        return manifest.getHeader().getDescription();
    }

    @Nonnull
    public Collection<MinecraftPackManifest.Module> getModules() {
        return manifest.getModules();
    }

    public Collection<MinecraftPackManifest.Dependency> getDependencies() {
        return manifest.getDependencies();
    }

    public long getPackSize() {
        return packFile.getPackSize();
    }

    public int getCompressedSize() {
        return packFile.getCompressedSize();
    }

    public byte[] getSha256() {
        return packFile.getSha256();
    }

    public byte[] getPackChunk(int chunkIndex) {
        return packFile.getPackChunk(chunkIndex);
    }

    public int getChunkCount() {
        return packFile.getChunkCount();
    }
}