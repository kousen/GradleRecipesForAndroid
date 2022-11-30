package com.kousenit.helloworld;

import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IcndbJokeTest {
    private final String jsonTxt =
            "{\"type\": \"success\", \"value\": {\"id\": 451, \"joke\": \"Xav Ducrohet writes code that optimizes itself.\", \"categories\": [\"nerdy\"]}}";

    @Test
    public void testGetJoke() throws Exception {
        Gson gson = new Gson();
        IcndbJoke icndbJoke = gson.fromJson(jsonTxt, IcndbJoke.class);
        String correct = "Xav Ducrohet writes code that optimizes itself.";
        assertNotNull(icndbJoke);
        assertEquals(correct, icndbJoke.getJoke());
    }
}