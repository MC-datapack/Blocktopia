package github.mcdatapack.blocktopia.screen.custom.screenhandler;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import github.mcdatapack.blocktopia.enchantment.ModEnchantments;
import github.mcdatapack.more_tools_and_armor.init.EnchantmentInit;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.screen.ForgingScreenHandler;
import net.minecraft.screen.Property;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.ForgingSlotsManager;
import net.minecraft.text.Text;
import net.minecraft.util.StringHelper;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;

public abstract class AbstractExtendedAnvilScreenHandler extends ForgingScreenHandler {
    public static final ImmutableMap<RegistryKey<Enchantment>, Integer> MAX_LEVELS = ImmutableMap.<RegistryKey<Enchantment>, Integer>builder()
            .put(Enchantments.BINDING_CURSE, 1)
            .put(Enchantments.VANISHING_CURSE, 1)
            .put(Enchantments.SILK_TOUCH, 1)
            .put(Enchantments.CHANNELING, 1)
            .put(ModEnchantments.SILK_SWING_KEY, 1)
            .put(Enchantments.LURE, 5)
            .put(Enchantments.QUICK_CHARGE, 5)
            .put(EnchantmentInit.RANGE, 5)
            .put(Enchantments.SWIFT_SNEAK, 5)
            .put(Enchantments.LOYALTY, 127)
            .put(Enchantments.PIERCING, 127)
            .build();
    public static final ImmutableMap<RegistryKey<Enchantment>, Set<RegistryKey<Enchantment>>> INCOMPATIBLE = ImmutableMap.<RegistryKey<Enchantment>, Set<RegistryKey<Enchantment>>>builder()
            .put(Enchantments.FORTUNE, ImmutableSet.of(Enchantments.SILK_TOUCH))
            .put(Enchantments.DEPTH_STRIDER, ImmutableSet.of(Enchantments.FROST_WALKER))
            .put(Enchantments.RIPTIDE, ImmutableSet.of(Enchantments.LOYALTY, Enchantments.CHANNELING))
            .put(Enchantments.SILK_TOUCH, ImmutableSet.of(Enchantments.FORTUNE))
            .put(Enchantments.FROST_WALKER, ImmutableSet.of(Enchantments.DEPTH_STRIDER))
            .put(Enchantments.LOYALTY, ImmutableSet.of(Enchantments.RIPTIDE))
            .put(Enchantments.CHANNELING, ImmutableSet.of(Enchantments.RIPTIDE))
            .build();

    private int repairItemUsage;
    @Nullable private String newItemName;
    private final Property levelCost = Property.create();

    public AbstractExtendedAnvilScreenHandler(ScreenHandlerType<? extends AbstractExtendedAnvilScreenHandler> type, int syncId, PlayerInventory inventory, ScreenHandlerContext context) {
        super(type, syncId, inventory, context);
        this.addProperty(this.levelCost);
    }

    protected abstract int getMaxEnchantmentLevel();
    protected abstract int getMaxXpLevel();
    protected abstract BlockState damageState(BlockState state);

    protected ForgingSlotsManager getForgingSlotsManager() {
        return ForgingSlotsManager.create()
                .input(0, 27, 47, stack -> true)
                .input(1, 76, 47, stack -> true)
                .output(2, 134, 47)
                .build();
    }

    @Override
    protected boolean canUse(BlockState state) {
        return state.isIn(BlockTags.ANVIL);
    }

    @Override
    protected boolean canTakeOutput(PlayerEntity player, boolean present) {
        return (player.isInCreativeMode() || player.experienceLevel >= this.levelCost.get()) && this.levelCost.get() > 0;
    }

