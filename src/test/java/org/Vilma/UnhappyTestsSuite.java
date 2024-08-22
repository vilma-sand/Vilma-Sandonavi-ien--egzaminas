package org.Vilma;


import org.junit.platform.suite.api.*;

@Suite
@SelectPackages("org.vilma")
@IncludeTags("UnhappyTest")
@ExcludeTags({"not ready"})
public class UnhappyTestsSuite {
}