package com.github.h2m.monxample;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
public class PersonRepositoryTest {

    @Autowired
    PersonRepository repo;

    @Test
    public void testAdd() {
        Person p = repo.save(new Person("bla", "blubb"));
        Assert.assertEquals("id matches", "bla", p.getId());
        Assert.assertEquals("name matches", "blubb", p.getName());
    }
}
