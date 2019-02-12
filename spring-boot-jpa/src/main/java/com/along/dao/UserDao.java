package com.along.dao;

import com.along.model.entity.User;
import com.along.model.vo.UserVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author along
 * @Date 2019/1/9 14:07
 */
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    //重写findAll(Pageable pageable)方法,用实体图查询
    @EntityGraph(value = "user.all", type = EntityGraph.EntityGraphType.FETCH)
    @Override
    Page<User> findAll(Pageable pageable);

    // 这里的模糊查询并不会自动在name两边加"%"，需要手动对参数加"%"
    List<UserVo> findByNameLike(String name);

    List<User> findByName(String name);

    @Query("select u from User u where u.name like concat('%',:name,'%') and u.sex = :sex")
    List<User> findUserByNameAndSex(@Param("name") String name, @Param("sex") Integer sex);

}
