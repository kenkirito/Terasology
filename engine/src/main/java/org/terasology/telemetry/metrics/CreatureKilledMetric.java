/*
 * Copyright 2017 MovingBlocks
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
package org.terasology.engine.telemetry.metrics;

import com.snowplowanalytics.snowplow.tracker.events.Unstructured;
import org.terasology.engine.entitySystem.entity.EntityRef;
import org.terasology.engine.logic.players.LocalPlayer;
import org.terasology.engine.registry.CoreRegistry;
import org.terasology.engine.telemetry.GamePlayStatsComponent;
import org.terasology.engine.telemetry.TelemetryCategory;
import org.terasology.engine.telemetry.TelemetryField;

import java.util.Map;
import java.util.Optional;

/**
 * A player statistic metric for creatures killed in a game.
 */
@TelemetryCategory(id = "creatureKilled",
        displayName = "${engine:menu#telemetry-creature-killed}",
        isOneMapMetric = true
)
public final class CreatureKilledMetric extends Metric {

    public static final String SCHEMA_CREATURE_KILLED = "iglu:org.terasology/creatureKilled/jsonschema/1-0-0";

    private LocalPlayer localPlayer;

    @TelemetryField
    private Map creatureKilledMap;

    @Override
    public Optional<Unstructured> getUnstructuredMetric() {
        createTelemetryFieldToValue();
        return getUnstructuredMetric(SCHEMA_CREATURE_KILLED, telemetryFieldToValue);
    }

    @Override
    public Map<String, ?> createTelemetryFieldToValue() {
        localPlayer = CoreRegistry.get(LocalPlayer.class);
        EntityRef playerEntity = localPlayer.getCharacterEntity();
        if (playerEntity.hasComponent(GamePlayStatsComponent.class)) {
            GamePlayStatsComponent gamePlayStatsComponent = playerEntity.getComponent(GamePlayStatsComponent.class);
            telemetryFieldToValue.clear();
            telemetryFieldToValue.putAll(gamePlayStatsComponent.creatureKilled);
            return telemetryFieldToValue;
        } else {
            return telemetryFieldToValue;
        }
    }
}
