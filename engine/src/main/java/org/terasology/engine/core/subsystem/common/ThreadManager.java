// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.engine.core.subsystem.common;

import org.terasology.gestalt.module.sandbox.API;

@API
@FunctionalInterface
public interface ThreadManager {

    void submitTask(String name, Runnable task);
}