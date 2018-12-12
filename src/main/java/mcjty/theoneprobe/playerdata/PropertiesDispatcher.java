package mcjty.theoneprobe.playerdata;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;

public class PropertiesDispatcher implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    private PlayerGotNote playerGotNote = new PlayerGotNote();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == PlayerProperties.PLAYER_GOT_NOTE;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == PlayerProperties.PLAYER_GOT_NOTE) {
            return (T) playerGotNote;
        }
        return null;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        playerGotNote.saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        playerGotNote.loadNBTData(nbt);
    }
}
