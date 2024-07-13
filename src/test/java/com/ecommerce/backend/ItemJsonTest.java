package com.ecommerce.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class ItemJsonTest {

    @Autowired
    private JacksonTester<Item> json;

    @Test
    void ItemSerializationTest() throws IOException {
        Item item = new Item(0, "Hololive EN x OMOCAT Ceres Fauna Sweater", "L", 65);

        assertThat(json.write(item)).isStrictlyEqualToJson("expected.json");

        assertThat(json.write(item)).hasJsonPathNumberValue("@.id");

        assertThat(json.write(item)).extractingJsonPathNumberValue("@.id").isEqualTo(0);

        assertThat(json.write(item)).hasJsonPathNumberValue("@.price");

        assertThat(json.write(item)).extractingJsonPathNumberValue("@.price").isEqualTo(65);
    }
}
