package test;

import org.assertj.core.api.SoftAssertions;

public class SoftAssert {
    private static SoftAssertions softAssertions;

    public static SoftAssertions getSoftAssertions() {
        if (softAssertions == null) {
            softAssertions = new SoftAssertions();
        }
        return softAssertions;
    }

    public static void assertAll() {
        if (softAssertions != null) {
            softAssertions.assertAll();
        }
    }}
