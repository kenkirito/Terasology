// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.world.propagation;

import org.terasology.engine.math.Side;
import org.terasology.math.geom.Vector3i;
import org.terasology.engine.world.block.Block;
import org.terasology.engine.world.chunks.LitChunk;

/**
 * Handles propagating values through blocks on a block by block basis.
 */
public interface BatchPropagator {

    /**
     * Handle one or more blocks being changed from one type to another
     *
     * @param changes The change being made
     */
    void process(BlockChange... changes);

    /**
     * Equivalent to {@link #process(BlockChange...)}
     *
     * @param blockChanges The changes to handle
     */
    void process(Iterable<BlockChange> blockChanges);

    /**
     * Propagate a value from one chunk to another
     *
     * @param chunk             The chunk the values are originating from
     * @param adjChunk          The chunk the values are moving into
     * @param side              The side the values are moving through
     * @param propagateExternal TODO: Document
     */
    void propagateBetween(LitChunk chunk, LitChunk adjChunk, Side side, boolean propagateExternal);

    /**
     * Propagates a value out of the block at the given position
     *
     * @param pos   The position of the block
     * @param block The block type
     */
    void propagateFrom(Vector3i pos, Block block);

    /**
     * Propagates a specific value out from a location
     *
     * @param pos   The position to propagate out of
     * @param value The value to propagate out
     */
    void propagateFrom(Vector3i pos, byte value);

    /**
     * TODO: Document
     *
     * @param pos   The position to regenerate at
     * @param value The original value at this position
     */
    void regenerate(Vector3i pos, byte value);
}