    @Override
    protected void onTakeOutput(PlayerEntity player, ItemStack stack) {
        if (!player.getAbilities().creativeMode) {
            player.addExperienceLevels(-this.levelCost.get());
        }

        this.input.setStack(0, ItemStack.EMPTY);
        if (this.repairItemUsage > 0) {
            ItemStack itemStack = this.input.getStack(1);
            if (!itemStack.isEmpty() && itemStack.getCount() > this.repairItemUsage) {
                itemStack.decrement(this.repairItemUsage);
                this.input.setStack(1, itemStack);
            } else {
                this.input.setStack(1, ItemStack.EMPTY);
            }
        } else {
            this.input.setStack(1, ItemStack.EMPTY);
        }

        this.levelCost.set(0);
        this.context.run((world, pos) -> {
            BlockState blockState = world.getBlockState(pos);
            if (!player.isInCreativeMode() && blockState.isIn(BlockTags.ANVIL) && player.getRandom().nextFloat() < 0.32F) {
                BlockState blockState2 = damageState(blockState);
                if (blockState2 == null) {
                    world.removeBlock(pos, false);
                    world.syncWorldEvent(WorldEvents.ANVIL_DESTROYED, pos, 0);
                } else {
                    world.setBlockState(pos, blockState2, Block.NOTIFY_LISTENERS);
                    world.syncWorldEvent(WorldEvents.ANVIL_USED, pos, 0);
                }
            } else {
                world.syncWorldEvent(WorldEvents.ANVIL_USED, pos, 0);
            }
        });
    }

