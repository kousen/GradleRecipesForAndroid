package com.kousenit.helloworld;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void getRootPackageName() {
        String completeName = "a.b.c.d.e";
        String rootName = completeName.substring(0, completeName.lastIndexOf('.'));
        rootName = rootName.substring(0, rootName.lastIndexOf('.'));
        assertEquals("a.b.c", rootName);
    }
}