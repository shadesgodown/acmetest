package com.acme.test.app.service;

import com.acme.test.app.domain.Album;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudServiceTest {

    @Autowired
    ICrudService crudService;

    @Test
    public void createTest() throws Exception {
        Album album = new Album();
        album.setArtist("Pearl Jam");
        album.setTitle("Vs");
        album.setLabel("BMG");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        album.setReleaseDate(new Date(df.parse("1992-05-26").getTime()));

        album = crudService.create(album);
        assertThat(album, equalTo(crudService.findById(album.getId())));
    }
}
