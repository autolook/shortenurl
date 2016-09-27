package org.autolook.service;

import org.autolook.util.Base62;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.Map;

/**
 * Created by raoshaoquan on 16/9/26.
 */
@Service
public class ShortenService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String shorten(String url) {
        String insertSql = "INSERT INTO short_url(url,create_time) values (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement pstmt = connection.prepareStatement(insertSql,
                    new String[] { "id" });
            pstmt.setString(1, url);
            pstmt.setLong(2, System.currentTimeMillis());
            return pstmt;
        }, keyHolder);
        long generatedId = keyHolder.getKey().longValue();
        return Base62.encodeBase10(generatedId);
    }

    public String getUrl(String shortUrl) {
        Long id = Base62.decodeBase62(shortUrl);
        Map<String, Object> map = jdbcTemplate.queryForMap("SELECT url FROM short_url WHERE id = ?", id);
        String url = map.get("url").toString();
        return url;
    }
}
