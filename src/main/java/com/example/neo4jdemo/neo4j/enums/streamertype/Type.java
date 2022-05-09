/*
 * Copyright (c) 2002-2022 "Neo4j,"
 * Neo4j Sweden AB [http://neo4j.com]
 *
 * This file is part of Neo4j.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.neo4jdemo.neo4j.enums.streamertype;


/**
 * 主播類型-Enum
 */
public enum Type {
    Singing(1,"歌唱"),
    Chat(2,"聊天"),
    Dancing(3,"跳舞"),
    Idol(4,"偶像");

    private int id;
    private String desc;
    Type(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }
}
