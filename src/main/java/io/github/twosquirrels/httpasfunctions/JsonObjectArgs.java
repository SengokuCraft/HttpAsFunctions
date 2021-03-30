package io.github.twosquirrels.httpasfunctions;

import com.google.gson.*;

/**
 * Wrapper class for using JsonObject as an argument of HttpAsFunctions
 * @author TwoSquirrels
 * @version 1.2.2
 */
public class JsonObjectArgs {

    public JsonObject args;

    /**
     * Constructs a newly allocated JsonObjectArgs that represents the specified JsonObject.
     * @param args the JsonObject to be represented by the JsonObjectArgs
     * @throws HaFException when args is not a JsonObject
     */
    public JsonObjectArgs(JsonElement args) throws HaFException {
        if (!args.isJsonObject()) throw new HaFException(400, "The json is not a object.");
        this.args = args.getAsJsonObject();
    }

    /**
     * A method that throws an HaFException if a member with the specified name does not exist on this object.
     * @param memberName name of the member that is being checked for presence
     * @throws HaFException If there is not a member with the specified name.
     */
    public void check(String memberName) throws HaFException {
        if (!this.args.has(memberName)) throw new HaFException(400, "Missing property \"" + memberName + "\".");
    }

    /**
     * Convenience method to get the specified member as a JsonObject.
     * @param memberName name of the member being requested
     * @return the JsonObject corresponding to the specified member
     * @throws HaFException If there is not a member with the specified name or the member is not a JsonObject.
     */
    public JsonObject getAsJsonObject(String memberName) throws HaFException {
        this.check(memberName);
        try {
            return this.args.get(memberName).getAsJsonObject();
        } catch (Exception e) {
            throw new HaFException(400, "The property \"" + memberName + "\" is not a JsonObject.");
        }
    }

    /**
     * Convenience method to get the specified member as a JsonArray.
     * @param memberName name of the member being requested
     * @return the JsonArray corresponding to the specified member
     * @throws HaFException If there is not a member with the specified name or the member is not a JsonArray.
     */
    public JsonArray getAsJsonArray(String memberName) throws HaFException {
        this.check(memberName);
        try {
            return this.args.get(memberName).getAsJsonArray();
        } catch (Exception e) {
            throw new HaFException(400, "The property \"" + memberName + "\" is not a JsonArray.");
        }
    }

    /**
     * Convenience method to get the specified member as a JsonPrimitive.
     * @param memberName name of the member being requested
     * @return the JsonPrimitive corresponding to the specified member
     * @throws HaFException If there is not a member with the specified name or the member is not a JsonPrimitive.
     */
    public JsonPrimitive getAsJsonPrimitive(String memberName) throws HaFException {
        this.check(memberName);
        try {
            return this.args.get(memberName).getAsJsonPrimitive();
        } catch (Exception e) {
            throw new HaFException(400, "The property \"" + memberName + "\" is not a JsonPrimitive.");
        }
    }

    /**
     * Convenience method to get the specified member as a JsonNull.
     * @param memberName name of the member being requested
     * @return the JsonNull corresponding to the specified member
     * @throws HaFException If there is not a member with the specified name or the member is not a JsonNull.
     */
    public JsonNull getAsJsonNull(String memberName) throws HaFException {
        this.check(memberName);
        try {
            return this.args.get(memberName).getAsJsonNull();
        } catch (Exception e) {
            throw new HaFException(400, "The property \"" + memberName + "\" is not a JsonNull.");
        }
    }

    /**
     * Convenience method to get the specified member as a boolean.
     * @param memberName name of the member being requested
     * @return the boolean corresponding to the specified member
     * @throws HaFException If there is not a member with the specified name or the member is not a boolean.
     */
    public boolean getAsBoolean(String memberName) throws HaFException {
        this.check(memberName);
        try {
            return this.args.get(memberName).getAsBoolean();
        } catch (Exception e) {
            throw new HaFException(400, "The property \"" + memberName + "\" is not a boolean.");
        }
    }

    /**
     * Convenience method to get the specified member as a Number.
     * @param memberName name of the member being requested
     * @return the Number corresponding to the specified member
     * @throws HaFException If there is not a member with the specified name or the member is not a Number.
     */
    public Number getAsNumber(String memberName) throws HaFException {
        this.check(memberName);
        try {
            return this.args.get(memberName).getAsNumber();
        } catch (Exception e) {
            throw new HaFException(400, "The property \"" + memberName + "\" is not a Number.");
        }
    }

