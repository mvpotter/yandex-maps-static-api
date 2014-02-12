/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 05/02/14
 * Time: 22:14
 */
package io.github.mvpotter.urlbuilder;

import org.junit.Assert;
import org.junit.Test;

public class ApiKeyUrlArgumentBuilderTest extends AbstaratUrlBuilderTest {

    private static final String API_KEY = "yg4klGTG5yH6HF@Fxx:N5";
    private static final String API_KEY_ARGUMENT = "apiKey=" + API_KEY;

    private static final ApiKeyUrlArgumentBuilder apiKeyUrlArgumentBuilder = new ApiKeyUrlArgumentBuilder();

    @Test
    public void buildTest() {
        yandexMap.setApiKey(API_KEY);
        Assert.assertEquals(API_KEY_ARGUMENT, apiKeyUrlArgumentBuilder.build(yandexMap));
    }

}
