// Copyright 2021 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package org.terasology.engine.world.chunks.pipeline;

import org.joml.Vector3i;
import org.terasology.engine.utilities.concurrency.TaskMaster;
import org.terasology.engine.world.chunks.Chunk;

/**
 * Special Chunk task for shutdown {@link ChunkProcessingPipeline} and it's {@link TaskMaster}
 */
public final class ShutdownChunkTask implements ChunkTask {

    @Override
    public String getName() {
        return "Shutdown";
    }

    @Override
    public void run() {
    }

    @Override
    public boolean isTerminateSignal() {
        return true;
    }

    @Override
    public Chunk getChunk() {
        return null;
    }

    @Override
    public Vector3i getPosition() {
        return new Vector3i();
    }
}
