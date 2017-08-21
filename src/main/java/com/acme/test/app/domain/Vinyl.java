package com.acme.test.app.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "vinyl")
public class Vinyl implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(Vinyl.class);
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

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(final String artist) {
        this.artist = artist;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(final Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Vinyl vinyl = (Vinyl) o;

        if (id != null ? !id.equals(vinyl.id) : vinyl.id != null) return false;
        if (title != null ? !title.equals(vinyl.title) : vinyl.title != null) return false;
        if (artist != null ? !artist.equals(vinyl.artist) : vinyl.artist != null) return false;
        if (label != null ? !label.equals(vinyl.label) : vinyl.label != null) return false;
        return releaseDate != null ? releaseDate.equals(vinyl.releaseDate) : vinyl.releaseDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            LOG.warn("Could not serialize object to JSON");
            return "Vinyl{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", artist='" + artist + '\'' +
                    ", label='" + label + '\'' +
                    ", releaseDate=" + releaseDate +
                    '}';
        }
    }
}
