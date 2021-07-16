package com.kw.beerchartapp.repository;

import com.kw.beerchartapp.domain.BeerItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

@Repository
public class JdbcBeerItemRepository implements BeerItemRepository {
    private final RowMapper<BeerItem> beerItemRowMapper = beerItemRowMapper();
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcBeerItemRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<BeerItem> getBeers() {
        String sql = "select * from beer.beer_items order by id";
        return jdbcTemplate.query(sql, beerItemRowMapper);
    }

    @Override
    public void addBeer(BeerItem beer) {
        MapSqlParameterSource parameters = beerItemToParams(beer);
        jdbcTemplate.update(INSERT_QUERY, parameters);
    }

    @Override
    public void deleteById(int id) {
        String sql = "delete from beer.beer_items where id = :id";
        jdbcTemplate.update(sql, new MapSqlParameterSource().addValue("id", id));
    }

    @Override
    public void update(BeerItem beer) {
        MapSqlParameterSource parameters = beerItemToParams(beer);
        parameters.addValue("id", beer.getId());
        jdbcTemplate.update(UPDATE_QUERY, parameters);
    }

    private MapSqlParameterSource beerItemToParams(BeerItem beer) {
       return new MapSqlParameterSource()
                .addValue("name", beer.getName())
                .addValue("style", beer.getStyle())
                .addValue("abv", beer.getAbv())
                .addValue("bottling_date", beer.getBottlingDate())
                .addValue("ebc", beer.getEbc())
                .addValue("ibu", beer.getIbu())
                .addValue("description", beer.getDescription());
    }

    private RowMapper<BeerItem> beerItemRowMapper() {
        return (ResultSet rs, int rowNum) -> BeerItem.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .style(rs.getString("style"))
                .abv(rs.getDouble("abv"))
                .bottlingDate(rs.getObject("bottling_date", LocalDate.class))
                .ebc(rs.getInt("ebc"))
                .ibu(rs.getInt("ibu"))
                .description(rs.getString("description"))
                .build();
    }

    private static final String INSERT_QUERY = "INSERT INTO beer.beer_items" +
            "( name" +
            ", style" +
            ", abv" +
            ", bottling_date" +
            ", ebc" +
            ", ibu" +
            ", description) " +
            " values (" +
            ":name" +
            ", :style" +
            ", :abv" +
            ", :bottling_date" +
            ", :ebc" +
            ", :ibu" +
            ", :description)";

    private static final String UPDATE_QUERY =
            "UPDATE beer.beer_items SET " +
            "name = :name," +
            "style = :style," +
            "abv = :abv," +
            "bottling_date = :bottling_date," +
            "ebc = :ebc," +
            "ibu = :ibu," +
            "description = :description " +
            "WHERE id = :id";
}
