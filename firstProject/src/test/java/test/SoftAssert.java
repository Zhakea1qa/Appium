package test;

import io.qameta.allure.Attachment;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SoftAssert {
    private static SoftAssertions softAssertions;

    public static SoftAssertions getSoftAssertions() {
        if (softAssertions == null) {
            softAssertions = new SoftAssertions();
        }
        return softAssertions;
    }
    public byte[] attachScreenshot(byte[] screenshot) {
        return screenshot;
    }
    public static void assertAll() {
        if (softAssertions != null) {
            softAssertions.assertAll();
        }
    }}
