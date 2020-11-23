package com.dummy.spring;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbstractJdbcTemplateDao
{

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AbstractJdbcTemplateDao( DataSource ds )
    {

        if( ds == null )
        {
            throw new NullPointerException( "Datasource can be null" );
        }

        this.jdbcTemplate = new JdbcTemplate( ds );
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate( ds );
    }

    protected final JdbcTemplate getJdbcTemplate( )
    {

        return jdbcTemplate;
    }

    protected NamedParameterJdbcTemplate getNamedParameterJdbcTemplate( )
    {

        return namedParameterJdbcTemplate;
    }

    public static class StringRowMapper implements RowMapper<String>
    {

        public StringRowMapper( )
        {
        	//Default Constructor
        }

        @Override
        public String mapRow( ResultSet rs, int rowNum ) throws SQLException
        {

            // TODO Auto-generated method stub
            return rs.getString( 1 );
        }

    }

}