    /**
     * Convenience method to get the specified member as a String.
     * @param memberName name of the member being requested
     * @return the String corresponding to the specified member
     * @throws HaFException If there is not a member with the specified name or the member is not a String.
     */
    public String getAsString(String memberName) throws HaFException {
        this.check(memberName);
        try {
            return this.args.get(memberName).getAsString();
        } catch (Exception e) {
            throw new HaFException(400, "The property \"" + memberName + "\" is not a String.");
        }
    }

    /**
     * Convenience method to get the specified member as a double.
     * @param memberName name of the member being requested
     * @return the double corresponding to the specified member
     * @throws HaFException If there is not a member with the specified name or the member is not a double.
     */
    public double getAsDouble(String memberName) throws HaFException {
        this.check(memberName);
        try {
            return this.args.get(memberName).getAsDouble();
        } catch (Exception e) {
            throw new HaFException(400, "The property \"" + memberName + "\" is not a double.");
        }
    }
    
    /**
     * Convenience method to get the specified member as a float.
     * @param memberName name of the member being requested
     * @return the float corresponding to the specified member
     * @throws HaFException If there is not a member with the specified name or the member is not a float.
     */
    public float getAsFloat(String memberName) throws HaFException {
        this.check(memberName);
        try {
            return this.args.get(memberName).getAsFloat();
        } catch (Exception e) {
            throw new HaFException(400, "The property \"" + memberName + "\" is not a float.");
        }
    }

    /**
     * Convenience method to get the specified member as a long.
     * @param memberName name of the member being requested
     * @return the long corresponding to the specified member
     * @throws HaFException If there is not a member with the specified name or the member is not a long.
     */
    public long getAsLong(String memberName) throws HaFException {
        this.check(memberName);
        try {
            return this.args.get(memberName).getAsLong();
        } catch (Exception e) {
            throw new HaFException(400, "The property \"" + memberName + "\" is not a long.");
        }
    }

    /**
     * Convenience method to get the specified member as a int.
     * @param memberName name of the member being requested
     * @return the int corresponding to the specified member
     * @throws HaFException If there is not a member with the specified name or the member is not a int.
     */
    public int getAsInt(String memberName) throws HaFException {
        this.check(memberName);
        try {
            return this.args.get(memberName).getAsInt();
        } catch (Exception e) {
            throw new HaFException(400, "The property \"" + memberName + "\" is not a int.");
        }
    }
    
    /**
     * Convenience method to get the specified member as a byte.
     * @param memberName name of the member being requested
     * @return the byte corresponding to the specified member
     * @throws HaFException If there is not a member with the specified name or the member is not a byte.
     */
    public byte getAsByte(String memberName) throws HaFException {
        this.check(memberName);
        try {
            return this.args.get(memberName).getAsByte();
        } catch (Exception e) {
            throw new HaFException(400, "The property \"" + memberName + "\" is not a byte.");
        }
    }

    /**
     * Convenience method to get the specified member as a BigDecimal.
     * @param memberName name of the member being requested
     * @return the BigDecimal corresponding to the specified member
     * @throws HaFException If there is not a member with the specified name or the member is not a BigDecimal.
     */
    public java.math.BigDecimal getAsBigDecimal(String memberName) throws HaFException {
        this.check(memberName);
        try {
            return this.args.get(memberName).getAsBigDecimal();
        } catch (Exception e) {
            throw new HaFException(400, "The property \"" + memberName + "\" is not a BigDecimal.");
        }
    }

    /**
     * Convenience method to get the specified member as a BigInteger.
     * @param memberName name of the member being requested
     * @return the BigInteger corresponding to the specified member
     * @throws HaFException If there is not a member with the specified name or the member is not a BigInteger.
     */
    public java.math.BigInteger getAsBigInteger(String memberName) throws HaFException {
        this.check(memberName);
        try {
            return this.args.get(memberName).getAsBigInteger();
        } catch (Exception e) {
            throw new HaFException(400, "The property \"" + memberName + "\" is not a BigInteger.");
        }
    }

    /**
     * Convenience method to get the specified member as a short.
     * @param memberName name of the member being requested
     * @return the short corresponding to the specified member
     * @throws HaFException If there is not a member with the specified name or the member is not a short.
     */
    public short getAsShort(String memberName) throws HaFException {
        this.check(memberName);
        try {
            return this.args.get(memberName).getAsShort();
        } catch (Exception e) {
            throw new HaFException(400, "The property \"" + memberName + "\" is not a short.");
        }
    }

}
