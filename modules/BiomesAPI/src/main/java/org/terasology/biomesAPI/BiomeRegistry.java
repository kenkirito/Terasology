/*
 * Copyright 2018 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.biomesAPI;

import org.terasology.entitySystem.systems.ComponentSystem;
import org.terasology.math.geom.Vector3i;

import java.util.Optional;

public interface BiomeRegistry {
    /**
     * This method must be called on every startup to register biomes with this module.
     * <p>
     * Biomes should be ideally registered through new {@link ComponentSystem}, in the method
     * {@link ComponentSystem#preBegin()}.
     *
     * @param biome Biome to register
     */
    void registerBiome(Biome biome);

    /**
     * Sets specified biome at position in world.
     *
     * @param biome Biome to set
     * @param x     x position of the block to set
     * @param y     y position of the block to set
     * @param z     z position of the block to set
     */
    void setBiome(Biome biome, int x, int y, int z);

    /**
     * Sets specified biome at position in world.
     *
     * @param biome Biome to set
     * @param pos   Position of the block to set
     */
    void setBiome(Biome biome, Vector3i pos);

    /**
     * Gets biome at position in world.
     *
     * @param pos Position of the block to get biome of.
     * @return Biome of the block
     */
    Optional<Biome> getBiome(Vector3i pos);

    /**
     * Gets biome at position in world.
     *
     * @param x x position of the block to get biome of
     * @param y y position of the block to get biome of
     * @param z z position of the block to get biome of
     * @return Biome of the block
     */
    Optional<Biome> getBiome(int x, int y, int z);
}
