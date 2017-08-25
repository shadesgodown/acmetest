package com.acme.test.app.service;

import com.acme.test.app.domain.Album;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
        this.testAlbum.setTitle("Vs.");
        this.testAlbum.setLabel("Epic");
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
        assertThat(album.getArtist(), equalTo("Pearl Jam"));
        assertThat(album.getLabel(), equalTo("Epic"));

        List<Album> albums = crudService.findAll();
        assertThat(albums.size(), equalTo(9));
    }

    @Test
    public void testDelete() throws Exception {
        Album album = crudService.create(this.testAlbum);
        crudService.delete(album);
        album = crudService.findById(album.getId());
        assertThat(album, is(nullValue()));

        album = crudService.create(this.testAlbum);
        crudService.deleteById(album.getId());
        album = crudService.findById(album.getId());
        assertThat(album, is(nullValue()));
    }
}
