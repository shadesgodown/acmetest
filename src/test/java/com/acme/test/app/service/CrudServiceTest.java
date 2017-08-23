package com.acme.test.app.service;

import com.acme.test.app.domain.Album;
import org.junit.Before;
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
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudServiceTest {

    private Album testAlbum;

    @Autowired
    ICrudService crudService;

    @Before
    public void setup() throws Exception {
        this.testAlbum = new Album();
        this.testAlbum.setArtist("Pearl Jam");
        this.testAlbum.setTitle("Vs");
        this.testAlbum.setLabel("BMG");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        this.testAlbum.setReleaseDate(new Date(df.parse("1992-05-26").getTime()));
    }

    @Test
    public void testCreate() throws Exception {
        Album album = crudService.create(this.testAlbum);
        assertThat(crudService.findById(album.getId()), equalTo(album));
    }

    @Test
    public void testQuery() throws Exception {
        Album album = crudService.findById(1l);
        assertThat(album.getTitle(), equalTo("Ten"));
    }

    @Test
    public void testDelete() throws Exception {
        Album album = crudService.create(this.testAlbum);
        crudService.delete(album);
        album = crudService.findById(album.getId());
        assertThat(album, is(nullValue()));
    }
}
