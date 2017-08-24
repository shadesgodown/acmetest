package com.acme.test.app.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Entity that represents an album that can be stored in its repository.
 */
@Entity
@Table(name = "album")
public class Album implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(Album.class);
    private static final long serialVersionUID = -2283325522913028372L;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="artist", nullable = false)
    private String artist;

    @Column(name="label", nullable = false)
    private String label;

    @Column(name="release_date", nullable = false)
    private Date releaseDate;

    /**
     * Gets the <code>Album</code> id.
     *
     * @return the <code>Album</code> id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the <code>Album</code> id.
     *
     * @param id the <code>Album</code> id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets the <code>Album</code> title.
     *
     * @return the <code>Album</code> title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the <code>Album</code> title.
     *
     * @param title the <code>Album</code> title
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Gets the <code>Album</code> artist.
     *
     * @return the <code>Album</code> artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Sets the <code>Album</code> artist.
     *
     * @param artist the <code>Album</code> artist
     */
    public void setArtist(final String artist) {
        this.artist = artist;
    }

    /**
     * Gets the <code>Album</code> label.
     *
     * @return the <code>Album</code> label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the <code>Album</code> label.
     *
     * @param label the <code>Album</code> label
     */
    public void setLabel(final String label) {
        this.label = label;
    }

    /**
     * Gets the <code>Album</code> release date.
     *
     * @return the <code>Album</code> release date
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the <code>Album</code> release date.
     *
     * @param releaseDate the <code>Album</code> release date
     */
    public void setReleaseDate(final Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Album album = (Album) o;

        if (id != null ? !id.equals(album.id) : album.id != null) return false;
        if (title != null ? !title.equals(album.title) : album.title != null) return false;
        if (artist != null ? !artist.equals(album.artist) : album.artist != null) return false;
        if (label != null ? !label.equals(album.label) : album.label != null) return false;
        return releaseDate != null ? releaseDate.equals(album.releaseDate) : album.releaseDate == null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // uses Jackson ObjectMapper to convert object to JSON String
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            LOG.warn("Could not serialize object to JSON");
            return "Album{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", artist='" + artist + '\'' +
                    ", label='" + label + '\'' +
                    ", releaseDate=" + releaseDate +
                    '}';
        }
    }
}
