package com.example.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.entity.Bookmark;

@Dao
@ConfigAutowireable
public interface BookmarkDao {

    @Select
    Optional<Bookmark> findByUsernameAndEntryId(String username, Long entryId);

    @Select
    List<Bookmark> findByEntryId(Long entryId);

    @Select
    List<Map<String, Object>> findByUsername(String username);

    @Insert
    int insert(Bookmark entity);

    @Update
    int update(Bookmark entity);
}
