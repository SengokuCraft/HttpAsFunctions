package io.github.twosquirrels.httpasfunctions;

import com.google.gson.*;
import static io.github.twosquirrels.httpasfunctions.HttpAsFunctions.*;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }

    @Test
    public void localTest() {
        System.out.println("start localTest");
        makeFunc(56473, "add", args -> {
            System.out.println("called add func");
            JsonObjectArgs jsonObjectArgs = new JsonObjectArgs(args);
            System.out.println("x: " + jsonObjectArgs.getAsFloat("x"));
            System.out.println("y: " + jsonObjectArgs.getAsFloat("y"));
            return new JsonPrimitive(jsonObjectArgs.getAsFloat("x") + jsonObjectArgs.getAsFloat("y"));
        });
        System.out.println("finish setup add func");
        JsonObject args = new JsonObject();
        args.addProperty("x", 84);
        args.addProperty("y", 47);
        try {
            System.out.println(
                callFunc(56473, "add", args).toString()
            );
        } catch(Exception e) {
            System.out.println("-------- error in callFunc --------");
            e.printStackTrace();
            System.out.println("-----------------------------------");
        }
        System.out.println("called add func");
        System.out.println("finish localTest");
    }

    @Test
    public void discordTest() {
        System.out.println("start discordTest");
        JsonObject args = new JsonObject();
        args.addProperty("username", "AppTest.java");
        args.addProperty("avatar_url", "https://www.oracle.com/a/ocom/img/cb71-java-logo.png");
        args.addProperty("content", "Hello, from Java!");
        System.out.println(args);
        try {
            JsonElement ret = callFunc(
                "discord.com",
                true,
                443,
                System.getenv("DISCORD_WEBHOOK").replace("https://discord.com/", ""),
                args
            );
            System.out.println(ret);
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("finish discordTest");
    }

}
