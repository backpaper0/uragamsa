package com.example.dao;

import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.entity.Entry;

@Dao
@ConfigAutowireable
public interface EntryDao {

    @Select
    Optional<Entry> findByUrl(String url);

    @Insert
    int insert(Entry entity);
}