    @Override
    public void updateResult() {
        ItemStack inputStack = this.input.getStack(0);
        this.levelCost.set(1);
        int totalCost = 0;
        long repairCostSum = 0L;
        int renameCost = 0;
        if (!inputStack.isEmpty() && EnchantmentHelper.canHaveEnchantments(inputStack)) {
            ItemStack resultStack = inputStack.copy();
            ItemStack additionStack = this.input.getStack(1);
            ItemEnchantmentsComponent.Builder builder = new ItemEnchantmentsComponent.Builder(EnchantmentHelper.getEnchantments(resultStack));
            repairCostSum += inputStack.getOrDefault(DataComponentTypes.REPAIR_COST, 0) + additionStack.getOrDefault(DataComponentTypes.REPAIR_COST, 0);
            this.repairItemUsage = 0;
            if (!additionStack.isEmpty()) {
                boolean isAdditionEnchanted = additionStack.contains(DataComponentTypes.STORED_ENCHANTMENTS);
                if (resultStack.isDamageable() && resultStack.getItem().canRepair(inputStack, additionStack)) {
                    int repairAmount = Math.min(resultStack.getDamage(), resultStack.getMaxDamage() / 4);
                    if (repairAmount <= 0) {
                        this.output.setStack(0, ItemStack.EMPTY);
                        this.levelCost.set(0);
                        return;
                    }

                    int additionItemCount;
                    for (additionItemCount = 0; repairAmount > 0 && additionItemCount < additionStack.getCount(); additionItemCount++) {
                        int newDamage = resultStack.getDamage() - repairAmount;
                        resultStack.setDamage(newDamage);
                        totalCost++;
                        repairAmount = Math.min(resultStack.getDamage(), resultStack.getMaxDamage() / 4);
                    }

                    this.repairItemUsage = additionItemCount;
                } else {
                    if (!isAdditionEnchanted && (!resultStack.isOf(additionStack.getItem()) || !resultStack.isDamageable())) {
                        this.output.setStack(0, ItemStack.EMPTY);
                        this.levelCost.set(0);
                        return;
                    }

                    if (resultStack.isDamageable() && !isAdditionEnchanted) {
                        int baseDurabilityRemaining = inputStack.getMaxDamage() - inputStack.getDamage();
                        int additionDurabilityRemaining = additionStack.getMaxDamage() - additionStack.getDamage();
                        int bonusRepairAmount = additionDurabilityRemaining + resultStack.getMaxDamage() * 12 / 100;
                        int totalPotential = baseDurabilityRemaining + bonusRepairAmount;
                        int postRepairDamage = resultStack.getMaxDamage() - totalPotential;
                        if (postRepairDamage < 0) {
                            postRepairDamage = 0;
                        }

                        if (postRepairDamage < resultStack.getDamage()) {
                            resultStack.setDamage(postRepairDamage);
                            totalCost += 2;
                        }
                    }

                    ItemEnchantmentsComponent itemEnchantmentsComponent = EnchantmentHelper.getEnchantments(additionStack);
                    boolean enchantmentsApplied = false;
                    boolean hasConflictingEnchantments = false;

                    for (Entry<RegistryEntry<Enchantment>> entry : itemEnchantmentsComponent.getEnchantmentEntries()) {
                        RegistryEntry<Enchantment> registryEntry = entry.getKey();
                        int baseLevel = builder.getLevel(registryEntry);
                        int combinedLevel = entry.getIntValue();
                        combinedLevel = baseLevel == combinedLevel ? combinedLevel + 1 : Math.max(combinedLevel, baseLevel);
                        Enchantment enchantment = registryEntry.value();
                        boolean isAcceptable = enchantment.isAcceptableItem(inputStack);
                        if (this.player.getAbilities().creativeMode || inputStack.isOf(Items.ENCHANTED_BOOK)) {
                            isAcceptable = true;
                        }

                        for (RegistryEntry<Enchantment> registryEntry2 : builder.getEnchantments()) {
                            if (!registryEntry2.equals(registryEntry) && INCOMPATIBLE.getOrDefault(registryEntry.getKey().orElseThrow(), ImmutableSet.of())
                                            .contains(registryEntry2.getKey().orElseThrow())) {
                                isAcceptable = false;
                                totalCost++;
                            }
                        }

                        if (!isAcceptable) {
                            hasConflictingEnchantments = true;
                        } else {
                            enchantmentsApplied = true;
                            if (combinedLevel > getMaxEnchantmentLevel()) {
                                combinedLevel = getMaxEnchantmentLevel();
                            }
                            int max = MAX_LEVELS.getOrDefault(registryEntry.getKey().orElseThrow(), 255);
                            if (combinedLevel > max) {
                                combinedLevel = max;
                            }

                            builder.set(registryEntry, combinedLevel);
                            int enchantmentCost = enchantment.getAnvilCost();
                            if (isAdditionEnchanted) {
                                enchantmentCost = Math.max(1, enchantmentCost / 2);
                            }

                            totalCost += enchantmentCost * combinedLevel;
                            if (inputStack.getCount() > 1) {
                                totalCost = 40;
                            }
                        }
                    }

                    if (hasConflictingEnchantments && !enchantmentsApplied) {
                        this.output.setStack(0, ItemStack.EMPTY);
                        this.levelCost.set(0);
                        return;
                    }
                }
            }

            if (this.newItemName != null && !StringHelper.isBlank(this.newItemName)) {
                if (!this.newItemName.equals(inputStack.getName().getString())) {
                    renameCost = 1;
                    totalCost += renameCost;
                    resultStack.set(DataComponentTypes.CUSTOM_NAME, Text.literal(this.newItemName));
                }
            } else if (inputStack.contains(DataComponentTypes.CUSTOM_NAME)) {
                renameCost = 1;
                totalCost += renameCost;
                resultStack.remove(DataComponentTypes.CUSTOM_NAME);
            }

            this.levelCost.set((int) MathHelper.clamp(repairCostSum + totalCost, 0L, getMaxXpLevel()));
            if (totalCost <= 0) {
                resultStack = ItemStack.EMPTY;
            }

            if (!resultStack.isEmpty()) {
                int newRepairCost = resultStack.getOrDefault(DataComponentTypes.REPAIR_COST, 0);
                if (newRepairCost < additionStack.getOrDefault(DataComponentTypes.REPAIR_COST, 0)) {
                    newRepairCost = additionStack.getOrDefault(DataComponentTypes.REPAIR_COST, 0);
                }

                if (renameCost != totalCost || renameCost == 0) {
                    newRepairCost = getNextCost(newRepairCost);
                }

                resultStack.set(DataComponentTypes.REPAIR_COST, newRepairCost);
                EnchantmentHelper.set(resultStack, builder.build());
            }

            this.output.setStack(0, resultStack);
            this.sendContentUpdates();
        } else {
            this.output.setStack(0, ItemStack.EMPTY);
            this.levelCost.set(0);
        }
    }

    public static int getNextCost(int cost) {
        return (int)Math.min(cost * 2L + 1L, 2147483647L);
    }

    public boolean setNewItemName(String newItemName) {
        String string = sanitize(newItemName);
        if (string != null && !string.equals(this.newItemName)) {
            this.newItemName = string;
            if (this.getSlot(2).hasStack()) {
                ItemStack itemStack = this.getSlot(2).getStack();
                if (StringHelper.isBlank(string)) {
                    itemStack.remove(DataComponentTypes.CUSTOM_NAME);
                } else {
                    itemStack.set(DataComponentTypes.CUSTOM_NAME, Text.literal(string));
                }
            }

            this.updateResult();
            return true;
        } else {
            return false;
        }
    }

    @Nullable
    private static String sanitize(String name) {
        String string = StringHelper.stripInvalidChars(name);
        return string.length() <= 50 ? string : null;
    }

    public int getLevelCost() {
        return this.levelCost.get();
    }
}
